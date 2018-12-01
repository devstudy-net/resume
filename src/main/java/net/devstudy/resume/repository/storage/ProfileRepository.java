package net.devstudy.resume.repository.storage;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.devstudy.resume.domain.Profile;

/**
 *  
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ProfileRepository extends PagingAndSortingRepository<Profile, String> {

	Profile findByUid(String uid);
	
	Profile findByEmail(String email);
	
	Profile findByPhone(String phone);
	
	Profile findByUidOrEmailOrPhone(String uid, String email, String phone);
	
	int countByUid(String uid);
	
	Page<Profile> findAllByCompletedTrue(Pageable pageable);
	
	List<Profile> findByCompletedFalseAndCreatedBefore(Date created);
}
