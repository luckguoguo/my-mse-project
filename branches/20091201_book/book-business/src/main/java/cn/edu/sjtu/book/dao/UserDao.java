package cn.edu.sjtu.book.dao;

import cn.edu.sjtu.book.entity.User;

public interface UserDao {

	User findByLoginName(String loginName);
	
}
