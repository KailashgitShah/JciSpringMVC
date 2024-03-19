package com.jci.model; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "jcicredit_note" , schema = "dbo")
public class CreditNotes {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Crn_id")
	    private int crnId; //  int PK, AI

		@Column(name = "Credit_note_date", length = 255)
		@NotNull
		private String crnDate;

		
	    @Column(name = "Credit_note_no",length = 255)
	    @NotNull
	    private String crnNo; 
	    
	    
	    @Column(name = "ChallanNo",length = 255)
	    @NotNull
	    private String ChallanNo; 

	    @Column(name = "Shipment_details",length = 255)
	    @NotNull
	    private String shipmentDetails; 
	    
	    @Column(name = "Contract_no",length = 255)
	    @NotNull
	    private String contractNo; 
	    
	    @Column(name = "BOS_qty")
	    @NotNull
	    private Double bosQty; 
	    
	    @Column(name = "Actual_qty")
	    @NotNull
	    private Double actualQty;
	    
	    @Column(name = "Short_qty")
	    @NotNull
	    private Double shortQty; 
	    
	    @Column(name = "Credit_note_amount")
	    @NotNull
	    private Double crnAmount; 
	    
	    @Column(name = "Ro_id")
	    @NotNull
	    private String RoId;

	    @Column(name = "Crn_status")
	    private int crnStatus = 0;

	    @Column(name = "Created_by")
	    private String Created_by;

	    @Column(name = "Creation_date")
	    @NotNull
	    private Date creationDate;
	    
	    @Column(name = "document")
	    private String document;

		public int getCrnId() {
			return crnId;
		}

		public void setCrnId(int crnId) {
			this.crnId = crnId;
		}

		public String getCrnDate() {
			return crnDate;
		}

		public void setCrnDate(String crnDate) {
			this.crnDate = crnDate;
		}

	
		public String getCrnNo() {
			return crnNo;
		}

		public void setCrnNo(String crnNo) {
			this.crnNo = crnNo;
		}

		public String getShipmentDetails() {
			return shipmentDetails;
		}

		public void setShipmentDetails(String shipmentDetails) {
			this.shipmentDetails = shipmentDetails;
		}

		public Double getBosQty() {
			return bosQty;
		}

		public void setBosQty(Double bosQty) {
			this.bosQty = bosQty;
		}

		public Double getActualQty() {
			return actualQty;
		}

		public void setActualQty(Double actualQty) {
			this.actualQty = actualQty;
		}

		public Double getShortQty() {
			return shortQty;
		}

		public void setShortQty(Double shortQty) {
			this.shortQty = shortQty;
		}

		public Double getCrnAmount() {
			return crnAmount;
		}

		public void setCrnAmount(Double crnAmount) {
			this.crnAmount = crnAmount;
		}

		public String getRoId() {
			return RoId;
		}

		public void setRoId(String roId) {
			RoId = roId;
		}

		public int getCrnStatus() {
			return crnStatus;
		}

		public void setCrnStatus(int crnStatus) {
			this.crnStatus = crnStatus;
		}

		public String getCreated_by() {
			return Created_by;
		}

		public void setCreated_by(String created_by) {
			Created_by = created_by;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		
		

		public String getDocument() {
			return document;
		}

		public void setDocument(String document) {
			this.document = document;
		}
		
		

		public String getContractNo() {
			return contractNo;
		}

		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}
		
		

		public String getChallanNo() {
			return ChallanNo;
		}

		public void setChallanNo(String challanNo) {
			ChallanNo = challanNo;
		}

		@Override
		public String toString() {
			return "CreditNotes [crnId=" + crnId + ", crnDate=" + crnDate + ", crnNo=" + crnNo + ", shipmentDetails="
					+ shipmentDetails + ", contractNo=" + contractNo + ", bosQty=" + bosQty + ", actualQty=" + actualQty
					+ ", shortQty=" + shortQty + ", crnAmount=" + crnAmount + ", RoId=" + RoId + ", crnStatus="
					+ crnStatus + ", Created_by=" + Created_by + ", creationDate=" + creationDate + ", document="
					+ document + "]";
		}

		public CreditNotes() {
			super();
			// TODO Auto-generated constructor stub
		}


		
}
