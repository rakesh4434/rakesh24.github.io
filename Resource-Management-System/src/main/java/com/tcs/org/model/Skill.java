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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcs.org.audit.AuditableEntity;

@Entity
@Table(name="skill")
public class Skill /*extends AuditableEntity<String>*/ /*extends AuditableEntity*/{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int compId;
private String competencyName;
private String competencyType;
private int categorizationId;
private int subCategorizationId;
private int subSubCategorizationId;
private int competencyTypeId;
private String categorization;
private String subCategorization;
private String subSubCategorization;
 @JsonIgnore
 @ElementCollection(targetClass=Integer.class)
 @CollectionTable(name = "req_skill", joinColumns= {@JoinColumn(name="compId")})
 @Column(name="id")//,insertable=false)
private List<Integer> id;

 @JsonIgnore
 @ElementCollection(targetClass=Integer.class)
 @CollectionTable(name = "digital_competency", joinColumns= {@JoinColumn(name="compId")})
 @Column(name="empId")//,insertable=false)
private List<Integer> empId;


public Skill() {

}


public Skill(int compId, String competencyName, String competencyType, int categorizationId,
        int subCategorizationId, int subSubCategorizationId, int competencyTypeId, String categorization,
        String subCategorization, String subSubCategorization) {
    super();
    this.compId = compId;
    this.competencyName = competencyName;
    this.competencyType = competencyType;
    this.categorizationId = categorizationId;
    this.subCategorizationId = subCategorizationId;
    this.subSubCategorizationId = subSubCategorizationId;
    this.competencyTypeId = competencyTypeId;
    this.categorization = categorization;
    this.subCategorization = subCategorization;
    this.subSubCategorization = subSubCategorization;
}


public int getCompId() {
    return compId;
}


public void setCompId(int compId) {
    this.compId = compId;
}


public String getCompetencyName() {
    return competencyName;
}


public void setCompetencyName(String competencyName) {
    this.competencyName = competencyName;
}


public String getCompetencyType() {
    return competencyType;
}


public void setCompetencyType(String competencyType) {
    this.competencyType = competencyType;
}


public int getCategorizationId() {
    return categorizationId;
}


public void setCategorizationId(int categorizationId) {
    this.categorizationId = categorizationId;
}


public int getSubCategorizationId() {
    return subCategorizationId;
}


public void setSubCategorizationId(int subCategorizationId) {
    this.subCategorizationId = subCategorizationId;
}


public int getSubSubCategorizationId() {
    return subSubCategorizationId;
}


public void setSubSubCategorizationId(int subSubCategorizationId) {
    this.subSubCategorizationId = subSubCategorizationId;
}


public int getCompetencyTypeId() {
    return competencyTypeId;
}


public void setCompetencyTypeId(int competencyTypeId) {
    this.competencyTypeId = competencyTypeId;
}


public String getCategorization() {
    return categorization;
}


public void setCategorization(String categorization) {
    this.categorization = categorization;
}


public String getSubCategorization() {
    return subCategorization;
}


public void setSubCategorization(String subCategorization) {
    this.subCategorization = subCategorization;
}


public String getSubSubCategorization() {
    return subSubCategorization;
}


public void setSubSubCategorization(String subSubCategorization) {
    this.subSubCategorization = subSubCategorization;
}


public List<Integer> getId() {
    return id;
}


public void setId(List<Integer> id) {
    this.id = id;
}


public List<Integer> getEmpId() {
    return empId;
}


public void setEmpId(List<Integer> empId) {
    this.empId = empId;
}
}

