package cn.edu.sjtu.petclinic.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.sjtu.petclinic.dao.AppointmentDao;
import cn.edu.sjtu.petclinic.dao.ClinicDao;
import cn.edu.sjtu.petclinic.dao.DailyOutpatientDao;
import cn.edu.sjtu.petclinic.dao.DiagnosisDao;
import cn.edu.sjtu.petclinic.dao.InterrogationDao;
import cn.edu.sjtu.petclinic.dao.PetCategoryDao;
import cn.edu.sjtu.petclinic.dao.PetDao;
import cn.edu.sjtu.petclinic.dao.UserDao;

public abstract class AbstractService {

	protected final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected UserDao userDao;
	
	@Autowired
	protected ClinicDao clinicDao;
	
	@Autowired
	protected PetDao petDao;
	
	@Autowired
	protected PetCategoryDao petCategoryDao;
	
	@Autowired
	protected InterrogationDao interrogationDao;
	
	@Autowired
	protected DiagnosisDao diagnosisDao;
	
	@Autowired
	protected DailyOutpatientDao dailyOutpatientDao;
	
	@Autowired
	protected AppointmentDao appointmentDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setClinicDao(ClinicDao clinicDao) {
		this.clinicDao = clinicDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}

	public void setPetCategoryDao(PetCategoryDao petCategoryDao) {
		this.petCategoryDao = petCategoryDao;
	}

	public void setInterrogationDao(InterrogationDao interrogationDao) {
		this.interrogationDao = interrogationDao;
	}

	public void setDiagnosisDao(DiagnosisDao diagnosisDao) {
		this.diagnosisDao = diagnosisDao;
	}

	public void setDailyOutpatientDao(DailyOutpatientDao dailyOutpatientDao) {
		this.dailyOutpatientDao = dailyOutpatientDao;
	}

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}
	
}
