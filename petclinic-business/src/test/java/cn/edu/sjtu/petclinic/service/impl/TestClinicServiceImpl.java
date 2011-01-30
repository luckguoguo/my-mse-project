package cn.edu.sjtu.petclinic.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cn.edu.sjtu.petclinic.dao.ClinicDao;
import cn.edu.sjtu.petclinic.entity.Clinic;
import cn.edu.sjtu.petclinic.service.exception.DuplicatedClinicNameException;

public class TestClinicServiceImpl {

	ClinicServiceImpl clinicService;
	ClinicDao mockClinicDao;
	
	String password = "123456";
	String md5Password = "e10adc3949ba59abbe56e057f20f883e"; // from 123456
	
	@Before
	public void setUp() {
		clinicService = new ClinicServiceImpl();
		mockClinicDao = createMock(ClinicDao.class);
		clinicService.setClinicDao(mockClinicDao);
	}
	
	@Test(expected = DuplicatedClinicNameException.class)
	public void testRegisterClinic_ExistsClinicName() 
			throws DuplicatedClinicNameException {
		
		Clinic clinic = new Clinic();
		clinic.setName("exists");
		expect(mockClinicDao.findClinicByName("exists")).andReturn(clinic);
		replay(mockClinicDao);
		clinicService.registerClinic(clinic);
		verify(mockClinicDao);
	}
	
	public void testRegisterClinic_Success() 
		throws DuplicatedClinicNameException {
	
		Clinic clinic = new Clinic();
		clinic.setName("a new clinic");
		clinic.setMgrPassword(password);
		expect(mockClinicDao.findClinicByName("a new clinic")).andReturn(null);
		replay(mockClinicDao);
		clinicService.registerClinic(clinic);
		assertEquals(md5Password, clinic.getMgrPassword());
		verify(mockClinicDao);
	}
	
}
