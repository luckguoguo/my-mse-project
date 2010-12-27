package cn.edu.sjtu.book.dao.jpa;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestSaleJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "saleDao")
	SaleJpaDao saleDao;
	
	@Test
	public void testFindByStoreBook_Success() {
		Store store1 = new Store();
		store1.setId(1l);
		Store store2 = new Store();
		store2.setId(2l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		
		assertEquals(3, saleDao.findByStoreBook(store1, book1).size());
		assertEquals(3, saleDao.findByStoreBook(store1, book2).size());
		assertEquals(3, saleDao.findByStoreBook(store2, book1).size());
		assertEquals(3, saleDao.findByStoreBook(store2, book2).size());
	}
	
	@Test
	public void testFindByStoreBook_SaleNotExists() {
		Store store = new Store();
		store.setId(1l);
		Book book = new Book();
		book.setId(3l);
		
		assertEquals(0, saleDao.findByStoreBook(store, book).size());
	}
	
	@Test
	public void testFindByStoreDate_Success() throws ParseException {
		Store store1 = new Store();
		store1.setId(1l);
		Store store2 = new Store();
		store2.setId(2l);
		
		assertEquals(2, saleDao.findByStoreDate(store1, DateUtils.parseDefaultFormatDate("2010-1-5")).size());
		assertEquals(2, saleDao.findByStoreDate(store1, DateUtils.parseDefaultFormatDate("2010-1-6")).size());
		assertEquals(2, saleDao.findByStoreDate(store1, DateUtils.parseDefaultFormatDate("2010-1-7")).size());
		assertEquals(2, saleDao.findByStoreDate(store2, DateUtils.parseDefaultFormatDate("2010-1-5")).size());
		assertEquals(2, saleDao.findByStoreDate(store2, DateUtils.parseDefaultFormatDate("2010-1-6")).size());
		assertEquals(2, saleDao.findByStoreDate(store2, DateUtils.parseDefaultFormatDate("2010-1-7")).size());
	}
	
	@Test
	public void testFindByStoreDate_SaleNotexists() throws ParseException {
		Store store1 = new Store();
		store1.setId(1l);
		Store store2 = new Store();
		store2.setId(2l);
		
		assertEquals(0, saleDao.findByStoreDate(store1, DateUtils.parseDefaultFormatDate("2000-1-5")).size());
	}
	
	@Test
	public void testFindDailySalesByStoreDate() throws ParseException {
		Store store1 = new Store();
		store1.setId(1l);
		Store store2 = new Store();
		store2.setId(2l);
		
		assertEquals(1, saleDao.findDailySalesByStoreDate(store1, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-5")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store1, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-7")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store1, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-7")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store1, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-8")).size());
		assertEquals(0, saleDao.findDailySalesByStoreDate(store1, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-1")).size());
		
		assertEquals(1, saleDao.findDailySalesByStoreDate(store2, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-5")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store2, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-7")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store2, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-7")).size());
		assertEquals(3, saleDao.findDailySalesByStoreDate(store2, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-8")).size());
		assertEquals(0, saleDao.findDailySalesByStoreDate(store2, 
				DateUtils.parseDefaultFormatDate("2010-1-1"), 
				DateUtils.parseDefaultFormatDate("2010-1-1")).size());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/sale-data.xml";
	}

}
