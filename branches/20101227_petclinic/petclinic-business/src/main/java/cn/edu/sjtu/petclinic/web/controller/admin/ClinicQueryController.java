package cn.edu.sjtu.petclinic.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class ClinicQueryController extends AbstractController {

	@RequestMapping(value = "/admin/clinic/query/form", method = RequestMethod.GET)
	public String getClinicQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getClinicQueryForm...");
		ClinicQuery query = new ClinicQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		return ViewNames.FORWARD_ADMIN_CLINIC_QUERY_FORM;
	}
	
	@RequestMapping(value = "/admin/clinic/query/result", method = RequestMethod.GET)
	public String queryClinic(HttpServletRequest request, Model model, ClinicQuery query) {
		log.debug("do queryClinic...");
		Page<Clinic> page = clinicService.queryClinics(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_ADMIN_CLINIC_QUERY_RESULT;
	}
	
}
