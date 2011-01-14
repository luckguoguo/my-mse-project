package cn.edu.sjtu.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.sjtu.common.orm.jpa.AuditableEntity;

@Entity
@Table(name = "tbl_diagnosis")
public class Diagnosis extends AuditableEntity {

	private String diagnosis;
	
	@ManyToOne
	@JoinColumn(name = "interrogation_id")
	private Interrogation interrogation;
	
	@ManyToOne
	@JoinColumn(name = "vet_id")
	private Veterinarian veterinarian;

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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
