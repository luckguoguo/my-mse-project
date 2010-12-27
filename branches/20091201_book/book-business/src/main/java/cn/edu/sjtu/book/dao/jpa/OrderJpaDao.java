package cn.edu.sjtu.book.dao.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.book.dao.OrderDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.DrawOrder;
import cn.edu.sjtu.book.entity.DrawOrderItem;
import cn.edu.sjtu.book.entity.Order;
import cn.edu.sjtu.book.entity.QuotaOrder;
import cn.edu.sjtu.book.entity.QuotaOrderItem;
import cn.edu.sjtu.book.entity.StockOrder;
import cn.edu.sjtu.book.entity.StockOrderItem;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.entity.Order.Status;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;

@Repository("orderDao")
public class OrderJpaDao extends AbstractJpaDaoSupport<Order, Serializable> implements OrderDao {

	@Override
	public StockOrder findStockOrderById(Long id) {
		return entityManager.find(StockOrder.class, id);
	}
	
	@Override
	public List<StockOrder> findStockOrders(Store store, Date startDate, 
			Date endDate, Status status) {
		return find("from StockOrder where store = ? and orderDate >= ? and orderDate < ? and status = ? order by orderDate desc", 
				store, startDate, DateUtils.addDays(endDate, 1), status);
	}

	@Override
	public List<StockOrder> findStockOrders(Store store, Book book) {
		List<Object[]> list = find("select o, i from StockOrder o join o.items i where o.store = ? and i.book = ? order by o.orderDate desc", store, book);
		List<StockOrder> result = new ArrayList<StockOrder>();
		for (Object[] o : list) {
			((StockOrder) o[0]).getItems().add((StockOrderItem) o[1]);
			result.add((StockOrder) o[0]);
		}
		return result;
	}

	@Override
	public void updateStockOrder(StockOrder stockOrder) {
		if (entityManager.contains(stockOrder)) {
			logger.debug("updating stock order...");
			entityManager.merge(stockOrder);
			entityManager.flush();
		}
	}
	
	@Override
	public DrawOrder findDrawOrderById(Long id) {
		return entityManager.find(DrawOrder.class, id);
	}
	
	@Override
	public List<DrawOrder> findDrawOrders(Store store, Date startDate, 
			Date endDate, Status status) {
		return find("from DrawOrder where store = ? and orderDate >= ? and orderDate < ? and status = ? order by orderDate desc", 
				store, startDate, DateUtils.addDays(endDate, 1), status);
	}

	@Override
	public List<DrawOrder> findDrawOrders(Store store, Book book) {
		List<Object[]> list = find("select o, i from DrawOrder o join o.items i where o.store = ? and i.book = ? order by o.orderDate desc", store, book);
		List<DrawOrder> result = new ArrayList<DrawOrder>();
		for (Object[] o : list) {
			((DrawOrder) o[0]).getItems().add((DrawOrderItem) o[1]);
			result.add((DrawOrder) o[0]);
		}
		return result;
	}
	
	@Override
	public void insertDrawOrder(DrawOrder drawOrder) {
		drawOrder.setOrderNo("2000020000");
		entityManager.persist(drawOrder);
		drawOrder.setOrderNo(2000020000l + drawOrder.getId() + "");
		entityManager.flush();
	}

	@Override
	public QuotaOrder findQuotaOrderById(Long id) {
		return entityManager.find(QuotaOrder.class, id);
	}
	
	@Override
	public List<QuotaOrder> findQuotaOrders(Store store, Date startDate, 
			Date endDate, Status status) {
		return find("from QuotaOrder where store = ? and orderDate >= ? and orderDate < ? and status = ? order by orderDate desc", 
				store, startDate, DateUtils.addDays(endDate, 1), status);
	}

	@Override
	public List<QuotaOrder> findQuotaOrders(Store store, Book book) {
		List<Object[]> list = find("select o, i from QuotaOrder o join o.items i where o.store = ? and i.book = ? order by o.orderDate desc", store, book);
		List<QuotaOrder> result = new ArrayList<QuotaOrder>();
		for (Object[] o : list) {
			((QuotaOrder) o[0]).getItems().add((QuotaOrderItem) o[1]);
			result.add((QuotaOrder) o[0]);
		}
		return result;
	}

	@Override
	public void insertQuotaOrder(QuotaOrder quotaOrder) {
		quotaOrder.setOrderNo("3000020000");
		entityManager.persist(quotaOrder);
		quotaOrder.setOrderNo(3000020000l + quotaOrder.getId() + "");
		entityManager.flush();
	}

}
