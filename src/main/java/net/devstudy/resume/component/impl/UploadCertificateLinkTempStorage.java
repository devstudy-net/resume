package net.devstudy.resume.component.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import net.devstudy.resume.service.ImageStorageService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component
@Scope(scopeName="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UploadCertificateLinkTempStorage implements Serializable{
	private static final long serialVersionUID = -8075703850628908992L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadCertificateLinkTempStorage.class);
	@Autowired
	private transient ImageStorageService imageStorageService;
	
	private List<String> imageLinks;
	protected List<String> getImageLinks(){
		if(imageLinks == null) {
			imageLinks = new ArrayList<>(6);
		}
		return imageLinks;
	}
	
	public final void addImageLinks(String largeImageLink, String smallImageLink) {
		getImageLinks().add(largeImageLink);
		getImageLinks().add(smallImageLink);
	}
	
	public final void clearImageLinks(){
		getImageLinks().clear();
	}
	
	@PreDestroy
	private void preDestroy(){
		if(!getImageLinks().isEmpty()) {
			for(String link : getImageLinks()) {
				imageStorageService.remove(link);
			}
			LOGGER.info("Removed {} temporary images", imageLinks);
		}
	}
}
