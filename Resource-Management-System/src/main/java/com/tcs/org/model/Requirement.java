package com.tcs.org.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
@Audited
public class Requirement extends AuditableEntity<String> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//private int reqId;
	private int reqType;
	//@Column(nullable = true)
	private int branchId;
	///private String reqBranch;
	@Nullable
	private LocalDateTime startDate;
	@Nullable
	private LocalDateTime endDate;
	@Nullable
	private int associateCount;
	@Nullable
	private int associateExp;
	@Nullable
	private int realizationCurrency;
	@Nullable
	private int realizationAmt;
	@Nullable
	private int expectedCostCurrency;
	@Nullable
	private int expcetedcostMin;
	@Nullable
	private int expcetedcostMax;
	@Nullable
	private int sttafingReason;
	@Nullable
	private int replacementEmpCode;
	@Nullable
	private int staffingSource;
	@Nullable
	private int associateReqCountry;
	@Lob
	@Nullable
	private String skillsMust;
	@Lob
	@Nullable
	private String skillsGood;
	@Lob
	@Nullable
	private String reqResponsibilities;
	@Lob
	@Nullable
	private String reqKeywords;
	@Nullable
	private int evaluatorId;
	@Nullable
	private int locationOffshore;
	@Nullable
	private String programName;
	@Nullable
	private String trackName;
	@Nullable
	private String customerGroup;
	@Nullable
	private int brmId;
	@Nullable
	private int onsitedmId;
	@Nullable
	private int offshoreDmId;
	@Nullable
	private int clientManager;
	@Nullable
	private String servicePractice;
	@Nullable
	private boolean clientInterviewFlag;
	@Nullable
	private int status;
	@Nullable
	private int reqWonId;
	@Nullable
	private String billRate;
	@Nullable
	private String billLoss;
	@Nullable
	private int engagementType;
	@Nullable
	private String jobDesc;
	private String reqRole;
	@Lob
	@Nullable
	private String taggedSkill;
	@Nullable
	private int opportunityId;
	
	public Requirement(String jobDesc, String reqRole) {
		super();
		this.jobDesc = jobDesc;
		this.reqRole = reqRole;
	}
	
	/*@Column(name="project_details_id")
	private int projectId;*/
	//private String reqRole;
	private LocalDateTime reqCreatedDate;
	
	public Requirement(LocalDateTime reqCreatedDate) {
		super();
		this.reqCreatedDate = reqCreatedDate;
	}
	
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	private ProjectDetails projectDetails;
	*/
	 /*@ElementCollection(targetClass=Integer.class)
	    @CollectionTable(name="req_skill", joinColumns= {@JoinColumn(name="id")})
	    private List<Integer> compId;*/
	
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Location> location;*/
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private Location location;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private ProjectDetails projectDetails;
	
	
	 /*@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	    private Skill skill;*/
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @ElementCollection
	    @CollectionTable(name="req_skill", joinColumns= {@JoinColumn(name="id")})
	private List<RequirementSkill> reqSkill;
	 
	
//	
//	@JsonIgnore
//	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinTable(name="req_skill", joinColumns = @JoinColumn(name="id"),inverseJoinColumns= @JoinColumn(name ="comp_id"))
//	private List<Skill> skill;

	
	



	/*public Requirement(List<Skill> skill) {
		super();
		this.skill = skill;
	}*/





	public Requirement(int id,	int reqType,	int branchId,	LocalDateTime startDate,	LocalDateTime endDate,	int associateCount,	int associateExp,	int realizationCurrency,	int realizationAmt,	int expectedCostCurrency,	int expcetedcostMin,	int expcetedcostMax,	int sttafingReason,	int replacementEmpCode,	int staffingSource,	int associateReqCountry,	String skillsMust,	String skillsGood,	String reqResponsibilities,	String reqKeywords,	int evaluatorId,	int locationOffshore,	String programName,	String trackName,	String customerGroup,	int brmId,	int onsitedmId,	int offshoreDmId,	int clientManager,	String servicePractice,	boolean clientInterviewFlag,	int status,	int reqWonId,	String billRate,	String billLoss,	int engagementType/*,	int projectId*/,List<RequirementSkill> reqSkill, Location location, ProjectDetails projectDetails, String taggedSkill, int opportunityId/*, Skill skill*/) {
		super();
		this.id = id;
		this.reqType = reqType;
		this.branchId = branchId;
		//this.reqBranch = reqBranch;
		this.startDate = startDate;
		this.endDate = endDate;
		this.associateCount = associateCount;
		this.associateExp = associateExp;
		this.realizationCurrency = realizationCurrency;
		this.realizationAmt = realizationAmt;
		this.expectedCostCurrency = expectedCostCurrency;
		this.expcetedcostMin = expcetedcostMin;
		this.expcetedcostMax = expcetedcostMax;
		this.sttafingReason = sttafingReason;
		this.replacementEmpCode = replacementEmpCode;
		this.staffingSource = staffingSource;
		this.associateReqCountry = associateReqCountry;
		this.skillsMust = skillsMust;
		this.skillsGood = skillsGood;
		this.reqResponsibilities = reqResponsibilities;
		this.reqKeywords = reqKeywords;
		this.evaluatorId = evaluatorId;
		this.locationOffshore = locationOffshore;
		this.programName = programName;
		this.trackName = trackName;
		this.customerGroup = customerGroup;
		this.brmId = brmId;
		this.onsitedmId = onsitedmId;
		this.offshoreDmId = offshoreDmId;
		this.clientManager = clientManager;
		this.servicePractice = servicePractice;
		this.clientInterviewFlag = clientInterviewFlag;
		this.status = status;
		this.reqWonId = reqWonId;
		this.billRate = billRate;
		this.billLoss = billLoss;
		this.engagementType = engagementType;
		//this.projectId = projectId;
		//this.role = role;
		this.projectDetails = projectDetails;
		this.reqSkill = reqSkill;
		this.location = location;
		this.taggedSkill = taggedSkill;
		this.opportunityId = opportunityId;
		//this.skill = skill;
	}





	public Requirement() {
		
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}












	public Location getLocation() {
		return location;
	}





	public void setLocation(Location location) {
		this.location = location;
	}





	public int getReqType() {
		return reqType;
	}





	public void setReqType(int reqType) {
		this.reqType = reqType;
	}





	public int getBranchId() {
		return branchId;
	}





	public void setBranchId(int branchId) {
		this.branchId = branchId;
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





	public int getRealizationCurrency() {
		return realizationCurrency;
	}





	public void setRealizationCurrency(int realizationCurrency) {
		this.realizationCurrency = realizationCurrency;
	}





	public int getRealizationAmt() {
		return realizationAmt;
	}





	public void setRealizationAmt(int realizationAmt) {
		this.realizationAmt = realizationAmt;
	}





	public int getExpectedCostCurrency() {
		return expectedCostCurrency;
	}





	public void setExpectedCostCurrency(int expectedCostCurrency) {
		this.expectedCostCurrency = expectedCostCurrency;
	}





	public int getExpcetedcostMin() {
		return expcetedcostMin;
	}





	public void setExpcetedcostMin(int expcetedcostMin) {
		this.expcetedcostMin = expcetedcostMin;
	}





	public int getExpcetedcostMax() {
		return expcetedcostMax;
	}





	public void setExpcetedcostMax(int expcetedcostMax) {
		this.expcetedcostMax = expcetedcostMax;
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





	public int getStaffingSource() {
		return staffingSource;
	}





	public void setStaffingSource(int staffingSource) {
		this.staffingSource = staffingSource;
	}





	public int getAssociateReqCountry() {
		return associateReqCountry;
	}





	public void setAssociateReqCountry(int associateReqCountry) {
		this.associateReqCountry = associateReqCountry;
	}





	public String getSkillsMust() {
		return skillsMust;
	}





	public void setSkillsMust(String skillsMust) {
		this.skillsMust = skillsMust;
	}





	public String getSkillsGood() {
		return skillsGood;
	}





	public void setSkillsGood(String skillsGood) {
		this.skillsGood = skillsGood;
	}





	public String getReqResponsibilities() {
		return reqResponsibilities;
	}





	public void setReqResponsibilities(String reqResponsibilities) {
		this.reqResponsibilities = reqResponsibilities;
	}





	public String getReqKeywords() {
		return reqKeywords;
	}





	public void setReqKeywords(String reqKeywords) {
		this.reqKeywords = reqKeywords;
	}





	public int getEvaluatorId() {
		return evaluatorId;
	}





	public void setEvaluatorId(int evaluatorId) {
		this.evaluatorId = evaluatorId;
	}





	public int getLocationOffshore() {
		return locationOffshore;
	}





	public void setLocationOffshore(int locationOffshore) {
		this.locationOffshore = locationOffshore;
	}





	public String getProgramName() {
		return programName;
	}





	public void setProgramName(String programName) {
		this.programName = programName;
	}





	public String getTrackName() {
		return trackName;
	}





	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}





	public String getCustomerGroup() {
		return customerGroup;
	}





	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}





	public int getBrmId() {
		return brmId;
	}





	public void setBrmId(int brmId) {
		this.brmId = brmId;
	}





	public int getOnsitedmId() {
		return onsitedmId;
	}





	public void setOnsitedmId(int onsitedmId) {
		this.onsitedmId = onsitedmId;
	}





	public int getOffshoreDmId() {
		return offshoreDmId;
	}





	public void setOffshoreDmId(int offshoreDmId) {
		this.offshoreDmId = offshoreDmId;
	}





	public int getClientManager() {
		return clientManager;
	}





	public void setClientManager(int clientManager) {
		this.clientManager = clientManager;
	}





	public String getServicePractice() {
		return servicePractice;
	}





	public void setServicePractice(String servicePractice) {
		this.servicePractice = servicePractice;
	}





	public boolean isClientInterviewFlag() {
		return clientInterviewFlag;
	}





	public void setClientInterviewFlag(boolean clientInterviewFlag) {
		this.clientInterviewFlag = clientInterviewFlag;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	public int getReqWonId() {
		return reqWonId;
	}





	public void setReqWonId(int reqWonId) {
		this.reqWonId = reqWonId;
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





	public int getEngagementType() {
		return engagementType;
	}





	public void setEngagementType(int engagementType) {
		this.engagementType = engagementType;
	}




/*
	public int getProjectId() {
		return projectId;
	}





	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
*/




	public LocalDateTime getReqCreatedDate() {
		return reqCreatedDate;
	}





	public void setReqCreatedDate(LocalDateTime reqCreatedDate) {
		this.reqCreatedDate = reqCreatedDate;
	}





	public String getJobDesc() {
		return jobDesc;
	}





	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}





	public String getReqRole() {
		return reqRole;
	}





	public void setReqRole(String reqRole) {
		this.reqRole = reqRole;
	}













	/*	public List<Integer> getCompId() {
		return compId;
	}





	public void setCompId(List<Integer> compId) {
		this.compId = compId;
	}
*/




	public List<RequirementSkill> getReqSkill() {
		return reqSkill;
	}





	public void setReqSkill(List<RequirementSkill> reqSkill) {
		this.reqSkill = reqSkill;
	}





	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}


	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}





	public Requirement(List<RequirementSkill> reqSkill) {
		super();
		this.reqSkill = reqSkill;
	}





	public String getTaggedSkill() {
		return taggedSkill;
	}





	public void setTaggedSkill(String taggedSkill) {
		this.taggedSkill = taggedSkill;
	}





	public int getOpportunityId() {
		return opportunityId;
	}





	public void setOpportunityId(int opportunityId) {
		this.opportunityId = opportunityId;
	}





	/*public int getReqId() {
		return reqId;
	}





	public void setReqId(int reqId) {
		this.reqId = reqId;
	}*/





	/*public Skill getSkill() {
		return skill;
	}





	public void setSkill(Skill skill) {
		this.skill = skill;
	}*/
}