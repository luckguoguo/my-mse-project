package cn.edu.sjtu.petclinic.web.controller;

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

import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.UserService;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidStatusException;
import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Autowired
	protected UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(Model model) {
		log.debug("do getLoginForm...");
		model.addAttribute(new LoginForm());
		return getLoginFormViewName();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, @Valid LoginForm loginForm, BindingResult result) {
		log.debug("do submit login form...");
		
		if (result.hasErrors()) {
			log.debug("login form has field errors");
			return getLoginFormViewName();
		}
		
		try {
			User user = userService.authenticate(loginForm.getUsername(), loginForm.getPassword());
			setSessionUser(request.getSession(), user);
		} catch (UserNotExistsException e) {
			result.reject("login.error.userNotExists");
		} catch (UserInvalidPasswordException e) {
			result.reject("login.error.userInvalidPassword");
		} catch (UserInvalidStatusException e) {
			result.reject("login.error.userInvalidStatus");
		}
		
		if (result.hasErrors()) {
			log.debug("login form has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Login Error", request.getLocale()));
			return getLoginFormViewName();
		}
		
		log.debug("login success");
		return getHomeViewName(getSessionUser(request.getSession()));
	}

	protected String getHomeViewName(User sessionUser) {
		if (sessionUser instanceof Veterinarian) {
			return ViewNames.REDIRECT_VETERINARIAN_HOME;
		} else if (sessionUser instanceof PetOwner) {
			return ViewNames.REDIRECT_PETOWNER_HOME;
		}
		return null;
	}

	protected String getLoginFormViewName() {
		return ViewNames.FORWARD_LOGIN;
	}
	
	public static class LoginForm {
		
		@NotEmpty
		@Size(max = 20)
		private String username;
		
		@NotEmpty
		@Size(min = 4, max = 12)
		private String password;


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
}
