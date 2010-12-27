package cn.edu.sjtu.book.service;

import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.book.entity.BookRepository;
import cn.edu.sjtu.book.entity.Store;

public interface BookRepositoryManager {

	BookRepository findBookRepository(Store store, Book book);
	
}
