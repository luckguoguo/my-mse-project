package cn.edu.sjtu.book.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.edu.sjtu.book.dao.BookRepositoryDao;
import cn.edu.sjtu.book.dao.OrderDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.StockOrderItem;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;

public class TestOrderManagerImpl {

	OrderManagerImpl orderManager;
	
	OrderDao mockOrderDao;
	
	BookRepositoryDao mockBookRepositoryDao;
	
	@Before
	public void setup() {
		orderManager = new OrderManagerImpl();
		mockOrderDao = createMock(OrderDao.class);
		orderManager.setOrderDao(mockOrderDao);
		mockBookRepositoryDao = createMock(BookRepositoryDao.class);
		orderManager.setBookRepositoryDao(mockBookRepositoryDao);
	}
	
	@Test
	public void testVerifyStockOrder() {
		StockOrder stockOrderParam = new StockOrder();
		stockOrderParam.setId(1l);
		stockOrderParam.setLastModifyBy("jim");
		stockOrderParam.setLastModifyTime(new Date());
		
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		StockOrder stockOrder = new StockOrder();
		stockOrder.setId(1l);
		stockOrder.setStore(store);
		StockOrderItem item1 = new StockOrderItem();
		item1.setBook(book1);
		item1.setNum(10);
		item1.setOrder(stockOrder);
		StockOrderItem item2 = new StockOrderItem();
		item2.setBook(book2);
		item2.setNum(10);
		item2.setOrder(stockOrder);
		stockOrder.getItems().add(item1);
		stockOrder.getItems().add(item2);
		BookRepository bookRepository1 = new BookRepository();
		bookRepository1.setStore(store);
		bookRepository1.setBook(book1);
		bookRepository1.setNum(100);
		
		assertEquals(Status.PENDING, stockOrder.getStatus());
		expect(mockOrderDao.findStockOrderById(stockOrder.getId())).andReturn(stockOrder);
		mockOrderDao.updateStockOrder(stockOrder);
		expect(mockBookRepositoryDao.findByStoreBook(store, book1)).andReturn(bookRepository1);
		mockBookRepositoryDao.update(bookRepository1);
		expect(mockBookRepositoryDao.findByStoreBook(store, book2)).andReturn(null);
		mockBookRepositoryDao.insert(isA(BookRepository.class));
		
		replay(mockOrderDao, mockBookRepositoryDao);
		orderManager.verifyStockOrder(stockOrderParam);
		assertEquals(Status.VERIFY, stockOrder.getStatus());
		assertEquals("jim", stockOrder.getLastModifyBy());
		assertNotNull(stockOrder.getLastModifyTime());
		assertEquals(110, bookRepository1.getNum());
		verify(mockOrderDao, mockBookRepositoryDao);
	}
	
}
