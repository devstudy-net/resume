package net.devstudy.resume.component.impl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

	@Value("${application.production}")
	private boolean production;
	
	@Value("${application.css.common.version}")
	private String cssCommonVersion;
	
	@Value("${application.css.ex.version}")
	private String cssExVersion;
	
	@Value("${application.js.common.version}")
	private String jsCommonVersion;
	
	@Value("${application.js.ex.version}")
	private String jsExVersion;
	
	@Value("${application.js.messages.version}")
	private String jsMessagesVersion;
	
	@Value("${application.host}")
	private String applicationHost;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("production", 		 production);
		sce.getServletContext().setAttribute("cssCommonVersion", cssCommonVersion);
		sce.getServletContext().setAttribute("cssExVersion", 	 cssExVersion);
		sce.getServletContext().setAttribute("jsCommonVersion",  jsCommonVersion);
		sce.getServletContext().setAttribute("jsExVersion", 	 jsExVersion);
		sce.getServletContext().setAttribute("jsMessagesVersion",jsMessagesVersion);
		sce.getServletContext().setAttribute("applicationHost",  applicationHost);
		LOGGER.info("Application started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.info("Application stopped");
	}
}
