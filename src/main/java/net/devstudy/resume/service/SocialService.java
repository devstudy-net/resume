package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.entity.Profile;

public interface SocialService<T> {

	@Nullable Profile loginOrSignup(@Nonnull T model);
}
