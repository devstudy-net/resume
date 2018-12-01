package net.devstudy.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Marker annotation which marks info field from Profile document. 
 * This marker is used for updating profile document by reflection
 * 
 * Please look at net.devstudy.resume.service.impl.EditProfileServiceImpl.updateIndexProfileInfoIfTransactionSuccess() for details 
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Retention(RUNTIME)
public @interface ProfileInfoField {

}
