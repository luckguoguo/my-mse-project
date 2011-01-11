package cn.edu.sjtu.common.orm.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditableEntity extends IdEntity {

	@Column(name = "created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdTime;
	
	@Column(name = "created_by", updatable = false)
	protected String createdBy;
	
	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedTime;
	
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
}
