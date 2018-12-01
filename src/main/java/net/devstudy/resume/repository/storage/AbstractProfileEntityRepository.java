package net.devstudy.resume.repository.storage;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@NoRepositoryBean
public interface AbstractProfileEntityRepository<T> extends Repository<T, Long> {

	void deleteByProfileId(Long idProfile);
	
	List<T> findByProfileIdOrderByIdAsc(Long idProfile);
	
	<S extends T> S saveAndFlush(S entity);
	
	void flush();
}
