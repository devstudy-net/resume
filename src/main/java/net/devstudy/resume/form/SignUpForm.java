package net.devstudy.resume.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.annotation.constraints.FieldMatch;
import net.devstudy.resume.annotation.constraints.PasswordStrength;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class SignUpForm implements Serializable {
	private static final long serialVersionUID = 185151345117447819L;

	@NotNull
	@Size(max=50)
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String firstName;

	@NotNull
	@Size(max=50)
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String lastName;
	
	@PasswordStrength
	private String password;
	
	private String confirmPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
