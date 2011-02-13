package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class VeterinarianDiagnosisQueryController extends AbstractController {

	@RequestMapping(value = "/veterinarian/diagnosis/query/form", method = RequestMethod.GET)
	public String getInterrogationQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getDiagnosisQueryForm...");
		DiagnosisQuery query = new DiagnosisQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_FORM;
	}
	
	@RequestMapping(value = "/veterinarian/diagnosis/query/result", method = RequestMethod.GET)
	public String queryDiagnosis(HttpServletRequest request, Model model, DiagnosisQuery query) {
		log.debug("do queryDiagnosis...");
		
		// can only find veterinarian himself's diagnosiss
		query.setVeterinarianId(getSessionUser(request.getSession()).getId());
		Page<Diagnosis> page = interrogationService.queryDiagnosises(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/veterinarian/diagnosis/{diagnosisId}", method = RequestMethod.GET)
	public String queryDiagnosisDetail(HttpServletRequest request, @PathVariable Long diagnosisId, Model model) {
		log.debug("do queryDiagnosisDetail...");
		Diagnosis diagnosis = interrogationService.getDiagnosis(diagnosisId);
		if (diagnosis == null || !diagnosis.getVeterinarian().getId().equals(getSessionUser(request.getSession()).getId()))
			diagnosis = new Diagnosis();
		model.addAttribute(Constants.MODEL_NAME_DIAGNOSIS, diagnosis);
		return ViewNames.FORWARD_VETERINARIAN_DIAGNOSIS_QUERY_DETAIL;
	}
	
}
