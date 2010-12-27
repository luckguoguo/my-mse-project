package cn.edu.sjtu.book.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.BookSaleDaily;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.User;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestJpaMapping extends SpringTxDaoTestCase {

	EntityManager entityManager;
	
	@PersistenceContext(unitName = "BookJPAPU")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Test
	public void testLoadEntityManager() {
		assertNotNull(entityManager);
	}
	
	@Test
	public void testColumnMapping() {
		assertNotNull(entityManager.find(Store.class, 1l));
		assertNotNull(entityManager.find(User.class, 1l));
		assertNotNull(entityManager.find(Book.class, 1l));
		assertNotNull(entityManager.find(BookRepository.class, 1l));
		assertNotNull(entityManager.createQuery(
				"select br from BookRepository br where br.store.id=1 and br.book.id=1").getSingleResult());
		assertNotNull(entityManager.find(BookSaleDaily.class, 1l));
		assertNotNull(entityManager.createQuery(
				"select bsd from BookSaleDaily bsd where bsd.store.id=1 and bsd.book.id=1 and bsd.saleDate='2010-01-05'").getSingleResult());
		assertNotNull(entityManager.find(StockOrder.class, 1l));
		assertEquals(2, entityManager.find(StockOrder.class, 1l).getItems().size());
		assertNotNull(entityManager.find(DrawOrder.class, 1l));
		assertEquals(1, entityManager.find(DrawOrder.class, 1l).getItems().size());
		assertNotNull(entityManager.find(QuotaOrder.class, 1l));
		assertEquals(1, entityManager.find(QuotaOrder.class, 1l).getItems().size());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/test-data.xml";
	}

}
