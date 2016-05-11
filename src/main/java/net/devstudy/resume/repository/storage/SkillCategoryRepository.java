package net.devstudy.resume.repository.storage;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;

import net.devstudy.resume.entity.SkillCategory;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@RepositoryDefinition(domainClass=SkillCategory.class, idClass=Long.class)
public interface SkillCategoryRepository {

	List<SkillCategory> findAll(Sort sort);
}
