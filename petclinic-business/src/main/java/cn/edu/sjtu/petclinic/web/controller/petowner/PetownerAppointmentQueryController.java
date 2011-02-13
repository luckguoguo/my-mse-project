package cn.edu.sjtu.petclinic.web.controller.petowner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class PetownerAppointmentQueryController extends AbstractController {

	@RequestMapping(value = "/petowner/appointment/query/form", method = RequestMethod.GET)
	public String getAppointmentQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getAppointmentQueryForm...");
		AppointmentQuery query = new AppointmentQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		return ViewNames.FORWARD_PETOWNER_APPOINTMENT_QUERY_FORM;
	}
	
	@RequestMapping(value = "/petowner/appointment/query/result", method = RequestMethod.GET)
	public String queryAppointment(HttpServletRequest request, Model model, AppointmentQuery query) {
		log.debug("do queryAppointment...");
		
		query.setPetOwnerId(getSessionUser(request.getSession()).getId());
		Page<Appointment> page = appointmentService.queryAppointments(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_PETOWNER_APPOINTMENT_QUERY_RESULT;
	}
	
}
