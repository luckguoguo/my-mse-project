package cn.edu.sjtu.book.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.book.dao.UserDao;
import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.book.service.UserManager;
import cn.edu.sjtu.book.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.book.service.exception.UserNotExistsException;

@Service
public class UserManagerImpl implements UserManager {
	
	private static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User authenticate(User user) throws UserNotExistsException, UserInvalidPasswordException {
		
		logger.debug("call findBookByName");
		User aUser = userDao.findByLoginName(user.getLoginName());
		if (aUser == null) throw new UserNotExistsException();
		
		logger.debug("checking password");
		if (StringUtils.isEmpty(user.getPassword()) || !user.getPassword().equals(aUser.getPassword())) {
			// user password invalid
			logger.debug("invalid password");
			throw new UserInvalidPasswordException();
		}
		
		return aUser;
	}

}
