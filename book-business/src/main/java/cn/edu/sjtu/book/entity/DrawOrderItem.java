package cn.edu.sjtu.book.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order02_detail")
public class DrawOrderItem extends OrderItem {

	@ManyToOne()
	@JoinColumn(name = "order_id")
	private DrawOrder order;

	public DrawOrder getOrder() {
		return order;
	}

	public void setOrder(DrawOrder order) {
		this.order = order;
	}
	
}
