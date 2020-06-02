package com.tcs.org.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.lang.Nullable;

import com.tcs.org.audit.AuditableEntity;

@Entity
@Audited
public class DigitalProfile extends AuditableEntity<String> {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
    //@Column(name = "emp_id", length = 255, nullable = false)

	private int empId;
    //@Column(name = "prof_id",  nullable = false)
	//private int profeciancyId;

    //@Column(name = "views",  nullable = false)
    private int views;
	
	//@Column(name = "endors",  nullable = false)
	private int endors;
	//@Column(name = "exop",  nullable = false)
	private int exop;
	
	private String empName;
	private String empGrade;
	private String empDesignation;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	private Location baseBranch;
	
	private int tcsExp;
	private int totalExp;
	private int prevExp;
	@Lob
	private String empSummary;
	@Lob 
	private String empAchievement;
	@Lob 
	private String empSoftSkill;
	@Lob
	private String empHardwareSkill;
	@Lob
	private String empToolSkill;
	@Lob
	private String empMethodSkill;
	@Lob
	private String empDomainSkill;
	@Lob
	private String empMgmtSkill;
	@Lob
	private String emBDSkill;
	@Lob
	private String empEmail;
	private int empPresentPhone;
	private int empPermanentPhone;
	@Lob
	private String empAdditionalDetail;
	private boolean empMentorFlag;
	private boolean empDeputationFlag;
	private String gspeedStatus;
	private String ninjaStatus;
	private String softskillStatus;
	private String aspirationalRole;
	private int gemsPoint;
	private int tfactorScore;
	private int empMiles;
	private int empCredits;
	//@Nullable
	//private int reqId;
	@Lob
	private String exitFeedback;
	private String passportNo;
	private String visaNo;
	private Date visaExpDate;
	private Date releaseDate;
	private int freeLance;
	private int badges;
	//private int requirementId;
	//private String exitFeedback;
	
	private String role;
	
	//@Lob
	//private byte[] data;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private ProjectDetails projectDetails ;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@Nullable
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    private Requirement requirement;
	
	public DigitalProfile(Requirement requirement) {
		super();
		this.requirement = requirement;
	}



	/*@OneToOne
	private ProfileCertification profileCertification;*/
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "emp_id")
	private List<TcsExperience> tcsExperience;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "emp_id")
	private List<Experience> experience;
	
/*    @OneToMany
    @JoinTable(name="DIGITAL_STATUS",joinColumns = @JoinColumn(name = "emp_Id"),
			inverseJoinColumns = @JoinColumn(name = "status_Id"))
    private List<Status> status;*/
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="statusId_FK")
    private Status status ;
	
	 /*@ElementCollection
	    @CollectionTable(name="profile_status", joinColumns= {@JoinColumn(name="empId")})
	private List<ProfileStatus> profileStatus;*/
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @ElementCollection
	    @CollectionTable(name="profile_certification", joinColumns= {@JoinColumn(name="empId")})
	private List<ProfileCertification> pCertification;
	
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name = "emp_id")
		private List<Education> education;

	/* @OneToMany(targetEntity=Experience.class,mappedBy="digitalProfile",
				cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
	private List<Experience> experience;*/
	 
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name = "emp_id")
		private List<AwardTbl> awardTbl ;

	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @ElementCollection
	    @CollectionTable(name="training_table", joinColumns= {@JoinColumn(name="empId")})
	private List<ProfileTraining> profileTraining;
	

	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name = "emp_id")
		private List<GemsTable> gems;


	
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	 @ElementCollection
	 @CollectionTable(name="digital_competency", joinColumns= {@JoinColumn(name="empId")})
	 private List<ProfileCompetency> ProfileCompetency;
	 
	public List<ProfileCertification> getpCertification() {
		return pCertification;
	}



	public void setpCertification(List<ProfileCertification> pCertification) {
		this.pCertification = pCertification;
	}



	public DigitalProfile() {
		
	}

	public DigitalProfile(ProjectDetails projectDetails) {
		
		this.projectDetails = projectDetails;
	}


	
	




	/*public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}*/


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public int getEndors() {
		return endors;
	}


	public void setEndors(int endors) {
		this.endors = endors;
	}


	public int getExop() {
		return exop;
	}


	public void setExop(int exop) {
		this.exop = exop;
	}


	


	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}


	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

/*	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}*/

	
	/*public List<Experience> getExperience() {
		return experience;
	}



	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}*/

/*	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}*/
	


	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmpGrade() {
		return empGrade;
	}



	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}



	public String getEmpDesignation() {
		return empDesignation;
	}



	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}



	public Location getBaseBranch() {
		return baseBranch;
	}



	public void setBaseBranch(Location baseBranch) {
		this.baseBranch = baseBranch;
	}



	public int getTcsExp() {
		return tcsExp;
	}



	public void setTcsExp(int tcsExp) {
		this.tcsExp = tcsExp;
	}



	public int getTotalExp() {
		return totalExp;
	}



	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}



	public int getPrevExp() {
		return prevExp;
	}



	public void setPrevExp(int prevExp) {
		this.prevExp = prevExp;
	}



	public String getEmpSummary() {
		return empSummary;
	}



	public void setEmpSummary(String empSummary) {
		this.empSummary = empSummary;
	}



	public String getEmpAchievement() {
		return empAchievement;
	}



	public void setEmpAchievement(String empAchievement) {
		this.empAchievement = empAchievement;
	}



	public String getEmpSoftSkill() {
		return empSoftSkill;
	}



	public void setEmpSoftSkill(String empSoftSkill) {
		this.empSoftSkill = empSoftSkill;
	}



	public String getEmpHardwareSkill() {
		return empHardwareSkill;
	}



	public void setEmpHardwareSkill(String empHardwareSkill) {
		this.empHardwareSkill = empHardwareSkill;
	}



	public String getEmpToolSkill() {
		return empToolSkill;
	}



	public void setEmpToolSkill(String empToolSkill) {
		this.empToolSkill = empToolSkill;
	}



	public String getEmpMethodSkill() {
		return empMethodSkill;
	}



	public void setEmpMethodSkill(String empMethodSkill) {
		this.empMethodSkill = empMethodSkill;
	}



	public String getEmpDomainSkill() {
		return empDomainSkill;
	}



	public void setEmpDomainSkill(String empDomainSkill) {
		this.empDomainSkill = empDomainSkill;
	}



	public String getEmpMgmtSkill() {
		return empMgmtSkill;
	}



	public void setEmpMgmtSkill(String empMgmtSkill) {
		this.empMgmtSkill = empMgmtSkill;
	}



	public String getEmBDSkill() {
		return emBDSkill;
	}



	public void setEmBDSkill(String emBDSkill) {
		this.emBDSkill = emBDSkill;
	}



	public String getEmpEmail() {
		return empEmail;
	}



	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}



	public int getEmpPresentPhone() {
		return empPresentPhone;
	}



	public void setEmpPresentPhone(int empPresentPhone) {
		this.empPresentPhone = empPresentPhone;
	}



	public int getEmpPermanentPhone() {
		return empPermanentPhone;
	}



	public void setEmpPermanentPhone(int empPermanentPhone) {
		this.empPermanentPhone = empPermanentPhone;
	}



	public String getEmpAdditionalDetail() {
		return empAdditionalDetail;
	}



	public void setEmpAdditionalDetail(String empAdditionalDetail) {
		this.empAdditionalDetail = empAdditionalDetail;
	}



	public boolean isEmpMentorFlag() {
		return empMentorFlag;
	}



	public void setEmpMentorFlag(boolean empMentorFlag) {
		this.empMentorFlag = empMentorFlag;
	}



	public boolean isEmpDeputationFlag() {
		return empDeputationFlag;
	}



	public void setEmpDeputationFlag(boolean empDeputationFlag) {
		this.empDeputationFlag = empDeputationFlag;
	}



	public String getGspeedStatus() {
		return gspeedStatus;
	}



	public void setGspeedStatus(String gspeedStatus) {
		this.gspeedStatus = gspeedStatus;
	}



	public String getNinjaStatus() {
		return ninjaStatus;
	}



	public void setNinjaStatus(String ninjaStatus) {
		this.ninjaStatus = ninjaStatus;
	}



	public String getSoftskillStatus() {
		return softskillStatus;
	}



	public void setSoftskillStatus(String softskillStatus) {
		this.softskillStatus = softskillStatus;
	}



	public String getAspirationalRole() {
		return aspirationalRole;
	}



	public void setAspirationalRole(String aspirationalRole) {
		this.aspirationalRole = aspirationalRole;
	}



	public int getGemsPoint() {
		return gemsPoint;
	}



	public void setGemsPoint(int gemsPoint) {
		this.gemsPoint = gemsPoint;
	}



	public int getTfactorScore() {
		return tfactorScore;
	}



	public void setTfactorScore(int tfactorScore) {
		this.tfactorScore = tfactorScore;
	}



	public int getEmpMiles() {
		return empMiles;
	}



	public void setEmpMiles(int empMiles) {
		this.empMiles = empMiles;
	}



	public int getEmpCredits() {
		return empCredits;
	}



	public void setEmpCredits(int empCredits) {
		this.empCredits = empCredits;
	}



	

	public List<ProfileTraining> getProfileTraining() {
		return profileTraining;
	}



	public void setProfileTraining(List<ProfileTraining> profileTraining) {
		this.profileTraining = profileTraining;
	}




	/*public List<DigitalProfileTcsExperience> getDigitalProfileTcsExperience() {
		return digitalProfileTcsExperience;
	}



	public void setDigitalProfileTcsExperience(List<DigitalProfileTcsExperience> digitalProfileTcsExperience) {
		this.digitalProfileTcsExperience = digitalProfileTcsExperience;
	}

*/

	public List<ProfileCompetency> getProfileCompetency() {
		return ProfileCompetency;
	}



	public void setProfileCompetency(List<ProfileCompetency> profileCompetency) {
		ProfileCompetency = profileCompetency;
	}



	public DigitalProfile(int empId, int views, int endors, int exop,
			String empName, String empGrade, String empDesignation, Location baseBranch, int tcsExp, int totalExp,
			int prevExp, String empSummary, String empAchievement, String empSoftSkill, String empHardwareSkill,
			String empToolSkill, String empMethodSkill, String empDomainSkill, String empMgmtSkill, String emBDSkill,
			String empEmail, int empPresentPhone, int empPermanentPhone, String empAdditionalDetail,
			boolean empMentorFlag, boolean empDeputationFlag, String gspeedStatus, String ninjaStatus,
			String softskillStatus, String aspirationalRole, int gemsPoint, int tfactorScore, int empMiles,
			int empCredits, ProjectDetails projectDetails, Status status,
			List<ProfileCertification> pCertification, 
			List<AwardTbl> awardTbl,List<ProfileTraining> profileTraining,
			List<Experience> experience,/* List<DigitalProfileTcsExperience> digitalProfileTcsExperience,*/
			List<com.tcs.org.model.ProfileCompetency> profileCompetency,List<GemsTable> gems,int requirementId,String exitFeedback,String passportNo,String visaNo,Date visaExpDate,Date releaseDate,int freeLance,int badges, List<TcsExperience> tcsExperience,List<Education> education,String role) {
		super();
		this.empId = empId;
	//	this.competencyId = competencyId;
		//this.profeciancyId = profeciancyId;
		this.views = views;
		this.endors = endors;
		this.exop = exop;
		this.empName = empName;
		this.empGrade = empGrade;
		this.empDesignation = empDesignation;
		this.baseBranch = baseBranch;
		this.tcsExp = tcsExp;
		this.totalExp = totalExp;
		this.prevExp = prevExp;
		this.empSummary = empSummary;
		this.empAchievement = empAchievement;
		this.empSoftSkill = empSoftSkill;
		this.empHardwareSkill = empHardwareSkill;
		this.empToolSkill = empToolSkill;
		this.empMethodSkill = empMethodSkill;
		this.empDomainSkill = empDomainSkill;
		this.empMgmtSkill = empMgmtSkill;
		this.emBDSkill = emBDSkill;
		this.empEmail = empEmail;
		this.empPresentPhone = empPresentPhone;
		this.empPermanentPhone = empPermanentPhone;
		this.empAdditionalDetail = empAdditionalDetail;
		this.empMentorFlag = empMentorFlag;
		this.empDeputationFlag = empDeputationFlag;
		this.gspeedStatus = gspeedStatus;
		this.ninjaStatus = ninjaStatus;
		this.softskillStatus = softskillStatus;
		this.aspirationalRole = aspirationalRole;
		this.gemsPoint = gemsPoint;
		this.tfactorScore = tfactorScore;
		this.empMiles = empMiles;
		this.empCredits = empCredits;
		this.projectDetails = projectDetails;
		this.status = status;
		this.pCertification = pCertification;
		this.education = education;
		this.awardTbl=awardTbl;
		//this.profil= aeTraining = profileTraining;
		this.experience = experience;
		//this.digitalProfileTcsExperience = digitalProfileTcsExperience;
		this.ProfileCompetency = profileCompetency;
		this. gems =  gems;
	//	this.reqId = reqId;
		//this.requirementId=requirementId;
		this.exitFeedback=exitFeedback;
		this.passportNo=passportNo;
		this.visaNo=visaNo;
		this.visaExpDate=visaExpDate;
		this.releaseDate=releaseDate;
		this.freeLance=freeLance;
		this.badges=badges;
		this. tcsExperience = tcsExperience;
		this.setRole(role);
		
		
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	


	/*public int getReqId() {
		return reqId;
	}



	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
*/


	/*public Requirement getRequirement() {
		return requirement;
	}



	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}*/
	



	public String getExitFeedback() {
		return exitFeedback;
	}



	public void setExitFeedback(String exitFeedback) {
		this.exitFeedback = exitFeedback;
	}



	public String getPassportNo() {
		return passportNo;
	}



	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}



	public String getVisaNo() {
		return visaNo;
	}



	public void setVisaNo(String visaNo) {
		this.visaNo = visaNo;
	}



	public Date getVisaExpDate() {
		return visaExpDate;
	}



	public void setVisaExpDate(Date visaExpDate) {
		this.visaExpDate = visaExpDate;
	}



	public Date getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	public int getFreeLance() {
		return freeLance;
	}



	public void setFreeLance(int freeLance) {
		this.freeLance = freeLance;
	}



	public int getBadges() {
		return badges;
	}



	public void setBadges(int badges) {
		this.badges = badges;
	}



	public List<TcsExperience> getTcsExperience() {
		return tcsExperience;
	}



	public void setTcsExperience(List<TcsExperience> tcsExperience) {
		this.tcsExperience = tcsExperience;
	}



	public List<Experience> getExperience() {
		return experience;
	}



	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}



	public List<Education> getEducation() {
		return education;
	}



	public void setEducation(List<Education> education) {
		this.education = education;
	}



	public List<GemsTable> getGems() {
		return gems;
	}



	public void setGems(List<GemsTable> gems) {
		this.gems = gems;
	}



	public List<AwardTbl> getAwardTbl() {
		return awardTbl;
	}



	public void setAwardTbl(List<AwardTbl> awardTbl) {
		this.awardTbl = awardTbl;
	}



	/*public int getRequirementId() {
		return requirementId;
	}
	



	public void setRequirementId(int requirementId) {
		this.requirementId = requirementId;
	}
*/


	public Requirement getRequirement() {
		return requirement;
	}



	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}





	
	
	
	
	
}
