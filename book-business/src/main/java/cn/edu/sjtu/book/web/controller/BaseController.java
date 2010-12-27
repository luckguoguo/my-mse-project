package cn.edu.sjtu.book.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.book.web.utils.ServletUtils;

public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected User getSessionUser(HttpSession session) {
		return (User) session.getAttribute(ServletUtils.SESSION_USER_KEY);
	}

}
