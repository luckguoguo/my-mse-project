package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.enums.Gender;

@MappedSuperclass
public class User extends AuditableEntity {

	public static enum Status {
		ACTIVE, INACTIVE, PENDING;
	}
	
	protected String username;
	
	protected String password;
	
	@Column(name = "temp_password")
	protected String tempPassword;
	
	protected String email;
	
	protected String name;
	
	@Enumerated(EnumType.STRING)
	protected Gender gender = Gender.MALE;
	
	@Enumerated(EnumType.STRING)
	protected Status status = Status.PENDING;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
