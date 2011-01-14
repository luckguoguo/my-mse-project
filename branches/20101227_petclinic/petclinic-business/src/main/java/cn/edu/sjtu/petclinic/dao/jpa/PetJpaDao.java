package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.PetDao;
import cn.edu.sjtu.petclinic.entity.Pet;

@Repository("petDao")
public class PetJpaDao extends AbstractJpaDaoSupport<Pet, Long> implements PetDao {

}
