package net.devstudy.resume.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.util.DataUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Course extends AbstractFinishDateDocument<Long> implements Serializable, ProfileCollectionField, Comparable<Course> {
	private static final long serialVersionUID = 4206575925684228495L;

	@EnglishLanguage(withSpechSymbols = false)
	private String name;

	@SafeHtml
	@EnglishLanguage(withSpechSymbols = false)
	private String school;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getFinishDate() == null) ? 0 : getFinishDate().hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (getFinishDate() == null) {
			if (other.getFinishDate() != null)
				return false;
		} else if (!getFinishDate().equals(other.getFinishDate()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}

	@Override
	public int compareTo(Course o) {
		return DataUtil.compareByFields(o.getFinishDate(), getFinishDate(), true);
	}
}
