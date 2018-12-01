package net.devstudy.resume.model;

import java.io.Serializable;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class UploadCertificateResult extends UploadResult implements Serializable {
	private static final long serialVersionUID = 6777278132063596897L;
	private String certificateName;

	public UploadCertificateResult(String certificateName, String largeUrl, String smallUrl) {
		super(largeUrl, smallUrl);
		this.certificateName = certificateName;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
}
