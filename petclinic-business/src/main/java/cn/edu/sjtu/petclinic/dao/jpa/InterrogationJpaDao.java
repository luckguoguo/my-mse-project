package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.InterrogationDao;
import cn.edu.sjtu.petclinic.entity.Interrogation;

@Repository("interrogationDao")
public class InterrogationJpaDao extends AbstractJpaDaoSupport<Interrogation, Long> implements InterrogationDao {

}
