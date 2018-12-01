package net.devstudy.resume.repository.storage;

import org.springframework.data.repository.CrudRepository;

import net.devstudy.resume.entity.ProfileRestore;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, String> {
	
	ProfileRestore findByToken(String token);
	
	ProfileRestore findByProfileId(String id);
}
