package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;

@Controller
public class VeterinarianQueryController extends AbstractController {

	@RequestMapping(value = "/vet/query/form", method = RequestMethod.GET)
	public String getVeterinarianQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getVeterinarianQueryForm...");
		VeterinarianQuery query = new VeterinarianQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_VETERINARIAN_QUERY_FORM;
	}
	
	@RequestMapping(value = "/vet/query/result", method = RequestMethod.GET)
	public String queryVeterinarian(HttpServletRequest request, Model model, VeterinarianQuery query) {
		log.debug("do queryVeterinarian...");
		Page<User> page = userService.queryActiveVeterinarians(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_VETERINARIAN_QUERY_RESULT;
	}
	
	@RequestMapping(value = "/vet/{veterinarianId}", method = RequestMethod.GET)
	public String queryVeterinarianDetail(HttpServletRequest request, @PathVariable Long veterinarianId, Model model) {
		log.debug("do queryVeterinarianDetail...");
		Veterinarian veterinarian = userService.getVeterinarian(veterinarianId);
		if (!isUserActive(veterinarian)) veterinarian = new Veterinarian(); 
		model.addAttribute(Constants.MODEL_NAME_VETERINARIAN, veterinarian);
		return ViewNames.FORWARD_VETERINARIAN_QUERY_DETAIL;
	}
	
}
