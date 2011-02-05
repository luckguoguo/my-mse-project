package cn.edu.sjtu.petclinic.web.controller;

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

import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.service.exception.ClinicInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedClinicNameException;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/admin/clinic")
public class ClinicFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getClinicRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getClinicRegistrationForm...");
		model.addAttribute(new Clinic());
		return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
	}
	
	@RequestMapping(value = "/{clinicId}", method = RequestMethod.GET)
	public String getClinicUpdateForm(HttpServletRequest request, @PathVariable Long clinicId, Model model) {
		log.debug("do getClinicUpdateForm...");
		Clinic clinic = clinicService.getClinic(clinicId);
		if (clinic == null) clinic = new Clinic();
		model.addAttribute(clinic);
		return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
	}
	
	@RequestMapping(value = "/{clinicId}/active", method = RequestMethod.POST)
	public @ResponseBody Model active(HttpServletRequest request, @PathVariable Long clinicId, Model model) {
		log.debug("do active...");
		Clinic clinic = new Clinic();
		clinic.setId(clinicId);
		clinicService.activeClinic(clinic);
		model.addAttribute(clinic);
		return model;
	}
	
	@RequestMapping(value = "/{clinicId}/inactive", method = RequestMethod.POST)
	public @ResponseBody Model inactive(HttpServletRequest request, @PathVariable Long clinicId, Model model) {
		log.debug("do inactive...");
		Clinic clinic = new Clinic();
		clinic.setId(clinicId);
		clinicService.inactiveClinic(clinic);
		model.addAttribute(clinic);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid Clinic clinic, BindingResult result) {
		log.debug("do submit clinic form...");
		String step = request.getParameter("step");
		if (StringUtils.isBlank(step)) step = "0";
		
		if ("0".equals(step)) {
			return doPrevious(clinic);
		} else if ("1".equals(step)) {
			return doNext(request, model, clinic, result);
		} else if ("2".equals(step)) {
			return doSubmit(request, model, clinic, result);
		} else {
			return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
		}
	}
	
	private String doPrevious(Clinic clinic) {
		log.debug("doPrevious...");
		resetMgrPassword(clinic);
		return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
	}
	
	private String doNext(HttpServletRequest request, Model model,
			Clinic clinic, BindingResult result) {
		
		log.debug("doNext...");
		
		if (result.hasErrors()) {
			log.debug("doNext has field errors");
			return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
		}
		
		try {
			clinicService.checkClinic(clinic);
		} catch (DuplicatedClinicNameException e) {
			result.reject("admin.clinic.form.error.duplicatedClinicName");
		}
		
		if (result.hasErrors()) {
			log.debug("doNext has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Clinic Error", request.getLocale()));
			return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP1;
		}
		
		// set mgr password to blank, enforce user enter a valid password on step2
		resetMgrPassword(clinic);
		
		return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP2;
	}

	private void resetMgrPassword(Clinic clinic) {
		if (clinic.isNewEntity()) {
			// let mgrPassword be unset
			clinic.setMgrPassword(null);
			clinic.setConfirmMgrPassword(null);
		} else {
			// let confirmMgrPassword be unset
			clinic.setConfirmMgrPassword(null);
		}
	}

	private String doSubmit(HttpServletRequest request, Model model,
			Clinic clinic, BindingResult result) {
		
		log.debug("doSubmit...");
		
		if (clinic.isNewEntity()) {
			// check equals
			if (!clinic.getMgrPassword().equals(clinic.getConfirmMgrPassword())) {
				// add field error for confirmMgrPassword
				log.debug("add field error for confirmMgrPassword");
				result.rejectValue("confirmMgrPassword", "admin.clinic.form.error.confirmMgrPassword.notequals");
			}
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP2;
		}
		
		if (clinic.isNewEntity()) {
			addCreationAuditInfo(request, clinic);
			try {
				clinicService.registerClinic(clinic);
				log.debug("register clinic successfully");
			} catch (DuplicatedClinicNameException e) {
				result.reject("admin.clinic.form.error.duplicatedClinicName");
			}
		} else {
			addModificationAuditInfo(request, clinic);
			try {
				clinicService.updateClinic(clinic);
				log.debug("update clinic successfully");
			} catch (DuplicatedClinicNameException e) {
				result.reject("admin.clinic.form.error.duplicatedClinicName");
			} catch (ClinicInvalidPasswordException e) {
				clinic.setConfirmMgrPassword(null);
				result.reject("admin.clinic.form.error.invalidMgrPassword");
			}
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Clinic Error", request.getLocale()));
			return ViewNames.FORWARD_ADMIN_CLINIC_FORM_STEP2;
		}
		
		log.debug("submit clinic form successfully");
		return ViewNames.FORWARD_ADMIN_CLINIC_FORM_MESSAGE;
	}

}
