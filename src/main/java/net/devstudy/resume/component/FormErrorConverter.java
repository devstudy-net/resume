package net.devstudy.resume.component;

import java.lang.annotation.Annotation;

import javax.annotation.Nonnull;

import org.springframework.validation.BindingResult;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface FormErrorConverter {

	void convertFormErrorToFieldError(@Nonnull Class<? extends Annotation> validationAnnotationClass, @Nonnull Object formInstance, @Nonnull BindingResult bindingResult);
}
