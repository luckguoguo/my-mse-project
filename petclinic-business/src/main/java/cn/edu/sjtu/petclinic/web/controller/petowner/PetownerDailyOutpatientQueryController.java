package cn.edu.sjtu.petclinic.web.controller.petowner;

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
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientAppointedException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientCountExceedsException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class PetownerDailyOutpatientQueryController extends AbstractController {

	@RequestMapping(value = "/petowner/availableDailyOutpatient/query/form", method = RequestMethod.GET)
	public String getAvailableDailyOutpatientQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getAvailableDailyOutpatientQueryForm...");
		DailyOutpatientQuery query = new DailyOutpatientQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_PETOWNER_DAILYOUTPATIENT_QUERY_FORM;
	}
	
	@RequestMapping(value = "/petowner/availableDailyOutpatient/query/result", method = RequestMethod.GET)
	public String queryDailyOutpatient(HttpServletRequest request, Model model, DailyOutpatientQuery query) {
		log.debug("do queryDailyOutpatient...");
		
		Page<DailyOutpatient> page = appointmentService.queryUpcomingDailyOutpatients(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_PETOWNER_DAILYOUTPATIENT_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/petowner/availableDailyOutpatient/{dailyOutpatientId}/appointment", method = RequestMethod.GET)
	public String appointDailyOutpatient(HttpServletRequest request, @PathVariable Long dailyOutpatientId, Model model) {
		log.debug("do appointDailyOutpatient...");
		try{
		Appointment appointment = new Appointment();
		appointment.setPetOwner((PetOwner) getSessionUser(request.getSession()));
		DailyOutpatient dailyOutpatient = appointmentService.getDailyOutpatient(dailyOutpatientId);
		appointment.setDailyOutpatient(dailyOutpatient);
		
		addCreationAuditInfo(request, appointment);
		try {
			String serialNo = appointmentService.addAppointment(appointment);
			model.addAttribute("serialNo", serialNo);
			model.addAttribute("messageCode", "petowner.dailyoutpatient.appointment.message.success");
			model.addAttribute("success", true);
		} catch (DailyOutpatientAppointedException e) {
			model.addAttribute("messageCode", "petowner.dailyoutpatient.appointment.message.error.appointed");
			model.addAttribute("success", false);
		} catch (DailyOutpatientCountExceedsException e) {
			model.addAttribute("messageCode", "petowner.dailyoutpatient.appointment.message.error.countexceeds");
			model.addAttribute("success", false);
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ViewNames.FORWARD_PETOWNER_DAILYOUTPATIENT_APPOINTMENT_MESSAGE;
	}
	
}
