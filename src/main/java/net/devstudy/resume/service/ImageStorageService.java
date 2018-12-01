package net.devstudy.resume.service;

import java.nio.file.Path;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.devstudy.resume.Constants.UIImageType;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ImageStorageService {
	
	@Nonnull String saveAndReturnImageLink (@Nonnull String imageName, @Nonnull UIImageType imageType, @Nonnull Path tempImageFile);

	void remove (@Nullable String ... imageLinks);
}
