package cn.edu.sjtu.petclinic.dao;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Interrogation;

public interface InterrogationDao {

	void save(Interrogation interrogation);

	Interrogation get(Long id);
	
	Page<Interrogation> findInterrogations(InterrogationQuery query);
	
}
