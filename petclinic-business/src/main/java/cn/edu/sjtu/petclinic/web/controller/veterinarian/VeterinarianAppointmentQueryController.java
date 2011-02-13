package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class VeterinarianAppointmentQueryController extends AbstractController {

	@RequestMapping(value = "/veterinarian/dailyoutpatient/query/form", method = RequestMethod.GET)
	public String getDailyOutpatienttQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getDailyOutpatienttQueryForm...");
		DailyOutpatientQuery query = new DailyOutpatientQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		return ViewNames.FORWARD_VETERINARIAN_DAILYOUTPATIENT_QUERY_FORM;
	}
	
	@RequestMapping(value = "/veterinarian/dailyoutpatient/query/result", method = RequestMethod.GET)
	public String queryDailyoutpatient(HttpServletRequest request, Model model, DailyOutpatientQuery query) {
		log.debug("do queryDailyoutpatient...");
		
		query.setVeterinarianId(getSessionUser(request.getSession()).getId());
		Page<DailyOutpatient> page = appointmentService.queryDailyOutpatients(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_VETERINARIAN_DAILYOUTPATIENT_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/veterinarian/dailyoutpatient/{dailyOutpatiendId}/appointments", method = RequestMethod.GET)
	public String queryAppointments(HttpServletRequest request, @PathVariable Long dailyOutpatiendId, Model model) {
		log.debug("do queryAppointments...");
		
		DailyOutpatient dailyOutpatient = appointmentService.getDailyOutpatient(dailyOutpatiendId);
		
		if (dailyOutpatient != null 
				&& dailyOutpatient.getVeterinarian().getId().equals(getSessionUser(request.getSession()).getId())) {
			List<Appointment> appointments = appointmentService.queryAppointmentsByDailyOutpatient(dailyOutpatient);
			model.addAttribute(Constants.MODEL_NAME_APPOINTMENTS, appointments);
		}
		
		return ViewNames.FORWARD_VETERINARIAN_DAILYOUTPATIENT_APPOINTMENTS;
	}
	
}
