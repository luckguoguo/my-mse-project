package cn.edu.sjtu.book.service;

import java.util.Date;
import java.util.List;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.service.exception.BookNotExistsException;
import cn.edu.sjtu.book.service.exception.BookRepositoryOutOfBoundException;

public interface OrderManager {

	StockOrder findStockOrderById(Long id);
	
	DrawOrder findDrawOrderById(Long id);
	
	QuotaOrder findQuotaOrderById(Long id);
	
	List<StockOrder> findStockOrders(Store store, Date startDate, Date endDate, Status status);
	
	List<DrawOrder> findDrawOrders(Store store, Date startDate, Date endDate, Status status);
	
	List<QuotaOrder> findQuotaOrders(Store store, Date startDate, Date endDate, Status status);
	
	List<StockOrder> findStockOrders(Store store, Book book);
	
	List<DrawOrder> findDrawOrders(Store store, Book book);
	
	List<QuotaOrder> findQuotaOrders(Store store, Book book);
	
	StockOrder verifyStockOrder(StockOrder stockOrder);
	
	DrawOrder addDrawOrder(DrawOrder drawOrder) throws BookRepositoryOutOfBoundException;
	
	QuotaOrder addQuotaOrder(QuotaOrder quotaOrder) throws BookNotExistsException;
	
}
