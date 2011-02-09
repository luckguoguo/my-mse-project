package cn.edu.sjtu.petclinic.web.controller.petowner;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/petowner/pet")
public class PetownerPetFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPetRegistrationForm(HttpServletRequest request, Model model) {
		log.debug("do getPetRegistrationForm...");
		model.addAttribute(new Pet());
		return returnToForm(model);
	}
	
	private String returnToForm(Model model) {
		bindAllPetCategoriesAsOptions(model);
		return ViewNames.FORWARD_PETOWNER_PET_FORM;
	}
	
	@RequestMapping(value = "/{petId}", method = RequestMethod.GET)
	public String getPetUpdateForm(HttpServletRequest request, @PathVariable Long petId, Model model) {
		log.debug("do getPetUpdateForm...");
		
		Pet pet = petService.getPet(petId);
		
		// check pet is own
		if (pet == null || !pet.getOwner().getId().equals(getSessionUser(request.getSession()).getId()))
			pet = new Pet();
		
		model.addAttribute(pet);
		return returnToForm(model);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @Valid Pet pet, BindingResult result) {
		log.debug("do submit pet form...");
		
		if (result.hasErrors()) {
			log.debug("doSubmit has field errors");
			return returnToForm(model);
		}
		
		pet.setOwner((PetOwner) getSessionUser(request.getSession()));
		
		if (pet.getCategory() == null || pet.getCategory().isNewEntity()) {
			pet.setCategory(null);
		}
		
		if (pet.isNewEntity()) {
			addCreationAuditInfo(request, pet);
			petService.addPet(pet);
			log.debug("register pet successfully");
		} else {
			addModificationAuditInfo(request, pet);
			petService.updatePet(pet);
			log.debug("update clinic successfully");
		}
		
		if (result.hasErrors()) {
			log.debug("doSubmit has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Submit Pet Error", request.getLocale()));
			return returnToForm(model);
		}
		
		log.debug("submit pet form successfully");
		return ViewNames.FORWARD_PETOWNER_PET_FORM_MESSAGE;
	}
	
}
