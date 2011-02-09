package cn.edu.sjtu.petclinic.dao;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;

public interface AppointmentDao {

	void save(Appointment appointment);
	
	Appointment get(Long id);
	
	Page<Appointment> findAppointments(AppointmentQuery query);
	
}
