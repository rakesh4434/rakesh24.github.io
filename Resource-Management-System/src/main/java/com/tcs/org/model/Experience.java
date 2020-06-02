package com.tcs.org.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tcs.org.audit.AuditableEntity;

@Entity
public class Experience /*extends AuditableEntity*/ {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	private String organisationName;
	private Date startDate;
	private Date endDate;
	/*
	@ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "profile_experience", joinColumns= {@JoinColumn(name="roleId")})
	 @Column(name="empId")//,insertable=false)
	private List<Integer> empId;
	
*/


	public Experience( String organisationName, Date startDate, Date endDate, int roleId) {

		//this.empId = empId;
		this.organisationName = organisationName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roleId = roleId;
		//this.digitalProfile=digitalProfile;
	}
	public Experience()
	{
		
	}
	
	public String getOrganisationName() {
		return organisationName;
	}
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/*public DigitalProfile getDigitalProfile() {
		return digitalProfile;
	}

	public void setDigitalProfile(DigitalProfile digitalProfile) {
		this.digitalProfile = digitalProfile;
	}
*/



	
	
	
}
