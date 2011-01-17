package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.DailyOutpatientDao;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

@Repository("dailyOutpatientDao")
public class DailyOutpatientJpaDao extends AbstractJpaDaoSupport<DailyOutpatient, Long> implements DailyOutpatientDao {

}
