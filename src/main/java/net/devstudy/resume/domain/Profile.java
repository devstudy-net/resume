package net.devstudy.resume.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.SafeHtml;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.devstudy.resume.annotation.ProfileDataFieldGroup;
import net.devstudy.resume.annotation.ProfileInfoField;
import net.devstudy.resume.annotation.constraints.Adulthood;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.annotation.constraints.Phone;

/**
 * 
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Document(indexName="profile")
@org.springframework.data.mongodb.core.mapping.Document(collection="profile")
public class Profile extends AbstractDocument<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@ProfileDataFieldGroup
	@Adulthood
	@NotNull
	private Date birthDay;

	@ProfileDataFieldGroup
	@Size(max=100)
	@NotNull
	@SafeHtml
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String city;

	@ProfileDataFieldGroup
	@Size(max=60)
	@NotNull
	@SafeHtml
	@EnglishLanguage(withNumbers=false, withSpechSymbols=false)
	private String country;

	private String firstName;

	private String lastName;

	@ProfileDataFieldGroup
	@NotNull
	@SafeHtml
	@EnglishLanguage
	private String objective;

	@JsonIgnore
	@Size(max=255)
	private String largePhoto;

	@Size(max=255)
	private String smallPhoto;

	@JsonIgnore
	@ProfileDataFieldGroup
	@NotNull
	@Size(max=20)
	@Phone
	@Indexed(unique=true, name = "phone_idx")
	private String phone;

	@JsonIgnore
	@ProfileDataFieldGroup
	@NotNull
	@Size(max=100)
	@Email
	@EnglishLanguage
	@Indexed(unique=true, name = "email_idx")
	private String email;
	
	@ProfileInfoField
	private String info;

	@ProfileDataFieldGroup
	@NotNull
	@SafeHtml
	@EnglishLanguage
	private String summary;

	@Indexed(unique=true, name = "uid_idx")
	private String uid;
	
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	@Indexed(name = "completed_idx")
	private boolean completed;
	
	@Indexed(name = "created_idx")
	private Date created;

	private List<Certificate> certificates;

	@JsonIgnore
	private List<Education> educations;

	@JsonIgnore
	private List<Hobby> hobbies;

	private List<Language> languages;

	private List<Practic> practics;

	private List<Skill> skills;
	
	private List<Course> courses;
	
	@JsonIgnore
	private Contacts contacts;

	public Profile() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getObjective() {
		return this.objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<Certificate> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Hobby> getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Practic> getPractics() {
		return this.practics;
	}

	public void setPractics(List<Practic> practics) {
		this.practics = practics;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getLargePhoto() {
		return largePhoto;
	}

	public void setLargePhoto(String largePhoto) {
		this.largePhoto = largePhoto;
	}

	public String getSmallPhoto() {
		return smallPhoto;
	}

	public void setSmallPhoto(String smallPhoto) {
		this.smallPhoto = smallPhoto;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public int getAge(){
		LocalDate birthdate = new LocalDate (birthDay);
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthdate, now);
		return age.getYears();
	}
	
	public String getProfilePhoto(){
		if(largePhoto != null) {
			return largePhoto;
		} else {
			return "/static/img/profile-placeholder.png";
		}
	}
	
	public void updateProfilePhotos(String largePhoto, String smallPhoto) {
		setLargePhoto(largePhoto);
		setSmallPhoto(smallPhoto);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Contacts getContacts() {
		if(contacts == null) {
			contacts = new Contacts();
		}
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}
}