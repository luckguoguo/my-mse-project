package cn.edu.sjtu.book.dao.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.sjtu.book.dao.BookDao;
import cn.edu.sjtu.book.entity.Book;
import cn.edu.sjtu.common.orm.jpa.AbstractJpaDaoSupport;

@Repository("bookDao")
public class BookJpaDao extends AbstractJpaDaoSupport<Book, Serializable> implements BookDao {

	public Book get(Long id) {
		return findUnique("from Book where id = ?", id);
	}
	
	@Override
	public List<Book> findByName(String name) {
		return find("from Book where name like ? order by id", "%" + name + "%");
	}

}
