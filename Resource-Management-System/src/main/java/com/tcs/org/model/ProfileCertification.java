package com.tcs.org.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Table;

import com.tcs.org.audit.AuditableEntity;

@Embeddable
@Table(name="profile_certification")
public class ProfileCertification /*extends AuditableEntity*/ {
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;*/
	private Date acquiredDate;
	private Date expiryDate;
	private int version;
	private double score;
	
	
	
	
	public ProfileCertification(Date acquiredDate, Date expiryDate, int version, double score) {
		super();
		this.acquiredDate = acquiredDate;
		this.expiryDate = expiryDate;
		this.version = version;
		this.score = score;
	}






	private int certificationId;
	
	public ProfileCertification(int certificationId) {
		
		this.setCertificationId(certificationId);
	}

	public ProfileCertification()
	{
		
	}



	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}
	
	public Date getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
}


