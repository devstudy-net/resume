package net.devstudy.resume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Entity
@Table(name="skill_category")
public class SkillCategory extends AbstractEntity<Long>{
	private static final long serialVersionUID = -8959739023562086833L;
	
	@Id
	@Column
	private Long id;
	
	@Column(nullable=false, length=50)
	private String category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
