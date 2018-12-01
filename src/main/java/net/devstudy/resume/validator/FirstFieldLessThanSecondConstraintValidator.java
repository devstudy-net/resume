package net.devstudy.resume.validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanUtils;

import net.devstudy.resume.annotation.constraints.FirstFieldLessThanSecond;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class FirstFieldLessThanSecondConstraintValidator implements ConstraintValidator<FirstFieldLessThanSecond, Object> {
	private String firstFieldName;
	private String secondFieldName;

	@Override
	public void initialize(final FirstFieldLessThanSecond constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		try {
			Object firstValue  = BeanUtils.getPropertyDescriptor(value.getClass(), firstFieldName).getReadMethod().invoke(value);
			Object secondValue = BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName).getReadMethod().invoke(value);
			if(firstValue == null || secondValue == null) {
				return true;
			} else if(firstValue instanceof Comparable<?> && secondValue instanceof Comparable<?>) {
				return ((Comparable<Object>)firstValue).compareTo((Comparable<Object>)secondValue) <= 0;
			} else {
				throw new IllegalArgumentException("first and second fields are not comparable!!!");
			}
		} catch (InvocationTargetException | IllegalAccessException e) {
			return false;
		}
	}
}
