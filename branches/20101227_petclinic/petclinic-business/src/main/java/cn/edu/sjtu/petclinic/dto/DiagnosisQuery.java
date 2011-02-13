package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.Diagnosis;

public class DiagnosisQuery {

	private String name;
	
	private Long petId;
	
	private Long petOwnerId;
	
	private Long veterinarianId;
	
	private Long interrogationId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateTo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateTo;
	
	private Diagnosis.Status status;
	
	private Page<Diagnosis> page = new Page<Diagnosis>(10);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(Long petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	public Long getVeterinarianId() {
		return veterinarianId;
	}

	public void setVeterinarianId(Long veterinarianId) {
		this.veterinarianId = veterinarianId;
	}

	public Long getInterrogationId() {
		return interrogationId;
	}

	public void setInterrogationId(Long interrogationId) {
		this.interrogationId = interrogationId;
	}

	public Date getStartDateFrom() {
		return startDateFrom;
	}

	public void setStartDateFrom(Date startDateFrom) {
		this.startDateFrom = startDateFrom;
	}

	public Date getStartDateTo() {
		return startDateTo;
	}

	public void setStartDateTo(Date startDateTo) {
		this.startDateTo = startDateTo;
	}

	public Date getCreatedDateFrom() {
		return createdDateFrom;
	}

	public void setCreatedDateFrom(Date createdDateFrom) {
		this.createdDateFrom = createdDateFrom;
	}

	public Date getCreatedDateTo() {
		return createdDateTo;
	}

	public void setCreatedDateTo(Date createdDateTo) {
		this.createdDateTo = createdDateTo;
	}

	public Diagnosis.Status getStatus() {
		return status;
	}

	public void setStatus(Diagnosis.Status status) {
		this.status = status;
	}

	public Page<Diagnosis> getPage() {
		return page;
	}

	public void setPage(Page<Diagnosis> page) {
		this.page = page;
	}
	
}
