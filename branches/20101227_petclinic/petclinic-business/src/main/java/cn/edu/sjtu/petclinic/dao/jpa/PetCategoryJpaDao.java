package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.PetDao;
import cn.edu.sjtu.petclinic.entity.PetCategory;

@Repository("petCategoryDao")
public class PetCategoryJpaDao extends AbstractJpaDaoSupport<PetCategory, Long> implements PetDao {

}
