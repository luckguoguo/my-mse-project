package cn.edu.sjtu.petclinic.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class AdminVeterinarianQueryController extends AbstractController {

	@RequestMapping(value = "/admin/veterinarian/query/form", method = RequestMethod.GET)
	public String getVeterinarianQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getVeterinarianQueryForm...");
		VeterinarianQuery query = new VeterinarianQuery();
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_ADMIN_VETERINARIAN_QUERY_FORM;
	}
	
	@RequestMapping(value = "/admin/veterinarian/query/result", method = RequestMethod.GET)
	public String queryVeterinarian(HttpServletRequest request, Model model, VeterinarianQuery query) {
		log.debug("do queryVeterinarian...");
		Page<User> page = userService.queryVeterinarians(query);
		model.addAttribute(Constants.MODEL_NAME_QUERY, query);
		model.addAttribute(Constants.MODEL_NAME_PAGE, page);
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_ADMIN_VETERINARIAN_QUERY_RESULT;
	}
	
}
