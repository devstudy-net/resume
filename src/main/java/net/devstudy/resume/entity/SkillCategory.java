package net.devstudy.resume.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Document(collection="skillCategory")
public class SkillCategory extends AbstractEntity<String>{
	private static final long serialVersionUID = -8959739023562086833L;
	public static final String ORDER_FIELD_NAME = "idCategory"; 
	@Id
	private String id;
	
	private Short idCategory;
	
	private String category;	
	
	public SkillCategory() {
		super();
	}

	public SkillCategory(String category) {
		super();
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Short getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Short idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
