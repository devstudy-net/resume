package net.devstudy.resume.component.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component("applicationAccessDeniedHandler")
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);
	
	@Value("${application.production}")
	private boolean production;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		LOGGER.error("Detected AccessDeniedException: "+accessDeniedException.getMessage(), accessDeniedException);
		if(production) {
			response.sendRedirect("/error?status=403");
		} else {
			throw new ServletException(accessDeniedException);
		}
	}

}
