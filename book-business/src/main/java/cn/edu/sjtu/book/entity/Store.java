package cn.edu.sjtu.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "t_store")
public class Store extends AuditableEntity {

	public enum Status {
		OPEN, CLOSE;
	};
	
	@Column(name = "store_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
