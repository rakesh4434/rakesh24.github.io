package com.tcs.org.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

@Entity
public class Request {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int requestId;
	private String status;
	/*ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	private List<Requirement> requirement;*/
	
	/*@Nullable
	@ManyToMany(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	@JoinColumn(name = "requirement_id")
    private List<Requirement> requirement;*/
	/*
	@ElementCollection
    @CollectionTable(name="req_skill", joinColumns= {@JoinColumn(name="id")})
private List<RequirementSkill> reqSkill;*/
/*	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "request_id")
	private List<Requirement> requirement;*/
	 /*@ManyToOne
	    private Requirement requirement;*/
	
	
	public Request() {
		super();
	}
	
	
	
	public Request(int requestId, String status, List<Requirement> requirement) {
		super();
		this.requestId = requestId;
		this.status = status;
		//this.requirement=requirement;
		
	}



	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



/*	public List<Requirement> getRequirement() {
		return requirement;
	}



	public void setRequirement(List<Requirement> requirement) {
		this.requirement = requirement;
	}*/
}
