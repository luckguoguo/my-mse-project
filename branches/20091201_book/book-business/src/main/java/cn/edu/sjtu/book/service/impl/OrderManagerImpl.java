package cn.edu.sjtu.book.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.book.dao.BookDao;
import cn.edu.sjtu.book.dao.BookRepositoryDao;
import cn.edu.sjtu.book.dao.OrderDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.DrawOrderItem;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.QuotaOrderItem;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.StockOrderItem;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.service.OrderManager;
import cn.edu.sjtu.book.service.exception.BookNotExistsException;
import cn.edu.sjtu.book.service.exception.BookRepositoryOutOfBoundException;

@Service
public class OrderManagerImpl implements OrderManager {

	private static Logger logger = LoggerFactory.getLogger(OrderManagerImpl.class);

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private BookRepositoryDao bookRepositoryDao;
	
	@Autowired
	private BookDao bookDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	public void setBookRepositoryDao(BookRepositoryDao bookRepositoryDao) {
		this.bookRepositoryDao = bookRepositoryDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public StockOrder findStockOrderById(Long id) {
		logger.debug("call findStockOrderById");
		return orderDao.findStockOrderById(id);
	}

	@Override
	public List<StockOrder> findStockOrders(Store store, Date startDate, Date endDate,
			Status status) {
		logger.debug("call findStockOrders");
		return orderDao.findStockOrders(store, startDate, endDate, status);
	}

	@Override
	public List<StockOrder> findStockOrders(Store store, Book book) {
		logger.debug("call findStockOrders");
		return orderDao.findStockOrders(store, book);
	}

	@Override
	public StockOrder verifyStockOrder(StockOrder stockOrder) {
		logger.debug("call verifyStockOrder");
		StockOrder orderParam = stockOrder;
		stockOrder = orderDao.findStockOrderById(stockOrder.getId());
		stockOrder.setStatus(Status.VERIFY);
		stockOrder.setLastModifyBy(orderParam.getLastModifyBy());
		stockOrder.setLastModifyTime(orderParam.getLastModifyTime());
		orderDao.updateStockOrder(stockOrder);
		for (StockOrderItem item : stockOrder.getItems()) {
			logger.debug("item id: " + item.getId() + ", book id: " + item.getBook().getId());
			BookRepository repository = bookRepositoryDao.findByStoreBook(stockOrder.getStore(), item.getBook());
			logger.debug("" + repository);
			if (repository == null) {
				
				// add a new book repository
				logger.debug("add a new repository");
				repository = new BookRepository();
				repository.setStore(stockOrder.getStore());
				repository.setBook(item.getBook());
				repository.setDate(new Date());
				repository.setNum(item.getNum());
				bookRepositoryDao.insert(repository);
			} else {
				
				// increase the book repository
				logger.debug("update repository");
				repository.setNum(repository.getNum() + item.getNum());
				bookRepositoryDao.update(repository);
			}
		}
		return stockOrder;
	}
	
	@Override
	public DrawOrder findDrawOrderById(Long id) {
		logger.debug("call findDrawOrderById");
		return orderDao.findDrawOrderById(id);
	}

	@Override
	public List<DrawOrder> findDrawOrders(Store store, Date startDate, Date endDate,
			Status status) {
		logger.debug("call findDrawOrders");
		return orderDao.findDrawOrders(store, startDate, endDate, status);
	}

	@Override
	public List<DrawOrder> findDrawOrders(Store store, Book book) {
		logger.debug("call findDrawOrders");
		return orderDao.findDrawOrders(store, book);
	}
	
	@Override
	public DrawOrder addDrawOrder(DrawOrder drawOrder) throws BookRepositoryOutOfBoundException {
		logger.debug("call addDrawOrder");
		drawOrder.setTotalPrice(new BigDecimal(0.00));
		for (DrawOrderItem item : drawOrder.getItems()) {
			BookRepository repository = bookRepositoryDao.findByStoreBook(drawOrder.getStore(), item.getBook());
			if (repository == null || repository.getNum() - item.getNum() < 0) {
				throw new BookRepositoryOutOfBoundException("draw num: " + item.getNum());
			}
			item.setPrice(repository.getBook().getPrice());
			drawOrder.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getNum())).add(drawOrder.getTotalPrice()));
		}
		orderDao.insertDrawOrder(drawOrder);
		for (DrawOrderItem item : drawOrder.getItems()) {
			BookRepository repository = bookRepositoryDao.findByStoreBook(drawOrder.getStore(), item.getBook());
			repository.setNum(repository.getNum() - item.getNum());
			bookRepositoryDao.update(repository);
		}
		return drawOrder;
	}

	@Override
	public QuotaOrder findQuotaOrderById(Long id) {
		logger.debug("call findQuotaOrderById");
		return orderDao.findQuotaOrderById(id);
	}

	@Override
	public List<QuotaOrder> findQuotaOrders(Store store, Date startDate, Date endDate,
			Status status) {
		logger.debug("call findQuotaOrders");
		return orderDao.findQuotaOrders(store, startDate, endDate, status);
	}

	@Override
	public List<QuotaOrder> findQuotaOrders(Store store, Book book) {
		logger.debug("call findQuotaOrders");
		return orderDao.findQuotaOrders(store, book);
	}
	
	@Override
	public QuotaOrder addQuotaOrder(QuotaOrder quotaOrder) throws BookNotExistsException {
		logger.debug("call addQuotaOrder");
		quotaOrder.setTotalPrice(new BigDecimal(0.00));
		for (QuotaOrderItem item : quotaOrder.getItems()) {
			Book book = bookDao.get(item.getBook().getId());
			if (book == null) {
				throw new BookNotExistsException("book id: " + item.getBook().getId());
			}
			item.setPrice(book.getPrice());
			quotaOrder.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getNum())).add(quotaOrder.getTotalPrice()));
		}
		orderDao.insertQuotaOrder(quotaOrder);
		return null;
	}
	
}
