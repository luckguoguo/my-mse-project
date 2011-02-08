package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.junit.Test;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.VeterinarianQuery;
import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
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
	
	@Test
	public void testFindVeterinarians() throws ParseException {
		logger.debug("testFindVeterinarians...");
		Page<User> page = new Page<User>(1).pageNo(1);
		VeterinarianQuery query = new VeterinarianQuery();
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setClinicName("clinicName1");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setClinicName("clinicName0");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setUsername("vet1");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setUsername("vet0");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setName("vetname1");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setName("vetname0");
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setGender(Gender.MALE);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setGender(Gender.FEMALE);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setWorkingDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setWorkingDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setWorkingDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setWorkingDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setWorkingDateFrom(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setWorkingDateTo(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setSpecialityPetCategoryId(1l);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setSpecialityPetCategoryId(100l);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setStatus(User.Status.ACTIVE);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<User>(1).pageNo(1);
		query = new VeterinarianQuery();
		query.setStatus(User.Status.INACTIVE);
		query.setPage(page);
		page = userDao.findVeterinarians(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/user-data.xml";
	}
	
}
