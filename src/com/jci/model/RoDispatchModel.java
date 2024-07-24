package com.jci.model;
import javax.persistence.*;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name = "jciDI_ro")
public class RoDispatchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DI_RO_ID")
    private int diRoId; // Big int PK, AI

  

	@Column(name = "RO_DI_No", length = 255)
    private String roDiNo; // RO DI No Varchar Unique
	
    @Column(name = "HO_DI_No", nullable = false,length = 255)
    @NotNull
    private String hoDiNo; // HO DI No. Varchar NN
	
	@Column(name = "HO_DI_DATE",  length = 50)
	private String HoDiDate; // HO DI No Varchar Unique

    @Column(name = "RO_DI_Date", nullable = false)
    @NotNull
    private String roDiDate; // RO DI Date Server date NN

    @Column(name = "Contract_No", nullable = false,length = 255)
    @NotNull
    private String ContractNo; //Contract No. Varchar NN
    
    @Column(name = "Crop_Year", nullable = false,length = 20)
    @NotNull
    private String CropYear; //Contract No. Varchar NN
    
    @Column(name = "Contract_Date", nullable = false,length = 50)
    @NotNull
    private String ContractDate; //Contract No. Varchar NN
    
    @Column(name = "Last_Date_Of_Shipment", nullable = false,length = 50)
    @NotNull
    private String lastDateOfShipment; //Contract No. Varchar NN
    
    @Column(name = "Jute_Variety", nullable = false,length = 100)
    @NotNull
    private String JuteVariety; //Contract No. Varchar NN
    
    @Column(name = "Remarks", nullable = false,length = 255)
    @NotNull
    private String Remarks; //Contract No. Varchar NN

    @Column(name = "Gr1_qty", nullable = false)
    @NotNull
    private Double gr1Qty = 0.0; // Gr1_qty Double 0.0

    @Column(name = "Gr2_qty", nullable = false)
    @NotNull
    private Double gr2Qty = 0.0; // Gr2_qty Double 0.0

    @Column(name = "Gr3_qty", nullable = false)
    @NotNull
    private Double gr3Qty = 0.0; // Gr3_qty Double 0.0

    @Column(name = "Gr4_qty", nullable = false)
    @NotNull
    private Double gr4Qty = 0.0; // Gr4_qty Double 0.0

    @Column(name = "Gr5_qty", nullable = false)
    @NotNull
    private Double gr5Qty = 0.0; // Gr5_qty Double 0.0

    @Column(name = "Gr6_qty", nullable = false)
    @NotNull
    private Double gr6Qty = 0.0; // Gr6_qty Double 0.0

    @Column(name = "Gr7_qty", nullable = false)
    @NotNull
    private Double gr7Qty = 0.0; // Gr7_qty Double 0.0

    @Column(name = "Gr8_qty", nullable = false)
    @NotNull
    private Double gr8Qty = 0.0; // Gr8_qty Double 0.0

    @Column(name = "Creation_date", nullable = false)
    @NotNull
    private Date creationDate; // Creation_date Timestamp CurrentTime stamp

    @Column(name = "DPC", nullable = false,length = 20)
    @NotNull
    private String dpc; //Contract No. Varchar NN
    
    
  	public String getDpc() {
		return dpc;
	}

	public void setDpc(String dpc) {
		this.dpc = dpc;
	}

	public int getDiRoId() {
  		return diRoId;
  	}

  	public void setDiRoId(int diRoId) {
  		this.diRoId = diRoId;
  	}

  	public String getRoDiNo() {
  		return roDiNo;
  	}

  	public void setRoDiNo(String roDiNo) {
  		this.roDiNo = roDiNo;
  	}

  	public String getRoDiDate() {
  		return roDiDate;
  	}

  	public void setRoDiDate(String roDiDate) {
  		this.roDiDate = roDiDate;
  	}

  	public String getHoDiNo() {
  		return hoDiNo;
  	}

  	public void setHoDiNo(String hoDiNo) {
  		this.hoDiNo = hoDiNo;
  	}

  	public Double getGr1Qty() {
  		return gr1Qty;
  	}

  	public void setGr1Qty(Double gr1Qty) {
  		this.gr1Qty = gr1Qty;
  	}

  	public Double getGr2Qty() {
  		return gr2Qty;
  	}

  	public void setGr2Qty(Double gr2Qty) {
  		this.gr2Qty = gr2Qty;
  	}

  	public Double getGr3Qty() {
  		return gr3Qty;
  	}

  	public void setGr3Qty(Double gr3Qty) {
  		this.gr3Qty = gr3Qty;
  	}

  	public Double getGr4Qty() {
  		return gr4Qty;
  	}

  	public void setGr4Qty(Double gr4Qty) {
  		this.gr4Qty = gr4Qty;
  	}

  	public Double getGr5Qty() {
  		return gr5Qty;
  	}

  	public void setGr5Qty(Double gr5Qty) {
  		this.gr5Qty = gr5Qty;
  	}

  	public Double getGr6Qty() {
  		return gr6Qty;
  	}

  	public void setGr6Qty(Double gr6Qty) {
  		this.gr6Qty = gr6Qty;
  	}

  	public Double getGr7Qty() {
  		return gr7Qty;
  	}

  	public void setGr7Qty(Double gr7Qty) {
  		this.gr7Qty = gr7Qty;
  	}

  	public Double getGr8Qty() {
  		return gr8Qty;
  	}

  	public void setGr8Qty(Double gr8Qty) {
  		this.gr8Qty = gr8Qty;
  	}

  	public Date getCreationDate() {
  		return creationDate;
  	}

  	public void setCreationDate(Date creationDate) {
  		this.creationDate = creationDate;
  	}

	public String getHoDiDate() {
		return HoDiDate;
	}

	public void setHoDiDate(String hoDiDate) {
		HoDiDate = hoDiDate;
	}

	public String getContractNo() {
		return ContractNo;
	}

	public void setContractNo(String contractNo) {
		ContractNo = contractNo;
	}

	public String getCropYear() {
		return CropYear;
	}

	public void setCropYear(String cropYear) {
		CropYear = cropYear;
	}

	public String getContractDate() {
		return ContractDate;
	}

	public void setContractDate(String contractDate) {
		ContractDate = contractDate;
	}

	public String getLastDateOfShipment() {
		return lastDateOfShipment;
	}

	public void setLastDateOfShipment(String lastDateOfShipment) {
		this.lastDateOfShipment = lastDateOfShipment;
	}

	public String getJuteVariety() {
		return JuteVariety;
	}

	public void setJuteVariety(String juteVariety) {
		JuteVariety = juteVariety;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	

	public RoDispatchModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RoDispatchModel [diRoId=" + diRoId + ", roDiNo=" + roDiNo + ", hoDiNo=" + hoDiNo + ", HoDiDate="
				+ HoDiDate + ", roDiDate=" + roDiDate + ", ContractNo=" + ContractNo + ", CropYear=" + CropYear
				+ ", ContractDate=" + ContractDate + ", lastDateOfShipment=" + lastDateOfShipment + ", JuteVariety="
				+ JuteVariety + ", Remarks=" + Remarks + ", gr1Qty=" + gr1Qty + ", gr2Qty=" + gr2Qty + ", gr3Qty="
				+ gr3Qty + ", gr4Qty=" + gr4Qty + ", gr5Qty=" + gr5Qty + ", gr6Qty=" + gr6Qty + ", gr7Qty=" + gr7Qty
				+ ", gr8Qty=" + gr8Qty + ", creationDate=" + creationDate + ", dpc=" + dpc + "]";
	}

	


  
}
