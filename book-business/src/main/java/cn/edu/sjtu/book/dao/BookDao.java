package cn.edu.sjtu.book.dao;

import java.util.List;

import cn.edu.sjtu.book.entity.Book;

public interface BookDao {

	Book get(Long id);
	
	List<Book> findByName(String name);
	
}
