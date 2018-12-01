package net.devstudy.resume.form;

import org.hibernate.validator.constraints.SafeHtml;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.domain.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class InfoForm {

	@EnglishLanguage
	@SafeHtml
	private String info;

	public InfoForm() {
		super();
	}

	public InfoForm(String info) {
		super();
		this.info = info;
	}
	
	public InfoForm(Profile profile) {
		super();
		this.info = profile.getInfo();
	}

	public String getInfo() {
		return info != null ? info.trim() : null;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
