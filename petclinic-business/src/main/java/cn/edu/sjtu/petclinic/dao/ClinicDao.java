package cn.edu.sjtu.petclinic.dao;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;

public interface ClinicDao {

	Clinic findClinicByName(String name);
	
	void save(Clinic clinic);
	
	Clinic get(Long id);
	
	void merge(Clinic clinic);
	
	Page<Clinic> findClinics(Page<Clinic> page, ClinicQuery clinicQuery);
	
}
