package cn.edu.sjtu.book.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.book.dao.BookRepositoryDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.book.service.BookRepositoryManager;

@Service
public class BookRepositoryManagerImpl implements BookRepositoryManager {

	private static Logger logger = LoggerFactory.getLogger(BookRepositoryManagerImpl.class);

	@Autowired
	private BookRepositoryDao bookRepositoryDao;

	public void setBookRepositoryDao(BookRepositoryDao bookRepositoryDao) {
		this.bookRepositoryDao = bookRepositoryDao;
	}

	@Override
	public BookRepository findBookRepository(Store store, Book book) {
		logger.debug("call findBookRepository");
		return bookRepositoryDao.findByStoreBook(store, book);
	}

}
