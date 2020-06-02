package com.tcs.org.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//import com.example.polls.model.Role;
import com.tcs.org.audit.AuditableEntity;
import com.tcs.org.audit.DateAudit;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "user_master")


public class User   {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(unique=true)
	private String username;
	private String password;
	//@JsonIgnore
	private String textPassword;
	private String email;
	private String status;
	private String accountName;
	private String iou;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_projectDetails",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "projectDetails_id"))
  private List<ProjectDetails> projectDetails;
	
	/* @ElementCollection(targetClass=Integer.class)
	 @CollectionTable(name = "deal_users", joinColumns= {@JoinColumn(name="users")})
	 @Column(name="deal_deal_id")//,insertable=false)
	private List<Integer> dealId;*/
	
	public User() {
		
	}
	
	public User(int userId, String email, String password, String status, String textPassword, String username,String accountName,String iou) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.textPassword=textPassword;
		this.email = email;
		this.status = status;
		this.accountName=accountName;
		this.iou=iou;
		//this.projectDetails = projectDetails;
		//this.roles = roles;
	}
	


		public User(Set<Role> roles) {
		super();
		this.roles = roles;
	}
		
		public User(List<ProjectDetails> projectDetails) {
			super();
			this.projectDetails = projectDetails;
		}

/*	public User(String userId, String email, String password, String status, String textPassword,
				String username) {
		this.userId=Integer.parseInt(userId);
		this.username = username;
		this.password = password;
		this.textPassword=textPassword;
		this.email = email;
		this.status = status;
			
		}
*/
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/*public List<Integer> getDealId() {
		return dealId;
	}

	public void setDealId(List<Integer> dealId) {
		this.dealId = dealId;
	}*/

	public String getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(String textPassword) {
		this.textPassword = textPassword;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getIou() {
		return iou;
	}

	public void setIou(String iou) {
		this.iou = iou;
	}

	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}

	
	

}
