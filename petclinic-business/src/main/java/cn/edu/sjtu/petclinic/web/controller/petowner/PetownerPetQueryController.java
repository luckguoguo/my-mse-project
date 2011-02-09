package cn.edu.sjtu.petclinic.web.controller.petowner;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.Constants;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class PetownerPetQueryController extends AbstractController {

	@RequestMapping(value = "/petowner/pet/query/form", method = RequestMethod.GET)
	public String getPetQueryForm(HttpServletRequest request, Model model) {
		log.debug("do getPetQueryForm...");
		return ViewNames.FORWARD_PETOWNER_PET_QUERY_FORM;
	}
	
	@RequestMapping(value = "/petowner/pet/query/result", method = RequestMethod.GET)
	public String queryPet(HttpServletRequest request, Model model, ClinicQuery query) {
		log.debug("do queryPet...");
		List<Pet> pets = petService.getOwnerPets((PetOwner) getSessionUser(request.getSession()));
		model.addAttribute(Constants.MODEL_NAME_PETS, pets);
		return ViewNames.FORWARD_PETOWNER_PET_QUERY_RESULT;
	}
	
}
