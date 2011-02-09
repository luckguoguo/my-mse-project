package cn.edu.sjtu.petclinic.service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.service.exception.DiagnosisStaredException;
import cn.edu.sjtu.petclinic.service.exception.InterrogationDiagnosedException;

public interface InterrogationService {

	void addInterrogation(Interrogation interrogation);
	
	void updateInterrogation(Interrogation interrogation) throws InterrogationDiagnosedException;
	
	Page<Interrogation> queryUndiagnosedInterrogations(InterrogationQuery query);
	
	Page<Interrogation> queryDiagnosedInterrogations(InterrogationQuery query);
	
	Interrogation getInterrogation(Long id);
	
	void addDiagnosis(Diagnosis diagnosis) throws InterrogationDiagnosedException;

	void updateDiagnosis(Diagnosis diagnosis) throws DiagnosisStaredException;
	
	Page<Diagnosis> queryDiagnosis(DiagnosisQuery query);
	
	void updateDiagnosisStar(Diagnosis diagnosis, int star);
	
	Diagnosis getDiagnosis(Long id);
	
}
