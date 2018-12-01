package net.devstudy.resume.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Document(collection="profileRestore")
public class ProfileRestore extends AbstractDocument<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@DBRef
	private Profile profile;

	private String token;
	
	public ProfileRestore() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}