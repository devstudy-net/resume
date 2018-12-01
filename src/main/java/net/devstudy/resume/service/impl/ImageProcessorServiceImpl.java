package net.devstudy.resume.service.impl;

import static net.devstudy.resume.Constants.UIImageType.AVATARS;
import static net.devstudy.resume.Constants.UIImageType.CERTIFICATES;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.Constants.UIImageType;
import net.devstudy.resume.annotation.EnableUploadImageTempStorage;
import net.devstudy.resume.component.DataBuilder;
import net.devstudy.resume.component.ImageFormatConverter;
import net.devstudy.resume.component.ImageOptimizator;
import net.devstudy.resume.component.ImageResizer;
import net.devstudy.resume.component.impl.UploadCertificateLinkTempStorage;
import net.devstudy.resume.component.impl.UploadImageTempStorage;
import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.model.UploadCertificateResult;
import net.devstudy.resume.model.UploadResult;
import net.devstudy.resume.model.UploadTempPath;
import net.devstudy.resume.service.ImageProcessorService;
import net.devstudy.resume.service.ImageStorageService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Service
public class ImageProcessorServiceImpl implements ImageProcessorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageProcessorServiceImpl.class);
	
	@Autowired
	@Qualifier("pngToJpegImageFormatConverter")
	private ImageFormatConverter pngToJpegImageFormatConverter;
	
	@Autowired
	private ImageResizer imageResizer;
	
	@Autowired
	private ImageOptimizator imageOptimizator;
	
	@Autowired
	private ImageStorageService imageStorageService;
	
	@Autowired
	private UploadImageTempStorage uploadImageTempStorage;
	
	@Autowired
	private UploadCertificateLinkTempStorage uploadCertificateLinkManager;
	
	@Autowired
	protected DataBuilder dataBuilder;

	@Override
	@EnableUploadImageTempStorage
	public UploadResult processNewProfilePhoto(MultipartFile upload) {
		try {
			return processUpload(upload, AVATARS);
		} catch (IOException e) {
			throw new CantCompleteClientRequestException("Can't save profile photo upload: " + e.getMessage(), e);
		}
	}

	@Override
	@EnableUploadImageTempStorage
	public UploadCertificateResult processNewCertificateImage(MultipartFile upload) {
		try {
			UploadResult photoLinks = processUpload(upload, CERTIFICATES);
			uploadCertificateLinkManager.addImageLinks(photoLinks.getLargeUrl(), photoLinks.getSmallUrl());
			String certificateName = dataBuilder.buildCertificateName(upload.getOriginalFilename());
			return new UploadCertificateResult(certificateName, photoLinks.getLargeUrl(), photoLinks.getSmallUrl());
		} catch (IOException e) {
			throw new CantCompleteClientRequestException("Can't save certificate image upload: " + e.getMessage(), e);
		}
	}
	
	protected UploadResult processUpload(MultipartFile multipartFile, UIImageType imageType) throws IOException {
		String largePhoto = generateNewFileName();
		String smallPhoto = getSmallImageName(largePhoto);
		UploadTempPath uploadTempPath = getCurrentUploadTempPath();
		transferUploadToFile(multipartFile, uploadTempPath.getLargeImagePath());
		resizeAndOptimizeUpload(uploadTempPath, imageType);
		String largePhotoLink = imageStorageService.createImageLink(largePhoto, imageType);
		imageStorageService.save(largePhotoLink, uploadTempPath.getLargeImagePath());
		String smallPhotoLink = imageStorageService.createImageLink(smallPhoto, imageType);
		imageStorageService.save(smallPhotoLink, uploadTempPath.getSmallImagePath());
		return new UploadResult(largePhotoLink, smallPhotoLink);
	}
	
	protected void resizeAndOptimizeUpload(UploadTempPath uploadTempPath, UIImageType imageType) throws IOException {
		imageResizer.resize(uploadTempPath.getLargeImagePath(), uploadTempPath.getSmallImagePath(), imageType.getSmallWidth(), imageType.getSmallHeight());
		imageOptimizator.optimize(uploadTempPath.getSmallImagePath());
		imageResizer.resize(uploadTempPath.getLargeImagePath(), uploadTempPath.getLargeImagePath(), imageType.getLargeWidth(), imageType.getLargeHeight());
		imageOptimizator.optimize(uploadTempPath.getLargeImagePath());
	}

	protected String generateNewFileName() {
		return UUID.randomUUID().toString() + ".jpg";
	}

	protected String getSmallImageName(String largePhoto) {
		return largePhoto.replace(".jpg", "-sm.jpg");
	}
	
	protected UploadTempPath getCurrentUploadTempPath(){
		return uploadImageTempStorage.getCurrentUploadTempPath();
	}
	
	protected void transferUploadToFile(MultipartFile uploadPhoto, Path destPath) throws IOException {
		String contentType = uploadPhoto.getContentType();
		LOGGER.debug("Content type for upload {}", contentType);
		uploadPhoto.transferTo(destPath.toFile());
		if (contentType.contains("png")) {
			pngToJpegImageFormatConverter.convert(destPath, destPath);
		} else if (!contentType.contains("jpg") && !contentType.contains("jpeg")) {
			throw new CantCompleteClientRequestException("Only png and jpg image formats are supported: Current content type=" + contentType);
		}
	}
}
