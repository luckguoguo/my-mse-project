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
@Table(name = "t_order02")
public class DrawOrder extends Order {

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("id ASC")
	private Set<DrawOrderItem> items = new LinkedHashSet<DrawOrderItem>();

	public Set<DrawOrderItem> getItems() {
		return items;
	}

	public void setItems(Set<DrawOrderItem> items) {
		this.items = items;
	}
	
}
