package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.sjtu.petclinic.entity.User;

@Controller
public class LogoutController extends BaseController {
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		log.debug("do logout...");
		User sessionUser = getSessionUser(request.getSession());
		request.getSession().invalidate();
		return getLoginViewName(sessionUser);
	}
	
	protected String getLoginViewName(User sessionUser) {
		return ViewNames.REDIRECT_LOGIN;
	}

}
