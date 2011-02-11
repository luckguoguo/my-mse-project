package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_clinic")
public class Clinic extends AuditableEntity {

	public static enum Status {
		ACTIVE, INACTIVE, PENDING;
	};
	
	@NotBlank
	@Size(max = 31)
	private String name;
	
	@NotBlank
	@Size(max = 1023)
	private String introduction;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 3)
	private Integer grade;
	
	@NotBlank
	@Size(max = 127)
	private String address;
	
	@NotBlank
	@Size(max = 31)
	private String telephone;
	
	@NotBlank
	@Email()
	@Size(max = 255)
	private String email;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 5)
	private Integer star;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "management_password")
	private String mgrPassword;
	
	@NotBlank
	@Size(max = 255)
	@Transient
	private String confirmMgrPassword;
	
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

	public String getConfirmMgrPassword() {
		return confirmMgrPassword;
	}

	public void setConfirmMgrPassword(String confirmMgrPassword) {
		this.confirmMgrPassword = confirmMgrPassword;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
