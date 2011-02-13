package cn.edu.sjtu.petclinic.service;

import java.util.List;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientAppointedException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientCountExceedsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExistsException;
import cn.edu.sjtu.petclinic.service.exception.DailyOutpatientExpiredException;

public interface AppointmentService {

	void addDailyOutpatient(DailyOutpatient dailyOutpatient) throws DailyOutpatientExistsException;
	
	void updateDailyOutpatient(DailyOutpatient dailyOutpatient) 
			throws DailyOutpatientExpiredException, DailyOutpatientCountExceedsException;
	
	List<DailyOutpatient> queryAvailableDailyOutpatients(Veterinarian veterinarian);
	
	List<DailyOutpatient> queryUpcomingDailyOutpatients(Veterinarian veterinarian);
	
	List<Appointment> queryAppointmentsByDailyOutpatient(DailyOutpatient dailyOutpatient);
	
	Page<DailyOutpatient> queryUpcomingDailyOutpatients(DailyOutpatientQuery query);
	
	Page<DailyOutpatient> queryDailyOutpatients(DailyOutpatientQuery query);
	
	DailyOutpatient getDailyOutpatient(Long id);
	
	String addAppointment(Appointment appointment) throws DailyOutpatientCountExceedsException, DailyOutpatientAppointedException;
	
	Page<Appointment> queryAppointments(AppointmentQuery query);
	
	Appointment getAppointment(Long id);
	
}
