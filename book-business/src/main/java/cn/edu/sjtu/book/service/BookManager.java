package cn.edu.sjtu.book.service;

import java.util.List;

import cn.edu.sjtu.book.entity.Book;

public interface BookManager {

	List<Book> findBooksByName(String name);
	
}
