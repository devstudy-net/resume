package net.devstudy.resume.component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface DataBuilder {

	@Nonnull String buildProfileUid(@Nonnull String firstName, @Nonnull String lastName);
	
	@Nonnull String buildRestoreAccessLink(@Nonnull String appHost, @Nonnull String token);
	
	@Nonnull String rebuildUidWithRandomSuffix(@Nonnull String baseUid, @Nonnull String alphabet, int letterCount);
	
	@Nullable String buildCertificateName(@Nullable String fileName);
}
