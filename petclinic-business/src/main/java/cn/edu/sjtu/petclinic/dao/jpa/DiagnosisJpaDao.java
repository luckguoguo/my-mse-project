package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.DiagnosisDao;
import cn.edu.sjtu.petclinic.entity.Diagnosis;

@Repository("diagnosisDao")
public class DiagnosisJpaDao extends AbstractJpaDaoSupport<Diagnosis, Long> implements DiagnosisDao {

}
