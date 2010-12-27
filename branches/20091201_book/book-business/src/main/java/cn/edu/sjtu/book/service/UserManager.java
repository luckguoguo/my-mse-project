package cn.edu.sjtu.book.service;

import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.book.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.book.service.exception.UserNotExistsException;

public interface UserManager {
	
	public User authenticate(User user) throws UserNotExistsException, UserInvalidPasswordException;
	
}
