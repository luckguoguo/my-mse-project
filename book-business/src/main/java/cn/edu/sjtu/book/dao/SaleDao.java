package cn.edu.sjtu.book.dao;

import java.util.Date;
import java.util.List;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookSaleDaily;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.report.data.DailySale;

public interface SaleDao {

	List<BookSaleDaily> findByStoreDate(Store store, Date date);
	
	List<BookSaleDaily> findByStoreBook(Store store, Book book);
	
	List<DailySale> findDailySalesByStoreDate(Store store, Date startDate, Date endDate);
	
}
