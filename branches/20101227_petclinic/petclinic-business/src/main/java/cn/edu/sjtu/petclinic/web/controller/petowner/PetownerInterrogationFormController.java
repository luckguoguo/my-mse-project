package cn.edu.sjtu.petclinic.web.controller.petowner;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.InterrogationDiagnosedException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/petowner/interrogation")
public class PetownerInterrogationFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getInterrogationRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getInterrogationRegistrationForm...");
		
		String veterinarianId = request.getParameter("veterinarianId");
		if (StringUtils.isBlank(veterinarianId) || !StringUtils.isNumeric(veterinarianId)) {
			log.debug("error veterinarian id: " + veterinarianId);
			return ViewNames.FORWARD_PETOWNER_INTERROGATION_FORM_ERROR;
		}
		
		Veterinarian veterinarian = userService.getVeterinarian(new Long(veterinarianId));
		if (veterinarian == null) {
			log.debug("error no such veterinarian for id: " + veterinarianId);
			return ViewNames.FORWARD_PETOWNER_INTERROGATION_FORM_ERROR;
		}
		
		Interrogation interrogation = new Interrogation();
		interrogation.setVeterinarian(veterinarian);
		model.addAttribute(interrogation);
		return returnToForm(request, model);
	}
	
	private String returnToForm(HttpServletRequest request, Model model) {
		bindOwnerPetsAsOptions(model, (PetOwner) getSessionUser(request.getSession()));
		return ViewNames.FORWARD_PETOWNER_INTERROGATION_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid Interrogation interrogation, BindingResult result) {
		log.debug("do submit interrogation form...");
		
		if (interrogation.getPet() == null || interrogation.getPet().isNewEntity()) {
			result.rejectValue("pet.id", "petowner.interrogation.form.error.petId.null");
		}
		
		if (interrogation.getVeterinarian() == null || interrogation.getVeterinarian().isNewEntity()) {
			result.rejectValue("veterinarian.id", "petowner.interrogation.form.error.veterinarianId.null");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(request, model);
		}
		
		interrogation.setPetOwner((PetOwner) getSessionUser(request.getSession()));
		
		if (interrogation.isNewEntity()) {
			addCreationAuditInfo(request, interrogation);
			interrogationService.addInterrogation(interrogation);
			log.debug("register interrogation successfully");
		} else {
			addModificationAuditInfo(request, interrogation);
			try {
				interrogationService.updateInterrogation(interrogation);
			} catch (InterrogationDiagnosedException e) {
				result.reject("petowner.interrogation.form.error.diagnosed");
			}
			log.debug("update interrogation successfully");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Interrogation Error", request.getLocale()));
			return returnToForm(request, model);
		}
		
		log.debug("submit interrogation form successfully");
		return ViewNames.FORWARD_PETOWNER_INTERROGATION_FORM_MESSAGE;
	}
	
}
