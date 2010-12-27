package cn.edu.sjtu.book.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.edu.sjtu.book.web.controller.ViewNames;
import cn.edu.sjtu.book.web.utils.ServletUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		logger.debug("checking login status");
		
		if (request.getSession().getAttribute(ServletUtils.SESSION_USER_KEY) != null) {
			
			// user logged in
			logger.debug("user logged in");
			return true;
		} else {
			
			logger.debug("user not loggged in, redirect to index page");
			throw new ModelAndViewDefiningException(new ModelAndView(ViewNames.REDIRECT_INDEX));
		}
	}

}
