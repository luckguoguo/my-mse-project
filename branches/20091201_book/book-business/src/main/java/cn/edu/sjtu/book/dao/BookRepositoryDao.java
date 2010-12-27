package cn.edu.sjtu.book.dao;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.Store;

public interface BookRepositoryDao {

	BookRepository findByStoreBook(Store store, Book book);
	
	void insert(BookRepository bookRepository);
	
	void update(BookRepository bookRepository);
	
}
