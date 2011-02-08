package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dao.UserDao;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.User;

@Repository("userDao")
public class UserJpaDao extends AbstractJpaDaoSupport<User, Long> implements UserDao {

	@Override
	public User findUserByUsername(String username) {
		return findUnique("from User where username = ?", username);
	}

	@Override
	public Page<User> findVeterinarians(VeterinarianQuery query) {
		StringBuilder jpqlSb = new StringBuilder();
		jpqlSb.append("from Veterinarian v ");
		jpqlSb.append("where 1 = 1 ");
		
		Map<String, Object> values = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(query.getClinicName())) {
			jpqlSb.append("and v.clinic.name like :clinicName ");
			values.put("clinicName", "%" + query.getClinicName() + "%");
		}
		if (StringUtils.isNotBlank(query.getUsername())) {
			jpqlSb.append("and v.username like :username ");
			values.put("username", "%" + query.getUsername() + "%");
		}
		if (StringUtils.isNotBlank(query.getName())) {
			jpqlSb.append("and v.name like :name ");
			values.put("name", "%" + query.getName() + "%");
		}
		if (query.getGender() != null) {
			jpqlSb.append("and v.gender = :gender ");
			values.put("gender", query.getGender());
		}
		if (query.getWorkingDateFrom() != null) {
			jpqlSb.append("and v.workingdate >= :workingDateFrom ");
			values.put("workingDateFrom", query.getWorkingDateFrom());
		}
		if (query.getWorkingDateTo() != null) {
			jpqlSb.append("and v.workingdate < :workingDateTo ");
			values.put("workingDateTo", DateUtils.addDays(query.getWorkingDateTo(), 1));
		}
		if (query.getSpecialityPetCategoryId() != null && query.getSpecialityPetCategoryId() > 0) {
			jpqlSb.append("and v.specialityPetCategory.id = :specialityPetCategoryId ");
			values.put("specialityPetCategoryId", query.getSpecialityPetCategoryId());
		}
		if (query.getStatus() != null) {
			jpqlSb.append("and status = :status ");
			values.put("status", query.getStatus());
		}
		jpqlSb.append("order by v.clinic.name, v.name");
		return findPage(query.getPage(), jpqlSb.toString(), values);
	}
	
}
