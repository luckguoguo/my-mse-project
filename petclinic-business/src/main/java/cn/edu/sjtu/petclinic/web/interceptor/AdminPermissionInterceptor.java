package cn.edu.sjtu.petclinic.web.interceptor;

import org.springframework.web.servlet.ModelAndView;

import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;

public class AdminPermissionInterceptor extends UserPermissionInterceptor {

	@Override
	protected ModelAndView createRedirectLoginMav() {
		return new ModelAndView(ViewNames.REDIRECT_ADMIN_LOGIN);
	}

	@Override
	protected boolean hasPermission(User sessionUser) {
		if (sessionUser == null)
			return false;
		return sessionUser instanceof Administrator;
	}

}
