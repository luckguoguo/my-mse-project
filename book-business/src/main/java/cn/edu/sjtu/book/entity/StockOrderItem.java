package cn.edu.sjtu.book.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order01_detail")
public class StockOrderItem extends OrderItem {
	
	@ManyToOne()
	@JoinColumn(name = "order_id")
	private StockOrder order;

	public StockOrder getOrder() {
		return order;
	}

	public void setOrder(StockOrder order) {
		this.order = order;
	}
	
}
