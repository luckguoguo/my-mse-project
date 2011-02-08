package cn.edu.sjtu.petclinic.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.web.controller.AbstractPasswordFormController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
@RequestMapping("/admin/password")
public class AdminPasswordFormController extends AbstractPasswordFormController {

	@Override
	protected String getFormView() {
		return ViewNames.FORWARD_ADMIN_PASSWORD_FORM;
	}

	@Override
	protected String getFormMessageView() {
		return ViewNames.FORWARD_ADMIN_PASSWORD_FORM_MESSAGE;
	}
	
	@Override
	protected String getConfirmNewPasswordNotEqualsMessageKey() {
		return "admin.password.form.error.confirmNewPassword.notequals";
	}

	@Override
	protected String getInvalidOrigPasswordMessageKey() {
		return "admin.password.form.error.invalidOrigPassword";
	}

}
