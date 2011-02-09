package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPetownerRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getPetownerRegistrationForm...");
		model.addAttribute(new PetOwner());
		return returnToForm(model);
	}
	
	private String returnToForm(Model model) {
		return ViewNames.FORWARD_REGISTER;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid PetOwner petOwner, BindingResult result) {
		log.debug("do submit petowner form...");
		try{
		// check password and confirm password
		if (!StringUtils.equals(petOwner.getPassword(), petOwner.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "petowner.profile.form.error.confirmPassword.notequals");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(model);
		}
		
		addCreationAuditInfo(request, petOwner);
		try {
			userService.addPetOwner(petOwner);
			log.debug("register petowner successfully");
		} catch (DuplicatedUsernameException e) {
			result.reject("petowner.profile.form.error.duplicatedUsername");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Petowner Error", request.getLocale()));
			return returnToForm(model);
		}
		
		log.debug("submit petowner form successfully");
		
		// auto login
		setSessionUser(request.getSession(), petOwner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ViewNames.REDIRECT_PETOWNER_HOME;
	}
	
}
