package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface NotificationManagerService {

	void sendRestoreAccessLink(Profile profile, String restoreLink);

	void sendPasswordChanged(Profile profile);
}
