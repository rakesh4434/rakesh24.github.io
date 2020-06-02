package com.tcs.org.model;

import javax.persistence.Embeddable;
import javax.persistence.Table;

import com.tcs.org.audit.AuditableEntity;

@Embeddable
@Table(name="profile_status")
public class ProfileStatus /*extends AuditableEntity*/ {
	private int statusId;

	public ProfileStatus(int statusId) {
		super();
		this.statusId = statusId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
}
