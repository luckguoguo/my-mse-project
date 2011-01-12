package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.ClinicDao;
import cn.edu.sjtu.petclinic.entity.Clinic;

@Repository("clinicDao")
public class ClinicJpaDao extends AbstractJpaDaoSupport<Clinic, Long> implements ClinicDao {

}
