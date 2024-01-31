package com.jci.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jcipayment_arrangement", schema = "dbo")
public class EntryPaymentDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "Payment_id")
	private int Payment_id;
	
	@Column(name = "Instrument_No")
	private String Instrumentno;
	
	@Column(name = "Contract_No")
	private String contractno;
	
	@Column(name = "Instrument_Date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date instdate;
	
	@Column(name = "ifsc")
	private String IFSC;
	
	@Column(name = "branch")
	private String Branch ;
	
	@Column(name = "bank")
	private String BankName ;
	
	@Column(name = "Payment_type")
	private String payment ;
	
	@Column(name = "Instrument_value")
	private String InstrumentValue;
	
	@Column(name = "Expiry_date")
	//@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateofexpiry ;
	
	@Column(name = "Last_shipment_date")
	//@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateofship;
	
	@Column(name = "Auto_revolving_amount")
	private String autorevolvingamount ;
	
	
	
	@Column(name = "Supporting_document")
	private String SupportingDocument ;
	
	@Column(name = "Fc_status")
	private int Fc_status ;
	
	@Column(name = "Fc_remarks")
	private String Fc_remarks ;
	
	@Column(name = "Fc_action_date")
	private Date Fc_action_date ;
	
	@Column(name = "Created_date")
	private Date Created_date ;

	public int getPayment_id() {
		return Payment_id;
	}

	public void setPayment_id(int payment_id) {
		Payment_id = payment_id;
	}

	public String getInstrumentno() {
		return Instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		Instrumentno = instrumentno;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public Date getInstdate() {
		return instdate;
	}

	public void setInstdate(Date date1) {
		this.instdate = date1;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getInstrumentValue() {
		return InstrumentValue;
	}

	public void setInstrumentValue(String instrumentValue) {
		InstrumentValue = instrumentValue;
	}

	public Date getDateofexpiry() {
		return dateofexpiry;
	}

	public void setDateofexpiry(Date dateofexpiry) {
		this.dateofexpiry = dateofexpiry;
	}

	public Date getDateofship() {
		return dateofship;
	}

	public void setDateofship(Date dateofship) {
		this.dateofship = dateofship;
	}

	public String getAutorevolvingamount() {
		return autorevolvingamount;
	}

	public void setAutorevolvingamount(String autorevolvingamount) {
		this.autorevolvingamount = autorevolvingamount;
	}

	

	public String getSupportingDocument() {
		return SupportingDocument;
	}

	public void setSupportingDocument(String supportingDocument) {
		SupportingDocument = supportingDocument;
	}

	public int getFc_status() {
		return Fc_status;
	}

	public void setFc_status(int fc_status) {
		Fc_status = fc_status;
	}

	public String getFc_remarks() {
		return Fc_remarks;
	}

	public void setFc_remarks(String fc_remarks) {
		Fc_remarks = fc_remarks;
	}

	public Date getFc_action_date() {
		return Fc_action_date;
	}

	public void setFc_action_date(Date fc_action_date) {
		Fc_action_date = fc_action_date;
	}

	public Date getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(Date created_date) {
		Created_date = created_date;
	}

	public EntryPaymentDetailsModel(int payment_id, String instrumentno, String contractno, Date instdate, String iFSC,
			String branch, String bankName, String payment, String instrumentValue, Date dateofexpiry, Date dateofship,
			String autorevolvingamount, String qtyAllowed, String supportingDocument, int fc_status,
			String fc_remarks, Date fc_action_date, Date created_date) {
		super();
		Payment_id = payment_id;
		Instrumentno = instrumentno;
		this.contractno = contractno;
		this.instdate = instdate;
		IFSC = iFSC;
		Branch = branch;
		BankName = bankName;
		this.payment = payment;
		InstrumentValue = instrumentValue;
		this.dateofexpiry = dateofexpiry;
		this.dateofship = dateofship;
		this.autorevolvingamount = autorevolvingamount;
		SupportingDocument = supportingDocument;
		Fc_status = fc_status;
		Fc_remarks = fc_remarks;
		Fc_action_date = fc_action_date;
		Created_date = created_date;
	}

	public EntryPaymentDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EntryPaymentDetailsModel [Payment_id=" + Payment_id + ", Instrumentno=" + Instrumentno + ", contractno="
				+ contractno + ", instdate=" + instdate + ", IFSC=" + IFSC + ", Branch=" + Branch + ", BankName="
				+ BankName + ", payment=" + payment + ", InstrumentValue=" + InstrumentValue + ", dateofexpiry="
				+ dateofexpiry + ", dateofship=" + dateofship + ", autorevolvingamount=" + autorevolvingamount
				+ ", SupportingDocument=" + SupportingDocument + ", Fc_status="
				+ Fc_status + ", Fc_remarks=" + Fc_remarks + ", Fc_action_date=" + Fc_action_date + ", Created_date="
				+ Created_date + "]";
	}
	
	
	
	
	
}
