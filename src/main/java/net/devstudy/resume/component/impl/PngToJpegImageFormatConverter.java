package net.devstudy.resume.component.impl;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import net.devstudy.resume.component.ImageFormatConverter;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component("pngToJpegImageFormatConverter")
public class PngToJpegImageFormatConverter implements ImageFormatConverter {

	@Override
	public void convertImage(Path sourceImageFile, Path destImageFile) throws IOException {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(sourceImageFile.toFile());
			BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			ImageIO.write(newBufferedImage, "jpg", destImageFile.toFile());
		} finally {
			if (bufferedImage != null) {
				bufferedImage.flush();
			}
		}
	}
}
