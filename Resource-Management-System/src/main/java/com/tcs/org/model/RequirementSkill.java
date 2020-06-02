package com.tcs.org.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
@Table(name="req_skill")
public class RequirementSkill {

/*@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)*/
//private int reqSkillId;
//private int competencyId;

private int proficiencyLevel;
private String role;
@Column(name="compId")
  private int compId;
/*@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
@JoinTable(name="skill_role", joinColumns = @JoinColumn(name="req_skill_id"),inverseJoinColumns= @JoinColumn(name ="role_id"))
private List<Role> roles;*/

/*@OneToOne(cascade = CascadeType.ALL)
private Skill skill;*/

public RequirementSkill() {

}


public RequirementSkill(/*int reqSkillId, int competencyId*/ int proficiencyLevel,String role,int compId/* List<Role> roles, Skill skill*/) {
    super();
    //this.reqSkillId = reqSkillId;
    this.compId = compId;
    this.proficiencyLevel = proficiencyLevel;
    this.role = role;
    //this.skill = skill;
}

/*public int getReqSkillId() {
    return reqSkillId;
}

public void setReqSkillId(int reqSkillId) {
    this.reqSkillId = reqSkillId;
}*/

/*public int getCompetencyId() {
    return competencyId;
}

public void setCompetencyId(int competencyId) {
    this.competencyId = competencyId;
}*/

public int getProficiencyLevel() {
    return proficiencyLevel;
}

public void setProficiencyLevel(int proficiencyLevel) {
    this.proficiencyLevel = proficiencyLevel;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}


public int getCompId() {
    return compId;
}


public void setCompId(int compId) {
    this.compId = compId;
}


/*public Skill getSkill() {
    return skill;
}

public void setSkill(Skill skill) {
    this.skill = skill;
}*/
}

