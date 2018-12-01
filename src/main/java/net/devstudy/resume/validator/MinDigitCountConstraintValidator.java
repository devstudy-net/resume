package net.devstudy.resume.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.devstudy.resume.annotation.constraints.MinDigitCount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class MinDigitCountConstraintValidator implements ConstraintValidator<MinDigitCount, CharSequence>  {

	private int minValue;
	@Override
	public void initialize(MinDigitCount constraintAnnotation) {
		minValue = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		int count = 0;
		for(int i=0;i<value.length();i++){
			if(Character.isDigit(value.charAt(i))) {
				count++;
			}
		}
		return count >= minValue;
	}
}
