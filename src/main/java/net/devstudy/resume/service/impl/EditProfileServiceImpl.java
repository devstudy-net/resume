package net.devstudy.resume.service.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.Constants;
import net.devstudy.resume.annotation.ProfileDataFieldGroup;
import net.devstudy.resume.annotation.ProfileInfoField;
import net.devstudy.resume.component.impl.UploadCertificateLinkManager;
import net.devstudy.resume.entity.Certificate;
import net.devstudy.resume.entity.Contacts;
import net.devstudy.resume.entity.Course;
import net.devstudy.resume.entity.Education;
import net.devstudy.resume.entity.Hobby;
import net.devstudy.resume.entity.Language;
import net.devstudy.resume.entity.Practic;
import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.ProfileEntity;
import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.exception.FormValidationException;
import net.devstudy.resume.form.InfoForm;
import net.devstudy.resume.form.PasswordForm;
import net.devstudy.resume.form.SignUpForm;
import net.devstudy.resume.model.CurrentProfile;
import net.devstudy.resume.model.UploadResult;
import net.devstudy.resume.repository.search.ProfileSearchRepository;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import net.devstudy.resume.service.EditProfileService;
import net.devstudy.resume.service.ImageProcessorService;
import net.devstudy.resume.service.ImageStorageService;
import net.devstudy.resume.service.NotificationManagerService;
import net.devstudy.resume.service.StaticDataService;
import net.devstudy.resume.util.DataUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EditProfileServiceImpl extends AbstractCreateProfileService implements EditProfileService {
	private static Logger LOGGER = LoggerFactory.getLogger(FindProfileServiceImpl.class);

	@Autowired
	private ProfileSearchRepository profileSearchRepository;

	@Autowired
	private SkillCategoryRepository skillCategoryRepository;

	@Autowired
	private StaticDataService staticDataService;

	@Autowired
	private ImageProcessorService imageProcessorService;

	@Autowired
	private ImageStorageService imageStorageService;

	@Autowired
	private NotificationManagerService notificationManagerService;

	@Autowired
	private UploadCertificateLinkManager uploadCertificateLinkManager;

	@Value("${profile.hobbies.max}")
	private int maxProfileHobbies;

	protected Set<String> profileCollectionsToReIndex = new HashSet<>();

	@PostConstruct
	private void postConstruct() {
		profileCollectionsToReIndex.add("languages");
		profileCollectionsToReIndex.add("skills");
		profileCollectionsToReIndex.add("practics");
		profileCollectionsToReIndex.add("certificates");
		profileCollectionsToReIndex.add("courses");
	}

	protected Profile getProfile(CurrentProfile currentProfile) {
		return profileRepository.findOne(currentProfile.getId());
	}

	@Override
	public Profile findProfileById(CurrentProfile currentProfile) {
		return getProfile(currentProfile);
	}

	@Override
	public Contacts findContactsById(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getContacts();
	}

	@Override
	@Transactional
	public Profile createNewProfile(SignUpForm signUpForm) {
		Profile profile = createNewProfile(signUpForm.getFirstName(), signUpForm.getLastName(), signUpForm.getPassword());
		profileRepository.save(profile);
		showProfileCreatedLogInfoIfTransactionSuccess(profile);
		return profile;
	}

	@Override
	@Transactional
	public void removeProfile(CurrentProfile currentProfile) {
		Profile profile = profileRepository.findOne(currentProfile.getId());
		List<String> imageLinksToRemove = getImageLinksToRemove(profile);
		profileRepository.delete(profile);
		removeProfileIndexIfTransactionSuccess(profile, imageLinksToRemove);
	}

	protected List<String> getImageLinksToRemove(Profile profile) {
		List<String> imageLinksToRemove = new ArrayList<>();
		imageLinksToRemove.add(profile.getLargePhoto());
		imageLinksToRemove.add(profile.getSmallPhoto());
		if (profile.getCertificates() != null) {
			for (Certificate certificate : profile.getCertificates()) {
				imageLinksToRemove.add(certificate.getLargeUrl());
				imageLinksToRemove.add(certificate.getSmallUrl());
			}
		}
		return imageLinksToRemove;
	}

	protected void removeProfileIndexIfTransactionSuccess(final Profile profile, final List<String> imageLinksToRemove) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Profile by id=" + profile.getId() + " removed from storage");
				profileSearchRepository.delete(profile.getId());
				imageStorageService.remove(imageLinksToRemove.toArray(new String[imageLinksToRemove.size()]));
				LOGGER.info("Profile by id=" + profile.getId() + " removed from search index");
			}
		});
	}

	@Override
	@Transactional
	public Profile updateProfilePassword(CurrentProfile currentProfile, PasswordForm form) {
		Profile profile = profileRepository.findOne(currentProfile.getId());
		profile.setPassword(passwordEncoder.encode(form.getPassword()));
		profileRepository.save(profile);
		sendPasswordChangedIfTransactionSuccess(profile);
		return profile;
	}

	protected void sendPasswordChangedIfTransactionSuccess(final Profile profile) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				notificationManagerService.sendPasswordChanged(profile);
			}
		});
	}

	@Override
	@Transactional
	public void updateProfileData(CurrentProfile currentProfile, Profile profileForm, MultipartFile uploadPhoto) {
		Profile loadedProfile = profileRepository.findOne(currentProfile.getId());
		List<String> oldProfilePhotos = Collections.EMPTY_LIST;
		if (!uploadPhoto.isEmpty()) {
			UploadResult uploadResult = imageProcessorService.processNewProfilePhoto(uploadPhoto);
			deleteUploadedPhotosIfTransactionFailed(uploadResult);
			oldProfilePhotos = Arrays.asList(new String[] { loadedProfile.getLargePhoto(), loadedProfile.getSmallPhoto() });
			loadedProfile.updateProfilePhotos(uploadResult.getLargeUrl(), uploadResult.getSmallUrl());
		}
		int copiedFieldsCount = DataUtil.copyFields(profileForm, loadedProfile, ProfileDataFieldGroup.class);
		boolean shouldProfileBeUpdated = !uploadPhoto.isEmpty() || copiedFieldsCount > 0;
		if (shouldProfileBeUpdated) {
			executeUpdateProfileData(currentProfile, loadedProfile, oldProfilePhotos);
		}
	}

	protected void executeUpdateProfileData(CurrentProfile currentProfile, Profile loadedProfile, List<String> oldProfilePhotos) {
		loadedProfile.setCompleted(true);
		synchronized (this) {
			checkForDuplicatesEmailAndPhone(loadedProfile);
			profileRepository.save(loadedProfile);
		}
		updateIndexProfileDataIfTransactionSuccess(currentProfile, loadedProfile, oldProfilePhotos);
	}

	protected void checkForDuplicatesEmailAndPhone(Profile profileForm) {
		Profile profileForEmail = profileRepository.findByEmail(profileForm.getEmail());
		if (profileForEmail != null && !profileForEmail.getId().equals(profileForm.getId())) {
			throw new FormValidationException("email", profileForm.getEmail());
		}
		Profile profileForPhone = profileRepository.findByPhone(profileForm.getPhone());
		if (profileForPhone != null && !profileForPhone.getId().equals(profileForm.getId())) {
			throw new FormValidationException("phone", profileForm.getPhone());
		}
	}

	protected void updateIndexProfileDataIfTransactionSuccess(final CurrentProfile currentProfile, final Profile profileForm, final List<String> oldProfilePhotos) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Profile updated");
				imageStorageService.remove(oldProfilePhotos.toArray(Constants.EMPTY_ARRAY));
				updateIndexProfileData(currentProfile, profileForm, ProfileDataFieldGroup.class);
			}
		});
	}

	protected void deleteUploadedPhotosIfTransactionFailed(final UploadResult uploadResult) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCompletion(int status) {
				if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
					imageStorageService.remove(uploadResult.getLargeUrl(), uploadResult.getSmallUrl());
				}
			}
		});
	}

	protected <T extends Annotation> void updateIndexProfileData(CurrentProfile currentProfile, Profile profileForm, Class<T> annotationClass) {
		Profile p = profileSearchRepository.findOne(currentProfile.getId());
		if (p == null) {
			createNewProfileIndex(profileForm);
		} else {
			DataUtil.copyFields(profileForm, p, annotationClass);
			if (StringUtils.isNotBlank(profileForm.getLargePhoto()) || StringUtils.isNotBlank(profileForm.getSmallPhoto())) {
				p.setLargePhoto(profileForm.getLargePhoto());
				p.setSmallPhoto(profileForm.getSmallPhoto());
			}
			profileSearchRepository.save(p);
			LOGGER.info("Profile index updated");
		}
	}

	protected void createNewProfileIndex(Profile profileForm) {
		if (profileForm.getCertificates() == null) {
			profileForm.setCertificates(Collections.EMPTY_LIST);
		}
		if (profileForm.getPractics() == null) {
			profileForm.setPractics(Collections.EMPTY_LIST);
		}
		if (profileForm.getLanguages() == null) {
			profileForm.setLanguages(Collections.EMPTY_LIST);
		}
		if (profileForm.getSkills() == null) {
			profileForm.setSkills(Collections.EMPTY_LIST);
		}
		profileSearchRepository.save(profileForm);
		LOGGER.info("New profile index created: {}", profileForm.getUid());
	}

	@Override
	@Transactional
	public void updateContacts(CurrentProfile currentProfile, Contacts contactsForm) {
		Profile loadedProfile = profileRepository.findOne(currentProfile.getId());
		int copiedFieldsCount = DataUtil.copyFields(contactsForm, loadedProfile.getContacts());
		boolean shouldProfileBeUpdated = copiedFieldsCount > 0;
		if (shouldProfileBeUpdated) {
			profileRepository.save(loadedProfile);
		} else {
			LOGGER.debug("Profile contacts not updated");
		}
	}

	@Override
	@Transactional
	public void updateInfo(CurrentProfile currentProfile, InfoForm form) {
		Profile loadedProfile = profileRepository.findOne(currentProfile.getId());
		if (!StringUtils.equals(loadedProfile.getInfo(), form.getInfo())) {
			loadedProfile.setInfo(form.getInfo());
			profileRepository.save(loadedProfile);
			updateIndexProfileInfoIfTransactionSuccess(currentProfile, loadedProfile);
		} else {
			LOGGER.debug("Profile info not updated");
		}
	}

	protected void updateIndexProfileInfoIfTransactionSuccess(final CurrentProfile currentProfile, final Profile loadedProfile) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Updated info for profile: {}", loadedProfile);
				updateIndexProfileData(currentProfile, loadedProfile, ProfileInfoField.class);
				LOGGER.info("Updated info for profile index: {}", loadedProfile);
			}
		});
	}

	@Override
	public List<Hobby> listHobbiesWithProfileSelected(CurrentProfile currentProfile) {
		List<Hobby> profileHobbies = getProfile(currentProfile).getHobbies();
		List<Hobby> hobbies = new ArrayList<>();
		for (Hobby h : staticDataService.listAllHobbies()) {
			boolean selected = profileHobbies.contains(h);
			hobbies.add(new Hobby(h.getName(), selected));
		}
		return hobbies;
	}

	@Override
	@Transactional
	public void updateHobbies(CurrentProfile currentProfile, List<String> hobbies) {
		List<Hobby> updatedHobbies = staticDataService.createHobbyEntitiesByNames(hobbies);
		if (updatedHobbies.size() > maxProfileHobbies) {
			throw new CantCompleteClientRequestException("Detected more than " + maxProfileHobbies + " hobbies for profile: currentProfile=" + currentProfile + ", hobbies=" + updatedHobbies);
		}
		updateProfileEntities(currentProfile, updatedHobbies, Hobby.class);
	}

	@Override
	public List<Language> listLanguages(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getLanguages();
	}

	@Override
	@Transactional
	public void updateLanguages(CurrentProfile currentProfile, List<Language> languages) {
		updateProfileEntities(currentProfile, languages, Language.class);
	}

	@Override
	public List<Skill> listSkills(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getSkills();
	}

	@Override
	public List<SkillCategory> listSkillCategories() {
		return skillCategoryRepository.findAll(new Sort(SkillCategory.ORDER_FIELD_NAME));
	}

	@Override
	@Transactional
	public void updateSkills(CurrentProfile currentProfile, List<Skill> skills) {
		populateSkillCategories(skills);
		updateProfileEntities(currentProfile, skills, Skill.class);
	}

	protected void populateSkillCategories(List<Skill> skills) {
		List<SkillCategory> list = listSkillCategories();
		Map<Short, String> map = convertSkillCategoryListToMap(list);
		for (Skill skill : skills) {
			skill.setCategory(map.get(skill.getIdCategory()));
		}
	}

	protected Map<Short, String> convertSkillCategoryListToMap(List<SkillCategory> list) {
		Map<Short, String> map = new HashMap<>();
		for (SkillCategory category : list) {
			map.put(category.getIdCategory(), category.getCategory());
		}
		return map;
	}

	@Override
	public List<Practic> listPractics(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getPractics();
	}

	@Override
	@Transactional
	public void updatePractics(CurrentProfile currentProfile, List<Practic> practics) {
		updateProfileEntities(currentProfile, practics, Practic.class);
	}

	@Override
	public List<Education> listEducations(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getEducations();
	}

	@Override
	@Transactional
	public void updateEducations(CurrentProfile currentProfile, List<Education> educations) {
		updateProfileEntities(currentProfile, educations, Education.class);
	}

	@Override
	public List<Certificate> listCertificates(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getCertificates();
	}

	@Override
	@Transactional
	public void updateCertificates(CurrentProfile currentProfile, List<Certificate> certificates) {
		List<Certificate> loadedCertificates = listCertificates(currentProfile);
		List<String> certificateImages = DataUtil.getCertificateImageUrls(loadedCertificates);
		updateProfileEntities(currentProfile, certificates, Certificate.class);
		for (Certificate certificate : certificates) {
			certificateImages.remove(certificate.getLargeUrl());
			certificateImages.remove(certificate.getSmallUrl());
		}
		clearResourcesIfTransactionSuccess(certificateImages);
	}

	protected void clearResourcesIfTransactionSuccess(final List<String> certificateImages) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				uploadCertificateLinkManager.clearImageLinks();
				imageStorageService.remove(certificateImages.toArray(Constants.EMPTY_ARRAY));
			}
		});
	}

	@Override
	public List<Course> listCourses(CurrentProfile currentProfile) {
		return getProfile(currentProfile).getCourses();
	}

	@Override
	@Transactional
	public void updateCourses(CurrentProfile currentProfile, List<Course> courses) {
		updateProfileEntities(currentProfile, courses, Course.class);
	}

	protected <E extends ProfileEntity> void updateProfileEntities(CurrentProfile currentProfile, List<E> updatedData, Class<E> entityClass) {
		String collections = DataUtil.getCollectionName(entityClass);
		Profile profile = getProfile(currentProfile);
		List<E> profileData = getProfileEntities(profile, collections);
		DataUtil.removeEmptyElements(updatedData);
		if (Comparable.class.isAssignableFrom(entityClass)) {
			Collections.sort((List<? extends Comparable>) updatedData);
		}
		if (DataUtil.areListsEqual(updatedData, profileData)) {
			LOGGER.debug("Profile {}: nothing to update", collections);
			return;
		} else {
			executeProfileEntitiesUpdate(profile, updatedData, collections);
			updateIndexProfileEntitiesIfTransactionSuccess(currentProfile, updatedData, collections);
		}
	}

	protected <E extends ProfileEntity> List<E> getProfileEntities(Profile profile, String collections) {
		List<E> profileData = (List<E>) DataUtil.readProperty(profile, collections);
		if (profileData == null) {
			profileData = Collections.EMPTY_LIST;
		}
		return profileData;
	}

	protected <E extends ProfileEntity> void executeProfileEntitiesUpdate(Profile profile, List<E> updatedData, String collections) {
		DataUtil.writeProperty(profile, collections, updatedData);
		profileRepository.save(profile);
	}

	protected <E extends ProfileEntity> void updateIndexProfileEntitiesIfTransactionSuccess(final CurrentProfile currentProfile, final List<E> updatedData, final String collections) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Profile {} updated", collections);
				if (profileCollectionsToReIndex.contains(collections)) {
					updateIndexProfileEntities(currentProfile, updatedData, collections);
				}
			}
		});
	}

	protected <E> void updateIndexProfileEntities(CurrentProfile currentProfile, List<E> updatedData, String collections) {
		Profile profile = profileSearchRepository.findOne(currentProfile.getId());
		DataUtil.writeProperty(profile, collections, updatedData);
		profileSearchRepository.save(profile);
		LOGGER.info("Profile {} index updated", collections);
	}
}
