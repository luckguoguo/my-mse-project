package cn.edu.sjtu.book.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order03_detail")
public class QuotaOrderItem extends OrderItem {

	@ManyToOne()
	@JoinColumn(name = "order_id")
	private QuotaOrder order;

	public QuotaOrder getOrder() {
		return order;
	}

	public void setOrder(QuotaOrder order) {
		this.order = order;
	}
	
}
