package net.devstudy.resume.component.impl;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.stereotype.Component;

import net.coobird.thumbnailator.Thumbnails;
import net.devstudy.resume.component.ImageResizer;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component
public class ThumbnailsImageResizer implements ImageResizer {

	@Override
	public void resize(Path sourceImageFile, Path destImageFile, int width, int height) throws IOException {
		Thumbnails.of(sourceImageFile.toFile()).size(width, height).toFile(destImageFile.toFile());
	}
}
