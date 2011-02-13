package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientCountExceedsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExistsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExpiredException;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/veterinarian/dailyoutpatient")
public class VeterinarianDailyOutpatientFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getDailyOutpatientRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getDailyOutpatientRegistrationForm...");
		DailyOutpatient dailyOutpatient  = new DailyOutpatient();
		model.addAttribute(dailyOutpatient);
		return returnToForm(request, model);
	}
	
	private String returnToForm(HttpServletRequest request, Model model) {
		return ViewNames.FORWARD_VETERINARIAN_DAILYOUTPATIENT_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid DailyOutpatient dailyOutpatient, BindingResult result) {
		log.debug("do submit daily outpatient form...");
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(request, model);
		}
		
		dailyOutpatient.setVeterinarian((Veterinarian) getSessionUser(request.getSession()));
		
		if (dailyOutpatient.isNewEntity()) {
			addCreationAuditInfo(request, dailyOutpatient);
			try {
				appointmentService.addDailyOutpatient(dailyOutpatient);
			} catch (DailyOutpatientExistsException e) {
				result.reject("veterinarian.dailyoutpatient.form.error.dayexists");
			}
			log.debug("register daily outpatient successfully");
		} else {
			addModificationAuditInfo(request, dailyOutpatient);
			try {
				appointmentService.updateDailyOutpatient(dailyOutpatient);
			} catch (DailyOutpatientExpiredException e) {
				result.reject("veterinarian.dailyoutpatient.form.error.expired");
			} catch (DailyOutpatientCountExceedsException e) {
				result.reject("veterinarian.dailyoutpatient.form.error.countexceeds");
			}
			log.debug("update daily outpatient successfully");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit DailyOutpatient Error", request.getLocale()));
			return returnToForm(request, model);
		}
		
		log.debug("submit daily outpatient form successfully");
		return ViewNames.FORWARD_VETERINARIAN_DAILYOUTPATIENT_FORM_MESSAGE;
	}
	
}
