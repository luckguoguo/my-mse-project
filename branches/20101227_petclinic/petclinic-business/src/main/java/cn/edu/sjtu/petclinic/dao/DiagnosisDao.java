package cn.edu.sjtu.petclinic.dao;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;

public interface DiagnosisDao {

	void save(Diagnosis diagnosis);
	
	Diagnosis get(Long id);
	
	Page<Diagnosis> findDiagnosises(DiagnosisQuery query);
	
	Diagnosis findDiagnosis(Interrogation interrogation);
	
}
