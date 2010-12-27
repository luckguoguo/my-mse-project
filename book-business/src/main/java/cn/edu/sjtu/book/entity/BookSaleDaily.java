package cn.edu.sjtu.book.entity;

import java.math.BigDecimal;
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
@Table(name = "t_store_book_sell")
public class BookSaleDaily extends IdEntity {

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "sale_date")
	@Temporal(TemporalType.DATE)
	private Date saleDate;
	
	@Column(name = "sale_num")
	private int saleNum;
	
	@Column(name = "sale_total")
	private BigDecimal saleTotal;

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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public BigDecimal getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(BigDecimal saleTotal) {
		this.saleTotal = saleTotal;
	}
	
}
