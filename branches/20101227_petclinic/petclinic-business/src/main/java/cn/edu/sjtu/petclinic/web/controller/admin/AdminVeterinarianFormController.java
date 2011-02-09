package cn.edu.sjtu.petclinic.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedUsernameException;
import cn.edu.sjtu.petclinic.service.exception.InvalidClinicPasswordException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/admin/veterinarian")
public class AdminVeterinarianFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getVeterinarianRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getVeterinarianRegistrationForm...");
		model.addAttribute(new Veterinarian());
		return returnToStep1(model);
	}
	
	@RequestMapping(value = "/{veterinarianId}", method = RequestMethod.GET)
	public String getVeterinarianUpdateForm(HttpServletRequest request, @PathVariable Long veterinarianId, Model model) {
		log.debug("do getVeterinarianUpdateForm...");
		Veterinarian veterinarian = userService.getVeterinarian(veterinarianId);
		if (veterinarian == null) veterinarian = new Veterinarian();
		model.addAttribute(veterinarian);
		return returnToStep1(model);
	}

	private String returnToStep1(Model model) {
		bindAllClinicsAsOptions(model);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_ADMIN_VETERINARIAN_FORM_STEP1;
	}

	@RequestMapping(value = "/{veterinarianId}/active", method = RequestMethod.POST)
	public @ResponseBody Model active(HttpServletRequest request, @PathVariable Long veterinarianId, Model model) {
		log.debug("do active...");
		Veterinarian veterinarian = new Veterinarian();
		veterinarian.setId(veterinarianId);
		userService.activeVeterinarian(veterinarian);
		model.addAttribute(veterinarian);
		return model;
	}
	
	@RequestMapping(value = "/{veterinarianId}/inactive", method = RequestMethod.POST)
	public @ResponseBody Model inactive(HttpServletRequest request, @PathVariable Long veterinarianId, Model model) {
		log.debug("do inactive...");
		Veterinarian veterinarian = new Veterinarian();
		veterinarian.setId(veterinarianId);
		userService.inactiveVeterinarian(veterinarian);
		model.addAttribute(veterinarian);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid Veterinarian veterinarian, BindingResult result) {
		log.debug("do submit veterinarian form...");
		String step = request.getParameter("step");
		if (StringUtils.isBlank(step)) step = "0";
		
		try {
		if ("0".equals(step)) {
			return doPrevious(request, model, veterinarian, result);
		} else if ("1".equals(step)) {
			return doNext(request, model, veterinarian, result);
		} else if ("2".equals(step)) {
			return doSubmit(request, model, veterinarian, result);
		} else {
			return returnToStep1(model);
		}
		} catch(Exception e) {
			e.printStackTrace();
			return returnToStep1(model);
		}
	}
	
	private String doPrevious(HttpServletRequest request, Model model,
			Veterinarian veterinarian, BindingResult result) {
		log.debug("doPrevious...");
		return returnToStep1(model);
	}
	
	private String doNext(HttpServletRequest request, Model model,
			Veterinarian veterinarian, BindingResult result) {
		
		log.debug("doNext...");
		
		if (veterinarian.getClinic().isNewEntity()) {
			// clinic has not been set yet
			result.rejectValue("clinic.id", "admin.veterinarian.form.error.clinic.notselected");
		}
		
		if (result.hasErrors()) {
			log.debug("doNext has field errors");
			return returnToStep1(model);
		}
		
		try {
			userService.checkUser(veterinarian);
		} catch (DuplicatedUsernameException e) {
			result.reject("admin.veterinarian.form.error.duplicatedUsername");
		}
		
		if (result.hasErrors()) {
			log.debug("doNext has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Veterinarian Error", request.getLocale()));
			return returnToStep1(model);
		}
		
		return returnToStep2(model);
	}

	private String returnToStep2(Model model) {
		bindAllClinicsAsOptions(model);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_ADMIN_VETERINARIAN_FORM_STEP2;
	}

	private String doSubmit(HttpServletRequest request, Model model,
			Veterinarian veterinarian, BindingResult result) {
		
		log.debug("doSubmit...");
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToStep2(model);
		}
		
		if (veterinarian.getSpecialityPetCategory() == null || veterinarian.getSpecialityPetCategory().isNewEntity()) {
			veterinarian.setSpecialityPetCategory(null);
		}
		
		if (veterinarian.isNewEntity()) {
			addCreationAuditInfo(request, veterinarian);
			try {
				userService.addVeterinarian(veterinarian, veterinarian.getClinic().getConfirmMgrPassword());
				log.debug("register veterinarian successfully");
			} catch (InvalidClinicPasswordException e) {
				veterinarian.getClinic().setConfirmMgrPassword(null);
				result.reject("admin.veterinarian.form.error.invalidClinicPassword");
			} catch (DuplicatedUsernameException e) {
				result.reject("admin.veterinarian.form.error.duplicatedUsername");
			}
		} else {
			addModificationAuditInfo(request, veterinarian);
			try {
				userService.updateVeterinarian(veterinarian, veterinarian.getClinic().getConfirmMgrPassword());
				log.debug("update veterinarian successfully");
			} catch (InvalidClinicPasswordException e) {
				veterinarian.getClinic().setConfirmMgrPassword(null);
				result.reject("admin.veterinarian.form.error.invalidClinicPassword");
			} catch (DuplicatedUsernameException e) {
				result.reject("admin.veterinarian.form.error.duplicatedUsername");
			}
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Veterinarian Error", request.getLocale()));
			return returnToStep2(model);
		}
		
		log.debug("submit veterinarian form successfully");
		return ViewNames.FORWARD_ADMIN_VETERINARIAN_FORM_MESSAGE;
	}
	
}
