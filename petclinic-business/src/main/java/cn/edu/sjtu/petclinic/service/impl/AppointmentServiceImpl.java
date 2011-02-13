package cn.edu.sjtu.petclinic.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.AppointmentService;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientAppointedException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientCountExceedsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExistsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExpiredException;

@Service
public class AppointmentServiceImpl extends AbstractService implements AppointmentService {

	@Override
	public void addDailyOutpatient(DailyOutpatient dailyOutpatient)
			throws DailyOutpatientExistsException {
		
		DailyOutpatient dailyOutpatientPojo = dailyOutpatientDao.findByVeterinarianAndDay(dailyOutpatient.getVeterinarian().getId(), dailyOutpatient.getDay());
		
		if (dailyOutpatientPojo != null) {
			throw new DailyOutpatientExistsException();
		}
		
		dailyOutpatientDao.save(dailyOutpatient);
	}
	
	@Override
	public void updateDailyOutpatient(DailyOutpatient dailyOutpatient)
			throws DailyOutpatientExpiredException,
			DailyOutpatientCountExceedsException {
		
		DailyOutpatient dailyOutpatientPojo = dailyOutpatientDao.get(dailyOutpatient.getId());
		if (dailyOutpatientPojo.getDay().before(new Date())) {
			throw new DailyOutpatientExpiredException();
		}
		
		if (dailyOutpatientPojo.getCountActual() > dailyOutpatient.getCountLimit()) {
			throw new DailyOutpatientCountExceedsException();
		}
		
		dailyOutpatientPojo.setCountLimit(dailyOutpatient.getCountLimit());
		dailyOutpatientDao.save(dailyOutpatientPojo);
	}
	
	@Override
	public List<DailyOutpatient> queryAvailableDailyOutpatients(
			Veterinarian veterinarian) {
		
		DailyOutpatientQuery query = new DailyOutpatientQuery();
		query.setVeterinarianId(veterinarian.getId());
		query.setDayFrom(new Date());
		return dailyOutpatientDao.findDailyOutpatients(query);
	}

	@Override
	public List<DailyOutpatient> queryUpcomingDailyOutpatients(
			Veterinarian veterinarian) {
		
		DailyOutpatientQuery query = new DailyOutpatientQuery();
		query.setVeterinarianId(veterinarian.getId());
		query.setDayFrom(DateUtils.addDays(new Date(), 1));
		query.setDayTo(DateUtils.addDays(new Date(), 14));
		return dailyOutpatientDao.findDailyOutpatients(query);
	}

	@Override
	public Page<DailyOutpatient> queryUpcomingDailyOutpatients(
			DailyOutpatientQuery query) {
		
		query.setDayFrom(DateUtils.addDays(new Date(), 1));
		query.setDayTo(DateUtils.addDays(new Date(), 14));
		return dailyOutpatientDao.findPagedDailyOutpatients(query);
	}
	
	@Override
	public Page<DailyOutpatient> queryDailyOutpatients(
			DailyOutpatientQuery query) {

		return dailyOutpatientDao.findPagedDailyOutpatients(query);
	}
	
	@Override
	public DailyOutpatient getDailyOutpatient(Long id) {
		return dailyOutpatientDao.get(id);
	}

	@Override
	public String addAppointment(Appointment appointment)
			throws DailyOutpatientCountExceedsException, DailyOutpatientAppointedException {
		
		DailyOutpatient dailyOutpatient = dailyOutpatientDao.get(appointment.getDailyOutpatient().getId());
		
		Appointment appointmentPojo = appointmentDao.findByPetOwnerAndDay(appointment.getPetOwner().getId(), 
				appointment.getDailyOutpatient().getId());
		if (appointmentPojo != null) {
			throw new DailyOutpatientAppointedException();
		}
		
		if (dailyOutpatient.getCountLimit().equals(dailyOutpatient.getCountActual())) {
			throw new DailyOutpatientCountExceedsException();
		}
		
		dailyOutpatient.setCountActual(dailyOutpatient.getCountActual() + 1);
		dailyOutpatientDao.save(dailyOutpatient);
		appointment.setSerialNo(DateUtils.formatDefaultDate(appointment.getDailyOutpatient().getDay()) + "-"
				+ appointment.getDailyOutpatient().getVeterinarian().getId() + "-" 
				+ appointment.getPetOwner().getId() + "-" 
				+ RandomStringUtils.randomAlphanumeric(6));
		appointmentDao.save(appointment);
		return appointment.getSerialNo();
	}

	@Override
	public Page<Appointment> queryAppointments(AppointmentQuery query) {
		return appointmentDao.findAppointments(query);
	}

	@Override
	public Appointment getAppointment(Long id) {
		return appointmentDao.get(id);
	}

	@Override
	public List<Appointment> queryAppointmentsByDailyOutpatient(
			DailyOutpatient dailyOutpatient) {
		return appointmentDao.findAppointments(dailyOutpatient);
	}

}
