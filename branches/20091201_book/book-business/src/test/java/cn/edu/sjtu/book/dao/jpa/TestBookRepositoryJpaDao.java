package cn.edu.sjtu.book.dao.jpa;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestBookRepositoryJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "bookRepositoryDao")
	BookRepositoryJpaDao bookRepositoryDao;
	
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
		
		assertEquals(20, bookRepositoryDao.findByStoreBook(store1, book1).getNum());
		assertEquals(200, bookRepositoryDao.findByStoreBook(store1, book2).getNum());
		assertEquals(50, bookRepositoryDao.findByStoreBook(store2, book1).getNum());
		assertEquals(500, bookRepositoryDao.findByStoreBook(store2, book2).getNum());
	}
	
	@Test
	public void testFindByStoreBook_RepositoryNotExists() {
		Store store1 = new Store();
		store1.setId(1l);
		Book book3 = new Book();
		book3.setId(3l);
		assertNull(bookRepositoryDao.findByStoreBook(store1, book3));
	}
	
	@Test
	public void testInsert() {
		Store store = new Store();
		store.setId(1l);
		Book book = new Book();
		book.setId(3l);
		BookRepository bookRepository = new BookRepository();
		bookRepository.setStore(store);
		bookRepository.setBook(book);
		bookRepository.setDate(new Date());
		bookRepository.setNum(10);
		assertNull(bookRepository.getId());
		bookRepositoryDao.insert(bookRepository);
		assertNotNull(bookRepository.getId());
	}
	
	@Test
	public void testUpdate() {
		BookRepository bookRepository = bookRepositoryDao.get(1l);
		bookRepository.setId(1l);
		bookRepository.setNum(100);
		bookRepositoryDao.update(bookRepository);
		assertEquals(100, bookRepositoryDao.get(1l).getNum());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/bookrepository-data.xml";
	}

}
