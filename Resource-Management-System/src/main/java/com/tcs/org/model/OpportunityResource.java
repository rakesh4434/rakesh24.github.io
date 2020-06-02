package com.tcs.org.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import com.tcs.org.audit.AuditableEntity;

@Entity
public class OpportunityResource /*extends AuditableEntity*/ {
	@Id
	
	private int resourceId;
    private int  associateCount;
	@Nullable
	private int associateExp;
	private String billRate;
	@Nullable
	private String billLoss;
	/*@Nullable
	private LocalDateTime startDate;
	@Nullable
	private LocalDateTime endDate;*/
	private String reqRole;
	/*private int reqType;
	@Nullable
	private int sttafingReason;
	@Nullable
	private int replacementEmpCode;*/
	public OpportunityResource() {
		
	}
	public OpportunityResource(int resourceId, int associateCount, int associateExp, String billRate, String billLoss,
			LocalDateTime startDate, LocalDateTime endDate, String reqRole, int reqType, int sttafingReason,
			int replacementEmpCode) {
		super();
		this.resourceId = resourceId;
		this.associateCount = associateCount;
		this.associateExp = associateExp;
		this.billRate = billRate;
		this.billLoss = billLoss;
		/*this.startDate = startDate;
		this.endDate = endDate;*/
		this.reqRole = reqRole;
		/*this.reqType = reqType;
		this.sttafingReason = sttafingReason;
		this.replacementEmpCode = replacementEmpCode;*/
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getAssociateCount() {
		return associateCount;
	}
	public void setAssociateCount(int associateCount) {
		this.associateCount = associateCount;
	}
	public int getAssociateExp() {
		return associateExp;
	}
	public void setAssociateExp(int associateExp) {
		this.associateExp = associateExp;
	}
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	public String getBillLoss() {
		return billLoss;
	}
	public void setBillLoss(String billLoss) {
		this.billLoss = billLoss;
	}
	/*public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}*/
	public String getReqRole() {
		return reqRole;
	}
	public void setReqRole(String reqRole) {
		this.reqRole = reqRole;
	}
	/*public int getReqType() {
		return reqType;
	}
	public void setReqType(int reqType) {
		this.reqType = reqType;
	}
	public int getSttafingReason() {
		return sttafingReason;
	}
	public void setSttafingReason(int sttafingReason) {
		this.sttafingReason = sttafingReason;
	}
	public int getReplacementEmpCode() {
		return replacementEmpCode;
	}
	public void setReplacementEmpCode(int replacementEmpCode) {
		this.replacementEmpCode = replacementEmpCode;
	}*/
	

}