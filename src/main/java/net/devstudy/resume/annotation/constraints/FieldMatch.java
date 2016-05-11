package net.devstudy.resume.annotation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * https://github.com/Rudeg/Spring-MVC-Example/blob/master/Lab%202/src/main/java
 * /com/springexample/common/constraits/FieldMatch.java
 * 
 * Validation annotation to validate that 2 fields have the same value. An array
 * of fields and their matching confirmation fields can be supplied.
 *
 * Example, compare 1 pair of fields:
 * 
 * @FieldMatch(first = "password", second = "confirmPassword", message ="The password fields must match")
 *
 * Example, compare more than 1 pair of fields: 
 * @FieldMatch.List({ @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
 * 					  @FieldMatch(first = "email", second = "confirmEmail", message ="The email fields must match")})
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface FieldMatch {
	String message() default "FieldMatch";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String first();

	String second();

	/**
	 * Defines several <code>@FieldMatch</code> annotations on the same element
	 *
	 * @see FieldMatch
	 */
	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		FieldMatch[] value();
	}
}
