package net.devstudy.resume.component;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ImageResizer {

	void resize(@Nonnull Path sourceImageFile, @Nonnull Path destImageFile, int width, int height) throws IOException;
}
