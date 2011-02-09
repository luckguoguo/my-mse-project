package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dao.DiagnosisDao;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;

@Repository("diagnosisDao")
public class DiagnosisJpaDao extends AbstractJpaDaoSupport<Diagnosis, Long> implements DiagnosisDao {

	@Override
	public Page<Diagnosis> findDiagnosises(DiagnosisQuery query) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from Diagnosis ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (query.getPetId() != null) {
			jpqlSb.append("and interrogation.pet.id = :petId ");
			values.put("petId", query.getPetId());
		}
		if (query.getPetOwnerId() != null) {
			jpqlSb.append("and interrogation.petOwner.id = :petOwnerId ");
			values.put("petOwnerId", query.getPetOwnerId());
		}
		if (query.getVeterinarianId() != null) {
			jpqlSb.append("and veterinarian.id = :veterinarianId ");
			values.put("veterinarianId", query.getVeterinarianId());
		}
		if (query.getInterrogationId() != null) {
			jpqlSb.append("and interrogation.id = :interrogationId ");
			values.put("interrogationId", query.getInterrogationId());
		}
		if (StringUtils.isNotBlank(query.getName())) {
			jpqlSb.append("and interrogation.name like :name ");
			values.put("name", "%" + query.getName() + "%");
		}
		if (query.getStartDateFrom() != null) {
			jpqlSb.append("and interrogation.startDate >= :startDateFrom ");
			values.put("startDateFrom", query.getStartDateFrom());
		}
		if (query.getStartDateTo() != null) {
			jpqlSb.append("and interrogation.startDate < :startDateTo ");
			values.put("startDateTo", DateUtils.addDays(query.getStartDateTo(), 1));
		}
		if (query.getStatus() != null) {
			jpqlSb.append("and status = :status ");
			values.put("status", query.getStatus());
		}
		jpqlSb.append("order by createdTime desc");
		return findPage(query.getPage(), jpqlSb.toString(), values);
	}

}
