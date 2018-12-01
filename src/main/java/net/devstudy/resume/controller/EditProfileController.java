package net.devstudy.resume.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.devstudy.resume.annotation.constraints.FieldMatch;
import net.devstudy.resume.annotation.constraints.FirstFieldLessThanSecond;
import net.devstudy.resume.component.FormErrorConverter;
import net.devstudy.resume.domain.Contacts;
import net.devstudy.resume.domain.Profile;
import net.devstudy.resume.exception.FormValidationException;
import net.devstudy.resume.form.CertificateForm;
import net.devstudy.resume.form.CourseForm;
import net.devstudy.resume.form.EducationForm;
import net.devstudy.resume.form.InfoForm;
import net.devstudy.resume.form.LanguageForm;
import net.devstudy.resume.form.PasswordForm;
import net.devstudy.resume.form.PracticForm;
import net.devstudy.resume.form.SkillForm;
import net.devstudy.resume.model.CurrentProfile;
import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;
import net.devstudy.resume.model.UploadCertificateResult;
import net.devstudy.resume.service.EditProfileService;
import net.devstudy.resume.service.ImageProcessorService;
import net.devstudy.resume.service.StaticDataService;
import net.devstudy.resume.util.SecurityUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Controller
public class EditProfileController {

	@Autowired
	private EditProfileService editProfileService;

	@Autowired
	private StaticDataService staticDataService;

	@Autowired
	private ImageProcessorService imageService;
	
	@Autowired
	private FormErrorConverter formErrorConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,			new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(String.class,		new StringTrimmerEditor(true));
		binder.registerCustomEditor(LanguageType.class, LanguageType.getPropertyEditor());
		binder.registerCustomEditor(LanguageLevel.class,LanguageLevel.getPropertyEditor());
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEditProfile(Model model) {
		model.addAttribute("profileForm", editProfileService.findProfileById(SecurityUtil.getCurrentProfile()));
		return "edit/profile";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEditProfile(@Valid @ModelAttribute("profileForm") Profile profileForm, BindingResult bindingResult, @RequestParam("profilePhoto") MultipartFile uploadPhoto) {
		if (bindingResult.hasErrors()) {
			return "edit/profile";
        } else {
        	try {
				editProfileService.updateProfileData(SecurityUtil.getCurrentProfile(), profileForm, uploadPhoto);
				return "redirect:/edit/contacts";
			} catch (FormValidationException e) {
				bindingResult.addError(e.buildFieldError("profileForm"));
				return "edit/profile";
			}
        }
	}

	@RequestMapping(value = "/edit/contacts", method = RequestMethod.GET)
	public String getEditContactsProfile(Model model) {
		model.addAttribute("contactsForm", editProfileService.findContactsById(SecurityUtil.getCurrentProfile()));
		return "edit/contacts";
	}

	@RequestMapping(value = "/edit/contacts", method = RequestMethod.POST)
	public String saveEditContactsProfile(@Valid @ModelAttribute("contactsForm") Contacts contactsForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "edit/contacts";
        } else {
        	editProfileService.updateContacts(SecurityUtil.getCurrentProfile(), contactsForm);
    		return "redirect:/edit/skills";
        }
	}

	@RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
	public String getEditTechSkills(Model model) {
		model.addAttribute("skillForm", new SkillForm(editProfileService.findSkills(SecurityUtil.getCurrentProfile())));
		return gotoSkillsJSP(model);
	}

	@RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
	public String saveEditTechSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return gotoSkillsJSP(model);
        } else {
        	editProfileService.updateSkills(SecurityUtil.getCurrentProfile(), form.getItems());
    		return "redirect:/edit/practics";
        }
	}
	
	private String gotoSkillsJSP(Model model){
		model.addAttribute("skillCategories", editProfileService.findSkillCategories());
		return "edit/skills";
	}

	@RequestMapping(value = "/edit/practics", method = RequestMethod.GET)
	public String getEditPractics(Model model) {
		model.addAttribute("practicForm", new PracticForm(editProfileService.findPractics(SecurityUtil.getCurrentProfile())));
		return gotoPracticsJSP(model);
	}

	@RequestMapping(value = "/edit/practics", method = RequestMethod.POST)
	public String saveEditPractics(@Valid @ModelAttribute("practicForm") PracticForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			formErrorConverter.convertToFieldError(FirstFieldLessThanSecond.class, form.getItems(), bindingResult);
			return gotoPracticsJSP(model);
        } else {
        	editProfileService.updatePractics(SecurityUtil.getCurrentProfile(), form.getItems());
    		return "redirect:/edit/certificates";
        }
	}
	
	private String gotoPracticsJSP(Model model){
		model.addAttribute("years",  staticDataService.findPracticsYears());
		model.addAttribute("months", staticDataService.findMonthMap());
		return "edit/practics";
	}

	@RequestMapping(value = "/edit/certificates", method = RequestMethod.GET)
	public String getEditCertificates(Model model) {
		model.addAttribute("certificateForm", new CertificateForm(editProfileService.findCertificates(SecurityUtil.getCurrentProfile())));
		return "edit/certificates";
	}

	@RequestMapping(value = "/edit/certificates", method = RequestMethod.POST)
	public String saveEditCertificates(@Valid @ModelAttribute("certificateForm") CertificateForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "edit/certificates";
		} else {
			editProfileService.updateCertificates(SecurityUtil.getCurrentProfile(), form.getItems());
			return "redirect:/edit/courses";
		}
	}

	@RequestMapping(value = "/edit/certificates/upload", method = RequestMethod.POST)
	public @ResponseBody UploadCertificateResult uploadCertificate(@RequestParam("certificateFile") MultipartFile certificateFile) {
		return imageService.processNewCertificateImage(certificateFile);
	}
	
	@RequestMapping(value = "/edit/courses", method = RequestMethod.GET)
	public String getEditCourses(Model model) {
		model.addAttribute("courseForm", new CourseForm(editProfileService.findCourses(SecurityUtil.getCurrentProfile())));
		return gotoCoursesJSP(model);
	}

	@RequestMapping(value = "/edit/courses", method = RequestMethod.POST)
	public String saveEditCourses(@Valid @ModelAttribute("courseForm") CourseForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return gotoCoursesJSP(model);
		} else {
			editProfileService.updateCourses(SecurityUtil.getCurrentProfile(), form.getItems());
			return "redirect:/edit/education";
		}
	}
	
	private String gotoCoursesJSP(Model model){
		model.addAttribute("years",  staticDataService.findCourcesYears());
		model.addAttribute("months", staticDataService.findMonthMap());
		return "edit/courses";
	}

	@RequestMapping(value = "/edit/education", method = RequestMethod.GET)
	public String getEditEducation(Model model) {
		model.addAttribute("educationForm", new EducationForm(editProfileService.findEducations(SecurityUtil.getCurrentProfile())));
		return gotoEducationJSP(model);
	}

	@RequestMapping(value = "/edit/education", method = RequestMethod.POST)
	public String saveEditEducation(@Valid @ModelAttribute("educationForm") EducationForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			formErrorConverter.convertToFieldError(FirstFieldLessThanSecond.class, form.getItems(), bindingResult);
			return gotoEducationJSP(model);
		} else {
			editProfileService.updateEducations(SecurityUtil.getCurrentProfile(), form.getItems());
			return "redirect:/edit/languages";
		}
	}
	
	private String gotoEducationJSP(Model model){
		model.addAttribute("years",  staticDataService.findEducationYears());
		model.addAttribute("months", staticDataService.findMonthMap());
		return "edit/education";
	}

	@RequestMapping(value = "/edit/languages", method = RequestMethod.GET)
	public String getEditLanguages(Model model) {
		model.addAttribute("languageForm", new LanguageForm(editProfileService.findLanguages(SecurityUtil.getCurrentProfile())));
		return gotoLanguagesJSP(model);
	}

	@RequestMapping(value = "/edit/languages", method = RequestMethod.POST)
	public String saveEditLanguages(@Valid @ModelAttribute("languageForm") LanguageForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return gotoLanguagesJSP(model);
		} else {
			editProfileService.updateLanguages(SecurityUtil.getCurrentProfile(), form.getItems());
			return "redirect:/edit/hobbies";
		}
	}
	
	private String gotoLanguagesJSP(Model model){
		model.addAttribute("languageTypes",  staticDataService.findAllLanguageTypes());
		model.addAttribute("languageLevels", staticDataService.findAllLanguageLevels());
		return "edit/languages";
	}

	@RequestMapping(value = "/edit/hobbies", method = RequestMethod.GET)
	public String getEditHobbies(Model model) {
		model.addAttribute("hobbies", editProfileService.findHobbiesWithProfileSelected(SecurityUtil.getCurrentProfile()));
		return "edit/hobbies";
	}

	@RequestMapping(value = "/edit/hobbies", method = RequestMethod.POST)
	public String saveEditHobbies(@RequestParam("hobbies") List<String> hobbies) {
		editProfileService.updateHobbies(SecurityUtil.getCurrentProfile(), hobbies);
		return "redirect:/edit/info";
	}

	@RequestMapping(value = "/edit/info", method = RequestMethod.GET)
	public String getEditProfileInfo(Model model) {
		model.addAttribute("infoForm", new InfoForm(editProfileService.findProfileById(SecurityUtil.getCurrentProfile())));
		return "edit/info";
	}

	@RequestMapping(value = "/edit/info", method = RequestMethod.POST)
	public String saveEditProfileInfo(@Valid @ModelAttribute("infoForm") InfoForm infoForm, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "edit/info";
		} else {
			editProfileService.updateInfo(SecurityUtil.getCurrentProfile(), infoForm);
			return "redirect:/my-profile";
		}
	}

	@RequestMapping(value = "/edit/password", method = RequestMethod.GET)
	public String getEditPasswords(Model model) {
		model.addAttribute("passwordForm", new PasswordForm());
		return "password";
	}

	@RequestMapping(value = "/edit/password", method = RequestMethod.POST)
	public String saveEditPasswords(@Valid @ModelAttribute("passwordForm") PasswordForm form, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			formErrorConverter.convertToFieldError(FieldMatch.class, form, bindingResult);
			return "password";
		} else {
			CurrentProfile currentProfile = SecurityUtil.getCurrentProfile();
			Profile profile = editProfileService.updateProfilePassword(currentProfile, form);
			SecurityUtil.authentificate(profile);
			return "redirect:/" + currentProfile.getUid();
		}
	}

	@RequestMapping(value = "/my-profile")
	public String getMyProfile(Model model) {
		CurrentProfile currentProfile = SecurityUtil.getCurrentProfile();
		return "redirect:/" + currentProfile.getUid();
	}
}
