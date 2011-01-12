package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_clinic")
public class Clinic extends AuditableEntity {

	public static enum Status {
		ACTIVE, INACTIVE, PENDING;
	};
	
	private String name;
	
	private String introduction;
	
	private Integer grade;
	
	private String address;
	
	private String telephone;
	
	private String email;
	
	private Integer star;
	
	@Column(name = "management_password")
	private String mgrPassword;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getMgrPassword() {
		return mgrPassword;
	}

	public void setMgrPassword(String mgrPassword) {
		this.mgrPassword = mgrPassword;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
