package net.devstudy.resume.service.impl;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.devstudy.resume.domain.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RemoveNotCompletedProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoveNotCompletedProfileService.class);
	
	@Transactional
	@Scheduled(cron = "0 59 23 * * *")
	public void removeNotCompletedProfiles() {
		DateTime date = DateTime.now().minusDays(removeNotCompletedProfilesInterval);
		int removed = 0;
		for(Profile profile : profileRepository.findByCompletedFalseAndCreatedBefore(new Date(date.getMillis()))) {
			profileRepository.delete(profile);
			removed++;
		}
		LOGGER.info("Removed {} profiles", removed);
	}
	
	@Autowired
	private ProfileRepository profileRepository;

	@Value("${remove.not.completed.profiles.interval}")
	private int removeNotCompletedProfilesInterval;
}
