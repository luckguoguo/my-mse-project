package cn.edu.sjtu.book.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@MappedSuperclass
public class Order extends AuditableEntity {

	public enum Status {
		PENDING, REVIEW, VERIFY
	}
	
	public enum SyncFlag {
		WAITING, FINISHED;
	}
	
	@Column(name = "order_no")
	private String orderNo;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;
	
	@Column(name = "sync_flag")
	@Enumerated(EnumType.STRING)
	private SyncFlag syncFlag;
	
	private int num;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	private String memo;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SyncFlag getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(SyncFlag syncFlag) {
		this.syncFlag = syncFlag;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
