package com.tcs.org.model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.jboss.logging.Logger;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity

@EntityListeners(AuditingEntityListener.class)
public class AuditDetails {
	/*private static Logger logger=Logger.getLogger(AuditDetails.class);
	public enum OPERATION {
	    INSERT, UPDATE, DELETE;
	    private String value;

	    OPERATION() {
	        value = toString();
	    }

	    public String getValue() {
	        return value;
	    }

	    public static OPERATION parse(final String value) {
	        OPERATION operation = null;
	        for (final OPERATION op : OPERATION.values()) {
	            if (op.getValue().equals(value)) {
	                operation = op;
	                break;
	            }
	        }
	        return operation;
	    }
	};*/

	@Id
	@GeneratedValue
	int id;
	int referenceNo;
	String tableName;
	String fieldName;
	//@LastModifiedBy
	String  oldValue;
	//@CreatedBy
	String newValue;
	String action;
	String modifiedOn;
	String modifiedBy;
	@Column(name = "operation")
	private String operation;

	@Column(name = "timestamp")
	private long timestamp;
	/*
	public OPERATION getOperation() {
	    return OPERATION.parse(operation);
	}

	public void setOperation(final OPERATION operation) {
	    this.operation = operation.getValue();
	}*/
	
	public long getTimestamp() {
	    return timestamp;
	}

	public void setTimestamp(final long timestamp) {
	    this.timestamp = timestamp;
	}
	
	public void setOperation(final String operation) {
	    this.operation = operation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/*@PrePersist
	public void onPrePersist() {
	    logger.info("@PrePersist");
	    audit(OPERATION.INSERT);
	}

	@PreUpdate
	public void onPreUpdate() {
	    logger.info("@PreUpdate");
	    audit(OPERATION.UPDATE);
	}

	@PreRemove
	public void onPreRemove() {
	    logger.info("@PreRemove");
	    audit(OPERATION.DELETE);
	}

	private void audit(final OPERATION operation) {
	    setOperation(operation);
	    setTimestamp((new Date()).getTime());
	}
	*/
	
}
