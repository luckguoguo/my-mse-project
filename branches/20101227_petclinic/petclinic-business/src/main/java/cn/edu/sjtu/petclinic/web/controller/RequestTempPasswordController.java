package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

@Controller
@RequestMapping("/requestTempPassword")
public class RequestTempPasswordController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getTempPasswordForm(HttpServletRequest request, Model model) {
		log.debug("do getTempPasswordForm...");
		model.addAttribute(new TempPasswordForm());
		return getFormView();
	}

	protected String getFormView() {
		return ViewNames.FORWARD_REQUEST_TEMPPASSWORD_FORM;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String requestTempPassword(HttpServletRequest request, Model model, @Valid TempPasswordForm tempPasswordForm, BindingResult result) {
		log.debug("do submit temp password form...");
		
		if (result.hasErrors()) {
			log.debug("temp password form has field errors");
			return getFormView();
		}
		
		try {
			userService.requestTempPassword(tempPasswordForm.getUsername());
		} catch (UserNotExistsException e) {
			result.reject(getUserNotExistsMessageKey());
		}
		
		if (result.hasErrors()) {
			log.debug("temp password form has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Temp Password Error", request.getLocale()));
			return getFormView();
		}
		
		log.debug("update password success");
		return getFormMessageView();
	}

	protected String getFormMessageView() {
		return ViewNames.FORWARD_REQUEST_TEMPPASSWORD_FORM_MESSAGE;
	}

	protected String getUserNotExistsMessageKey() {
		return "requestTempPassword.form.error.userNotExists";
	}

	public static class TempPasswordForm {
		
		@NotBlank
		private String username;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

	}
	
}
