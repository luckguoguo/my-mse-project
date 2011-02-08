package cn.edu.sjtu.petclinic.web.controller.veterinarian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.web.controller.AbstractPasswordFormController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
@RequestMapping("/veterinarian/password")
public class VeterinarianPasswordFormController extends AbstractPasswordFormController {

	@Override
	protected String getFormView() {
		return ViewNames.FORWARD_VETERINARIAN_PASSWORD_FORM;
	}

	@Override
	protected String getFormMessageView() {
		return ViewNames.FORWARD_VETERINARIAN_PASSWORD_FORM_MESSAGE;
	}
	
	@Override
	protected String getConfirmNewPasswordNotEqualsMessageKey() {
		return "user.password.form.error.confirmNewPassword.notequals";
	}

	@Override
	protected String getInvalidOrigPasswordMessageKey() {
		return "user.password.form.error.invalidOrigPassword";
	}

}
