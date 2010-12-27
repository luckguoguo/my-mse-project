package cn.edu.sjtu.book.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.book.dao.SaleDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookSaleDaily;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.report.data.DailySale;
import cn.edu.sjtu.book.service.SaleManager;

@Service
public class SaleManagerImpl implements SaleManager {

	private static Logger logger = LoggerFactory.getLogger(SaleManagerImpl.class);
	
	@Autowired
	private SaleDao saleDao;
	
	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	@Override
	public List<BookSaleDaily> findStoreSalesDailys(Store store, Date saleDate) {
		logger.debug("call findStoreSalesDailys");
		return saleDao.findByStoreDate(store, saleDate);
	}

	@Override
	public List<BookSaleDaily> findStoreSalesDailys(Store store, Book book) {
		logger.debug("call findStoreSalesDailys");
		return saleDao.findByStoreBook(store, book);
	}

	@Override
	public List<DailySale> findDailySalesByStoreDate(Store store,
			Date startDate, Date endDate) {
		logger.debug("call findDailySalesByStoreDate");
		return saleDao.findDailySalesByStoreDate(store, startDate, endDate);
	}

}
