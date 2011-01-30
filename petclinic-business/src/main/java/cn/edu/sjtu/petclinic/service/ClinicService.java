package cn.edu.sjtu.petclinic.service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.service.exception.ClinicInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedClinicNameException;

public interface ClinicService {

	void checkClinic(Clinic clinic) throws DuplicatedClinicNameException;
	
	void registerClinic(Clinic clinic) throws DuplicatedClinicNameException;
	
	void updateClinic(Clinic clinic) throws DuplicatedClinicNameException, ClinicInvalidPasswordException;
	
	Page<Clinic> queryClinics(Page<Clinic> page, ClinicQuery clinicQuery);

	Page<Clinic> queryActiveClinics(Page<Clinic> page, ClinicQuery clinicQuery);
	
	Clinic getClinic(Long id);
	
	void activeClinic(Clinic clinic);
	
	void inactiveClinic(Clinic clinic);
	
}
