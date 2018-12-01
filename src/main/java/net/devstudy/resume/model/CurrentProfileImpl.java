package net.devstudy.resume.model;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import net.devstudy.resume.Constants;
import net.devstudy.resume.entity.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CurrentProfileImpl extends User implements CurrentProfile {
	private static final long serialVersionUID = 3850489832510630519L;
	private final String id;
	private final String fullName;

	public CurrentProfileImpl(Profile profile) {
		super(profile.getUid(), profile.getPassword(), true, true, true, true, 
				Collections.singleton(new SimpleGrantedAuthority(Constants.USER)));
		this.id = profile.getId();
		this.fullName = profile.getFullName();
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getUid() {
		return getUsername();
	}
	
	public String getFullName() {
		return fullName;
	}

	@Override
	public String toString() {
		return String.format("CurrentProfile [id=%s, username=%s]", id, getUsername());
	}
}
