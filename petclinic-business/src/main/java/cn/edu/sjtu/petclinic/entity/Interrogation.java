package cn.edu.sjtu.petclinic.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_interrogation")
public class Interrogation extends AuditableEntity {

	public static enum Status {
		NEW, DIAGNOSING, DIAGNOSED
	}

	@NotBlank
	@Size(max = 63)
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@NotBlank
	@Size(max = 2000)
	private String symptom;
	
	private String memo;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.NEW;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name = "petowner_id")
	private PetOwner petOwner;
	
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Veterinarian veterinarian;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public PetOwner getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}
	
}
