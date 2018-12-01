package net.devstudy.resume.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.devstudy.resume.annotation.constraints.MinSpecCharCount;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class MinSpecCharCountConstraintValidator implements ConstraintValidator<MinSpecCharCount, CharSequence>  {

	private int minValue;
	private String specSymbols;
	
	@Override
	public void initialize(MinSpecCharCount constraintAnnotation) {
		minValue = constraintAnnotation.value();
		specSymbols = constraintAnnotation.specSymbols();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		int count = 0;
		for(int i=0;i<value.length();i++){
			if(specSymbols.indexOf(value.charAt(i)) != -1) {
				count++;
			}
		}
		return count >= minValue;
	}
}
