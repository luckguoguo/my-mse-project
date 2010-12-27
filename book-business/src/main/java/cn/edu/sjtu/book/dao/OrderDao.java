package cn.edu.sjtu.book.dao;

import java.util.Date;
import java.util.List;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;

public interface OrderDao {

	StockOrder findStockOrderById(Long id);
	List<StockOrder> findStockOrders(Store store, Date startDate, Date endDate, Status status);
	List<StockOrder> findStockOrders(Store store, Book book);
	void updateStockOrder(StockOrder stockOrder);
	
	DrawOrder findDrawOrderById(Long id);
	List<DrawOrder> findDrawOrders(Store store, Date startDate, Date endDate, Status status);
	List<DrawOrder> findDrawOrders(Store store, Book book);
	void insertDrawOrder(DrawOrder drawOrder);
	
	QuotaOrder findQuotaOrderById(Long id);
	List<QuotaOrder> findQuotaOrders(Store store, Date startDate, Date endDate, Status status);
	List<QuotaOrder> findQuotaOrders(Store store, Book book);
	void insertQuotaOrder(QuotaOrder quotaOrder);
	
}
