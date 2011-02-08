package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.PetCategoryDao;
import cn.edu.sjtu.petclinic.entity.PetCategory;

@Repository("petCategoryDao")
public class PetCategoryJpaDao extends AbstractJpaDaoSupport<PetCategory, Long> implements PetCategoryDao {

	@Override
	public List<PetCategory> getAll() {
		return find("from PetCategory order by id");
	}

}
