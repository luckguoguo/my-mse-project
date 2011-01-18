package cn.edu.sjtu.petclinic.web.utils;

import javax.servlet.http.HttpSession;

import cn.edu.sjtu.petclinic.entity.User;

public final class ServletUtils {

	public static final String MODEL_GLOBAL_ERROR_MESSAGE_KEY = "globalErrorMessage";
	
	public static final String SESSION_USER_KEY = "cn.edu.sjtu.petclinic.session.user";
	
	public static Object getSessionObject(HttpSession session, String name) {
		return session.getAttribute(name);
	}
	
	public static void setSessionObject(HttpSession session, String name, Object value) {
		session.setAttribute(name, value);
	}
	
	public static User getSessionUser(HttpSession session) {
		return (User) getSessionObject(session, SESSION_USER_KEY);
	}
	
	public static void setSessionUser(HttpSession session, User user) {
		session.setAttribute(SESSION_USER_KEY, user);
	}
	
}
