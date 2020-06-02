package com.tcs.org.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.tcs.org.audit.AuditableEntity;

@Entity
public class Status /*extends AuditableEntity*/ {
/*   @Id
	private int id;
	public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}*/

	
   @Id
   @Column(name="statusId_pk")
	private int statusId;
	
	private String statusName;
	
	
/*	@ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "profile_status", joinColumns= {@JoinColumn(name="statusId")})
	 @Column(name="empId")//,insertable=false)
	private List<Integer> empId;*/



	public Status(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	 
		//this.digitalProfile=new DigitalProfile(digitalProfileId,digitalProfileId, digitalProfileId, digitalProfileId, null, statusName, statusName, null) ;
	}


	public Status() {
		
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


/*	public List<Integer> getEmpId() {
		return empId;
	}


	public void setEmpId(List<Integer> empId) {
		this.empId = empId;
	}
*/

	/*public DigitalProfile getDigitalProfile() {
		return digitalProfile;
	}


	public void setDigitalProfile(DigitalProfile digitalProfile) {
		this.digitalProfile = digitalProfile;
	}
	*/
	
	
	

}
