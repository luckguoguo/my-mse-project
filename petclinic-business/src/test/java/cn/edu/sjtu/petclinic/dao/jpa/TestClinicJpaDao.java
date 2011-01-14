package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.apache.commons.lang.time.DateUtils;
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
	public void testGet_Success() throws ParseException {
		logger.debug("testLoad_Success...");
		Clinic clinic = clinicDao.get(new Long(1));
		assertNotNull(clinic);
		assertEquals(1l, clinic.getId());
		assertEquals("clinicName1", clinic.getName());
		assertEquals("intro1", clinic.getIntroduction());
		assertEquals(1, clinic.getGrade());
		assertEquals("address1", clinic.getAddress());
		assertEquals("telephone1", clinic.getTelephone());
		assertEquals("email1", clinic.getEmail());
		assertEquals(1, clinic.getStar());
		assertEquals("mgrPassword1", clinic.getMgrPassword());
		assertEquals(Clinic.Status.ACTIVE, clinic.getStatus());
		assertEquals(1l, clinic.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), clinic.getCreatedTime());
		assertEquals(1l, clinic.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), clinic.getLastModifiedTime());
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
