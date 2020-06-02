package com.tcs.org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tcs.org.audit.AuditableEntity;

@Entity
@Table(name="job_Description")
public class JobDescription /*extends AuditableEntity*/ {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jdId;
	private String skillsMustHave;
	private String skillsGoodToHave;
	private String keyResponsibilities;
	private String keywords;
	
	public JobDescription() {
		
	}
	
	public JobDescription(int jdId, String skillsMustHave, String skillsGoodToHave, String keyResponsibilities,
			String keywords) {
		
		this.jdId = jdId;
		this.skillsMustHave = skillsMustHave;
		this.skillsGoodToHave = skillsGoodToHave;
		this.keyResponsibilities = keyResponsibilities;
		this.keywords = keywords;
	}
	public int getJdId() {
		return jdId;
	}
	public void setJdId(int jdId) {
		this.jdId = jdId;
	}
	public String getSkillsMustHave() {
		return skillsMustHave;
	}
	public void setSkillsMustHave(String skillsMustHave) {
		this.skillsMustHave = skillsMustHave;
	}
	public String getSkillsGoodToHave() {
		return skillsGoodToHave;
	}
	public void setSkillsGoodToHave(String skillsGoodToHave) {
		this.skillsGoodToHave = skillsGoodToHave;
	}
	public String getKeyResponsibilities() {
		return keyResponsibilities;
	}
	public void setKeyResponsibilities(String keyResponsibilities) {
		this.keyResponsibilities = keyResponsibilities;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}	
	
	
	
	
	