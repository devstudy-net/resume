package net.devstudy.resume.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.joda.time.DateTime;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@MappedSuperclass
public abstract class AbstractFinishDateEntity<T> extends AbstractEntity<T> {
	private static final long serialVersionUID = -3388293457711051284L;

	@Column(name = "finish_date")
	private Date finishDate;
	
	@Transient
	private Integer finishDateMonth;

	@Transient
	private Integer finishDateYear;
	
	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	@Transient
	public boolean isFinish() {
		return finishDate != null;
	}

	@Transient
	public Integer getFinishDateMonth() {
		if (finishDate != null) {
			return new DateTime(finishDate).getMonthOfYear();
		} else {
			return null;
		}
	}

	@Transient
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
