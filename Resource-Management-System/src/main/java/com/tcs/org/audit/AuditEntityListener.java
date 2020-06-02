package com.tcs.org.audit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tcs.org.model.AuditDetails;
import com.tcs.org.repository.AuditRepository;

public class AuditEntityListener {
	
	 @Autowired(required = true)
	 @Qualifier("AuditRepository")
	  private static  AuditRepository auditRepository;
	
	 @Autowired(required = true)
	 @Qualifier("AuditDetails")
	 private static AuditDetails auditObj;
	
		  @PostPersist
	    public void postPersist(Object target) { 
		   perform(target, "INSERTED");
		  
	  	}
	    @PostUpdate
	    public void postUpdate(Object target) { perform(target, "UPDATED"); }
	    @PostRemove
	    public void postRemove(Object target) { perform(target, "DELETED"); }
	    
	    
	    private void perform(Object obj, String action) {
	    	if (obj.getClass().isAnnotationPresent(Audited.class)) {

	    		Annotation annotation = obj.getClass().getAnnotation(Audited.class);
	    		Audited testerInfo = (Audited) annotation;

	    		System.out.println("auditTableName : "+ testerInfo.auditTableName());
	    		
	    		
	    		if(action.equalsIgnoreCase("INSERTED")) {
	    			auditObj.setAction(action);
	    			auditObj.setModifiedBy("admin");
	    			auditRepository.save(auditObj);
		    		
		    	}else if(action.equalsIgnoreCase("UPDATED")) {
		    		
		    		
		    	}else if(action.equalsIgnoreCase("DELETED")) {
		    		
		    		
		    	}
	    		
	    	
	    	}
	    	

	    }
}
