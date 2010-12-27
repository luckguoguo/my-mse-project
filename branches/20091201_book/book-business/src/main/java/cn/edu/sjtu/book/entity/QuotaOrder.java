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
@Table(name = "t_order03")
public class QuotaOrder extends Order {
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("id ASC")
	private Set<QuotaOrderItem> items = new LinkedHashSet<QuotaOrderItem>();

	public Set<QuotaOrderItem> getItems() {
		return items;
	}

	public void setItems(Set<QuotaOrderItem> items) {
		this.items = items;
	}
	
}
