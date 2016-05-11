package net.devstudy.resume.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Embeddable
@Access(AccessType.FIELD)
public class Contacts implements Serializable {
	private static final long serialVersionUID = -3685720846934765841L;
	
	@Column(length = 80)
	private String skype;

	@Column(length = 255)
	private String vkontakte;

	@Column(length = 255)
	private String facebook;

	@Column(length = 255)
	private String linkedin;

	@Column(length = 255)
	private String github;
	
	@Column(length = 255)
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
