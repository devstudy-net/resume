package net.devstudy.resume.service;

import java.util.List;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.domain.Certificate;
import net.devstudy.resume.domain.Contacts;
import net.devstudy.resume.domain.Course;
import net.devstudy.resume.domain.Education;
import net.devstudy.resume.domain.Hobby;
import net.devstudy.resume.domain.Language;
import net.devstudy.resume.domain.Practic;
import net.devstudy.resume.domain.Profile;
import net.devstudy.resume.domain.Skill;
import net.devstudy.resume.domain.SkillCategory;
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

	@Nonnull Profile findProfileById(@Nonnull CurrentProfile currentProfile);
	
	@Nonnull Contacts findContactsById(@Nonnull CurrentProfile currentProfile);

	@Nonnull Profile createNewProfile(@Nonnull SignUpForm signUpForm);

	void removeProfile(@Nonnull CurrentProfile currentProfile);

	@Nonnull Profile updateProfilePassword(@Nonnull CurrentProfile currentProfile, @Nonnull PasswordForm form);

	void updateProfileData(@Nonnull CurrentProfile currentProfile, @Nonnull Profile data, @Nonnull MultipartFile uploadPhoto);

	void updateContacts(@Nonnull CurrentProfile currentProfile, @Nonnull Contacts data);
	
	void updateInfo(@Nonnull CurrentProfile currentProfile, @Nonnull InfoForm form);

	@Nonnull List<Hobby> findHobbiesWithProfileSelected(@Nonnull CurrentProfile currentProfile);

	void updateHobbies(@Nonnull CurrentProfile currentProfile, @Nonnull List<String> hobbies);

	@Nonnull List<Language> findLanguages(@Nonnull CurrentProfile currentProfile);

	void updateLanguages(@Nonnull CurrentProfile currentProfile, @Nonnull List<Language> languages);

	@Nonnull List<Skill> findSkills(@Nonnull CurrentProfile currentProfile);

	@Nonnull List<SkillCategory> findSkillCategories();

	void updateSkills(@Nonnull CurrentProfile currentProfile, @Nonnull List<Skill> skills);

	@Nonnull List<Practic> findPractics(@Nonnull CurrentProfile currentProfile);

	void updatePractics(@Nonnull CurrentProfile currentProfile, @Nonnull List<Practic> practics);

	@Nonnull List<Education> findEducations(@Nonnull CurrentProfile currentProfile);

	void updateEducations(@Nonnull CurrentProfile currentProfile, @Nonnull List<Education> educations);

	@Nonnull List<Certificate> findCertificates(@Nonnull CurrentProfile currentProfile);
	
	void updateCertificates(@Nonnull CurrentProfile currentProfile, @Nonnull List<Certificate> certificates);
	
	@Nonnull List<Course> findCourses(@Nonnull CurrentProfile currentProfile);
	
	void updateCourses(@Nonnull CurrentProfile currentProfile, @Nonnull List<Course> courses);
}
