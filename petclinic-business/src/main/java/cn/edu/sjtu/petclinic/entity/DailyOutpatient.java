package cn.edu.sjtu.petclinic.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.sjtu.common.orm.jpa.IdEntity;

@Entity
@Table(name = "tbl_daily_outpatient")
public class DailyOutpatient extends IdEntity {

	@Temporal(TemporalType.DATE)
	private Date day;
	
	@Column(name = "count_limit")
	private Integer countLimit;
	
	@Column(name = "count_current")
	private Integer countCurrent;
	
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Veterinarian veterinarian;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Integer getCountLimit() {
		return countLimit;
	}

	public void setCountLimit(Integer countLimit) {
		this.countLimit = countLimit;
	}

	public Integer getCountCurrent() {
		return countCurrent;
	}

	public void setCountCurrent(Integer countCurrent) {
		this.countCurrent = countCurrent;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}
	
}
