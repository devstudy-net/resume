package net.devstudy.resume.service;

import java.util.List;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.form.SignUpForm;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface EditProfileService {

	Profile createNewProfile(SignUpForm signUpForm);
	
	List<Skill> listSkills(long idProfile);

	List<SkillCategory> listSkillCategories();
	
	void updateSkills(long idProfile, List<Skill> skills);
}
