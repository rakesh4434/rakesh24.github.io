package com.tcs.org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.tcs.org.audit.AuditableEntity;

@Embeddable
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Table(name="profile_training")
public class ProfileTraining /*extends AuditableEntity*/ {
	//private int empId;
	
	private Date startDate;
	private Date endDate;
	private String status;
	
	@Column(name="trainId")
	  private int trainId;
	
	
	public ProfileTraining( int trainId, Date startDate, Date endDate, String status) {
		
		//this.empId = empId;
		this.trainId = trainId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}




	public ProfileTraining() {
		
	}




	/*public int getEmpId() {
		return empId;
	}




	public void setEmpId(int empId) {
		this.empId = empId;
	}*/




	public int getTrainId() {
		return trainId;
	}




	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

