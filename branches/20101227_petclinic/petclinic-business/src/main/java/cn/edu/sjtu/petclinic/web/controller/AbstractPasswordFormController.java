package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

public abstract class AbstractPasswordFormController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPasswordForm(HttpServletRequest request, Model model) {
		log.debug("do getPasswordForm...");
		model.addAttribute(new PasswordForm());
		return getFormView();
	}

	protected abstract String getFormView();
	
	@RequestMapping(method = RequestMethod.POST)
	public String updatePassword(HttpServletRequest request, Model model, @Valid PasswordForm passwordForm, BindingResult result) {
		log.debug("do submit password form...");
		
		if (!passwordForm.getNewPassword().equals(passwordForm.getConfirmNewPassword())) {
			result.rejectValue("confirmNewPassword", getConfirmNewPasswordNotEqualsMessageKey());
		}
		
		if (result.hasErrors()) {
			log.debug("password form has field errors");
			return getFormView();
		}
		
		try {
			userService.updatePassword(getSessionUser(request.getSession()).getId(), 
					passwordForm.getOrigPassword(), passwordForm.getNewPassword());
		} catch (UserInvalidPasswordException e) {
			result.reject(getInvalidOrigPasswordMessageKey());
		}
		
		if (result.hasErrors()) {
			log.debug("password form has business errors");
			model.addAttribute(ServletUtils.MODEL_GLOBAL_ERROR_MESSAGE_KEY, 
					messageSource.getMessage(result.getGlobalError().getCode(), null, "Password Error", request.getLocale()));
			return getFormView();
		}
		
		log.debug("update password success");
		return getFormMessageView();
	}

	protected abstract String getFormMessageView();

	protected abstract String getInvalidOrigPasswordMessageKey();

	protected abstract String getConfirmNewPasswordNotEqualsMessageKey();

	public static class PasswordForm {
		
		@NotBlank
		@Size(min = 4, max = 12)
		private String origPassword;
		
		@NotBlank
		@Size(min = 4, max = 12)
		private String newPassword;
		
		@NotEmpty
		@Size(min = 4, max = 12)
		private String confirmNewPassword;

		public String getOrigPassword() {
			return origPassword;
		}

		public void setOrigPassword(String origPassword) {
			this.origPassword = origPassword;
		}

		public String getNewPassword() {
			return newPassword;
		}

		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}

		public String getConfirmNewPassword() {
			return confirmNewPassword;
		}

		public void setConfirmNewPassword(String confirmNewPassword) {
			this.confirmNewPassword = confirmNewPassword;
		}

	}
	
}
