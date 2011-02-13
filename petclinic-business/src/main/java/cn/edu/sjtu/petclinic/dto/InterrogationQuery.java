package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.Interrogation;

public class InterrogationQuery {

	private String name;
	
	private Long petId;
	
	private Long petOwnerId;
	
	private Long veterinarianId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDateTo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDateTo;
	
	private Interrogation.Status status;
	
	private Page<Interrogation> page = new Page<Interrogation>(10);

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

	public Interrogation.Status getStatus() {
		return status;
	}

	public void setStatus(Interrogation.Status status) {
		this.status = status;
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

	public Page<Interrogation> getPage() {
		return page;
	}

	public void setPage(Page<Interrogation> page) {
		this.page = page;
	}
	
}
