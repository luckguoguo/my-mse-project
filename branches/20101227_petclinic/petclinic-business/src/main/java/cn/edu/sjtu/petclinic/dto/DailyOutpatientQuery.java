package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.DailyOutpatient;

public class DailyOutpatientQuery {

	private Long veterinarianId;
	
	private String clinicName;
	
	private String clinicAddress;
	
	private Long specialityPetCategoryId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayTo;
	
	private Page<DailyOutpatient> page = new Page<DailyOutpatient>(10);

	public Long getVeterinarianId() {
		return veterinarianId;
	}

	public void setVeterinarianId(Long veterinarianId) {
		this.veterinarianId = veterinarianId;
	}

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

	public Long getSpecialityPetCategoryId() {
		return specialityPetCategoryId;
	}

	public void setSpecialityPetCategoryId(Long specialityPetCategoryId) {
		this.specialityPetCategoryId = specialityPetCategoryId;
	}

	public Date getDayFrom() {
		return dayFrom;
	}

	public void setDayFrom(Date dayFrom) {
		this.dayFrom = dayFrom;
	}

	public Date getDayTo() {
		return dayTo;
	}

	public void setDayTo(Date dayTo) {
		this.dayTo = dayTo;
	}

	public Page<DailyOutpatient> getPage() {
		return page;
	}

	public void setPage(Page<DailyOutpatient> page) {
		this.page = page;
	}
	
}
