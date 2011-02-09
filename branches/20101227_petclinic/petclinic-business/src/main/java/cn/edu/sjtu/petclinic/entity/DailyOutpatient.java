package cn.edu.sjtu.petclinic.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_daily_outpatient")
public class DailyOutpatient extends AuditableEntity {

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date day;
	
	@NotNull
	@Column(name = "count_limit")
	private Integer countLimit;
	
	@Column(name = "count_actual")
	private Integer countActual = 0;
	
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

	public Integer getCountActual() {
		return countActual;
	}

	public void setCountActual(Integer countActual) {
		this.countActual = countActual;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}
	
}
