package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.entity.User;

@Controller
public class AdminLogoutController extends LogoutController {

	@RequestMapping("/admin/logout")
	public String logout(HttpServletRequest request) {
		return super.logout(request);
	}
	
	@Override
	protected String getLoginViewName(User sessionUser) {
		return ViewNames.REDIRECT_ADMIN_LOGIN;
	}

}
