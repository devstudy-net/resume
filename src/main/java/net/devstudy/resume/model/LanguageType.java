package net.devstudy.resume.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public enum LanguageType {

	ALL,

	SPOKEN,

	WRITING;
	
	public String getDbValue() {
		return name().toLowerCase();
	}

	public LanguageType getReverseType() {
		if (this == SPOKEN) {
			return WRITING;
		} else if (this == WRITING) {
			return SPOKEN;
		} else {
			throw new IllegalArgumentException(this+" does not have reverse type");
		}
	}
	
	@Converter
	public static class PersistJPAConverter implements AttributeConverter<LanguageType, String> {
		@Override
		public String convertToDatabaseColumn(LanguageType attribute) {
			return attribute.getDbValue();
		}
		@Override
		public LanguageType convertToEntityAttribute(String dbValue) {
			return LanguageType.valueOf(dbValue.toUpperCase());
		}
	}
}
