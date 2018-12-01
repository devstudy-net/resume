package net.devstudy.resume.service;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.entity.Certificate;
import net.devstudy.resume.entity.Contacts;
import net.devstudy.resume.entity.Course;
import net.devstudy.resume.entity.Education;
import net.devstudy.resume.entity.Hobby;
import net.devstudy.resume.entity.Language;
import net.devstudy.resume.entity.Practic;
import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.form.InfoForm;
import net.devstudy.resume.form.PasswordForm;
import net.devstudy.resume.form.SignUpForm;
import net.devstudy.resume.model.CurrentProfile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface EditProfileService {

	@Nullable Profile findProfileById(@Nonnull CurrentProfile currentProfile);
	
	@Nonnull Contacts findContactsById(@Nonnull CurrentProfile currentProfile);

	@Nonnull Profile createNewProfile(@Nonnull SignUpForm signUpForm);

	void removeProfile(@Nonnull CurrentProfile currentProfile);

	@Nonnull Profile updateProfilePassword(@Nonnull CurrentProfile currentProfile, @Nonnull PasswordForm form);

	void updateProfileData(@Nonnull CurrentProfile currentProfile, @Nonnull Profile data, @Nonnull MultipartFile uploadPhoto);

	void updateContacts(@Nonnull CurrentProfile currentProfile, @Nonnull Contacts data);
	
	void updateInfo(@Nonnull CurrentProfile currentProfile, @Nonnull InfoForm form);

	@Nonnull List<Hobby> listHobbiesWithProfileSelected(@Nonnull CurrentProfile currentProfile);

	void updateHobbies(@Nonnull CurrentProfile currentProfile, @Nonnull List<String> hobbies);

	@Nonnull List<Language> listLanguages(@Nonnull CurrentProfile currentProfile);

	void updateLanguages(@Nonnull CurrentProfile currentProfile, @Nonnull List<Language> languages);

	@Nonnull List<Skill> listSkills(@Nonnull CurrentProfile currentProfile);

	@Nonnull List<SkillCategory> listSkillCategories();

	void updateSkills(@Nonnull CurrentProfile currentProfile, @Nonnull List<Skill> skills);

	@Nonnull List<Practic> listPractics(@Nonnull CurrentProfile currentProfile);

	void updatePractics(@Nonnull CurrentProfile currentProfile, @Nonnull List<Practic> practics);

	@Nonnull List<Education> listEducations(@Nonnull CurrentProfile currentProfile);

	void updateEducations(@Nonnull CurrentProfile currentProfile, @Nonnull List<Education> educations);

	@Nonnull List<Certificate> listCertificates(@Nonnull CurrentProfile currentProfile);
	
	void updateCertificates(@Nonnull CurrentProfile currentProfile, @Nonnull List<Certificate> certificates);
	
	@Nonnull List<Course> listCourses(@Nonnull CurrentProfile currentProfile);
	
	void updateCourses(@Nonnull CurrentProfile currentProfile, @Nonnull List<Course> courses);
}
