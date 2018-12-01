package net.devstudy.resume.domain;

import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public abstract class AbstractFinishDateDocument<T> {

	@JsonIgnore
	private Date finishDate;
	
	@JsonIgnore
	private Integer finishDateMonth;

	@JsonIgnore
	private Integer finishDateYear;
	
	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isFinish() {
		return finishDate != null;
	}
	
	public Integer getFinishDateMonth() {
		if (finishDate != null) {
			return new DateTime(finishDate).getMonthOfYear();
		} else {
			return null;
		}
	}

	public Integer getFinishDateYear() {
		if (finishDate != null) {
			return new DateTime(finishDate).getYear();
		} else {
			return null;
		}
	}

	public void setFinishDateMonth(Integer finishDateMonth) {
		this.finishDateMonth = finishDateMonth;
		setupFinishDate();
	}

	public void setFinishDateYear(Integer finishDateYear) {
		this.finishDateYear = finishDateYear;
		setupFinishDate();
	}

	private void setupFinishDate() {
		if (finishDateYear != null && finishDateMonth != null) {
			setFinishDate(new Date(new DateTime(finishDateYear, finishDateMonth, 1, 0, 0).getMillis()));
		} else {
			setFinishDate(null);
		}
	}
}
