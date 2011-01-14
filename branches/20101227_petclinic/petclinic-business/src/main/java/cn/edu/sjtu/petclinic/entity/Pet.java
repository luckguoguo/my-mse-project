package cn.edu.sjtu.petclinic.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.enums.Gender;

@Entity
@Table(name = "tbl_pet")
public class Pet extends AuditableEntity {

	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	private String introduction;
	
	@ManyToOne
	@JoinColumn(name = "petowner_id")
	private PetOwner owner;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private PetCategory category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public PetOwner getOwner() {
		return owner;
	}

	public void setOwner(PetOwner owner) {
		this.owner = owner;
	}

	public PetCategory getCategory() {
		return category;
	}

	public void setCategory(PetCategory category) {
		this.category = category;
	}
	
}
