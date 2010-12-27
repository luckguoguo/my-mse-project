package cn.edu.sjtu.book.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sjtu.book.dao.BookDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.service.BookManager;

@Service
public class BookManagerImpl implements BookManager {

	private static Logger logger = LoggerFactory.getLogger(BookManagerImpl.class);

	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findBooksByName(String name) {
		logger.debug("call findBookByName");
		return bookDao.findByName(name);
	}

}
