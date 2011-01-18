package cn.edu.sjtu.petclinic.dao.jpa;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestUserJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "userDao")
	UserJpaDao userDao;
	
	@Test
	public void testFindUserByUsername() {
		logger.debug("testFindUserByUsername...");
		assertNotNull(userDao.findUserByUsername("admin1"));
		assertNotNull(userDao.findUserByUsername("vet1"));
		assertNotNull(userDao.findUserByUsername("petowner1"));
		assertNull(userDao.findUserByUsername("notexists"));
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/user-data.xml";
	}
	
}
