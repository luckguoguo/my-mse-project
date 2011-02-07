package cn.edu.sjtu.petclinic.dao.jpa;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.junit.Test;

import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.enums.Gender;

public class TestUserJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "userDao")
	UserJpaDao userDao;
	
	@Test
	public void testFindUserByUsername() {
		logger.debug("testFindUserByUsername...");
		assertNotNull(userDao.findUserByUsername("admin1"));
		assertTrue(userDao.findUserByUsername("admin1") instanceof Administrator);
		assertNotNull(userDao.findUserByUsername("vet1"));
		assertTrue(userDao.findUserByUsername("vet1") instanceof Veterinarian);
		assertNotNull(userDao.findUserByUsername("petowner1"));
		assertTrue(userDao.findUserByUsername("petowner1") instanceof PetOwner);
		assertNull(userDao.findUserByUsername("notexists"));
	}
	
	@Test
	public void testSaveVeterinarian_Success() {
		logger.debug("testSaveVeterinarian_Success...");
		Veterinarian veterinarian = createValidVeterinarian();
		userDao.save(veterinarian);
		userDao.getEntityManager().flush();
	}
	
	@Test(expected = PersistenceException.class)
	public void testSave_NameExists() {
		logger.debug("testSave_NameExists...");
		Veterinarian veterinarian = createValidVeterinarian();
		veterinarian.setUsername("vet1");
		userDao.save(veterinarian);
	}
	
	private Veterinarian createValidVeterinarian() {
		Veterinarian veterinarian = new Veterinarian();
		veterinarian.setUsername("new veterinarian");
		veterinarian.setPassword("111111");
		veterinarian.setEmail("a@a.com");
		veterinarian.setName("vet");
		veterinarian.setGender(Gender.FEMALE);
		veterinarian.setTitle("Dr.");
		veterinarian.setIntroduction("hei");
		veterinarian.setTelephone("1222");
		veterinarian.setBirthdate(new Date());
		veterinarian.setWorkingdate(new Date());
		Clinic clinic = new Clinic();
		clinic.setId(1l);
		veterinarian.setClinic(clinic);
		return veterinarian;
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/user-data.xml";
	}
	
}
