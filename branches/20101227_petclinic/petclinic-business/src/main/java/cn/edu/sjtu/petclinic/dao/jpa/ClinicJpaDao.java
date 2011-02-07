package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.ClinicDao;
import cn.edu.sjtu.petclinic.dto.ClinicQuery;
import cn.edu.sjtu.petclinic.entity.Clinic;

@Repository("clinicDao")
public class ClinicJpaDao extends AbstractJpaDaoSupport<Clinic, Long> implements ClinicDao {

	@Override
	public Clinic findClinicByName(String name) {
		return findUnique("from Clinic where name = ?", name);
	}

	@Override
	public Page<Clinic> findClinics(ClinicQuery clinicQuery) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from Clinic ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(clinicQuery.getName())) {
			jpqlSb.append("and name like :name ");
			values.put("name", "%" + clinicQuery.getName() + "%");
		}
		if (clinicQuery.getGrade() != null) {
			jpqlSb.append("and grade = :grade ");
			values.put("grade", clinicQuery.getGrade());
		}
		if (StringUtils.isNotBlank(clinicQuery.getAddress())) {
			jpqlSb.append("and address like :address ");
			values.put("address", "%" + clinicQuery.getAddress() + "%");
		}
		if (clinicQuery.getStar() != null) {
			jpqlSb.append("and star = :star ");
			values.put("star", clinicQuery.getStar());
		}
		if (clinicQuery.getStatus() != null) {
			jpqlSb.append("and status = :status ");
			values.put("status", clinicQuery.getStatus());
		}
		jpqlSb.append("order by createdTime");
		return findPage(clinicQuery.getPage(), jpqlSb.toString(), values);
	}

	@Override
	public List<Clinic> getAll() {
		return find("from Clinic order by name");
	}
	
}
