package cn.edu.sjtu.book.dao.jpa;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.book.dao.UserDao;
import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;

@Repository("userDao")
public class UserJpaDao extends AbstractJpaDaoSupport<User, Long> implements UserDao {

	@Override
	public User findByLoginName(String loginName) {
		return findUnique("from User where loginName = ?", loginName);
	}
	
}