package cn.edu.sjtu.petclinic.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.web.controller.RequestTempPasswordController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
@RequestMapping("/adminRequestTempPassword")
public class AdminRequestTempPasswordController extends RequestTempPasswordController {

	protected String getFormView() {
		return ViewNames.FORWARD_ADMIN_REQUEST_TEMPPASSWORD_FORM;
	}
	
	protected String getFormMessageView() {
		return ViewNames.FORWARD_ADMIN_REQUEST_TEMPPASSWORD_FORM_MESSAGE;
	}

}
