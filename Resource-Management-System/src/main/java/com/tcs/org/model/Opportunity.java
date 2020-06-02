package com.tcs.org.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.tcs.org.audit.AuditableEntity;

@Entity
public class Opportunity /*extends AuditableEntity*/ {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int branchId;
	
	private int brmId;
	///private String reqBranch;
	@Nullable
	private String customerGroup;
	@Nullable
	private int engagementType;
	@Nullable
	@Lob
	private String evaluatorId;
	@Nullable
	private int expectedcostMax;
	@Nullable
	private int expcetedcostMin;
	@Nullable
	private int expectedCostCurrency;
	@Nullable
	private int locationOffshore;
	@Nullable
	private int offshoreDmId;
	@Nullable
	private int onsitedmId;
	@Nullable
	private String programName;
	@Nullable
	private int realizationAmt;
	@Nullable
	private int realizationCurrency;
	@Nullable
	private int reqWonId;
	@Nullable
	private String servicePractice;
	@Nullable
	private int staffingSource;
	@Nullable
	private String trackName;
	@Nullable
	@Lob
	private String clientManager;
	@Nullable
	private int associateReqCountry;
	@Nullable
	private LocalDateTime startDate;
	@Nullable
	private LocalDateTime endDate;
	private LocalDateTime reqCreatedDate;
	private int reqType;
	@Nullable
	private int sttafingReason;
	/*public List<AuditDetails> getAuditDetails() {
		return auditDetails;
	}
	public void setAuditDetails(List<AuditDetails> auditDetails) {
		this.auditDetails = auditDetails;
	}*/
	@Nullable
	private int replacementEmpCode;
	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "opportunity_id")
	private List<AuditDetails> auditDetails;
	*/
	 @OneToMany(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
		@JoinColumn(name = "id")
		private List<OpportunityResource> opportunityResource ;
	 
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	    private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private ProjectDetails projectDetails;
	
	public Opportunity() {
		
	}
	public Opportunity(int id, int branchId, int brmId, String customerGroup, int engagementType, String evaluatorId,
			int expectedcostMax, int expcetedcostMin, int expectedCostCurrency, int locationOffshore, int offshoreDmId,
			int onsitedmId, String programName, int realizationAmt, int realizationCurrency, int reqWonId,
			String servicePractice, int staffingSource, String trackName, String clientManager, int associateReqCountry,LocalDateTime startDate, LocalDateTime endDate,
			LocalDateTime reqCreatedDate, Location location, ProjectDetails projectDetails, List<OpportunityResource> opportunityResource, int reqType, int sttafingReason,
			int replacementEmpCode) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.brmId = brmId;
		this.customerGroup = customerGroup;
		this.engagementType = engagementType;
		this.evaluatorId = evaluatorId;
		this.expectedcostMax = expectedcostMax;
		this.expcetedcostMin = expcetedcostMin;
		this.expectedCostCurrency = expectedCostCurrency;
		this.locationOffshore = locationOffshore;
		this.offshoreDmId = offshoreDmId;
		this.onsitedmId = onsitedmId;
		this.programName = programName;
		this.realizationAmt = realizationAmt;
		this.realizationCurrency = realizationCurrency;
		this.reqWonId = reqWonId;
		this.servicePractice = servicePractice;
		this.staffingSource = staffingSource;
		this.trackName = trackName;
		this.clientManager = clientManager;
		this.associateReqCountry = associateReqCountry;
		this.reqCreatedDate = reqCreatedDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reqType = reqType;
		this.sttafingReason = sttafingReason;
		this.replacementEmpCode = replacementEmpCode;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getBrmId() {
		return brmId;
	}
	public void setBrmId(int brmId) {
		this.brmId = brmId;
	}
	public String getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}
	public int getEngagementType() {
		return engagementType;
	}
	public void setEngagementType(int engagementType) {
		this.engagementType = engagementType;
	}
	public String getEvaluatorId() {
		return evaluatorId;
	}
	public void setEvaluatorId(String evaluatorId) {
		this.evaluatorId = evaluatorId;
	}
	public int getExpectedcostMax() {
		return expectedcostMax;
	}
	public void setExpectedcostMax(int expectedcostMax) {
		this.expectedcostMax = expectedcostMax;
	}
	public int getExpcetedcostMin() {
		return expcetedcostMin;
	}
	public void setExpcetedcostMin(int expcetedcostMin) {
		this.expcetedcostMin = expcetedcostMin;
	}
	public int getExpectedCostCurrency() {
		return expectedCostCurrency;
	}
	public void setExpectedCostCurrency(int expectedCostCurrency) {
		this.expectedCostCurrency = expectedCostCurrency;
	}
	public int getLocationOffshore() {
		return locationOffshore;
	}
	public void setLocationOffshore(int locationOffshore) {
		this.locationOffshore = locationOffshore;
	}
	public int getOffshoreDmId() {
		return offshoreDmId;
	}
	public void setOffshoreDmId(int offshoreDmId) {
		this.offshoreDmId = offshoreDmId;
	}
	public int getOnsitedmId() {
		return onsitedmId;
	}
	public void setOnsitedmId(int onsitedmId) {
		this.onsitedmId = onsitedmId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public int getRealizationAmt() {
		return realizationAmt;
	}
	public void setRealizationAmt(int realizationAmt) {
		this.realizationAmt = realizationAmt;
	}
	public int getRealizationCurrency() {
		return realizationCurrency;
	}
	public void setRealizationCurrency(int realizationCurrency) {
		this.realizationCurrency = realizationCurrency;
	}
	public int getReqWonId() {
		return reqWonId;
	}
	public void setReqWonId(int reqWonId) {
		this.reqWonId = reqWonId;
	}
	public String getServicePractice() {
		return servicePractice;
	}
	public void setServicePractice(String servicePractice) {
		this.servicePractice = servicePractice;
	}
	public int getStaffingSource() {
		return staffingSource;
	}
	public void setStaffingSource(int staffingSource) {
		this.staffingSource = staffingSource;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getClientManager() {
		return clientManager;
	}
	public void setClientManager(String clientManager) {
		this.clientManager = clientManager;
	}
	public int getAssociateReqCountry() {
		return associateReqCountry;
	}
	public void setAssociateReqCountry(int associateReqCountry) {
		this.associateReqCountry = associateReqCountry;
	}
	public LocalDateTime getReqCreatedDate() {
		return reqCreatedDate;
	}
	public void setReqCreatedDate(LocalDateTime reqCreatedDate) {
		this.reqCreatedDate = reqCreatedDate;
	}
	public Opportunity(List<OpportunityResource> opportunityResource) {
		super();
		this.opportunityResource = opportunityResource;
	}
	public List<OpportunityResource> getOpportunityResource() {
		return opportunityResource;
	}
	public void setOpportunityResource(List<OpportunityResource> opportunityResource) {
		this.opportunityResource = opportunityResource;
	}
	public Opportunity(Location location) {
		super();
		this.location = location;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Opportunity(ProjectDetails projectDetails) {
		super();
		this.projectDetails = projectDetails;
	}
	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}
	public LocalDateTime getStartDate() {
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
	}
	public int getReqType() {
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
	}
	
	


}
