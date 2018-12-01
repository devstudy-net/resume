package net.devstudy.resume.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import net.devstudy.resume.annotation.constraints.Phone;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
	@Override
	public void initialize(Phone constraintAnnotation) {
	}

	@Override
	public boolean isValid(String rawNumber, ConstraintValidatorContext context) {
		if(rawNumber == null) {
			return true;
		}
		try {
        	Phonenumber.PhoneNumber number = PhoneNumberUtil.getInstance().parse(rawNumber, "");
            return PhoneNumberUtil.getInstance().isValidNumber(number);
        } catch (NumberParseException e) {
            return false;
        }
	}
}
