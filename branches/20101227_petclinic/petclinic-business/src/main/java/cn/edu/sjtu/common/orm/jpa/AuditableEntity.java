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
	protected Long createdBy;
	
	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedTime;
	
	@Column(name = "last_modified_by")
	protected Long lastModifiedBy;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
}
