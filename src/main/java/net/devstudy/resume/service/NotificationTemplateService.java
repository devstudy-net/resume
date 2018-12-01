package net.devstudy.resume.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.model.NotificationMessage;

public interface NotificationTemplateService {

	@Nonnull NotificationMessage createNotificationMessage (@Nonnull String templateName, @Nullable Object model);
}
