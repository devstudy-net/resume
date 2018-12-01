package net.devstudy.resume.configuration;

import java.util.EnumSet;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;

import net.devstudy.resume.component.impl.ApplicationListener;
import net.devstudy.resume.component.impl.DebugFilter;
import net.devstudy.resume.component.impl.ErrorHandler;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class ResumeWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(container);

		container.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		container.addListener(new ContextLoaderListener(ctx));
		container.addListener(ctx.getBean(ApplicationListener.class));

		registerFilters(container, ctx);
		registerSpringMVCDispatcherServlet(container, ctx);
	}

	private WebApplicationContext createWebApplicationContext(ServletContext container) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("net.devstudy.resume.configuration");
		ctx.setServletContext(container);
		ctx.refresh();
		return ctx;
	}

	private void registerFilters(ServletContext container, WebApplicationContext ctx) {
		registerFilter(container, ctx.getBean(ErrorHandler.class));
		registerFilter(container, new CharacterEncodingFilter("UTF-8", true));
		registerFilter(container, new RequestContextFilter());
		registerDebugFilterIfEnabled(container, ctx.getBean(DebugFilter.class));
		registerFilter(container, new DelegatingFilterProxy("springSecurityFilterChain", ctx), "springSecurityFilterChain");
		registerFilter(container, buildConfigurableSiteMeshFilter(), "sitemesh");
	}
	
	private void registerDebugFilterIfEnabled(ServletContext container, DebugFilter filter) {
		if(filter.isEnabledDebug() && filter.getDebugUrl().length != 0) {
			FilterRegistration.Dynamic filterRegistration = container.addFilter(filter.getClass().getSimpleName(), filter);
			for(String url : filter.getDebugUrl()) {
				filterRegistration.addMappingForUrlPatterns(null, true, url);
			}
		}
	}

	private void registerFilter(ServletContext container, Filter filter, String... filterNames) {
		String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName();
		container.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
	}

	private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
		return new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder
					.addDecoratorPath("/*",          "/WEB-INF/template/page-template.jsp")
					.addDecoratorPath("/fragment/*", "/WEB-INF/template/fragment-template.jsp")
					.addTagRuleBundle(new Sm2TagRuleBundle());
			}
		};
	}

	private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
