package cn.edu.sjtu.book.dao.jpa;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.DrawOrderItem;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.QuotaOrderItem;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.entity.Order.SyncFlag;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.common.test.SpringTxDaoTestCase;

public class TestOrderJpaDao extends SpringTxDaoTestCase {

	@Resource(name = "orderDao")
	OrderJpaDao orderDao;
	
	@Test
	public void testFindStockOrderById() {
		StockOrder stockOrder = orderDao.findStockOrderById(1l);
		assertNotNull(stockOrder);
		assertEquals(2, stockOrder.getItems().size());
		
		stockOrder = orderDao.findStockOrderById(2l);
		assertNotNull(stockOrder);
		assertEquals(1, stockOrder.getItems().size());
	}
	
	@Test
	public void testFindStockOrdersByStoreDateStatus() throws ParseException {
		Store store = new Store();
		store.setId(1l);
		assertEquals(1, orderDao.findStockOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				Status.PENDING).size());
		assertEquals(2, orderDao.findStockOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-6"), 
				Status.PENDING).size());
		assertEquals(0, orderDao.findStockOrders(store, 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				Status.PENDING).size());
	}
	
	@Test
	public void testFindStockOrdersByStoreBook() {
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		assertEquals(2, orderDao.findStockOrders(store, book1).size());
		assertEquals(1, orderDao.findStockOrders(store, book2).size());
	}
	
	@Test
	public void testUpdateStockOrder() {
		StockOrder stockOrder = orderDao.findStockOrderById(1l);
		stockOrder.setStatus(Status.VERIFY);
		orderDao.updateStockOrder(stockOrder);
		assertEquals(Status.VERIFY, orderDao.findStockOrderById(1l).getStatus());
		assertEquals(10, orderDao.findStockOrderById(1l).getNum());
	}
	
	@Test
	public void testFindDrawOrderById() {
		DrawOrder drawOrder = orderDao.findDrawOrderById(1l);
		assertNotNull(drawOrder);
		assertEquals(1, drawOrder.getItems().size());
		
		drawOrder = orderDao.findDrawOrderById(2l);
		assertNotNull(drawOrder);
		assertEquals(1, drawOrder.getItems().size());
	}
	
	@Test
	public void testFindDrawOrdersByStoreDateStatus() throws ParseException {
		Store store = new Store();
		store.setId(1l);
		assertEquals(1, orderDao.findDrawOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				Status.PENDING).size());
		assertEquals(2, orderDao.findDrawOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-6"), 
				Status.PENDING).size());
		assertEquals(0, orderDao.findDrawOrders(store, 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				Status.PENDING).size());
	}
	
	@Test
	public void testFindDrawOrdersByStoreBook() {
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		assertEquals(2, orderDao.findDrawOrders(store, book1).size());
		assertEquals(0, orderDao.findDrawOrders(store, book2).size());
	}
	
	@Test
	public void testInsertDrawOrder() {
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		
		DrawOrder drawOrder = new DrawOrder();
		drawOrder.setOrderNo("2000020001");
		drawOrder.setStore(store);
		drawOrder.setStatus(Status.REVIEW);
		drawOrder.setSyncFlag(SyncFlag.WAITING);
		drawOrder.setNum(10);
		drawOrder.setTotalPrice(new BigDecimal(200.00));
		drawOrder.setOrderDate(new Date());
		drawOrder.setMemo("");
		
		DrawOrderItem item1 = new DrawOrderItem();
		item1.setOrder(drawOrder);
		item1.setBook(book1);
		item1.setNum(5);
		item1.setPrice(new BigDecimal(100.00));
		
		DrawOrderItem item2 = new DrawOrderItem();
		item2.setOrder(drawOrder);
		item2.setBook(book2);
		item2.setNum(5);
		item2.setPrice(new BigDecimal(100.00));
		
		drawOrder.getItems().add(item1);
		drawOrder.getItems().add(item2);
		
		orderDao.insertDrawOrder(drawOrder);
		assertNotNull(drawOrder.getId());
		assertNotNull(item1.getId());
		assertNotNull(item2.getId());
	}
	
	@Test
	public void testFindQuotaOrderById() {
		QuotaOrder quotaOrder = orderDao.findQuotaOrderById(1l);
		assertNotNull(quotaOrder);
		assertEquals(2, quotaOrder.getItems().size());
		
		quotaOrder = orderDao.findQuotaOrderById(2l);
		assertNotNull(quotaOrder);
		assertEquals(1, quotaOrder.getItems().size());
	}
	
	@Test
	public void testFindQuotaOrdersByStoreDateStatus() throws ParseException {
		Store store = new Store();
		store.setId(1l);
		assertEquals(1, orderDao.findQuotaOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				Status.PENDING).size());
		assertEquals(2, orderDao.findQuotaOrders(store, 
				DateUtils.parseDefaultFormatDate("2010-1-5"), 
				DateUtils.parseDefaultFormatDate("2010-1-6"), 
				Status.PENDING).size());
		assertEquals(0, orderDao.findQuotaOrders(store, 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				DateUtils.parseDefaultFormatDate("2009-1-1"), 
				Status.PENDING).size());
	}
	
	@Test
	public void testFindQuotaOrdersByStoreBook() {
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		assertEquals(2, orderDao.findQuotaOrders(store, book1).size());
		assertEquals(1, orderDao.findQuotaOrders(store, book2).size());
	}
	
	@Test
	public void testInsertQuotaOrder() {
		Store store = new Store();
		store.setId(1l);
		Book book1 = new Book();
		book1.setId(1l);
		Book book2 = new Book();
		book2.setId(2l);
		
		QuotaOrder quotaOrder = new QuotaOrder();
		quotaOrder.setOrderNo("3000020001");
		quotaOrder.setStore(store);
		quotaOrder.setStatus(Status.REVIEW);
		quotaOrder.setSyncFlag(SyncFlag.WAITING);
		quotaOrder.setNum(10);
		quotaOrder.setTotalPrice(new BigDecimal(200.00));
		quotaOrder.setOrderDate(new Date());
		quotaOrder.setMemo("");
		
		QuotaOrderItem item1 = new QuotaOrderItem();
		item1.setOrder(quotaOrder);
		item1.setBook(book1);
		item1.setNum(5);
		item1.setPrice(new BigDecimal(100.00));
		
		QuotaOrderItem item2 = new QuotaOrderItem();
		item2.setOrder(quotaOrder);
		item2.setBook(book2);
		item2.setNum(5);
		item2.setPrice(new BigDecimal(100.00));
		
		quotaOrder.getItems().add(item1);
		quotaOrder.getItems().add(item2);
		
		orderDao.insertQuotaOrder(quotaOrder);
		assertNotNull(quotaOrder.getId());
		assertNotNull(item1.getId());
		assertNotNull(item2.getId());
	}
	
	@Override
	protected String getTestDataFile() {
		return "/fixtures/order-data.xml";
	}

}
