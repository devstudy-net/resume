package net.devstudy.resume.component.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.devstudy.resume.filter.AbstractFilter;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component
public class ErrorHandler extends AbstractFilter implements HandlerExceptionResolver {

	@Value("${application.production}")
	private boolean production;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		} else {
			throw new IllegalArgumentException(ex);
		}
	}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String requestUrl = req.getRequestURI();
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			LOGGER.error("Process request failed: " + requestUrl, th);
			handleException(th, requestUrl, resp);
		}
	}

	protected void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
		if (production) {
			if (requestUrl.startsWith("/fragment") || "/error".equals(requestUrl)) {
				sendErrorStatus(resp);
			} else {
				resp.sendRedirect("/error?url=" + requestUrl);
			}
		} else {
			throw new ServletException(th);
		}
	}

	protected void sendErrorStatus(HttpServletResponse resp) throws IOException {
		resp.reset();
		resp.getWriter().write("");
		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
}
