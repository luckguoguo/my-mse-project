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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.enums.Gender;

@Entity
@Table(name = "tbl_pet")
public class Pet extends AuditableEntity {

	@NotBlank
	@Size(max = 63)
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@NotBlank
	@Size(max = 255)
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
