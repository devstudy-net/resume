package net.devstudy.resume.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Marker annotation which groups the fields from Profile document into field list, 
 * which should be used for updating profile data. This marker is used for updating profile document by reflection.
 * 
 * Please look at net.devstudy.resume.service.impl.EditProfileServiceImpl.updateProfileData() for details 
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Retention(RUNTIME)
public @interface ProfileDataFieldGroup {

}
