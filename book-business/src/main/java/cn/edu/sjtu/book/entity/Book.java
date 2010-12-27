package cn.edu.sjtu.book.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.sjtu.common.orm.jpa.IdEntity;

@Entity
@Table(name = "t_book")
public class Book extends IdEntity {

	@Column(name = "isbn_no")
	private String isbn;
	
	@Column(name = "book_name")
	private String name;
	
	private String author;
	
	private String publisher;
	
	@Column(name = "publish_date")
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	private BigDecimal price;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
