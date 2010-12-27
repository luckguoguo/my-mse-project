package cn.edu.sjtu.book.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.sjtu.common.orm.jpa.IdEntity;

@Entity
@Table(name = "t_store_repository")
public class BookRepository extends IdEntity {

	@ManyToOne
	@JoinColumn(name = "store_id", updatable = false)
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "book_id", updatable = false)
	private Book book;
	
	@Column(updatable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private int num;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
