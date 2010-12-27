package cn.edu.sjtu.common.orm.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AuditableEntity extends IdEntity {

	@Column(name = "create_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createTime;
	
	@Column(name = "create_by", updatable = false)
	protected String createBy;
	
	@Column(name = "modify_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifyTime;
	
	@Column(name = "modify_by")
	protected String lastModifyBy;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	
}
