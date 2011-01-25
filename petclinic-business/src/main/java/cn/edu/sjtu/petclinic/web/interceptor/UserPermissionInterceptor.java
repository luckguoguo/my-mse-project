package cn.edu.sjtu.petclinic.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.controller.ViewNames;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

public class UserPermissionInterceptor extends HandlerInterceptorAdapter {
	
	protected final Log log = LogFactory.getLog(UserPermissionInterceptor.class);
	
	protected String validUserClassName;
	
	public void setValidUserClassName(String validUserClassName) {
		this.validUserClassName = validUserClassName;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		log.debug("checking login status");
		
		User sessionUser = ServletUtils.getSessionUser(request.getSession());
		
		if (hasPermission(sessionUser)) {
			// user logged in
			log.debug("user logged in with valid permission");
			return true;
		} else {
			log.debug("user has no permission to this page");
			throw new ModelAndViewDefiningException(createRedirectLoginMav());
		}
	}

	protected ModelAndView createRedirectLoginMav() {
		return new ModelAndView(ViewNames.REDIRECT_LOGIN);
	}

	protected boolean hasPermission(User sessionUser) {
		if (sessionUser == null) {
			log.debug("user not loggged in, redirect to login page");
			return false;
		}
		return sessionUser.getClass().getSimpleName().equals(validUserClassName);
	}

}
