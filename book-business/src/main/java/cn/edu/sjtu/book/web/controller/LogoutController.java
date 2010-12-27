package cn.edu.sjtu.book.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController extends BaseController {
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		logger.debug("do logout...");
		request.getSession().invalidate();
		return ViewNames.REDIRECT_INDEX;
	}

}
