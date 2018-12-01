package net.devstudy.resume.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Certificate implements Serializable, ProfileEntity {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String largeUrl;
	
	@JsonIgnore
	private String smallUrl;

	@SafeHtml
	@EnglishLanguage
	private String name;
	
	public Certificate() {
	}

	public String getLargeUrl() {
		return largeUrl;
	}

	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}

	public String getSmallUrl() {
		return smallUrl;
	}

	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((largeUrl == null) ? 0 : largeUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((smallUrl == null) ? 0 : smallUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Certificate))
			return false;
		Certificate other = (Certificate) obj;
		if (largeUrl == null) {
			if (other.largeUrl != null)
				return false;
		} else if (!largeUrl.equals(other.largeUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smallUrl == null) {
			if (other.smallUrl != null)
				return false;
		} else if (!smallUrl.equals(other.smallUrl))
			return false;
		return true;
	}
}