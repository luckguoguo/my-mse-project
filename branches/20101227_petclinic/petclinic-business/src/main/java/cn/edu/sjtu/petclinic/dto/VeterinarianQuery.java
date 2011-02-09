package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.enums.Gender;

public class VeterinarianQuery {
	
	private String clinicName;
	
	private String clinicAddress;
	
	private String username;
	
	private String name;
	
	private Gender gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workingDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workingDateTo;
	
	private Long specialityPetCategoryId;
	
	private User.Status status;
	
	private Page<User> page = new Page<User>(10);

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getWorkingDateFrom() {
		return workingDateFrom;
	}

	public void setWorkingDateFrom(Date workingDateFrom) {
		this.workingDateFrom = workingDateFrom;
	}

	public Date getWorkingDateTo() {
		return workingDateTo;
	}

	public void setWorkingDateTo(Date workingDateTo) {
		this.workingDateTo = workingDateTo;
	}

	public Long getSpecialityPetCategoryId() {
		return specialityPetCategoryId;
	}

	public void setSpecialityPetCategoryId(Long specialityPetCategoryId) {
		this.specialityPetCategoryId = specialityPetCategoryId;
	}

	public User.Status getStatus() {
		return status;
	}

	public void setStatus(User.Status status) {
		this.status = status;
	}

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}
	
}
