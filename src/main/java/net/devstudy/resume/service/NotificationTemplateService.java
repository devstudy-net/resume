package net.devstudy.resume.service;

import net.devstudy.resume.model.NotificationMessage;

public interface NotificationTemplateService {

	NotificationMessage createNotificationMessage (String templateName, Object model);
}
