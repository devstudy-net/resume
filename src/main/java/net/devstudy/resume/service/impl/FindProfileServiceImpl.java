package net.devstudy.resume.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.model.CurrentProfile;
import net.devstudy.resume.repository.search.ProfileSearchRepository;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.service.FindProfileService;

@Service
public class FindProfileServiceImpl implements FindProfileService, UserDetailsService{
	private static final Logger LOGGER = LoggerFactory.getLogger(FindProfileServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private ProfileSearchRepository profileSearchRepository;
	
	@Override
	public Profile findByUid(String uid) {
		return profileRepository.findByUid(uid);
	}
	
	@Override
	public Page<Profile> findAll(Pageable pageable) {
		return profileRepository.findAll(pageable);
	}
	
	@Override
	@Transactional
	public Iterable<Profile> findAllForIndexing() {
		Iterable<Profile> all = profileRepository.findAll();
		for(Profile p : all) {
			p.getSkills().size();
			p.getCertificates().size();
			p.getLanguages().size();
			p.getPractics().size();
			p.getCourses().size();
		}
		return all;
	}
	
	@Override
	public Page<Profile> findBySearchQuery(String query, Pageable pageable) {
		return profileSearchRepository.findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
				query, query, query, query, pageable);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Profile profile = findProfile(username);
		if (profile != null) {
			return new CurrentProfile(profile);
		} else {
			LOGGER.error("Profile not found by " + username);
			throw new UsernameNotFoundException("Profile not found by " + username);
		}
	}
	
	private Profile findProfile(String anyUnigueId) {
		Profile profile = profileRepository.findByUid(anyUnigueId);
		if (profile == null) {
			profile = profileRepository.findByEmail(anyUnigueId);
			if (profile == null) {
				profile = profileRepository.findByPhone(anyUnigueId);
			}
		}
		return profile;
	}
}
