package cn.edu.sjtu.petclinic.web.controller.petowner;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class PetownerInterrogationQueryController extends AbstractController {

	@RequestMapping(value = "/petowner/interrogation/query/form", method = RequestMethod.GET)
	public String getInterrogationQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getInterrogationQueryForm...");
		InterrogationQuery query = new InterrogationQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		bindOwnerPetsAsOptions(model, (PetOwner) getSessionUser(request.getSession()));
		return ViewNames.FORWARD_PETOWNER_INTERROGATION_QUERY_FORM;
	}
	
	@RequestMapping(value = "/petowner/interrogation/query/result", method = RequestMethod.GET)
	public String queryInterrogation(HttpServletRequest request, Model model, InterrogationQuery query) {
		log.debug("do queryInterrogation...");
		
		// can only find pet owner himself's interrogations
		query.setPetOwnerId(getSessionUser(request.getSession()).getId());
		Page<Interrogation> page = interrogationService.queryInterrogations(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		bindOwnerPetsAsOptions(model, (PetOwner) getSessionUser(request.getSession()));
		return ViewNames.FORWARD_PETOWNER_INTERROGATION_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/petowner/interrogation/{interrogationId}", method = RequestMethod.GET)
	public String queryInterrogationDetail(HttpServletRequest request, @PathVariable Long interrogationId, Model model) {
		log.debug("do queryInterrogationDetail...");
		Interrogation interrogation = interrogationService.getInterrogation(interrogationId);
		if (interrogation == null || !interrogation.getPetOwner().getId().equals(getSessionUser(request.getSession()).getId()))
			interrogation = new Interrogation();
		model.addAttribute(Constants.MODEL_NAME_INTERROGATION, interrogation);
		
		// find diagnosis if exists
		if (!interrogation.isNewEntity() && interrogation.getStatus() == Interrogation.Status.DIAGNOSED) {
			Diagnosis diagnosis = interrogationService.getDiagnosis(interrogation);
			model.addAttribute(Constants.MODEL_NAME_DIAGNOSIS, diagnosis);
		}
		
		return ViewNames.FORWARD_PETOWNER_INTERROGATION_QUERY_DETAIL;
	}
	
	@RequestMapping(value = "/petowner/diagnosis/{diagnosisId}/star", method = RequestMethod.POST)
	public @ResponseBody Model starDiagnosis(HttpServletRequest request, @PathVariable Long diagnosisId, Model model) {
		log.debug("do starDiagnosis...");
		Diagnosis diagnosis = interrogationService.getDiagnosis(diagnosisId);
		if (diagnosis == null 
				|| !diagnosis.getInterrogation().getPetOwner().getId().equals(getSessionUser(request.getSession()).getId())) {
			model.addAttribute("success", false);
			return model;
		}
		
		String starStr = request.getParameter("star");
		if (StringUtils.isBlank(starStr) || !StringUtils.isNumeric(starStr)) {
			model.addAttribute("success", false);
			return model;
		}
		
		interrogationService.updateDiagnosisStar(diagnosis, new Integer(starStr));
		
		model.addAttribute("success", true);
		return model;
	}
	
}
