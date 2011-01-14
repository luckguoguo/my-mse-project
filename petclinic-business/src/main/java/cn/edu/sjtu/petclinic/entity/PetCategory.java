package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.edu.sjtu.common.orm.jpa.IdEntity;

@Entity
@Table(name = "tbl_pet_category")
public class PetCategory extends IdEntity {

	private String name;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
