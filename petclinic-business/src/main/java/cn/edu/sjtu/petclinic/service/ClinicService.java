package cn.edu.sjtu.petclinic.service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedClinicNameException;

public interface ClinicService {

	void addClinic(Clinic clinic) throws DuplicatedClinicNameException;
	
	void updateClinic(Clinic clinic);
	
	Page<Clinic> queryClinics(ClinicQuery query);
	
	Clinic getClinic(Long id);
	
	void activeClinic(Clinic clinic);
	
	void inactiveClinic(Clinic clinic);
	
}
