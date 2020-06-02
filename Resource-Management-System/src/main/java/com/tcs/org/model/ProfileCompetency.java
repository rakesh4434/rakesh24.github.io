package com.tcs.org.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import com.tcs.org.audit.AuditableEntity;

@Embeddable
@Table(name="digital_competency")
public class ProfileCompetency /*extends AuditableEntity*/ {

// private String DigitalProfileAwardTblId;

private int profeciancyID;
private double score;

@Column(name="compId")
  private int compId;

public ProfileCompetency(int profeciancyID, double score, int compId) {
    super();
    this.profeciancyID = profeciancyID;
    this.score = score;
    this.compId = compId;
}

public ProfileCompetency() {
    super();
}

public int getProfeciancyID() {
    return profeciancyID;
}

public void setProfeciancyID(int profeciancyID) {
    this.profeciancyID = profeciancyID;
}

public double getScore() {
    return score;
}

public void setScore(double score) {
    this.score = score;
}

public int getCompId() {
    return compId;
}

public void setCompId(int compId) {
    this.compId = compId;
}
}