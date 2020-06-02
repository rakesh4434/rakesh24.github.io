package com.tcs.org.model;


	
	

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;

import com.tcs.org.audit.AuditableEntity;

    @Entity
	public class GemsTable /*extends AuditableEntity*/ {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int gemsId;
		private Date date;
		@Lob
		private String appreciation;
		@Lob
		private String givenBy;
		
		
		public GemsTable() {
			
		}

		public GemsTable( Date date, String appreciation, String givenBy,int gemsId,List<Integer> empId) {
			
			//this.empId = empId;
			this.gemsId=gemsId;
			this.date = date;
			this.appreciation = appreciation;
			this.givenBy = givenBy;
			//this.empId=empId;
		}


		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getAppreciation() {
			return appreciation;
		}

		public void setAppreciation(String appreciation) {
			this.appreciation = appreciation;
		}

		public String getGivenBy() {
			return givenBy;
		}

		public void setGivenBy(String givenBy) {
			this.givenBy = givenBy;
		}

		public int getGemsId() {
			return gemsId;
		}

		public void setGemsId(int gemsId) {
			this.gemsId = gemsId;
		}

	
		

	}
