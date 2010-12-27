package cn.edu.sjtu.book.dao.jpa;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestBookJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "bookDao")
	BookJpaDao bookDao;
	
	@Test
	public void testFindByName() {
		logger.debug("testFindBookByName_Success...");
		assertEquals(5, bookDao.findByName("book").size());
		assertEquals(1, bookDao.findByName("abc").size());
		assertEquals(0, bookDao.findByName("notexists").size());
		assertEquals(1, bookDao.findByName("java").size());
		List<Book> books = bookDao.findByName("编程思想");
		assertEquals(1, books.size());
		assertEquals("Java编程思想", books.get(0).getName());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/book-data.xml";
	}

}
