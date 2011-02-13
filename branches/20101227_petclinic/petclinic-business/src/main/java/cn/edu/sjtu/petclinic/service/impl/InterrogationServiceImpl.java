package cn.edu.sjtu.petclinic.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.service.InterrogationService;
import cn.edu.sjtu.petclinic.service.exception.DiagnosisStaredException;
import cn.edu.sjtu.petclinic.service.exception.InterrogationDiagnosedException;

@Service
public class InterrogationServiceImpl extends AbstractService implements InterrogationService {

	@Override
	public void addInterrogation(Interrogation interrogation) {
		interrogation.setStatus(Interrogation.Status.NEW);
		interrogationDao.save(interrogation);
	}
	
	@Override
	public void updateInterrogation(Interrogation interrogation)
			throws InterrogationDiagnosedException {
		
		Interrogation interrogationPojo = getInterrogation(interrogation.getId());
		
		if (interrogationPojo.getStatus() == Interrogation.Status.DIAGNOSED) {
			throw new InterrogationDiagnosedException();
		}
		
		copyToInterrogationPojo(interrogation, interrogationPojo);
		interrogationDao.save(interrogationPojo);
	}
	
	private void copyToInterrogationPojo(Interrogation interrogation,
			Interrogation interrogationPojo) {

		interrogationPojo.setName(interrogation.getName());
		interrogationPojo.setStartDate(interrogation.getStartDate());
		interrogationPojo.setSymptom(interrogation.getSymptom());
		interrogationPojo.setMemo(interrogation.getMemo());
		interrogationPojo.setLastModifiedTime(interrogation.getLastModifiedTime());
		interrogationPojo.setLastModifiedBy(interrogation.getLastModifiedBy());
	}

	@Override
	public Page<Interrogation> queryInterrogations(InterrogationQuery query) {
		return interrogationDao.findInterrogations(query);
	}
	
	@Override
	public Page<Interrogation> queryUndiagnosedInterrogations(
			InterrogationQuery query) {
		
		query.setStatus(Interrogation.Status.NEW);
		return interrogationDao.findInterrogations(query);
	}
	
	@Override
	public Page<Interrogation> queryDiagnosedInterrogations(
			InterrogationQuery query) {
		
		query.setStatus(Interrogation.Status.DIAGNOSED);
		return interrogationDao.findInterrogations(query);
	}
	
	@Override
	public Interrogation getInterrogation(Long id) {
		return interrogationDao.get(id);
	}

	@Override
	public void addDiagnosis(Diagnosis diagnosis)
			throws InterrogationDiagnosedException {
		
		Interrogation interrogation = interrogationDao.get(diagnosis.getInterrogation().getId());
		
		if (interrogation.getStatus() == Interrogation.Status.DIAGNOSED) {
			throw new InterrogationDiagnosedException();
		}
		
		diagnosis.setStatus(Diagnosis.Status.NEW);
		diagnosisDao.save(diagnosis);

		interrogation.setStatus(Interrogation.Status.DIAGNOSED);
		interrogationDao.save(interrogation);
	}
	
	@Override
	public void updateDiagnosis(Diagnosis diagnosis)
			throws DiagnosisStaredException {
		
		Diagnosis diagnosisPojo = getDiagnosis(diagnosis.getId());
		
		if (diagnosisPojo.getStatus() == Diagnosis.Status.STARED) {
			throw new DiagnosisStaredException();
		}
		
		copyToDiagnosisPojo(diagnosis, diagnosisPojo);
		diagnosisDao.save(diagnosisPojo);
	}

	private void copyToDiagnosisPojo(Diagnosis diagnosis,
			Diagnosis diagnosisPojo) {

		diagnosisPojo.setSymptom(diagnosis.getSymptom());
		diagnosisPojo.setDiagnosis(diagnosis.getDiagnosis());
		diagnosisPojo.setTherapy(diagnosis.getTherapy());
		diagnosisPojo.setPrescription(diagnosis.getPrescription());
		diagnosisPojo.setStar(diagnosis.getStar());
		diagnosisPojo.setLastModifiedTime(diagnosis.getLastModifiedTime());
		diagnosisPojo.setLastModifiedBy(diagnosis.getLastModifiedBy());
	}

	@Override
	public Page<Diagnosis> queryDiagnosises(DiagnosisQuery query) {
		return diagnosisDao.findDiagnosises(query);
	}
	
	@Override
	public void updateDiagnosisStar(Diagnosis diagnosis, int star) {
		Diagnosis diagnosisPojo = getDiagnosis(diagnosis.getId());
		diagnosisPojo.setStar(star);
		diagnosisPojo.setStatus(Diagnosis.Status.STARED);
		diagnosisDao.save(diagnosisPojo);
	}

	@Override
	public Diagnosis getDiagnosis(Long id) {
		return diagnosisDao.get(id);
	}

	@Override
	public Diagnosis getDiagnosis(Interrogation interrogation) {
		return diagnosisDao.findDiagnosis(interrogation);
	}

}
