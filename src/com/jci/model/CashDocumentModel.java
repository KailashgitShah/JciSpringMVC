package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jcicash_document", schema = "dbo")
public class CashDocumentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAD_Doc_No" )
	private int CAD_Doc_No ;


	
	
	@Column(name = "CAD_Date",nullable = false)
	private Date CAD_Date;

	@Column(name = "BOS_No" ,nullable = false)
	private String BOS_No;
	
	
	@Column(name = "BOS_Date", nullable = false)
	private String BOS_Date;


	


	public int getCAD_Doc_No() {
		return CAD_Doc_No;
	}


	public void setCAD_Doc_No(int cAD_Doc_No) {
		CAD_Doc_No = cAD_Doc_No;
	}


	public Date getCAD_Date() {
		return CAD_Date;
	}


	public void setCAD_Date(Date cAD_Date) {
		CAD_Date = cAD_Date;
	}


	public String getBOS_No() {
		return BOS_No;
	}


	public void setBOS_No(String bOS_No) {
		BOS_No = bOS_No;
	}


	public String getBOS_Date() {
		return BOS_Date;
	}


	public void setBOS_Date(String bOS_Date2) {
		BOS_Date = bOS_Date2;
	}


	public CashDocumentModel(int cAD_Doc_id, int cAD_Doc_No, Date cAD_Date, String bOS_No, String bOS_Date) {
		super();
		
		CAD_Doc_No = cAD_Doc_No;
		CAD_Date = cAD_Date;
		BOS_No = bOS_No;
		BOS_Date = bOS_Date;
	}


	public CashDocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CashDocumentModel [ CAD_Doc_No=" + CAD_Doc_No + ", CAD_Date=" + CAD_Date
				+ ", BOS_No=" + BOS_No + ", BOS_Date=" + BOS_Date + "]";
	}

	


	

	
}
