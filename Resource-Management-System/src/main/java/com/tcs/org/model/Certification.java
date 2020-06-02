package com.tcs.org.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
public class Certification /*extends AuditableEntity*/ {
	@Id
   // @GeneratedValue
	private int certificationId;
	private String name;
	private int category;
	
	 @JsonIgnore
	 @ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "profile_certification", joinColumns= {@JoinColumn(name="certificationId")})
	 @Column(name="empId")//,insertable=false)
	private List<Integer> empId;
	
	public Certification(List<Integer> empId) {
		super();
		this.empId = empId;
	}

	public Certification(int certificationId, String name, int category) {
		super();
		this.certificationId = certificationId;
		this.name = name;
		this.category = category;
		
	}
	
	public Certification()
	{
		
	}
	
	
/*
	public int getId() {
		return Id;
	}

	public Certification(int id) {
		super();
		Id = id;
	}
*/
	/*public void setId(int id) {
		Id = id;
	}
*/
	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public List<Integer> getEmpId() {
		return empId;
	}

	public void setEmpId(List<Integer> empId) {
		this.empId = empId;
	}



	

}
