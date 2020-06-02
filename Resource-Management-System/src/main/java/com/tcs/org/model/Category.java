package com.tcs.org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tcs.org.audit.AuditableEntity;

@Entity
@Table(name="category")
public class Category /*extends AuditableEntity*/ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String catType;
	private String valueName;
	private int valueId;
	
	
	public Category() {
	}

	public Category(int id, String catType, String catValue, int catId) {
		this.id = id;
		this.catType = catType;
		this.valueName = catValue;
		this.valueId = catId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public int getValueId() {
		return valueId;
	}

	public void setValueId(int valueId) {
		this.valueId = valueId;
	}


}