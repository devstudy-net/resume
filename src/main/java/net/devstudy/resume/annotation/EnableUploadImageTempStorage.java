package net.devstudy.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Adds net.devstudy.resume.component.impl.UploadImageTempStorage around aspect for method annotated by this annotation
 * 
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Retention(RUNTIME)
public @interface EnableUploadImageTempStorage {

}
