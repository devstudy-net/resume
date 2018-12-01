package net.devstudy.resume.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import net.devstudy.resume.entity.Hobby;
import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface StaticDataService {

	@Nonnull Set<Hobby> listAllHobbies();
	
	@Nonnull List<Hobby> createHobbyEntitiesByNames(@Nonnull List<String> names);
	
	@Nonnull Map<Integer, String> mapMonths();
	
	@Nonnull List<Integer> listPracticsYears();
	
	@Nonnull List<Integer> listCourcesYears();
	
	@Nonnull List<Integer> listEducationYears();
	
	@Nonnull Collection<LanguageType> getAllLanguageTypes(); 
	
	@Nonnull Collection<LanguageLevel> getAllLanguageLevels();
}
