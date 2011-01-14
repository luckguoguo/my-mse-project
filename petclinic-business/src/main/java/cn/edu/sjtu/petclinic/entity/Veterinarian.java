package cn.edu.sjtu.petclinic.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_veterinarian")
@DiscriminatorValue("1")
public class Veterinarian extends User {

	private String title;
	
	private String introduction;
	
	private String telephone;
	
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Temporal(TemporalType.DATE)
	private Date workingdate;
	
	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getWorkingdate() {
		return workingdate;
	}

	public void setWorkingdate(Date workingdate) {
		this.workingdate = workingdate;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
}
