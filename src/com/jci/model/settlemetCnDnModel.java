package com.jci.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcisettlement_cndn", schema = "dbo")
public class settlemetCnDnModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Initiation_ref_no;
	
	@Column(name = "millCode")
	private String millCode;
	
	@Column(name = "Contract_no")
	private String contractNo;
	
	@Column(name = "Credit_note_no")
	private String creditNoteNo;
	
	@Column(name = "dateOfIssue")
	private String dateOfIssue;
	
	@Column(name = "hodi")
	private String hodi;
	
	@Column(name = "consigneeNoteText")
	private String consigneeNoteText;
	
	@Column(name = "bosNo")
	private String bosNo;
	
	@Column(name = "dateOfShipment")
	private String dateOfShipment;
	
	@Column(name = "dateOfInspection")
	private String dateOfInspection;
	
	@Column(name = "creditNoteAmount")
	private String creditNoteAmount;
	
	@Column(name = "settlementId")
	private String settlementId;
	
	@Column(name = "consigneeDoc")
	private String consigneeDoc;
	
	@Column(name = "BosDoc")
	private String BosDoc;
	
	@Column(name = "creditNoteDoc")
	private String creditNoteDoc;
	
	@Column(name = "create_date_cndn")
	private String create_date_cndn;
	@Column(name = "AmountDiffCnAndDn")
	private Double AmountDiffCnAndDn;
	
	
	@Column(name = "cndnExcel_link")
	private String cndnExcel_link;
	
	@Column(name = "RowNumber")
	private Integer RowNumber;
	
	private String IdentificationCnDn;
	
	
	
	
	
	public settlemetCnDnModel() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getInitiation_ref_no() {
		return Initiation_ref_no;
	}




	public void setInitiation_ref_no(int initiation_ref_no) {
		Initiation_ref_no = initiation_ref_no;
	}




	




	public String getContractNo() {
		return contractNo;
	}




	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}




	public String getCreditNoteNo() {
		return creditNoteNo;
	}




	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}




	public String getDateOfIssue() {
		return dateOfIssue;
	}




	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}




	public String getHodi() {
		return hodi;
	}




	public void setHodi(String hodi) {
		this.hodi = hodi;
	}




	public String getConsigneeNoteText() {
		return consigneeNoteText;
	}




	public void setConsigneeNoteText(String consigneeNoteText) {
		this.consigneeNoteText = consigneeNoteText;
	}




	public String getBosNo() {
		return bosNo;
	}




	public void setBosNo(String bosNo) {
		this.bosNo = bosNo;
	}




	public String getDateOfShipment() {
		return dateOfShipment;
	}




	public void setDateOfShipment(String dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}




	public String getDateOfInspection() {
		return dateOfInspection;
	}




	public void setDateOfInspection(String dateOfInspection) {
		this.dateOfInspection = dateOfInspection;
	}




	public String getCreditNoteAmount() {
		return creditNoteAmount;
	}




	public void setCreditNoteAmount(String creditNoteAmount) {
		this.creditNoteAmount = creditNoteAmount;
	}




	public String getSettlementId() {
		return settlementId;
	}




	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}




	public String getConsigneeDoc() {
		return consigneeDoc;
	}




	public void setConsigneeDoc(String consigneeDoc) {
		this.consigneeDoc = consigneeDoc;
	}




	public String getBosDoc() {
		return BosDoc;
	}




	public void setBosDoc(String bosDoc) {
		BosDoc = bosDoc;
	}




	public String getCreditNoteDoc() {
		return creditNoteDoc;
	}




	public void setCreditNoteDoc(String creditNoteDoc) {
		this.creditNoteDoc = creditNoteDoc;
	}




	public String getMillCode() {
		return millCode;
	}




	public void setMillCode(String millCode) {
		this.millCode = millCode;
	}




	public String getCreate_date_cndn() {
		return create_date_cndn;
	}




	public void setCreate_date_cndn(String create_date_cndn) {
		this.create_date_cndn = create_date_cndn;
	}




	



	public Double getAmountDiffCnAndDn() {
		return AmountDiffCnAndDn;
	}




	public void setAmountDiffCnAndDn(Double amountDiffCnAndDn) {
		AmountDiffCnAndDn = amountDiffCnAndDn;
	}
     
	

    

	public String getCndnExcel_link() {
		return cndnExcel_link;
	}




	public void setCndnExcel_link(String cndnExcel_link) {
		this.cndnExcel_link = cndnExcel_link;
	}




	public Integer getRowNumber() {
		return RowNumber;
	}




	public void setRowNumber(Integer rowNumber) {
		RowNumber = rowNumber;
	}




	public String getIdentificationCnDn() {
		return IdentificationCnDn;
	}




	public void setIdentificationCnDn(String identificationCnDn) {
		IdentificationCnDn = identificationCnDn;
	}




	public settlemetCnDnModel(int initiation_ref_no, String millCode, String contractNo, String creditNoteNo,
			String dateOfIssue, String hodi, String consigneeNoteText, String bosNo, String dateOfShipment,
			String dateOfInspection, String creditNoteAmount, String settlementId, String consigneeDoc, String bosDoc,
			String creditNoteDoc, String create_date_cndn, Double amountDiffCnAndDn, String cndnExcel_link,
			Integer rowNumber, String identificationCnDn) {
		super();
		Initiation_ref_no = initiation_ref_no;
		this.millCode = millCode;
		this.contractNo = contractNo;
		this.creditNoteNo = creditNoteNo;
		this.dateOfIssue = dateOfIssue;
		this.hodi = hodi;
		this.consigneeNoteText = consigneeNoteText;
		this.bosNo = bosNo;
		this.dateOfShipment = dateOfShipment;
		this.dateOfInspection = dateOfInspection;
		this.creditNoteAmount = creditNoteAmount;
		this.settlementId = settlementId;
		this.consigneeDoc = consigneeDoc;
		BosDoc = bosDoc;
		this.creditNoteDoc = creditNoteDoc;
		this.create_date_cndn = create_date_cndn;
		AmountDiffCnAndDn = amountDiffCnAndDn;
		this.cndnExcel_link = cndnExcel_link;
		RowNumber = rowNumber;
		IdentificationCnDn = identificationCnDn;
	}




	@Override
	public String toString() {
		return "settlemetCnDnModel [Initiation_ref_no=" + Initiation_ref_no + ", millCode=" + millCode + ", contractNo="
				+ contractNo + ", creditNoteNo=" + creditNoteNo + ", dateOfIssue=" + dateOfIssue + ", hodi=" + hodi
				+ ", consigneeNoteText=" + consigneeNoteText + ", bosNo=" + bosNo + ", dateOfShipment=" + dateOfShipment
				+ ", dateOfInspection=" + dateOfInspection + ", creditNoteAmount=" + creditNoteAmount
				+ ", settlementId=" + settlementId + ", consigneeDoc=" + consigneeDoc + ", BosDoc=" + BosDoc
				+ ", creditNoteDoc=" + creditNoteDoc + ", create_date_cndn=" + create_date_cndn + ", AmountDiffCnAndDn="
				+ AmountDiffCnAndDn + ", cndnExcel_link=" + cndnExcel_link + ", RowNumber=" + RowNumber
				+ ", IdentificationCnDn=" + IdentificationCnDn + "]";
	}




	
	
}
