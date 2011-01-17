package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_appointment")
public class Appointment extends AuditableEntity {

	public static enum Status {
		NEW, PENDING, APPROVED
	}
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.NEW;
	
	@Column(name = "serial_no")
	private String serialNo;
	
	private String memo;
	
	@ManyToOne
	@JoinColumn(name = "daily_outpatient_id")
	private DailyOutpatient dailyOutpatient;
	
	@ManyToOne
	@JoinColumn(name = "petowner_id")
	private PetOwner petOwner;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public DailyOutpatient getDailyOutpatient() {
		return dailyOutpatient;
	}

	public void setDailyOutpatient(DailyOutpatient dailyOutpatient) {
		this.dailyOutpatient = dailyOutpatient;
	}

	public PetOwner getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

}
