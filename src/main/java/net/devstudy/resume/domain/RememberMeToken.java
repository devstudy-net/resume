package net.devstudy.resume.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Document(collection="rememberMeToken")
public class RememberMeToken extends PersistentRememberMeToken {

	@Id
    private String id;
	
	@PersistenceConstructor
	public RememberMeToken(String id, String username, String series, String tokenValue, Date date) {
		super(username, series, tokenValue, date);
		this.id = id;
	}
	
	public RememberMeToken(PersistentRememberMeToken token) {
		super(token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate());
		this.id = null;
	}
	
	public String getId() {
		return id;
	}
}
