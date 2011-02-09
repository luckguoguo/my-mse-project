package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.AppointmentQuery;
import cn.edu.sjtu.petclinic.entity.Appointment;

public class TestAppointmentJpaDao extends SpringTxDaoTestCase {
	
	@Resource(name = "appointmentDao")
	AppointmentJpaDao appointmentDao;

	@Test
	public void testFindAppointments() throws ParseException {
		logger.debug("testFindAppointments...");
		Page<Appointment> page = new Page<Appointment>(1).pageNo(1);
		AppointmentQuery query = new AppointmentQuery();
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setPetOwnerId(3l);
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setPetOwnerId(100l);
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setVeterinarianId(2l);
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setVeterinarianId(100l);
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Appointment>(1).pageNo(1);
		query = new AppointmentQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setPage(page);
		page = appointmentDao.findAppointments(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/appointment-data.xml";
	}
	
}
