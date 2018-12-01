package net.devstudy.resume.model;

import java.beans.PropertyEditorSupport;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.devstudy.resume.util.DataUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public enum LanguageType {

	ALL,

	SPOKEN,

	WRITING;

	public String getCaption() {
		return DataUtil.capitalizeName(name());
	}
	
	public String getDbValue() {
		return name();
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
	
	public static PropertyEditorSupport getPropertyEditor(){
		return new PropertyEditorSupport(){
			@Override
			public void setAsText(String dbValue) throws IllegalArgumentException {
				setValue(LanguageType.valueOf(dbValue.toUpperCase()));
			}
		};
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
