package com.tcs.org.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tcs.org.audit.AuditableEntity;
@JsonIgnoreProperties(
value = {"createdDate"},
allowGetters = true
)
@Entity
public class Workflow /*extends AuditableEntity*/ {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int workflowId;
	private int empId;
	private int reqId;
	private String actionTaken;
	@Lob
	private String actionFeedback;
	//private Date actionDoneOn;
	 @CreatedDate
	    private Date actionDoneOn = new Date();
	
	
	public Workflow(int workflowId, int empId, int reqId, String actionTaken, String actionFeedback, Date actionDoneOn) {
		super();
		this.workflowId = workflowId;
		this.empId = empId;
		this.reqId = reqId;
		this.actionTaken = actionTaken;
		this.actionFeedback = actionFeedback;
		this.actionDoneOn = actionDoneOn;
		//this.createdDate = createdDate;
	}
	
	
	public Workflow() {
		super();
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public String getActionFeedback() {
		return actionFeedback;
	}
	public void setActionFeedback(String actionFeedback) {
		this.actionFeedback = actionFeedback;
	}
	public Date getActionDoneOn() {
		return actionDoneOn;
	}
	public void setActionDoneOn(Date actionDoneOn) {
		this.actionDoneOn = actionDoneOn;
	}


	/*public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}*/


	public int getWorkflowId() {
		return workflowId;
	}


	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}
	
	
	

}
