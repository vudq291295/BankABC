package org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Column(name="record_version")
    @Version
    private long RecordVersion;

	@Column(name="created_date")
    private Date CreatedDate;

	@Column(name="last_update_date")
    private Date LastUpdateDate;

	public long getRecordVersion() {
		return RecordVersion;
	}

	public void setRecordVersion(long recordVersion) {
		RecordVersion = recordVersion;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Date getLastUpdateDate() {
		return LastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}

	
}
