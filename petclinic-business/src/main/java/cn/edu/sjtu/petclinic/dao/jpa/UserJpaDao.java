package cn.edu.sjtu.petclinic.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;
import cn.edu.sjtu.petclinic.dao.UserDao;
import cn.edu.sjtu.petclinic.entity.User;

@Repository("userDao")
public class UserJpaDao extends AbstractJpaDaoSupport<User, Long> implements UserDao {

	@Override
	public User findUserByUsername(String username) {
		return findUnique("from User where username = ?", username);
	}
	
}
