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


	
	
	@Column(name = "CAD_Date")
	private Date CAD_Date;

	@Column(name = "BOS_No" )
	private String BOS_No;
	
	
	@Column(name = "BOS_Date")
	private String BOS_Date;

	
	@Column(name = "bOEDOCpathnonlc")
	private String bOEDOCpathnonlc;

	@Column(name = "contarctNo")
	private String contarctNo;
	
	@Column(name = "millcode")
	private String millcode;
	
	@Column(name = "invoicevalue")
	private String invoicevalue;
	
	
	



	public String getInvoicevalue() {
		return invoicevalue;
	}


	public void setInvoicevalue(String invoicevalue) {
		this.invoicevalue = invoicevalue;
	}


	public String getContarctNo() {
		return contarctNo;
	}


	public void setContarctNo(String contarctNo) {
		this.contarctNo = contarctNo;
	}


	public String getMillcode() {
		return millcode;
	}


	public void setMillcode(String millcode) {
		this.millcode = millcode;
	}


	public String getbOEDOCpathnonlc() {
		return bOEDOCpathnonlc;
	}


	public void setbOEDOCpathnonlc(String bOEDOCpathnonlc) {
		this.bOEDOCpathnonlc = bOEDOCpathnonlc;
	}


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
