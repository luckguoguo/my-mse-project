package cn.edu.sjtu.book.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "t_order01")
public class StockOrder extends Order {
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("id ASC")
	private Set<StockOrderItem> items = new LinkedHashSet<StockOrderItem>();

	public Set<StockOrderItem> getItems() {
		return items;
	}

	public void setItems(Set<StockOrderItem> items) {
		this.items = items;
	}

}
