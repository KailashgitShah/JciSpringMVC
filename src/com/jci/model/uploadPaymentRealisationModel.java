package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciuploadpaymentRealisation", schema = "dbo")
public class uploadPaymentRealisationModel {
	@Id
	@Column(name="ref_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ref_id;
	
	private String utrNumber;
	private String utrDate;
	private String paymentRealisationFile;
    private String createdDate;
	private String transactionid;
    private String millcode;
    private String contractno;
    private String millName;
   
   
	
	public int getRef_id() {
		return ref_id;
	}
	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}
	public String getUtrNumber() {
		return utrNumber;
	}
	public void setUtrNumber(String utrNumber) {
		this.utrNumber = utrNumber;
	}
	public String getUtrDate() {
		return utrDate;
	}
	public void setUtrDate(String utrDate) {
		this.utrDate = utrDate;
	}
	public String getPaymentRealisationFile() {
		return paymentRealisationFile;
	}
	public void setPaymentRealisationFile(String paymentRealisationFile) {
		this.paymentRealisationFile = paymentRealisationFile;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	
	public String getMillcode() {
		return millcode;
	}
	public void setMillcode(String millcode) {
		this.millcode = millcode;
	}
	public String getContractno() {
		return contractno;
	}
	public void setContractno(String contractno) {
		this.contractno = contractno;
	}
	
	public String getMillName() {
		return millName;
	}
	public void setMillName(String millName) {
		this.millName = millName;
	}
	public uploadPaymentRealisationModel() {
		super();
	}
	public uploadPaymentRealisationModel(int ref_id, String utrNumber, String utrDate, String paymentRealisationFile,
			String createdDate, String transactionid, String millcode, String contractno, String millName) {
		super();
		this.ref_id = ref_id;
		this.utrNumber = utrNumber;
		this.utrDate = utrDate;
		this.paymentRealisationFile = paymentRealisationFile;
		this.createdDate = createdDate;
		this.transactionid = transactionid;
		this.millcode = millcode;
		this.contractno = contractno;
		this.millName = millName;
	}
	@Override
	public String toString() {
		return "uploadPaymentRealisationModel [ref_id=" + ref_id + ", utrNumber=" + utrNumber + ", utrDate=" + utrDate
				+ ", paymentRealisationFile=" + paymentRealisationFile + ", createdDate=" + createdDate
				+ ", transactionid=" + transactionid + ", millcode=" + millcode + ", contractno=" + contractno
				+ ", millName=" + millName + "]";
	}
	

	

}
