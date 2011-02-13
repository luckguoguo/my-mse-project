package cn.edu.sjtu.petclinic.dao;

import java.util.List;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

public interface AppointmentDao {

	void save(Appointment appointment);
	
	Appointment get(Long id);
	
	Page<Appointment> findAppointments(AppointmentQuery query);
	
	List<Appointment> findAppointments(DailyOutpatient dailyOutpatient);
	
	Appointment findByPetOwnerAndDay(Long petOwnerId, Long dailyOutpatientId);
	
}
