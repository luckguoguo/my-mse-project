package cn.edu.sjtu.petclinic.dao.jpa;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.junit.Test;

import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.petclinic.entity.Clinic;

public class TestClinicJpaDao extends SpringTxDaoTestCase {
	
	@Resource(name = "clinicDao")
	ClinicJpaDao clinicDao;
	
	@Test
	public void testSave_Success() {
		logger.debug("testSave...");
		Clinic clinic = new Clinic();
		clinic.setName("new clinic");
		clinic.setMgrPassword("new mgr password");
		clinicDao.save(clinic);
	}
	
	@Test(expected = PersistenceException.class)
	public void testSave_NameExists() {
		logger.debug("testSave...");
		Clinic clinic = new Clinic();
		clinic.setName("clinicName1");
		clinic.setMgrPassword("new mgr password");
		clinicDao.save(clinic);
	}
	
	@Test
	public void testGet_Success() {
		logger.debug("testLoad_Success...");
		Clinic clinic = clinicDao.get(new Long(1));
		assertNotNull(clinic);
		assertEquals("clinicName1", clinic.getName());
	}
	
	@Test
	public void testGet_NotExists() {
		logger.debug("testGet_NotExists...");
		Clinic clinic = clinicDao.get(new Long(0));
		assertNull(clinic);
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/clinic-data.xml";
	}
}
