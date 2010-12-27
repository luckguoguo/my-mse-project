package cn.edu.sjtu.book.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.book.service.UserManager;
import cn.edu.sjtu.book.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.book.service.exception.UserNotExistsException;
import cn.edu.sjtu.book.web.utils.ServletUtils;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(Model model) {
		logger.debug("do getLoginForm...");
		model.addAttribute(new LoginForm());
		return ViewNames.FORWARD_LOGIN;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, @Valid LoginForm loginForm, BindingResult result) {
		logger.debug("do onSubmit...");
		
		if (result.hasErrors()) {
			logger.debug("login form has field errors");
			return ViewNames.FORWARD_LOGIN;
		}
		
		try {
			User user = userManager.authenticate(loginForm.convertToUser());
			request.getSession().setAttribute(ServletUtils.SESSION_USER_KEY, user);
		} catch (UserNotExistsException e) {
			result.reject("login.error.userNotExists");
		} catch (UserInvalidPasswordException e) {
			result.reject("login.error.userInvalidPassword");
		}
		
		if (result.hasErrors()) {
			logger.debug("login form has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Login Error", request.getLocale()));
			return ViewNames.FORWARD_LOGIN;
		}
		
		logger.debug("login success");
		return ViewNames.REDIRECT_WELCOME;
	}
	
	static class LoginForm {
		
		@NotEmpty
		@Size(max = 20)
		private String loginName;
		
		@NotEmpty
		@Size(min = 4, max = 12)
		private String password;

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public User convertToUser() {
			User user = new User();
			user.setLoginName(loginName);
			user.setPassword(password);
			return user;
		}
		
	}
	
}
