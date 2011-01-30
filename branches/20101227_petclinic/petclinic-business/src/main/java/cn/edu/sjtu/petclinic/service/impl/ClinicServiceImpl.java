package cn.edu.sjtu.petclinic.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.EncryptionUtils;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.service.ClinicService;
import cn.edu.sjtu.petclinic.service.exception.ClinicInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedClinicNameException;

@Service
public class ClinicServiceImpl extends AbstractService implements ClinicService {

	@Override
	public void checkClinic(Clinic clinic) throws DuplicatedClinicNameException {
		if (isClinicNameRegistered(clinic)) throw new DuplicatedClinicNameException();
	}
	
	@Override
	public void registerClinic(Clinic clinic) throws DuplicatedClinicNameException {
		if (isClinicNameRegistered(clinic)) throw new DuplicatedClinicNameException();
		
		// register clinic
		clinic.setMgrPassword(EncryptionUtils.getMD5Str(clinic.getMgrPassword()));
		clinic.setStatus(Clinic.Status.ACTIVE);
		clinicDao.save(clinic);
	}
	
	private boolean isClinicNameRegistered(Clinic clinic) {
		Clinic clinicPojo = clinicDao.findClinicByName(clinic.getName());
		log.debug("clinicPojo: " + clinicPojo);
		if (clinicPojo == null) return false;
		log.debug("found clinicPojo");
		if (clinic.getId() == null || clinic.getId() < 1) {
			// a new clinic
			log.debug("new clinic's name is same as pojo's");
			return true;
		}
		log.debug("!clinic.getId().equals(clinicPojo.getId()): " + !clinic.getId().equals(clinicPojo.getId()));
		return (!clinic.getId().equals(clinicPojo.getId()));
	}
	
	@Override
	public void updateClinic(Clinic clinic) throws DuplicatedClinicNameException, ClinicInvalidPasswordException {
		if (!clinic.getMgrPassword().equals(EncryptionUtils.getMD5Str(clinic.getConfirmMgrPassword()))) {
			throw new ClinicInvalidPasswordException();
		}
		
		Clinic clinicPojo = getClinic(clinic.getId());
		copyToClinicPojo(clinic, clinicPojo);
		clinicDao.save(clinicPojo);
	}
	
	private void copyToClinicPojo(Clinic clinic, Clinic clinicPojo) {
		clinicPojo.setName(clinic.getName());
		clinicPojo.setIntroduction(clinic.getIntroduction());
		clinicPojo.setGrade(clinic.getGrade());
		clinicPojo.setAddress(clinic.getAddress());
		clinicPojo.setTelephone(clinic.getTelephone());
		clinicPojo.setEmail(clinic.getEmail());
		clinicPojo.setStar(clinic.getStar());
		clinicPojo.setMgrPassword(clinic.getMgrPassword());
		clinicPojo.setConfirmMgrPassword(clinic.getConfirmMgrPassword());
		clinicPojo.setLastModifiedTime(clinic.getLastModifiedTime());
		clinicPojo.setLastModifiedBy(clinic.getLastModifiedBy());
	}
	
	@Override
	public Page<Clinic> queryClinics(Page<Clinic> page, ClinicQuery clinicQuery) {
		return clinicDao.findClinics(page, clinicQuery);
	}
	
	@Override
	public Page<Clinic> queryActiveClinics(Page<Clinic> page, ClinicQuery clinicQuery) {
		clinicQuery.setStatus(Clinic.Status.ACTIVE);
		return clinicDao.findClinics(page, clinicQuery);
	}
	
	@Override
	public Clinic getClinic(Long id) {
		return clinicDao.get(id);
	}

	@Override
	public void activeClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inactiveClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		
	}

}
