package net.devstudy.resume.component.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.model.UploadTempPath;

@Aspect
@Component
public class UploadImageTempStorage {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadImageTempStorage.class);
	private final ThreadLocal<UploadTempPath> currentUploadTempPath = new ThreadLocal<>();

	@Around("@annotation(net.devstudy.resume.annotation.EnableUploadImageTempStorage)")
	public Object advice(ProceedingJoinPoint pjp) throws Throwable {
		UploadTempPath uploadTempPath = null;
		try {
			uploadTempPath = new UploadTempPath();
			currentUploadTempPath.set(uploadTempPath);
			LOGGER.debug("Before method: {}", pjp.getSignature());
			return pjp.proceed();
		} catch (IOException e) {
			throw new CantCompleteClientRequestException("Can't create temp image files: " + e.getMessage(), e);
		} finally {
			LOGGER.debug("After method: {}", pjp.getSignature());
			currentUploadTempPath.remove();
			if (uploadTempPath != null) {
				deleteQuietly(uploadTempPath.getLargeImagePath());
				deleteQuietly(uploadTempPath.getSmallImagePath());
			}
		}
	}
	
	public UploadTempPath getCurrentUploadTempPath() {
		return currentUploadTempPath.get();
	}
	
	protected void deleteQuietly(Path path) {
		try {
			Files.deleteIfExists(path);
			LOGGER.debug("Delete temp file {} successful", path);
		} catch (IOException e) {
			LOGGER.warn("Can't remove temp file: " + path, e);
		}
	}
}
