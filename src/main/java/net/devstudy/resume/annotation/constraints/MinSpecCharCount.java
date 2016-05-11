package net.devstudy.resume.annotation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy={})
public @interface MinSpecCharCount {

	int value() default 1;
	
	String specSymbols() default "!@~`#$%^&*()_-+=|\\/{}[].,;:/?";
	
	String message() default "MinSpecCharCount";
	
	Class<? extends Payload>[] payload() default { };
	
	Class<?>[] groups() default { };
}
