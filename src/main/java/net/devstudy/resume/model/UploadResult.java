package net.devstudy.resume.model;

import java.io.Serializable;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class UploadResult extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 6777278132063596897L;
	
	private String largeUrl;
	private String smallUrl;

	public UploadResult(String largeUrl, String smallUrl) {
		super();
		this.largeUrl = largeUrl;
		this.smallUrl = smallUrl;
	}

	public String getSmallUrl() {
		return smallUrl;
	}

	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}

	public String getLargeUrl() {
		return largeUrl;
	}

	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}
}
