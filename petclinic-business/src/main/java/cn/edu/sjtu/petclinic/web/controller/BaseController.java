package cn.edu.sjtu.petclinic.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

public class BaseController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	protected MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected User getSessionUser(HttpSession session) {
		return ServletUtils.getSessionUser(session);
	}
	
	protected void setSessionUser(HttpSession session, User user) {
		ServletUtils.setSessionUser(session, user);
	}
	
}
