package net.devstudy.resume.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.devstudy.resume.entity.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface FindProfileService {

	Profile findByUid(String uid);
	
	Page<Profile> findAll(Pageable pageable);
}
