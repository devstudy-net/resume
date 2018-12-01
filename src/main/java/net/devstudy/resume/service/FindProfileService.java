package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.devstudy.resume.domain.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface FindProfileService {

	@Nonnull Page<Profile> findAll(@Nonnull Pageable pageable);

	@Nullable Profile findByUid(@Nonnull String uid);

	@Nonnull Page<Profile> findBySearchQuery(@Nonnull String query, @Nonnull Pageable pageable);

	void restoreAccess(@Nonnull String anyUnigueId);
	
	@Nullable Profile findByRestoreToken(@Nonnull String token);
	
	@Nonnull Iterable<Profile> findAllForIndexing();
}
