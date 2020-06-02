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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
public class Training /*extends AuditableEntity*/ {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int trainId;

	private String trainName;
	private int passScore;
	
	 @JsonIgnore
	 @ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "digital_training", joinColumns= {@JoinColumn(name="trainId")})
	 @Column(name="empId")//,insertable=false)
	private List<Integer> empId;
	 
	 public Training() {
		 
	 }
	public Training(List<Integer> empId, int trainId, String trainName, int passScore) {
		super();
		this.empId = empId;
		this.trainId = trainId;
		this.trainName = trainName;
		this.passScore = passScore;
	}


	


	public int getTrainId() {
		return trainId;
	}


	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}


	public String getTrainName() {
		return trainName;
	}


	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}


	public int getPassScore() {
		return passScore;
	}


	public void setPassScore(int passScore) {
		this.passScore = passScore;
	}





	public List<Integer> getEmpId() {
		return empId;
	}





	public void setEmpId(List<Integer> empId) {
		this.empId = empId;
	}
	
	
	

}
