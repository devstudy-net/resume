package net.devstudy.resume.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Entity
@Table(name="skill")
public class Skill extends AbstractEntity<Long> implements Serializable, ProfileEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKILL_ID_GENERATOR", sequenceName="SKILL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKILL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=50)
	@EnglishLanguage
	@Size(min=1)
	private String category;

	@Column(nullable=false, length=2147483647)
	@EnglishLanguage
	@Size(min=1)
	private String value;

	//bi-directional many-to-one association to Profile
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profile", nullable=false)
	private Profile profile;

	public Skill() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Skill))
			return false;
		Skill other = (Skill) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}