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
public enum LanguageLevel {

	BEGINNER,
	
	ELEMENTARY,
	
	PRE_INTERMEDIATE,
	
	INTERMEDIATE,
	
	UPPER_INTERMEDIATE,
	
	ADVANCED,
	
	PROFICIENCY;

	public int getSliderIntValue(){
		return ordinal();
	}
	
	public String getDbValue(){
		return name();
	}
	
	public String getCaption(){
		return DataUtil.capitalizeName(name()).replace("_", "-");
	}
	
	public static PropertyEditorSupport getPropertyEditor(){
		return new PropertyEditorSupport(){
			@Override
			public void setAsText(String sliderIntValue) throws IllegalArgumentException {
				setValue(LanguageLevel.values()[Integer.parseInt(sliderIntValue)]);
			}
		};
	}
	
	@Converter
	public static class PersistJPAConverter implements AttributeConverter<LanguageLevel, String> {
		@Override
		public String convertToDatabaseColumn(LanguageLevel attribute) {
			return attribute.getDbValue();
		}
		@Override
		public LanguageLevel convertToEntityAttribute(String dbValue) {
			return LanguageLevel.valueOf(dbValue.toUpperCase());
		}
	}
}
