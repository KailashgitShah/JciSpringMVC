package com.jci.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "jciclaim_report_mill", schema = "dbo")
public class ConfirmationClaimSettlementModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "Settlement_id")
	private String Settlement_id;

	@Column(name = "Mill")
	private String Mill;

	@Column(name = "Contract_No")
	private String Contract_No;

	@Column(name = "Challan_No")
	private String Challan_No;

	@Column(name = "Claim_Amount")
	private Double Claim_Amount;

	@Column(name = "OM_Official")
	private String OM_Official;

	@Column(name = "FA_Official")
	private String FA_Official;

	@Column(name = "Date_of_Inspection")
	private Date Date_of_Inspection;

	@Column(name = "Quality_settlement")
	private Double Quality_settlement;

	@Column(name = "Moisture_settlement")
	private Double Moisture_settlement;
	@Column(name = "Dust_settlement")
	private Double Dust_settlement;
	@Column(name = "Ncv_settlement")
	private Double Ncv_settlement;

	@Column(name = "Settlement_amt")
	private Double Settlement_amt;

	@Column(name = "Inspection_by ")
	private String Inspection_by;

	@Column(name = "Supporting_doc")
	private String Supporting_doc;
	
	@Column(name = "FA_doc")
	private String FA_doc;
	
	@Column(name = "Dispute_flag")
	private int Dispute_flag;

	@Column(name = "Created_by")
	private String Created_by;

	@Column(name = "Created_on")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date Created_on;
	
	@Column(name = "Active")
	private String Active;
	
	@Column(name = "Mill_Acc")
	private String Mill_Acc;
	
	@Column(name = "Jute_Variety")
	private String Jute_Variety;
	
	@Column(name = "Jute_Grade")
	private String Jute_Grade;
	
	public String getJute_Variety() {
		return Jute_Variety;
	}

	public void setJute_Variety(String jute_Variety) {
		Jute_Variety = jute_Variety;
	}

	public String getJute_Grade() {
		return Jute_Grade;
	}

	public void setJute_Grade(String jute_Grade) {
		Jute_Grade = jute_Grade;
	}

	public String getMill_Acc() {
		return Mill_Acc;
	}

	public void setMill_Acc(String mill_Acc) {
		Mill_Acc = mill_Acc;
	}

	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		Active = active;
	}


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSettlement_id() {
		return Settlement_id;
	}

	public void setSettlement_id(String settlement_id) {
		Settlement_id = settlement_id;
	}

	public String getMill() {
		return Mill;
	}

	public void setMill(String mill) {
		Mill = mill;
	}

	public String getContract_No() {
		return Contract_No;
	}

	public void setContract_No(String contract_No) {
		Contract_No = contract_No;
	}

	public String getChallan_No() {
		return Challan_No;
	}

	public void setChallan_No(String challan_No) {
		Challan_No = challan_No;
	}

	public Double getClaim_Amount() {
		return Claim_Amount;
	}

	public void setClaim_Amount(Double claim_Amount) {
		Claim_Amount = claim_Amount;
	}

	public String getOM_Official() {
		return OM_Official;
	}

	public void setOM_Official(String oM_Official) {
		OM_Official = oM_Official;
	}

	public String getFA_Official() {
		return FA_Official;
	}

	public void setFA_Official(String fA_Official) {
		FA_Official = fA_Official;
	}

	public Date getDate_of_Inspection() {
		return Date_of_Inspection;
	}

	public void setDate_of_Inspection(Date date_of_Inspection) {
		Date_of_Inspection = date_of_Inspection;
	}

	public Double getQuality_settlement() {
		return Quality_settlement;
	}

	public void setQuality_settlement(Double quality_settlement) {
		Quality_settlement = quality_settlement;
	}

	public Double getMoisture_settlement() {
		return Moisture_settlement;
	}

	public void setMoisture_settlement(Double moisture_settlement) {
		Moisture_settlement = moisture_settlement;
	}

	public Double getNcv_settlement() {
		return Ncv_settlement;
	}

	public void setNcv_settlement(Double ncv_settlement) {
		Ncv_settlement = ncv_settlement;
	}

	public Double getSettlement_amt() {
		return Settlement_amt;
	}

	public void setSettlement_amt(Double settlement_amt) {
		Settlement_amt = settlement_amt;
	}

	public String getInspection_by() {
		return Inspection_by;
	}

	public void setInspection_by(String inspection_by) {
		Inspection_by = inspection_by;
	}

	public String getSupporting_doc() {
		return Supporting_doc;
	}

	public void setSupporting_doc(String supporting_doc) {
		Supporting_doc = supporting_doc;
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

	public Date getCreated_on() {
		return Created_on;
	}

	public void setCreated_on(Date created_on) {
		Created_on = created_on;
	}

	public Double getDust_settlement() {
		return Dust_settlement;
	}

	public void setDust_settlement(Double dust_settlement) {
		Dust_settlement = dust_settlement;
	}

	public String getFA_doc() {
		return FA_doc;
	}

	public void setFA_doc(String fA_doc) {
		FA_doc = fA_doc;
	}

	@Override
	public String toString() {
		return "ConfirmationClaimSettlementModel [id=" + id + ", Settlement_id=" + Settlement_id + ", Mill=" + Mill
				+ ", Contract_No=" + Contract_No + ", Challan_No=" + Challan_No + ", Claim_Amount=" + Claim_Amount
				+ ", OM_Official=" + OM_Official + ", FA_Official=" + FA_Official + ", Date_of_Inspection="
				+ Date_of_Inspection + ", Quality_settlement=" + Quality_settlement + ", Moisture_settlement="
				+ Moisture_settlement + ", Dust_settlement=" + Dust_settlement + ", Ncv_settlement=" + Ncv_settlement
				+ ", Settlement_amt=" + Settlement_amt + ", Inspection_by=" + Inspection_by + ", Supporting_doc="
				+ Supporting_doc + ", FA_doc=" + FA_doc + ", Dispute_flag=" + Dispute_flag + ", Created_by="
				+ Created_by + ", Created_on=" + Created_on + ", Active=" + Active + ", Mill_Acc=" + Mill_Acc
				+ ", Jute_Variety=" + Jute_Variety + ", Jute_Grade=" + Jute_Grade + "]";
	}

	public ConfirmationClaimSettlementModel(int id, String settlement_id, String mill, String contract_No,
			String challan_No, Double claim_Amount, String oM_Official, String fA_Official, Date date_of_Inspection,
			Double quality_settlement, Double moisture_settlement, Double dust_settlement, Double ncv_settlement,
			Double settlement_amt, String inspection_by, String supporting_doc, String fA_doc, int dispute_flag,
			String created_by, Date created_on, String active, String mill_Acc, String jute_Variety,
			String jute_Grade) {
		super();
		this.id = id;
		Settlement_id = settlement_id;
		Mill = mill;
		Contract_No = contract_No;
		Challan_No = challan_No;
		Claim_Amount = claim_Amount;
		OM_Official = oM_Official;
		FA_Official = fA_Official;
		Date_of_Inspection = date_of_Inspection;
		Quality_settlement = quality_settlement;
		Moisture_settlement = moisture_settlement;
		Dust_settlement = dust_settlement;
		Ncv_settlement = ncv_settlement;
		Settlement_amt = settlement_amt;
		Inspection_by = inspection_by;
		Supporting_doc = supporting_doc;
		FA_doc = fA_doc;
		Dispute_flag = dispute_flag;
		Created_by = created_by;
		Created_on = created_on;
		Active = active;
		Mill_Acc = mill_Acc;
		Jute_Variety = jute_Variety;
		Jute_Grade = jute_Grade;
	}

	public ConfirmationClaimSettlementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	

	
}
