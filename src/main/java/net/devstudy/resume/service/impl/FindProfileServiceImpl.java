package net.devstudy.resume.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.service.FindProfileService;

@Service
public class FindProfileServiceImpl implements FindProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Profile findByUid(String uid) {
		return profileRepository.findByUid(uid);
	}
}
