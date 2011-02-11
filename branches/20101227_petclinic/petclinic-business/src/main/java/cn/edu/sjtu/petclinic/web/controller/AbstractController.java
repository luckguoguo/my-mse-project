package cn.edu.sjtu.petclinic.web.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetCategory;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.service.AppointmentService;
import cn.edu.sjtu.petclinic.service.ClinicService;
import cn.edu.sjtu.petclinic.service.DictionaryService;
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
	protected DictionaryService dictionaryService;
	
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
	
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
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
		entity.setLastModifiedTime(now);
		if (getSessionUser(request.getSession()) != null) {
			entity.setCreatedBy(getSessionUser(request.getSession()).getId());
			entity.setLastModifiedBy(getSessionUser(request.getSession()).getId());
		}
	}
	
	protected void addModificationAuditInfo(HttpServletRequest request, AuditableEntity entity) {
		Date now = new Date();
		entity.setLastModifiedTime(now);
		entity.setLastModifiedBy(getSessionUser(request.getSession()).getId());
	}
	
	protected void bindAllClinicsAsOptions(Model model) {
		Map<String, String> allClinics = new LinkedHashMap<String, String>();
		allClinics.put("", "-");
		for (Clinic clinic : clinicService.getAllClinics()) {
			allClinics.put(clinic.getId() + "", clinic.getName());
		}
		model.addAttribute("allClinics", allClinics);
	}
	
	protected void bindAllPetCategoriesAsOptions(Model model) {
		Map<String, String> allPetCategories = new LinkedHashMap<String, String>();
		allPetCategories.put("", "-");
		for (PetCategory petCategory : petService.getAllPetCategories()) {
			allPetCategories.put(petCategory.getId() + "", petCategory.getName());
		}
		model.addAttribute("allPetCategories", allPetCategories);
	}
	
	protected void bindOwnerPetsAsOptions(Model model, PetOwner owner) {
		Map<String, String> ownerPets = new LinkedHashMap<String, String>();
		ownerPets.put("", "-");
		for (Pet pet : petService.getOwnerPets(owner)) {
			ownerPets.put(pet.getId() + "", pet.getName());
		}
		model.addAttribute("ownerPets", ownerPets);
	}
	
	protected boolean isClinicActive(Clinic clinic) {
		return clinic != null && clinic.getStatus() == Clinic.Status.ACTIVE;
	}
	
	protected boolean isUserActive(User user) {
		return user != null && user.getStatus() == User.Status.ACTIVE;
	}
	
}
