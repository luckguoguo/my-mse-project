package cn.edu.sjtu.petclinic.web.controller.petowner;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/petowner/profile")
public class PetownerProfileFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPetownerProfileForm(HttpServletRequest request, Model model) {
		log.debug("do getPetownerProfileForm...");
		model.addAttribute(Constants.MODEL_NAME_PETOWNER, getSessionUser(request.getSession()));
		return returnToForm(model);
	}
	
	private String returnToForm(Model model) {
		return ViewNames.FORWARD_PETOWNER_PROFILE;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid PetOwner petOwner, BindingResult result) {
		log.debug("do submit petowner form...");
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(model);
		}
		
		addModificationAuditInfo(request, petOwner);
		try {
			userService.updatePetOwner(petOwner);
			log.debug("update petowner successfully");
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
		setSessionUser(request.getSession(), userService.getPetOwner(petOwner.getId()));
		model.addAttribute(Constants.MODEL_NAME_PETOWNER, getSessionUser(request.getSession()));
		return ViewNames.FORWARD_PETOWNER_PROFILE;
	}
	
}
