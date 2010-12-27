package cn.edu.sjtu.book.service;

import java.util.Date;
import java.util.List;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookSaleDaily;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.report.data.DailySale;

public interface SaleManager {

	List<BookSaleDaily> findStoreSalesDailys(Store store, Date saleDate);
	
	List<BookSaleDaily> findStoreSalesDailys(Store store, Book book);
	
	List<DailySale> findDailySalesByStoreDate(Store store, Date startDate, Date endDate);
	
}
