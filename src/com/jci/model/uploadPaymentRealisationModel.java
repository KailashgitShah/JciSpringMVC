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
	public uploadPaymentRealisationModel() {
		super();
	}
	public uploadPaymentRealisationModel(int ref_id, String utrNumber, String utrDate, String paymentRealisationFile,
			String createdDate, String transactionid) {
		super();
		this.ref_id = ref_id;
		this.utrNumber = utrNumber;
		this.utrDate = utrDate;
		this.paymentRealisationFile = paymentRealisationFile;
		this.createdDate = createdDate;
		this.transactionid = transactionid;
	}
	@Override
	public String toString() {
		return "uploadPaymentRealisationModel [ref_id=" + ref_id + ", utrNumber=" + utrNumber + ", utrDate=" + utrDate
				+ ", paymentRealisationFile=" + paymentRealisationFile + ", createdDate=" + createdDate
				+ ", transactionid=" + transactionid + "]";
	}

	

}
