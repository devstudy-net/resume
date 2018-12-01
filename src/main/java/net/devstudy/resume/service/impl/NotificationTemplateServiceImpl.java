package net.devstudy.resume.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.ServletContextResource;

import net.devstudy.resume.component.TemplateResolver;
import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.model.NotificationMessage;
import net.devstudy.resume.service.NotificationTemplateService;

@Service
public class NotificationTemplateServiceImpl implements NotificationTemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationTemplateServiceImpl.class);
	private Map<String, NotificationMessage> notificationTemplates;
	
	@Value("${notification.config.path}")
	private String notificationConfigPath;
	
	@Autowired
	private TemplateResolver templateResolver;
	
	@Autowired(required=false)
	private ServletContext servletContext;
	
	@Override
	public NotificationMessage createNotificationMessage(String templateName, Object model) {
		NotificationMessage message = notificationTemplates.get(templateName);
		if(message == null) {
			throw new CantCompleteClientRequestException("Notification template '"+templateName+"' not found");
		}
		String resolvedSubject = templateResolver.resolve(message.getSubject(), model);
		String resolvedContent = templateResolver.resolve(message.getContent(), model);
		return new NotificationMessage(resolvedSubject, resolvedContent);
	}
	
	@PostConstruct
	private void postConstruct() throws IOException{
		notificationTemplates = Collections.unmodifiableMap(getNotificationTemplates());
		LOGGER.info("Loaded {} notification templates", notificationTemplates.size());
	}
	
	protected Map<String, NotificationMessage> getNotificationTemplates() throws IOException{
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.setValidating(false);
		reader.loadBeanDefinitions(getResource());
		return beanFactory.getBeansOfType(NotificationMessage.class);
	}
	
	protected Resource getResource() throws IOException{
		for(Resource resource : getResourceCandidates()) {
			if(resource.exists()) {
				return resource;
			}
		}
		throw new IOException("Resource "+notificationConfigPath+" not found");
	}
	
	protected Iterable<Resource> getResourceCandidates(){
		List<Resource> resourceCandidates = new ArrayList<>();
		resourceCandidates.add(new ServletContextResource(servletContext, notificationConfigPath));
		resourceCandidates.add(new PathResource(notificationConfigPath));
		resourceCandidates.add(new ClassPathResource(notificationConfigPath));
		try {
			resourceCandidates.add(new UrlResource(notificationConfigPath));
		} catch (MalformedURLException e) {
			//ignore error 
		}
		return resourceCandidates;
	}
}
