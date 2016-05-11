package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.model.NotificationMessage;

public interface NotificationSenderService {

	void sendNotification(NotificationMessage message);

	String getDestinationAddress(Profile profile);
}
