package net.devstudy.resume.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Adds rules for conversion from form validation to field validation for display errors on UI.
 * 
 * For example, class net.devstudy.resume.form.PasswordForm has FieldMatch validation annotation and 
 * EnableFormErrorConversion which convert FieldMatch form error to error for confirmPassword field.
 * 
 * Please look at net.devstudy.resume.component.impl.FormErrorConverterImpl component for details
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Target({ TYPE })
@Retention(RUNTIME)
@Documented
public @interface EnableFormErrorConversion {

	String formName();
	
	String fieldReference();
	
	Class<? extends Annotation> validationAnnotationClass();
	
	@Target({ TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EnableFormErrorConversion[] value();
	}
}
