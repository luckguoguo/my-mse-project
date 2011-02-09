package cn.edu.sjtu.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.Page;
import cn.edu.sjtu.petclinic.entity.Appointment;

public class AppointmentQuery {
	
	private Long petOwnerId;
	
	private Long veterinarianId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayTo;
	
	private Page<Appointment> page = new Page<Appointment>(10);

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

	public Page<Appointment> getPage() {
		return page;
	}

	public void setPage(Page<Appointment> page) {
		this.page = page;
	}

}
