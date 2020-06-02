package com.tcs.org.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

//import org.hibernate.annotations.Entity;

//import org.hibernate.annotations.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
public class TcsExperience /*extends AuditableEntity*/ {
@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
private int roleId;
// private int digitalId;
private int projectId;
private Date startDate;
private Date endDate;
//private int roleId;
private String responsibility;
private String technicalSkill;
private String achievement;
// private int empId;

/* @JsonIgnore
 @ElementCollection(targetClass=Integer.class)
 @CollectionTable(name = "digital_Tcs_Experience", joinColumns= {@JoinColumn(name="roleId")})
 @Column(name="EmpId")//,insertable=false)
private List<Integer> empId;


@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//@JoinColumn(name = DigitalId)
private DigitalProfile digitalProfile;*/

public TcsExperience(int projectId, Date startDate, Date endDate, int roleId, String responsibility,
        String technicalSkill, String achievement, int empId,DigitalProfile  digitalProfile) {
    super();
    //this.digitalId = digitalId;
    this.projectId = projectId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.roleId = roleId;
    this.responsibility = responsibility;
    this.technicalSkill = technicalSkill;
    this.achievement = achievement;
    //this.empId = empId;
    //this.digitalProfile = digitalProfile;
}
public TcsExperience() {
    super();
}
public int getProjectId() {
    return projectId;
}
public void setProjectId(int projectId) {
    this.projectId = projectId;
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
public String getResponsibility() {
    return responsibility;
}
public void setResponsibility(String responsibility) {
    this.responsibility = responsibility;
}
public String getTechnicalSkill() {
    return technicalSkill;
}
public void setTechnicalSkill(String technicalSkill) {
    this.technicalSkill = technicalSkill;
}
public String getAchievement() {
    return achievement;
}
public void setAchievement(String achievement) {
    this.achievement = achievement;
}
/*public int getEmpId() {
    return empId;
}
public void setEmpId(int empId) {
    this.empId = empId;
}

public DigitalProfile getDigitalProfile() {
    return digitalProfile;
}
public void setDigitalProfile(DigitalProfile digitalProfile) {
    this.digitalProfile = digitalProfile;
}*/
/*public List<Integer> getEmpId() {
    return empId;
}
public void setEmpId(List<Integer> empId) {
    this.empId = empId;
}*/
}