package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.DiagnosisStaredException;
import cn.edu.sjtu.petclinic.service.exception.InterrogationDiagnosedException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/veterinarian/diagnosis")
public class VeterinarianDiagnosisFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getDiagnosisRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getDiagnosisRegistrationForm...");
		
		String interrogationId = request.getParameter("interrogationId");
		if (StringUtils.isBlank(interrogationId) || !StringUtils.isNumeric(interrogationId)) {
			log.debug("error interrogation id: " + interrogationId);
			return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_FORM_ERROR;
		}
		
		Interrogation interrogation = interrogationService.getInterrogation(new Long(interrogationId));
		if (interrogation == null 
				|| !interrogation.getVeterinarian().getId().equals(getSessionUser(request.getSession()).getId())
				|| interrogation.getStatus() == Interrogation.Status.DIAGNOSED) {
			log.debug("error no such interrogation for id: " + interrogationId);
			return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_FORM_ERROR;
		}
		
		Diagnosis diagnosis  = new Diagnosis();
		diagnosis.setInterrogation(interrogation);
		model.addAttribute(diagnosis);
		return returnToForm(request, model);
	}
	
	private String returnToForm(HttpServletRequest request, Model model) {
		return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid Diagnosis diagnosis, BindingResult result) {
		log.debug("do submit diagnosis form...");
		
		if (diagnosis.getInterrogation() == null || diagnosis.getInterrogation().isNewEntity()) {
			result.rejectValue("interrogation.id", "veterinarian.diagnosis.form.error.interrogationId.null");
		}
		
		Interrogation interrogation = interrogationService.getInterrogation(diagnosis.getInterrogation().getId());
		if (interrogation == null 
				|| !interrogation.getVeterinarian().getId().equals(getSessionUser(request.getSession()).getId())
				|| interrogation.getStatus() == Interrogation.Status.DIAGNOSED) {
			log.debug("error no such interrogation for id: " + diagnosis.getInterrogation().getId());
			result.rejectValue("interrogation.id", "veterinarian.diagnosis.form.error.interrogationId.null");
		}
		diagnosis.setInterrogation(interrogation);
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(request, model);
		}
		
		diagnosis.setVeterinarian((Veterinarian) getSessionUser(request.getSession()));
		
		if (diagnosis.isNewEntity()) {
			addCreationAuditInfo(request, diagnosis);
			try {
				interrogationService.addDiagnosis(diagnosis);
			} catch (InterrogationDiagnosedException e) {
				result.reject("veterinarian.diagnosis.form.error.diagnosed");
			}
			log.debug("register diagnosis successfully");
		} else {
			addModificationAuditInfo(request, diagnosis);
			try {
				interrogationService.updateDiagnosis(diagnosis);
			} catch (DiagnosisStaredException e) {
				result.reject("veterinarian.diagnosis.form.error.stared");
			}
			log.debug("update diagnosis successfully");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Diagnosis Error", request.getLocale()));
			return returnToForm(request, model);
		}
		
		log.debug("submit diagnosis form successfully");
		return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_FORM_MESSAGE;
	}
	
}
