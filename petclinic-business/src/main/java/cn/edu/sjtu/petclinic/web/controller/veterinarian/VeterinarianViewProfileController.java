package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.web.controller.AbstractController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
public class VeterinarianViewProfileController extends AbstractController {

	@RequestMapping(value = "/veterinarian/profile", method = RequestMethod.GET)
	public String showProfile(HttpServletRequest request, Model model) {
		log.debug("do showProfile...");
		model.addAttribute("veterinarian", getSessionUser(request.getSession()));
		return ViewNames.FORWARD_VETERINARIAN_PROFILE;
	}
	
}
