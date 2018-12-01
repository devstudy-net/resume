package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.domain.Profile;
import net.devstudy.resume.model.NotificationMessage;

public interface NotificationSenderService {

	void sendNotification(@Nonnull NotificationMessage message);

	@Nullable String findDestinationAddress(@Nonnull Profile profile);
}
