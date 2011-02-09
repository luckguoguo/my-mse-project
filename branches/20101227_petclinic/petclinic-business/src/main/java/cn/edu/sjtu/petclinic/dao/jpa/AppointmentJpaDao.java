package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dao.AppointmentDao;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;

@Repository("appointmentDao")
public class AppointmentJpaDao extends AbstractJpaDaoSupport<Appointment, Long> implements AppointmentDao {

	@Override
	public Page<Appointment> findAppointments(AppointmentQuery query) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from Appointment ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (query.getPetOwnerId() != null) {
			jpqlSb.append("and petOwner.id = :petOwnerId ");
			values.put("petOwnerId", query.getPetOwnerId());
		}
		if (query.getVeterinarianId() != null) {
			jpqlSb.append("and dailyOutpatient.veterinarian.id = :veterinarianId ");
			values.put("veterinarianId", query.getVeterinarianId());
		}
		if (query.getDayFrom() != null) {
			jpqlSb.append("and dailyOutpatient.day >= :dayFrom ");
			values.put("dayFrom", query.getDayFrom());
		}
		if (query.getDayTo() != null) {
			jpqlSb.append("and dailyOutpatient.day < :dayTo ");
			values.put("dayTo", DateUtils.addDays(query.getDayTo(), 1));
		}
		jpqlSb.append("order by dailyOutpatient.day desc");
		return findPage(query.getPage(), jpqlSb.toString(), values);
	}

}
