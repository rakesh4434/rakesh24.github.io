package com.tcs.org.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tcs.org.audit.AuditableEntity;

@Entity
@Table(name="proj_details")
public class ProjectDetails /*extends AuditableEntity*/ {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
    @Size(max = 100)
	private String projectName;
    @Size(max = 100)
	private String IOU;
    @Size(max = 100)
	private String customerName;
    @Size(max = 100)
	private String projectType;
    @Size(max = 100)
	private String spName;
    private int projectDetailsId;
    @Lob
    private String projectDescription;
    @Lob
    private String technicalStackHardware;
    @Lob
    private String technicalStackSoftware;

    
	
	public ProjectDetails(int projectDetailsId) {
		super();
		this.projectDetailsId = projectDetailsId;
	}
	public ProjectDetails() {
		
	}
	public ProjectDetails( @NotNull @Size(max = 100) String projectName, @Size(max = 100) String iOU,
			@Size(max = 100) String customerName, @Size(max = 100) String projectType, @Size(max = 100) String spName, int id, String projectDescription, String technicalStackHardware,String technicalStackSoftware ) {
		super();
		this.id=id;
		this.projectName = projectName;
		this.IOU = iOU;
		this.customerName = customerName;
		this.projectType = projectType;
		this.spName = spName;
		this.technicalStackSoftware = technicalStackSoftware;
		this.technicalStackHardware = technicalStackHardware;
		this.projectDescription = projectDescription;
	}
	/*public int getProjectId() {
		return id;
	}
	public void setId(int projectId) {
		this.id = projectId;
	}*/
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getIOU() {
		return IOU;
	}
	public void setIOU(String iOU) {
		IOU = iOU;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		
		this.projectType = projectType;
	}
	public String getSpName() {
		
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
/*	public int getId() {
		return id;
	}*/
	public int getProjectDetailsId() {
		return projectDetailsId;
	}
	public void setProjectDetailsId(int projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getTechnicalStackHardware() {
		return technicalStackHardware;
	}
	public void setTechnicalStackHardware(String technicalStackHardware) {
		this.technicalStackHardware = technicalStackHardware;
	}
	public String getTechnicalStackSoftware() {
		return technicalStackSoftware;
	}
	public void setTechnicalStackSoftware(String technicalStackSoftware) {
		this.technicalStackSoftware = technicalStackSoftware;
	}


}
