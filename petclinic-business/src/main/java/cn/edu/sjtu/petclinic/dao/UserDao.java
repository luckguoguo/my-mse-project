package cn.edu.sjtu.petclinic.dao;

import cn.edu.sjtu.petclinic.entity.User;

public interface UserDao {

	User findUserByUsername(String username);
	
	void save(User user);
	
	User get(Long id);
	
}
