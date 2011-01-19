package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminLogoutController extends LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		return super.logout(request);
	}
	
	@Override
	protected String getLoginViewName(User sessionUser) {
		return ViewNames.REDIRECT_ADMIN_LOGIN;
	}

}
