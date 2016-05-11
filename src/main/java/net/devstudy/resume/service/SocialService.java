package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;

public interface SocialService<T> {

	Profile loginViaSocialNetwork(T model);
}
