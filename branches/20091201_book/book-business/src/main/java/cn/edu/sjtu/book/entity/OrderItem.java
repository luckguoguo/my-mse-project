package cn.edu.sjtu.book.entity;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import cn.edu.sjtu.common.orm.jpa.IdEntity;

@MappedSuperclass
public class OrderItem extends IdEntity {

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	private int num;
	
	private BigDecimal price;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
