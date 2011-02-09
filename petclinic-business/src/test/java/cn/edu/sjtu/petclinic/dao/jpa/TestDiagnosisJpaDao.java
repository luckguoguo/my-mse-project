package cn.edu.sjtu.petclinic.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;
import cn.edu.sjtu.common.utils.DateUtils;
import cn.edu.sjtu.petclinic.dto.DiagnosisQuery;
import cn.edu.sjtu.petclinic.entity.Diagnosis;

public class TestDiagnosisJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "diagnosisDao")
	DiagnosisJpaDao diagnosisDao;
	
	@Test
	public void testFindDiagnosises() throws ParseException {
		logger.debug("testFindDiagnosises...");
		Page<Diagnosis> page = new Page<Diagnosis>(1).pageNo(1);
		DiagnosisQuery query = new DiagnosisQuery();
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setPetId(1l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setPetId(100l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setPetOwnerId(3l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setPetOwnerId(100l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setVeterinarianId(2l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setVeterinarianId(100l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setInterrogationId(1l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setInterrogationId(100l);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setName("name1");
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setName("name0");
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-01"));
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStartDateFrom(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setStartDateTo(DateUtils.parseDefaultFormatDate("2011-01-02"));
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStatus(Diagnosis.Status.NEW);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(1l, page.getTotalCount());
		assertEquals(1l, page.getTotalPages());
		
		page = new Page<Diagnosis>(1).pageNo(1);
		query = new DiagnosisQuery();
		query.setStatus(Diagnosis.Status.STARED);
		query.setPage(page);
		page = diagnosisDao.findDiagnosises(query);
		assertEquals(0l, page.getTotalCount());
		assertEquals(0l, page.getTotalPages());
	}

	@Override
	protected String getTestDataFile() {
		return "/fixtures/interrogation-data.xml";
	}
	
}
