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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
public class AwardTbl /*extends AuditableEntity*/ {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int awardId;
	private String awardName;
//	private int empId;
	private String category;
	private String subCategory;
	private Date receivedOn;
	
	
	
	
	
	
	public AwardTbl(int awardId, String awardName,  String category, String subCategory, Date receivedOn) {
		super();
		this.awardId = awardId;
		this.awardName = awardName;
	//	this.empId = empId;
		this.category = category;
		this.subCategory = subCategory;
		this.receivedOn = receivedOn;
	}
	
	public AwardTbl() {
		
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	/*public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}*/

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Date getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}

	

/*	public List<Integer> getId() {
		return id;
	}

	public void setId(List<Integer> id) {
		this.id = id;
	}
	*/
	
	
 
}
