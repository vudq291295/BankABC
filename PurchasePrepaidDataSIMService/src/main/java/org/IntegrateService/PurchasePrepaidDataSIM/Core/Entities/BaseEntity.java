package org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {

	@Column(name="record_version")
    @Version
    private long RecordVersion;

	@Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedDate;

	@Column(name="last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastUpdateDate;

    @PrePersist
    protected void onCreate() {
    	LastUpdateDate = CreatedDate = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	LastUpdateDate = new Date();
    }

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
