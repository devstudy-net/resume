package net.devstudy.resume.service;

import javax.annotation.Nonnull;

import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.model.UploadCertificateResult;
import net.devstudy.resume.model.UploadResult;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ImageProcessorService {

	@Nonnull UploadResult processNewProfilePhoto(@Nonnull MultipartFile uploadPhoto);

	@Nonnull UploadCertificateResult processNewCertificateImage(@Nonnull MultipartFile uploadCertificateImage);
}
