package cn.edu.sjtu.petclinic.web.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class ClinicQueryController extends AbstractController {

	@RequestMapping(value = "/clinic/query/form", method = RequestMethod.GET)
	public String getClinicQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getClinicQueryForm...");
		ClinicQuery query = new ClinicQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		return ViewNames.FORWARD_CLINIC_QUERY_FORM;
	}
	
	@RequestMapping(value = "/clinic/query/result", method = RequestMethod.GET)
	public String queryClinic(HttpServletRequest request, Model model, ClinicQuery query) {
		log.debug("do queryClinic...");
		Page<Clinic> page = clinicService.queryActiveClinics(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_CLINIC_QUERY_RESULT;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/clinic/{clinicId}", method = RequestMethod.GET)
	public String queryClinicDetail(HttpServletRequest request, @PathVariable Long clinicId, Model model) {
		log.debug("do queryClinicDetail...");
		Clinic clinic = clinicService.getClinic(clinicId);
		List<User> veterinarians = Collections.EMPTY_LIST;
		if (isClinicActive(clinic)) {
			veterinarians = userService.findVeterinariansByClinic(clinic);
		} else {
			clinic = new Clinic();
		}
		model.addAttribute(Constants.MODEL_NAME_CLINIC, clinic);
		model.addAttribute(Constants.MODEL_NAME_VETERINARIANS, veterinarians);
		return ViewNames.FORWARD_CLINIC_QUERY_DETAIL;
	}

}
