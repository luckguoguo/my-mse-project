package cn.edu.sjtu.petclinic.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.service.InterrogationService;
import cn.edu.sjtu.petclinic.service.exception.InterrogationDiagnosedException;

@Service
public class InterrogationServiceImpl extends AbstractService implements InterrogationService {

	@Override
	public void addDiagnosis(Diagnosis diagnosis)
			throws InterrogationDiagnosedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterrogation(Interrogation interrogation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Diagnosis getDiagnosis(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interrogation getInterrogation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Interrogation> queryInterrogationsHistory(
			InterrogationQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Interrogation> queryUndiagnosedInterrogations(
			InterrogationQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInterrogation(Interrogation interrogation)
			throws InterrogationDiagnosedException {
		// TODO Auto-generated method stub
		
	}

}
