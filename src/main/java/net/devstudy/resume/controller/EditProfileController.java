package net.devstudy.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditProfileController {
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String getError(){
		return "edit";
	}
}
