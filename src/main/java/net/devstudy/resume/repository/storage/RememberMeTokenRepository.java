package net.devstudy.resume.repository.storage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.devstudy.resume.entity.RememberMeToken;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface RememberMeTokenRepository extends CrudRepository<RememberMeToken, String> {

	RememberMeToken findBySeries(String series);

	List<RememberMeToken> findByUsername(String username);
}
