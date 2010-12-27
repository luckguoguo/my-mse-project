package cn.edu.sjtu.book.dao.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.book.dao.SaleDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookSaleDaily;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.report.data.DailySale;
import cn.edu.sjtu.book.web.utils.DateUtils;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;

@Repository("saleDao")
public class SaleJpaDao extends AbstractJpaDaoSupport<BookSaleDaily, Serializable> implements SaleDao {

	@Override
	public List<BookSaleDaily> findByStoreBook(Store store, Book book) {
		return find("from BookSaleDaily where store = ? and book = ? order by saleDate desc", store, book);
	}

	@Override
	public List<BookSaleDaily> findByStoreDate(Store store, Date date) {
		return find("from BookSaleDaily where store = ? and saleDate = ? order by book.id", store, date);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DailySale> findDailySalesByStoreDate(Store store,
			Date startDate, Date endDate) {
		Query query = createQuery("select saleDate, sum(saleNum) as num, sum(saleTotal) as total " +
				"from BookSaleDaily where store = ? and saleDate >= ? and saleDate < ? " +
				"group by saleDate order by saleDate desc", 
				store, startDate, DateUtils.addDays(endDate, 1));
		
		List<Object[]> rows = query.getResultList();
		List<DailySale> results = new ArrayList<DailySale>();
		for (Object[] row : rows) {
			DailySale dailySale = new DailySale((Date) row[0], new Integer("" + row[1]), (BigDecimal) row[2]);
			results.add(dailySale);
		}
		
		return results;
	}

}
