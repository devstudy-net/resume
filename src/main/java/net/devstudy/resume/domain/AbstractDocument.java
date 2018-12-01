package net.devstudy.resume.domain;

import java.io.Serializable;

import net.devstudy.resume.model.AbstractModel;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public abstract class AbstractDocument<T> extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 8982713310863621560L;
	
	public abstract T getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AbstractDocument<T> other = (AbstractDocument<T>) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%s]", getClass().getSimpleName(),  getId());
	}
}
