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

import com.tcs.org.audit.AuditableEntity;

@Entity
public class Education /*extends AuditableEntity*/ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int qualificationId;
	private String subject;
	private double grade;
	private String university;
	
	/*@ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "profile_education", joinColumns= {@JoinColumn(name="qualificationId")})
	 @Column(name="empId")//,insertable=false)
	private List<Integer> empId;*/
	public Education( int qualificationId, String subject, double grade, String university) {
		super();
		//this.empId = employeeId;
		this.qualificationId = qualificationId;
		this.subject = subject;
		this.grade = grade;
		this.university = university;
	}
	
	public Education(){
		
	}

	/*public int getEmployeeId() {
		return empId;
	}

	public void setEmployeeId(int employeeId) {
		this.empId = employeeId;
	}*/

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	
	
	
			

}
