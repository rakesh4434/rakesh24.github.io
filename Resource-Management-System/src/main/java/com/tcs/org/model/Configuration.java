package com.tcs.org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int configurationId;
	private String parameter;
	private double weightage;
	public Configuration(int configurationId, String parameter, double weightage) {
		super();
		this.configurationId = configurationId;
		this.parameter = parameter;
		this.weightage = weightage;
	}
	public Configuration() {
		super();
	}
	public int getConfigurationId() {
		return configurationId;
	}
	public void setConfigurationId(int configurationId) {
		this.configurationId = configurationId;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public double getWeightage() {
		return weightage;
	}
	public void setWeightage(double weightage) {
		this.weightage = weightage;
	}
	
	
	

}
