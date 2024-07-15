package com.jci.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicredit_note_settled", schema = "dbo")
public class CreditNoteSettled {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Crn_id", unique = true)
	private int id;
	
	@Column(name = "Credit_note_date")
	private String creditNoteDate;
	
	@Column(name = "Credit_note_no")
	private String creditNoteNo;
	
	@Column(name = "Contract_No")
	private String ContractNo;
	
	@Column(name = "HoDi_No")
	private String hoDiNo;
	
	@Column(name = "Challan_No")
	private String ChallanNo;
	
	@Column(name = "Bales")
	private int bales;
	
	
	@Column(name = "Variety_grade")
	private String varityGrade;
	
	@Column(name = "Mr_no")
	private String mrNo;
	
	@Column(name = "Mr_date")
	private String mrDate;

	@Column(name = "Settlement_amt")
	private Double settlementAmt;
	
	@Column(name = "Credit_note_amt")
	private Double creditNoteAmt;
	
	@Column(name = "Ro_id")
	private String roId;
	
	@Column(name = "gstCode")
	private String gstCode;
	
	@Column(name = "Crn_status")
	private int crnStatus;

	@Column(name = "Created_by")
	private String createdBy;
	
	@Column(name = "Creation_date")
	private String creationDate;
	
	@Column(name = "doc")
	private String doc;
	
	@Column(name = "SettlementId")
	private String settlemetId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditNoteDate() {
		return creditNoteDate;
	}

	public void setCreditNoteDate(String creditNoteDate) {
		this.creditNoteDate = creditNoteDate;
	}

	public String getCreditNoteNo() {
		return creditNoteNo;
	}

	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}

	public String getContractNo() {
		return ContractNo;
	}

	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}

	public String getHoDiNo() {
		return hoDiNo;
	}

	public void setHoDiNo(String hoDiNo) {
		this.hoDiNo = hoDiNo;
	}

	public String getChallanNo() {
		return ChallanNo;
	}

	public void setChallanNo(String challanNo) {
		ChallanNo = challanNo;
	}

	public int getBales() {
		return bales;
	}

	public void setBales(int bales) {
		this.bales = bales;
	}

	public String getVarityGrade() {
		return varityGrade;
	}

	public void setVarityGrade(String varityGrade) {
		this.varityGrade = varityGrade;
	}

	public String getMrNo() {
		return mrNo;
	}

	public void setMrNo(String mrNo) {
		this.mrNo = mrNo;
	}

	public String getMrDate() {
		return mrDate;
	}

	public void setMrDate(String mrDate) {
		this.mrDate = mrDate;
	}

	public Double getSettlementAmt() {
		return settlementAmt;
	}

	public void setSettlementAmt(Double settlementAmt) {
		this.settlementAmt = settlementAmt;
	}

	public Double getCreditNoteAmt() {
		return creditNoteAmt;
	}

	public void setCreditNoteAmt(Double creditNoteAmt) {
		this.creditNoteAmt = creditNoteAmt;
	}

	public String getRoId() {
		return roId;
	}

	public void setRoId(String roId) {
		this.roId = roId;
	}

	public String getGstCode() {
		return gstCode;
	}

	public void setGstCode(String gstCode) {
		this.gstCode = gstCode;
	}

	public int getCrnStatus() {
		return crnStatus;
	}

	public void setCrnStatus(int crnStatus) {
		this.crnStatus = crnStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	

	public String getSettlemetId() {
		return settlemetId;
	}

	public void setSettlemetId(String settlemetId) {
		this.settlemetId = settlemetId;
	}

	@Override
	public String toString() {
		return "CreditNoteSettled [id=" + id + ", creditNoteDate=" + creditNoteDate + ", creditNoteNo=" + creditNoteNo
				+ ", ContractNo=" + ContractNo + ", hoDiNo=" + hoDiNo + ", ChallanNo=" + ChallanNo + ", bales=" + bales
				+ ", varityGrade=" + varityGrade + ", mrNo=" + mrNo + ", mrDate=" + mrDate + ", settlementAmt="
				+ settlementAmt + ", creditNoteAmt=" + creditNoteAmt + ", roId=" + roId + ", gstCode=" + gstCode
				+ ", crnStatus=" + crnStatus + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", doc="
				+ doc + ", settlemetId=" + settlemetId + "]";
	}
	
}
