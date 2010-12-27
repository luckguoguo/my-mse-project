package cn.edu.sjtu.book.service.impl;

import static junit.framework.Assert.assertEquals;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

import cn.edu.sjtu.book.dao.UserDao;
import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.book.service.exception.UserInvalidPasswordException;
import cn.edu.sjtu.book.service.exception.UserNotExistsException;

public class TestUserManagerImpl {

	UserManagerImpl userManager;
	
	UserDao mockUserDao;
	
	@Before
	public void setup() {
		userManager = new UserManagerImpl();
		mockUserDao = createMock(UserDao.class);
		userManager.setUserDao(mockUserDao);
	}
	
	@Test(expected = UserNotExistsException.class)
	public void testAuthenticate_UserNotExists() throws UserNotExistsException, UserInvalidPasswordException {
		User user = new User();
		user.setLoginName("notexists");
		user.setPassword("111111");
		
		expect(mockUserDao.findByLoginName(user.getLoginName())).andReturn(null);
		
		replay(mockUserDao);
		userManager.authenticate(user);
		verify(mockUserDao);
	}
	
	@Test(expected = UserInvalidPasswordException.class)
	public void testAuthenticate_UserInvalidPassword() throws UserNotExistsException, UserInvalidPasswordException {
		User userParam = new User();
		userParam.setLoginName("jim");
		userParam.setPassword("111111");
		
		User user = new User();
		user.setLoginName("jim");
		user.setPassword("222222");
		
		expect(mockUserDao.findByLoginName(userParam.getLoginName())).andReturn(user);
		
		replay(mockUserDao);
		userManager.authenticate(userParam);
		verify(mockUserDao);
	}
	
	@Test
	public void testAuthenticate_Success() throws UserNotExistsException, UserInvalidPasswordException {
		User userParam = new User();
		userParam.setLoginName("jim");
		userParam.setPassword("111111");
		
		User user = new User();
		user.setLoginName("jim");
		user.setPassword("111111");
		
		expect(mockUserDao.findByLoginName(userParam.getLoginName())).andReturn(user);
		
		replay(mockUserDao);
		User userResult = userManager.authenticate(userParam);
		assertEquals(user, userResult);
		verify(mockUserDao);
	}
	
}
