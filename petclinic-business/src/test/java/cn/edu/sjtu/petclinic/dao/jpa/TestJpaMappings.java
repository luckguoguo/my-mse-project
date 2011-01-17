package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.petclinic.entity.Administrator;
import cn.edu.sjtu.petclinic.entity.Appointment;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;
import cn.edu.sjtu.petclinic.entity.Diagnosis;
import cn.edu.sjtu.petclinic.entity.Interrogation;
import cn.edu.sjtu.petclinic.entity.Pet;
import cn.edu.sjtu.petclinic.entity.PetCategory;
import cn.edu.sjtu.petclinic.entity.PetOwner;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.enums.Gender;

public class TestJpaMappings extends SpringTxDaoTestCase {

	@Resource(name = "clinicDao")
	ClinicJpaDao clinicDao;
	
	@Resource(name = "userDao")
	UserJpaDao userDao;
	
	@Resource(name = "petCategoryDao")
	PetCategoryJpaDao petCategoryDao;
	
	@Resource(name = "petDao")
	PetJpaDao petDao;
	
	@Resource(name = "interrogationDao")
	InterrogationJpaDao interrogationDao;
	
	@Resource(name = "diagnosisDao")
	DiagnosisJpaDao diagnosisDao;
	
	@Resource(name = "dailyOutpatientDao")
	DailyOutpatientJpaDao dailyOutpatientDao;
	
	@Resource(name = "appointmentDao")
	AppointmentJpaDao appointmentDao;
	
	@Test
	public void testGetClinic() throws ParseException {
		logger.debug("testGetClinic...");
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
	public void testGetAdministrator() throws ParseException {
		logger.debug("testGetAdministrator...");
		User user = userDao.get(new Long(1));
		assertNotNull(user);
		assertTrue(user instanceof Administrator);
		assertEquals(1l, user.getId());
		assertEquals("admin1", user.getUsername());
		assertEquals("adminpwd1", user.getPassword());
		assertEquals("admintmppwd1", user.getTempPassword());
		assertEquals("admin1@petclinic.com", user.getEmail());
		assertEquals("adminname1", user.getName());
		assertEquals(Gender.MALE, user.getGender());
		assertEquals(User.Status.ACTIVE, user.getStatus());
		assertEquals(1l, user.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getCreatedTime());
		assertEquals(1l, user.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getLastModifiedTime());
	}
	
	@Test
	public void testGetVeterinarian() throws ParseException {
		logger.debug("testGetVeterinarian...");
		User user = userDao.get(new Long(2));
		assertNotNull(user);
		assertTrue(user instanceof Veterinarian);
		assertEquals(2l, user.getId());
		assertEquals("vet1", user.getUsername());
		assertEquals("vetpwd1", user.getPassword());
		assertEquals("vettmppwd1", user.getTempPassword());
		assertEquals("vet1@petclinic.com", user.getEmail());
		assertEquals("vetname1", user.getName());
		assertEquals(Gender.MALE, user.getGender());
		assertEquals(User.Status.ACTIVE, user.getStatus());
		assertEquals(1l, user.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getCreatedTime());
		assertEquals(1l, user.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getLastModifiedTime());
		Veterinarian vet = (Veterinarian) user;
		assertEquals("Dr.", vet.getTitle());
		assertEquals("intro2", vet.getIntroduction());
		assertEquals("telephone2", vet.getTelephone());
		assertEquals(DateUtils.parseDate("2011-01-01", new String[] { "yyyy-MM-dd" }), vet.getBirthdate());
		assertEquals(DateUtils.parseDate("2011-01-01", new String[] { "yyyy-MM-dd" }), vet.getWorkingdate());
		assertNotNull(vet.getClinic());
		assertEquals(1l, vet.getClinic().getId());
	}
	
	@Test
	public void testGetPetOwner() throws ParseException {
		logger.debug("testGetPetOwner...");
		User user = userDao.get(new Long(3));
		assertNotNull(user);
		assertTrue(user instanceof PetOwner);
		assertEquals(3l, user.getId());
		assertEquals("petowner1", user.getUsername());
		assertEquals("petownerpwd1", user.getPassword());
		assertEquals("petownertmppwd1", user.getTempPassword());
		assertEquals("petowner1@petclinic.com", user.getEmail());
		assertEquals("petownername1", user.getName());
		assertEquals(Gender.FEMALE, user.getGender());
		assertEquals(User.Status.ACTIVE, user.getStatus());
		assertEquals(1l, user.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getCreatedTime());
		assertEquals(1l, user.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), user.getLastModifiedTime());
		PetOwner petOwner = (PetOwner) user;
		assertEquals("310000xxxxxx", petOwner.getIdCard());
		assertEquals(DateUtils.parseDate("2011-01-01", new String[] { "yyyy-MM-dd" }), petOwner.getBirthdate());
		assertEquals("address3", petOwner.getAddress());
		assertEquals("200000", petOwner.getZipcode());
		assertEquals("telephone3", petOwner.getTelephone());
	}
	
	@Test
	public void testGetPetCategory() throws ParseException {
		logger.debug("testGetPetCategory...");
		PetCategory petCategory = petCategoryDao.get(new Long(1));
		assertNotNull(petCategory);
		assertEquals(1l, petCategory.getId());
		assertEquals("dog", petCategory.getName());
		assertEquals("desc1", petCategory.getDescription());
	}
	
	@Test
	public void testGetPet() throws ParseException {
		logger.debug("testGetPet...");
		Pet pet = petDao.get(new Long(1));
		assertNotNull(pet);
		assertEquals(1l, pet.getId());
		assertEquals(Gender.MALE, pet.getGender());
		assertEquals(DateUtils.parseDate("2011-01-01", new String[] { "yyyy-MM-dd" }), pet.getBirthdate());
		assertEquals("intro1", pet.getIntroduction());
		assertNotNull(pet.getOwner());
		assertEquals(3l, pet.getOwner().getId());
		assertNotNull(pet.getCategory());
		assertEquals(1l, pet.getCategory().getId());
		assertEquals(1l, pet.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), pet.getCreatedTime());
		assertEquals(1l, pet.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), pet.getLastModifiedTime());
	}
	
	@Test
	public void testGetInterrogation() throws ParseException {
		logger.debug("testGetInterrogation...");
		Interrogation interrogation = interrogationDao.get(new Long(1));
		assertNotNull(interrogation);
		assertEquals(1l, interrogation.getId());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), interrogation.getStartDate());
		assertEquals("symptom1", interrogation.getSymptom());
		assertEquals("memo1", interrogation.getMemo());
		assertEquals(Interrogation.Status.NEW, interrogation.getStatus());
		assertNotNull(interrogation.getPet());
		assertEquals(1l, interrogation.getPet().getId());
		assertNotNull(interrogation.getPetOwner());
		assertEquals(3l, interrogation.getPetOwner().getId());
		assertEquals(1l, interrogation.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), interrogation.getCreatedTime());
		assertEquals(1l, interrogation.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), interrogation.getLastModifiedTime());
	}
	
	@Test
	public void testGetDiagnosis() throws ParseException {
		logger.debug("testGetDiagnosis...");
		Diagnosis diagnosis = diagnosisDao.get(new Long(1));
		assertNotNull(diagnosis);
		assertEquals(1l, diagnosis.getId());
		assertEquals("diagnosis1", diagnosis.getDiagnosis());
		assertNotNull(diagnosis.getInterrogation());
		assertEquals(1l, diagnosis.getInterrogation().getId());
		assertNotNull(diagnosis.getVeterinarian());
		assertEquals(2l, diagnosis.getVeterinarian().getId());
		assertEquals(1l, diagnosis.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), diagnosis.getCreatedTime());
		assertEquals(1l, diagnosis.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), diagnosis.getLastModifiedTime());
	}
	
	@Test
	public void testGetDailyOutpatient() throws ParseException {
		logger.debug("testGetDailyOutpatient...");
		DailyOutpatient dailyOutpatient = dailyOutpatientDao.get(new Long(1));
		assertNotNull(dailyOutpatient);
		assertEquals(1l, dailyOutpatient.getId());
		assertEquals(DateUtils.parseDate("2011-01-01", new String[] { "yyyy-MM-dd" }), dailyOutpatient.getDay());
		assertEquals(10, dailyOutpatient.getCountLimit());
		assertEquals(1, dailyOutpatient.getCountActual());
		assertNotNull(dailyOutpatient.getVeterinarian());
		assertEquals(2l, dailyOutpatient.getVeterinarian().getId());
		assertEquals(1l, dailyOutpatient.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), dailyOutpatient.getCreatedTime());
		assertEquals(1l, dailyOutpatient.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), dailyOutpatient.getLastModifiedTime());
	}
	
	@Test
	public void testGetAppointment() throws ParseException {
		logger.debug("testGetAppointment...");
		Appointment appointment = appointmentDao.get(new Long(1));
		assertNotNull(appointment);
		assertEquals(1l, appointment.getId());
		assertEquals("serialno1", appointment.getSerialNo());
		assertEquals(Appointment.Status.NEW, appointment.getStatus());
		assertEquals("memo1", appointment.getMemo());
		assertNotNull(appointment.getDailyOutpatient());
		assertEquals(1l, appointment.getDailyOutpatient().getId());
		assertNotNull(appointment.getPetOwner());
		assertEquals(3l, appointment.getPetOwner().getId());
		assertEquals(1l, appointment.getCreatedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), appointment.getCreatedTime());
		assertEquals(1l, appointment.getLastModifiedBy());
		assertEquals(DateUtils.parseDate("2011-01-01 10:00:00", new String[] { "yyyy-MM-dd hh:mm:ss" }), appointment.getLastModifiedTime());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/mapping-data.xml";
	}
	
}
