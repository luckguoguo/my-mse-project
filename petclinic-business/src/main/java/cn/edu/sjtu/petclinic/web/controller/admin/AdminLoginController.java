package cn.edu.sjtu.petclinic.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.controller.LoginController;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController extends LoginController {

	@Override
	protected String getLoginFormViewName() {
		return ViewNames.FORWARD_ADMIN_LOGIN;
	}

	@Override
	protected boolean validateUser(User user) {
		return user instanceof Administrator;
	}
	
}
