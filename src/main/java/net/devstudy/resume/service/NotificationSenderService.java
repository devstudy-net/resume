package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.model.NotificationMessage;

public interface NotificationSenderService {

	void sendNotification(@Nonnull NotificationMessage message);

	@Nullable String getDestinationAddress(@Nonnull Profile profile);
}
