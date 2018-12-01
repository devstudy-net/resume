package net.devstudy.resume.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class Hobby implements Serializable, Comparable<Hobby>, ProfileCollectionField {
	private static final long serialVersionUID = 1L;

	private String name;
	
	@Transient
	private boolean selected;

	public Hobby() {
	}

	public Hobby(String name) {
		super();
		this.name = name;
	}

	public Hobby(String name, boolean selected) {
		super();
		this.name = name;
		this.selected = selected;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCssClassName(){
		return name.replace(" ", "-").toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hobby))
			return false;
		Hobby other = (Hobby) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Hobby o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		return String.format("Hobby [name=%s]", name);
	}
}