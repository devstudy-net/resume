package net.devstudy.resume.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Contacts implements Serializable {
	private static final long serialVersionUID = -3685720846934765841L;
	
	@SafeHtml
	@EnglishLanguage
	private String skype;

	@EnglishLanguage
	@URL(host="vk.com")
	private String vkontakte;

	@EnglishLanguage
	@URL(host="facebook.com")
	private String facebook;

	@EnglishLanguage
	@URL(host="linkedin.com")
	private String linkedin;

	@EnglishLanguage
	@URL(host="github.com")
	private String github;
	
	@EnglishLanguage
	@URL(host="stackoverflow.com")
	private String stackoverflow;

	public Contacts() {
		super();
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getVkontakte() {
		return vkontakte;
	}

	public void setVkontakte(String vkontakte) {
		this.vkontakte = vkontakte;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getStackoverflow() {
		return stackoverflow;
	}

	public void setStackoverflow(String stackoverflow) {
		this.stackoverflow = stackoverflow;
	}
}
