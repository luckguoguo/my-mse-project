package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.InterrogationQuery;
import cn.edu.sjtu.petclinic.entity.Interrogation;

public class TestInterrogationJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "interrogationDao")
	InterrogationJpaDao interrogationDao;
	
	@Test
	public void testFindInterrogations() throws ParseException {
		logger.debug("testFindInterrogations...");
		Page<Interrogation> page = new Page<Interrogation>(1).pageNo(1);
		InterrogationQuery query = new InterrogationQuery();
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setPetId(1l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setPetId(100l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setPetOwnerId(3l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setPetOwnerId(100l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setVeterinarianId(2l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setVeterinarianId(100l);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setName("name1");
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setName("name0");
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStatus(Interrogation.Status.NEW);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Interrogation>(1).pageNo(1);
		query = new InterrogationQuery();
		query.setStatus(Interrogation.Status.DIAGNOSED);
		query.setPage(page);
		page = interrogationDao.findInterrogations(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/interrogation-data.xml";
	}
	
}
