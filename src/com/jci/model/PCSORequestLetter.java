package com.jci.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcipcso_gen", schema = "dbo")

public class PCSORequestLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcso_gen_id")
	private int reqId;
	
	@Column(name = "jci_ref_no", length = 100)
	private String reference_no;
	
	@Column(name = "system_qty")
	private double sys_avail_qty;
	
	@Column(name = "req_qty")
	private double req_qty;
	
	@Column(name = "creation_date", length = 30)
	private Date creation_date;
	
	@Column(name = "ReqGenDate", length = 30)
	private String reqGenDate;
	
	@Column(name = "crop_year", length = 255)
	private String cropYear;
	
	@Column(name = "letter_path", length = 255)
	private String letter_path;
	
	@Column(name = "emailStatus")
	private int emailStatus = 0;
	
	@Column(name = "emailSentOn",length = 255)
	private String emailSentOn;
	

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public double getSys_avail_qty() {
		return sys_avail_qty;
	}

	public void setSys_avail_qty(double sys_avail_qty) {
		this.sys_avail_qty = sys_avail_qty;
	}

	public double getReq_qty() {
		return req_qty;
	}

	public void setReq_qty(double req_qty) {
		this.req_qty = req_qty;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getLetter_path() {
		return letter_path;
	}

	public void setLetter_path(String letter_path) {
		this.letter_path = letter_path;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	public String getReqGenDate() {
		return reqGenDate;
	}

	public void setReqGenDate(String reqGenDate) {
		this.reqGenDate = reqGenDate;
	}

	public int getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(int emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getEmailSentOn() {
		return emailSentOn;
	}

	public void setEmailSentOn(String emailSentOn) {
		this.emailSentOn = emailSentOn;
	}	
	
	
}
