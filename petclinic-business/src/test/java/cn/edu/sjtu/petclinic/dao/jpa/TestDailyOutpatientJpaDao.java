package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.DailyOutpatientQuery;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

public class TestDailyOutpatientJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "dailyOutpatientDao")
	DailyOutpatientJpaDao dailyOutpatientDao;
	
	@Test
	public void testFindByVeterinarianAndDay() throws ParseException {
		logger.debug("testFindByVeterinarianAndDay...");
		assertNotNull(dailyOutpatientDao.findByVeterinarianAndDay(2l, DateUtils.parseDefaultFormatDate("2011-01-01")));
		assertNull(dailyOutpatientDao.findByVeterinarianAndDay(2l, DateUtils.parseDefaultFormatDate("2001-01-01")));
	}
	
	@Test
	public void testFindDailyOutpatients() throws ParseException {
		logger.debug("testFindDailyOutpatients...");
		Page<DailyOutpatient> page = new Page<DailyOutpatient>(1).pageNo(1);
		DailyOutpatientQuery query = new DailyOutpatientQuery();
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setVeterinarianId(2l);
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setVeterinarianId(100l);
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setClinicName("clinicName1");
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setClinicName("clinicName0");
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setClinicAddress("address1");
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setClinicAddress("address0");
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setSpecialityPetCategoryId(1l);
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setSpecialityPetCategoryId(100l);
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<DailyOutpatient>(1).pageNo(1);
		query = new DailyOutpatientQuery();
		query.setDayFrom(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setDayTo(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setPage(page);
		page = dailyOutpatientDao.findPagedDailyOutpatients(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/appointment-data.xml";
	}
	
}
