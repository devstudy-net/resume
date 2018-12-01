package net.devstudy.resume.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.SafeHtml;

import net.devstudy.resume.annotation.EnableFormErrorConvertation;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.annotation.constraints.FirstFieldLessThanSecond;
import net.devstudy.resume.util.DataUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@FirstFieldLessThanSecond(first = "beginYear", second = "finishYear")
@EnableFormErrorConvertation(formName="educationForm", fieldReference="finishYear", validationAnnotationClass=FirstFieldLessThanSecond.class)
public class Education implements Serializable, ProfileEntity, Comparable<Education> {
	private static final long serialVersionUID = 1L;

	@SafeHtml
	@EnglishLanguage(withSpechSymbols = false)
	private String faculty;

	@SafeHtml
	@EnglishLanguage(withSpechSymbols = false)
	private String summary;

	@SafeHtml
	@EnglishLanguage(withSpechSymbols = false)
	private String university;

	private Integer beginYear;

	private Integer finishYear;

	public Education() {
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Integer getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	public Integer getFinishYear() {
		return finishYear;
	}

	public void setFinishYear(Integer finishYear) {
		this.finishYear = finishYear;
	}

	public boolean isFinish() {
		return finishYear != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((beginYear == null) ? 0 : beginYear.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((finishYear == null) ? 0 : finishYear.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((university == null) ? 0 : university.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Education))
			return false;
		Education other = (Education) obj;
		if (beginYear == null) {
			if (other.beginYear != null)
				return false;
		} else if (!beginYear.equals(other.beginYear))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (finishYear == null) {
			if (other.finishYear != null)
				return false;
		} else if (!finishYear.equals(other.finishYear))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		return true;
	}

	@Override
	public int compareTo(Education o) {
		int res = DataUtil.compareByFields(o.getFinishYear(), getFinishYear(), true);
		if(res == 0) {
			return DataUtil.compareByFields(o.getBeginYear(), getBeginYear(), true);
		} else {
			return res;
		}
	}
}