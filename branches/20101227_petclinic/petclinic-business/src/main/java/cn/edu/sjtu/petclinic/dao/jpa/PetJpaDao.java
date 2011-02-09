package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.PetDao;
import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetOwner;

@Repository("petDao")
public class PetJpaDao extends AbstractJpaDaoSupport<Pet, Long> implements PetDao {

	@Override
	public List<Pet> findPetsByOwner(PetOwner owner) {
		return find("from Pet p where p.owner.id = ? order by id", owner.getId());
	}

}
