package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciclaim_nomination")
public class Jciclaim_NominationModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Settlement_id")
	private Long Settlement_id; // Primary key, assumed to be BigInt

	@Column(name = "Mill", nullable = false)
	private String Mill;

	@Column(name = "ContractNo", nullable = false)
	private String ContractNo;
	
	@Column(name="HoDi")
	private String  HoDi;
	
	@Column(name="Challans")
	private String Challans;

	@Column(name = "OMOfficial", nullable = false)
	private String OMOfficial;
	
	@Column(name = "FAOfficial")
	private String FAOfficial;

	@Column(name = "DateofInspection", nullable = false)
	private String DateofInspection;
	
	@Column(name = "Inspection_by")
	private String Inspection_by;

	@Column(name = "Inspection_date")
	private String Inspection_date;

	@Column(name = "Dispute_flag", columnDefinition = "INT DEFAULT 0")
	private int Dispute_flag;

	@Column(name = "Created_by", nullable = false)
	private String Created_by;

	@Column(name = "Created_on")
	private String Created_on;
	
	@Column(name = "Settlement_id_generated")
	private String Settlement_id_generated;
	
	@Column(name = "ChallanNo", nullable = false)
	private String ChallanNo;

	@Column(name = "ClaimAmount", nullable = false)
	private double ClaimAmount;
	
	@Column(name = "Mr_number")
	private String Mr_number;
	
	@Column(name = "Mr_Date")
	private String Mr_Date;
	
	@Column(name = "billOfSupply_number")
	private String  billOfSupply_number;
	
	@Column(name = "dateofshipment")
	private String  dateofshipment;
	
	
	@Column(name = "shipmentquantity")
	private String  shipmentquantity;
	
	@Column(name = "claimValuation")
	private String claimValuation;
	

	public String getChallanNo() {
		return ChallanNo;
	}

	public void setChallanNo(String challanNo) {
		ChallanNo = challanNo;
	}

	public double getClaimAmount() {
		return ClaimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		ClaimAmount = claimAmount;
	}

	public Long getSettlement_id() {
		return Settlement_id;
	}

	public void setSettlement_id(Long settlement_id) {
		Settlement_id = settlement_id;
	}

	public String getMill() {
		return Mill;
	}

	public void setMill(String mill) {
		Mill = mill;
	}

	public String getContractNo() {
		return ContractNo;
	}

	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}

	public String getHoDi() {
		return HoDi;
	}

	public void setHoDi(String hoDi) {
		HoDi = hoDi;
	}

	public String getChallans() {
		return Challans;
	}

	public void setChallans(String challans) {
		Challans = challans;
	}

	public String getOMOfficial() {
		return OMOfficial;
	}

	public void setOMOfficial(String oMOfficial) {
		OMOfficial = oMOfficial;
	}

	public String getFAOfficial() {
		return FAOfficial;
	}

	public void setFAOfficial(String fAOfficial) {
		FAOfficial = fAOfficial;
	}

	public String getDateofInspection() {
		return DateofInspection;
	}

	public void setDateofInspection(String dateofInspection) {
		DateofInspection = dateofInspection;
	}

	public String getInspection_by() {
		return Inspection_by;
	}

	public void setInspection_by(String inspection_by) {
		Inspection_by = inspection_by;
	}



	public String getInspection_date() {
		return Inspection_date;
	}

	public void setInspection_date(String inspection_date) {
		Inspection_date = inspection_date;
	}

	public int getDispute_flag() {
		return Dispute_flag;
	}

	public void setDispute_flag(int dispute_flag) {
		Dispute_flag = dispute_flag;
	}

	public String getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}

	public String getCreated_on() {
		return Created_on;
	}

	public void setCreated_on(String created_on) {
		Created_on = created_on;
	}

	public String getSettlement_id_generated() {
		return Settlement_id_generated;
	}

	public void setSettlement_id_generated(String settlement_id_generated) {
		Settlement_id_generated = settlement_id_generated;
	}

	public String getMr_number() {
		return Mr_number;
	}

	public void setMr_number(String mr_number) {
		Mr_number = mr_number;
	}

	public String getMr_Date() {
		return Mr_Date;
	}

	public void setMr_Date(String mr_Date) {
		Mr_Date = mr_Date;
	}

	public String getBillOfSupply_number() {
		return billOfSupply_number;
	}

	public void setBillOfSupply_number(String billOfSupply_number) {
		this.billOfSupply_number = billOfSupply_number;
	}

	public String getDateofshipment() {
		return dateofshipment;
	}

	public void setDateofshipment(String dateofshipment) {
		this.dateofshipment = dateofshipment;
	}

	public String getShipmentquantity() {
		return shipmentquantity;
	}

	public void setShipmentquantity(String shipmentquantity) {
		this.shipmentquantity = shipmentquantity;
	}

	public String getClaimValuation() {
		return claimValuation;
	}

	public void setClaimValuation(String claimValuation) {
		this.claimValuation = claimValuation;
	}

	

}
