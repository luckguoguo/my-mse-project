package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dao.DailyOutpatientDao;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

@Repository("dailyOutpatientDao")
public class DailyOutpatientJpaDao extends AbstractJpaDaoSupport<DailyOutpatient, Long> implements DailyOutpatientDao {

	@Override
	public DailyOutpatient findByVeterinarianAndDay(Long veterinarianId,
			Date day) {
		return findUnique("from DailyOutpatient where veterinarian.id = ? and day = ?", 
				veterinarianId, day);
	}
	
	@Override
	public List<DailyOutpatient> findDailyOutpatients(DailyOutpatientQuery query) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from DailyOutpatient ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (query.getVeterinarianId() != null) {
			jpqlSb.append("and veterinarian.id = :veterinarianId ");
			values.put("veterinarianId", query.getVeterinarianId());
		}
		if (StringUtils.isNotBlank(query.getVeterinarianName())) {
			jpqlSb.append("and veterinarian.name like :veterinarianName ");
			values.put("veterinarianName", "%" + query.getVeterinarianName() + "%");
		}
		if (StringUtils.isNotBlank(query.getClinicName())) {
			jpqlSb.append("and veterinarian.clinic.name like :clinicName ");
			values.put("clinicName", "%" + query.getClinicName() + "%");
		}
		if (StringUtils.isNotBlank(query.getClinicAddress())) {
			jpqlSb.append("and veterinarian.clinic.address like :clinicAddress ");
			values.put("clinicAddress", "%" + query.getClinicAddress() + "%");
		}
		if (query.getSpecialityPetCategoryId() != null && query.getSpecialityPetCategoryId() > 0) {
			jpqlSb.append("and veterinarian.specialityPetCategory.id = :specialityPetCategoryId ");
			values.put("specialityPetCategoryId", query.getSpecialityPetCategoryId());
		}
		if (query.getDayFrom() != null) {
			jpqlSb.append("and day >= :dayFrom ");
			values.put("dayFrom", query.getDayFrom());
		}
		if (query.getDayTo() != null) {
			jpqlSb.append("and day < :dayTo ");
			values.put("dayTo", DateUtils.addDays(query.getDayTo(), 1));
		}
		jpqlSb.append("order by day, veterinarian.clinic.name, veterinarian.name");
		return find(jpqlSb.toString(), values);
	}
	
	@Override
	public Page<DailyOutpatient> findPagedDailyOutpatients(
			DailyOutpatientQuery query) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from DailyOutpatient ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (query.getVeterinarianId() != null) {
			jpqlSb.append("and veterinarian.id = :veterinarianId ");
			values.put("veterinarianId", query.getVeterinarianId());
		}
		if (StringUtils.isNotBlank(query.getVeterinarianName())) {
			jpqlSb.append("and veterinarian.name like :veterinarianName ");
			values.put("veterinarianName", "%" + query.getVeterinarianName() + "%");
		}
		if (StringUtils.isNotBlank(query.getClinicName())) {
			jpqlSb.append("and veterinarian.clinic.name like :clinicName ");
			values.put("clinicName", "%" + query.getClinicName() + "%");
		}
		if (StringUtils.isNotBlank(query.getClinicAddress())) {
			jpqlSb.append("and veterinarian.clinic.address like :clinicAddress ");
			values.put("clinicAddress", "%" + query.getClinicAddress() + "%");
		}
		if (query.getSpecialityPetCategoryId() != null && query.getSpecialityPetCategoryId() > 0) {
			jpqlSb.append("and veterinarian.specialityPetCategory.id = :specialityPetCategoryId ");
			values.put("specialityPetCategoryId", query.getSpecialityPetCategoryId());
		}
		if (query.getDayFrom() != null) {
			jpqlSb.append("and day >= :dayFrom ");
			values.put("dayFrom", query.getDayFrom());
		}
		if (query.getDayTo() != null) {
			jpqlSb.append("and day < :dayTo ");
			values.put("dayTo", DateUtils.addDays(query.getDayTo(), 1));
		}
		jpqlSb.append("order by day, veterinarian.clinic.name, veterinarian.name");
		return findPage(query.getPage(), jpqlSb.toString(), values);
	}

}
