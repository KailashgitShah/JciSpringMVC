package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jcitds_entry", schema = "dbo")
public class JciEntryTdsModel {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Declaration_id")
	    private Long Declaration_id ; // Primary key, assumed to be BigInt
  
	    @Column(name = "Mill", nullable = false) 
	    private String Mill; 
	  
	   
	    @Column(name = "Financial_year", nullable = false)
	    private String Financial_year;
	    
	    @Column(name = "Date_of_Intimation", nullable = false)
	    private String Date_of_Intimation;
	    
	    @Column(name = "Supporting_document", nullable = false)
	    private String Supporting_document;

		public Long getDeclaration_id() {
			return Declaration_id;
		}

		public void setDeclaration_id(Long declaration_id) {
			Declaration_id = declaration_id;
		}

		public String getMill() {
			return Mill;
		}

		public void setMill(String mill) {
			Mill = mill;
		}

		public String getFinancial_year() {
			return Financial_year;
		}

		public void setFinancial_year(String financial_year) {
			Financial_year = financial_year;
		}

		public String getDate_of_Intimation() {
			return Date_of_Intimation;
		}

		public void setDate_of_Intimation(String date_of_Intimation) {
			Date_of_Intimation = date_of_Intimation;
		}

		public String getSupporting_document() {
			return Supporting_document;
		}

		public void setSupporting_document(String supporting_document) {
			Supporting_document = supporting_document;
		}

		@Override
		public String toString() {
			return "JciEntryTdsModel [Declaration_id=" + Declaration_id + ", Mill=" + Mill + ", Financial_year="
					+ Financial_year + ", Date_of_Intimation=" + Date_of_Intimation + ", Supporting_document="
					+ Supporting_document + "]";
		}
	    
}
