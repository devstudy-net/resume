package net.devstudy.resume.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;

import net.devstudy.resume.annotation.constraints.Adulthood;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class AdulthoodConstraintValidator implements ConstraintValidator<Adulthood, Date> {
	private int adulthoodAge;
	@Override
	public void initialize(Adulthood constraintAnnotation) {
		this.adulthoodAge = constraintAnnotation.adulthoodAge();
	}

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		} else{
			DateTime critical = DateTime.now().minusYears(adulthoodAge);
			return value.before(critical.toDate());
		}
	}
}
