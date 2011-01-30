package cn.edu.sjtu.petclinic.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.service.AppointmentService;
import cn.edu.sjtu.petclinic.service.ClinicService;
import cn.edu.sjtu.petclinic.service.DirectoryService;
import cn.edu.sjtu.petclinic.service.EmailService;
import cn.edu.sjtu.petclinic.service.InterrogationService;
import cn.edu.sjtu.petclinic.service.PetService;
import cn.edu.sjtu.petclinic.service.UserService;
import cn.edu.sjtu.petclinic.web.utils.ServletUtils;

public abstract class AbstractController {
	
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected ClinicService clinicService;
	
	@Autowired
	protected PetService petService;
	
	@Autowired
	protected InterrogationService interrogationService;
	
	@Autowired
	protected AppointmentService appointmentService;
	
	@Autowired
	protected EmailService emailService;
	
	@Autowired
	protected DirectoryService directoryService;
	
	@Autowired
	protected MessageSource messageSource;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setClinicService(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	public void setPetService(PetService petService) {
		this.petService = petService;
	}

	public void setInterrogationService(InterrogationService interrogationService) {
		this.interrogationService = interrogationService;
	}

	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected User getSessionUser(HttpSession session) {
		return ServletUtils.getSessionUser(session);
	}
	
	protected void setSessionUser(HttpSession session, User user) {
		ServletUtils.setSessionUser(session, user);
	}
	
	protected void addCreationAuditInfo(HttpServletRequest request, AuditableEntity entity) {
		Date now = new Date();
		entity.setCreatedTime(now);
		entity.setCreatedBy(getSessionUser(request.getSession()).getId());
		entity.setLastModifiedTime(now);
		entity.setLastModifiedBy(getSessionUser(request.getSession()).getId());
	}
	
	protected void addModificationAuditInfo(HttpServletRequest request, AuditableEntity entity) {
		Date now = new Date();
		entity.setLastModifiedTime(now);
		entity.setLastModifiedBy(getSessionUser(request.getSession()).getId());
	}
	
}
