package cn.edu.sjtu.book.dao.jpa;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.junit.Test;

import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestUserJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "userDao")
	UserJpaDao userDao;
	
	@Test
	public void testSave_Success() {
		logger.debug("testSave...");
		User user = new User();
		user.setLoginName("newjim");
		user.setName("newjim");
		userDao.save(user);
	}
	
	@Test(expected = PersistenceException.class)
	public void testSave_LoginNameExists() {
		logger.debug("testSave...");
		User user = new User();
		user.setLoginName("jim");
		user.setName("jim");
		userDao.save(user);
	}
	
	@Test
	public void testFindByLoginName_UserExists() {
		logger.debug("testFindByLoginName_UserExists...");
		User user = userDao.findByLoginName("jim");
		assertNotNull(user);
		assertEquals("jim.jiang", user.getName());
		assertEquals(1l, user.getStore().getId());
		assertEquals("store1", user.getStore().getName());
	}
	
	@Test
	public void testFindByLoginName_UserNotExists() {
		logger.debug("testFindByLoginName_UserNotExists...");
		User user = userDao.findByLoginName("notexists");
		assertNull(user);
	}
	
	@Test
	public void testFindByLoginName_AnotherStore() {
		logger.debug("testFindByLoginName_AnotherStore...");
		User user = userDao.findByLoginName("tj");
		assertNotNull(user);
		assertEquals(2l, user.getStore().getId());
		assertEquals("store2", user.getStore().getName());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/user-data.xml";
	}
	
}
