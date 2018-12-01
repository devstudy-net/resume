package net.devstudy.resume.component;

import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ImageFormatConverter {

	void convertImage(@Nonnull Path sourceImageFile, @Nonnull Path destImageFile) throws IOException;
}
