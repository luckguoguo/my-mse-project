package cn.edu.sjtu.petclinic.dao;

import java.util.Date;
import java.util.List;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

public interface DailyOutpatientDao {

	void save(DailyOutpatient dailyOutpatient);
	
	DailyOutpatient findByVeterinarianAndDay(Long veterinarianId, Date day);
	
	DailyOutpatient get(Long id);
	
	List<DailyOutpatient> findDailyOutpatients(DailyOutpatientQuery query);
	
	Page<DailyOutpatient> findPagedDailyOutpatients(DailyOutpatientQuery query);
	
}
