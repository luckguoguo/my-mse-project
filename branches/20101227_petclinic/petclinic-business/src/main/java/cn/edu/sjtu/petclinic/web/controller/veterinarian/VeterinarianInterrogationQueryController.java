package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class VeterinarianInterrogationQueryController extends AbstractController {

	@RequestMapping(value = "/veterinarian/interrogation/query/form", method = RequestMethod.GET)
	public String getInterrogationQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getInterrogationQueryForm...");
		InterrogationQuery query = new InterrogationQuery();
		query.setVeterinarianId(getSessionUser(request.getSession()).getId());
		Page<Interrogation> page = interrogationService.queryUndiagnosedInterrogations(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_VETERINARIAN_INTERROGATION_QUERY_FORM;
	}
	
	@RequestMapping(value = "/veterinarian/interrogation/query/result", method = RequestMethod.GET)
	public String queryInterrogation(HttpServletRequest request, Model model, InterrogationQuery query) {
		log.debug("do queryInterrogation...");
		
		// can only find veterinarian himself's interrogations
		query.setVeterinarianId(getSessionUser(request.getSession()).getId());
		Page<Interrogation> page = interrogationService.queryUndiagnosedInterrogations(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_VETERINARIAN_INTERROGATION_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/veterinarian/interrogation/{interrogationId}", method = RequestMethod.GET)
	public String queryInterrogationDetail(HttpServletRequest request, @PathVariable Long interrogationId, Model model) {
		log.debug("do queryInterrogationDetail...");
		Interrogation interrogation = interrogationService.getInterrogation(interrogationId);
		if (interrogation == null || !interrogation.getVeterinarian().getId().equals(getSessionUser(request.getSession()).getId()))
			interrogation = new Interrogation();
		model.addAttribute(Constants.MODEL_NAME_INTERROGATION, interrogation);
		return ViewNames.FORWARD_VETERINARIAN_INTERROGATION_QUERY_DETAIL;
	}
	
	@RequestMapping(value = "/veterinarian/petowner/{username}", method = RequestMethod.GET)
	public String getPetOwnerProfile(HttpServletRequest request, @PathVariable String username, Model model) {
		log.debug("do getPetOwnerProfile...");
		PetOwner petOwner = userService.getPetOwner(username);
		if (petOwner == null) petOwner = new PetOwner();
		model.addAttribute(petOwner);
		return ViewNames.FORWARD_VETERINARIAN_PETOWNER_PROFILE;
	}
	
}
