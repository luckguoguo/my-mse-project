package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_diagnosis")
public class Diagnosis extends AuditableEntity {

	public static enum Status {
		NEW, STARED
	}
	
	@NotBlank
	@Size(max = 512)
	private String symptom;
	
	@NotBlank
	@Size(max = 512)
	private String diagnosis;
	
	@NotBlank
	@Size(max = 512)
	private String therapy;
	
	@NotBlank
	@Size(max = 512)
	private String prescription;
	
	private Integer star;
	
	private Status status = Status.NEW;
	
	@ManyToOne
	@JoinColumn(name = "interrogation_id")
	private Interrogation interrogation;
	
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Veterinarian veterinarian;

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTherapy() {
		return therapy;
	}

	public void setTherapy(String therapy) {
		this.therapy = therapy;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Interrogation getInterrogation() {
		return interrogation;
	}

	public void setInterrogation(Interrogation interrogation) {
		this.interrogation = interrogation;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}
	
}
