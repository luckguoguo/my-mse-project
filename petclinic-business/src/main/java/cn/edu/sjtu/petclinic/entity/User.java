package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;
import cn.edu.sjtu.petclinic.enums.Gender;

@Entity
@Table(name = "tbl_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class User extends AuditableEntity {

	public static enum Status {
		ACTIVE, INACTIVE, PENDING;
	}
	
	@NotBlank
	@Size(max = 31)
	protected String username;
	
	@NotBlank
	@Size(max = 255)
	protected String password;
	
	@Column(name = "temp_password")
	protected String tempPassword;
	
	@Transient
	protected String confirmPassword;
	
	@NotBlank
	@Email
	@Size(max = 255)
	protected String email;
	
	@NotBlank
	@Size(max = 31)
	protected String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	
	@Enumerated(EnumType.STRING)
	protected Status status = Status.PENDING;
	
	@Column(name = "user_type")
	protected Integer userType;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}
