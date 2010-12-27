package cn.edu.sjtu.book.dao.jpa;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.book.dao.BookRepositoryDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.Store;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;

@Repository("bookRepositoryDao")
public class BookRepositoryJpaDao extends AbstractJpaDaoSupport<BookRepository, Serializable> implements BookRepositoryDao {

	@Override
	public BookRepository findByStoreBook(Store store, Book book) {
		return findUnique("from BookRepository where store = ? and book = ?", store, book);
	}

	@Override
	public void insert(BookRepository bookRepository) {
		entityManager.persist(bookRepository);
	}
	
	@Override
	public void update(BookRepository bookRepository) {
		if (entityManager.contains(bookRepository))
			entityManager.merge(bookRepository);
	}

}
