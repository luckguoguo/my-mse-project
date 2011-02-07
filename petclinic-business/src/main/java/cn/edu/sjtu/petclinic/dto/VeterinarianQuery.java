package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.User;
import cn.edu.sjtu.petclinic.entity.Veterinarian;
import cn.edu.sjtu.petclinic.enums.Gender;

public class VeterinarianQuery {
	
	private String clinicName;
	
	private String username;
	
	private String name;
	
	private Gender gender;
	
	private Date workingDateFrom;
	
	private Date workingDateTo;
	
	private User.Status status;
	
	private Page<Veterinarian> page = new Page<Veterinarian>(10);

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
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

	public User.Status getStatus() {
		return status;
	}

	public void setStatus(User.Status status) {
		this.status = status;
	}

	public Page<Veterinarian> getPage() {
		return page;
	}

	public void setPage(Page<Veterinarian> page) {
		this.page = page;
	}
	
}
