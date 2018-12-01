package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.domain.Profile;

public interface SocialService<T> {
	
	@Nullable Profile login(@Nonnull T model);
	
	@Nullable Profile createNewProfile(@Nonnull T model);
}
