package net.devstudy.resume.form;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class UploadExampleForm {

	@Size(min=4, max=45)
	private String name;
	private MultipartFile file;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
