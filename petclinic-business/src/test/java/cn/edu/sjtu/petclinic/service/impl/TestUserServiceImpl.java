package cn.edu.sjtu.petclinic.service.impl;

import static org.easymock.EasyMock.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cn.edu.sjtu.petclinic.dao.UserDao;
import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.petclinic.service.exception.UserInvalidStatusException;
import cn.edu.sjtu.petclinic.service.exception.UserNotExistsException;

public class TestUserServiceImpl {

	UserServiceImpl userService;
	UserDao mockUserDao;
	
	String username = "jim";
	String password = "123456";
	String md5Password = "e10adc3949ba59abbe56e057f20f883e"; // from 123456
	
	@Before
	public void setUp() {
		userService = new UserServiceImpl();
		mockUserDao = createMock(UserDao.class);
		userService.setUserDao(mockUserDao);
	}
	
	@Test(expected = UserNotExistsException.class)
	public void testAuthenticate_UserNotExists() 
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException {
		
		expect(mockUserDao.findUserByUsername(username)).andReturn(null);
		replay(mockUserDao);
		userService.authenticate(username, password);
		verify(mockUserDao);
	}
	
	@Test(expected = UserInvalidPasswordException.class)
	public void testAuthenticate_UserInvalidPassword() 
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException {
		
		User user = new Administrator();
		user.setUsername(username);
		user.setPassword(md5Password);
		expect(mockUserDao.findUserByUsername(username)).andReturn(user);
		replay(mockUserDao);
		userService.authenticate(username, "111111");
		verify(mockUserDao);
	}
	
	@Test(expected = UserInvalidStatusException.class)
	public void testAuthenticate_UserInvalidStatus() 
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException {
		
		User user = new Administrator();
		user.setUsername(username);
		user.setPassword(md5Password);
		user.setStatus(User.Status.INACTIVE);
		expect(mockUserDao.findUserByUsername(username)).andReturn(user);
		replay(mockUserDao);
		userService.authenticate(username, password);
		verify(mockUserDao);
	}
	
	@Test
	public void testAuthenticate_Success() 
			throws UserNotExistsException, UserInvalidPasswordException, UserInvalidStatusException {
		
		User user = new Administrator();
		user.setUsername(username);
		user.setPassword(md5Password);
		user.setStatus(User.Status.ACTIVE);
		expect(mockUserDao.findUserByUsername(username)).andReturn(user);
		replay(mockUserDao);
		assertEquals(user, userService.authenticate(username, password));
		verify(mockUserDao);
	}
	
}
