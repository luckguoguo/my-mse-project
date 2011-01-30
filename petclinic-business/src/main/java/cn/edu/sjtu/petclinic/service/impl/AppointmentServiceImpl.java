package cn.edu.sjtu.petclinic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.AppointmentService;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientCountExceedsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExistsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExpiredException;

@Service
public class AppointmentServiceImpl extends AbstractService implements AppointmentService {

	@Override
	public String addAppointment(Appointment appointment)
			throws DailyOutpatientCountExceedsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDailyOutpatient(DailyOutpatient dailyOutpatient)
			throws DailyOutpatientExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment getAppointment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyOutpatient getDailyOutpatient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Appointment> queryAppointment(AppointmentQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyOutpatient> queryAvailableDailyOutpatients(
			Veterinarian veterinarian) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyOutpatient> queryUpcomingDailyOutpatients(
			Veterinarian veterinarian) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDailyOutpatient(DailyOutpatient dailyOutpatient)
			throws DailyOutpatientExpiredException,
			DailyOutpatientCountExceedsException {
		// TODO Auto-generated method stub
		
	}

}
