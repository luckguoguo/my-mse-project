package cn.edu.sjtu.petclinic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.entity.User;

@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController extends LoginController {

	@Override
	protected String getHomeViewName(User sessionUser) {
		return ViewNames.REDIRECT_ADMIN_HOME;
	}

	@Override
	protected String getLoginFormViewName() {
		return ViewNames.FORWARD_ADMIN_LOGIN;
	}

}
