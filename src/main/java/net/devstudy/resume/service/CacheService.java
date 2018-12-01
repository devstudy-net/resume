package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.entity.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface CacheService {

	@Nullable Profile findProfileByUid(@Nonnull String uid);
	
	void deleteProfileByUid(@Nonnull String uid);
}
