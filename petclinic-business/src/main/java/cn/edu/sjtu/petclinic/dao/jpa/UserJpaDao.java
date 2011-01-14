package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.ClinicDao;
import cn.edu.sjtu.petclinic.entity.User;

@Repository("userDao")
public class UserJpaDao extends AbstractJpaDaoSupport<User, Long> implements ClinicDao {

}
