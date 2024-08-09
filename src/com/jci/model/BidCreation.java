package com.jci.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="jcibid_creation" , schema="dbo")
public class BidCreation {

@Id
@Column(name = "Bid_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int Bid_id;
              
@Column(name = "bid_reference_no") 
public String BidRefNo;

@Column(name = "bid_date")
public String BidDate;

@Column(name = "bid_closing_date")
public String BidClosingDate;

@Column(name = "security_deposit_amount")
public double SecurityDepositAmt;

@Column(name = "day_to_deposit_amount")
public int DaystodepositAmt;

@Column(name = "delivery_period")
public int DeliveryPeriod;

@Column(name = "provision_claim")
public int ProvisionofClaim;

@Column(name = "lot_identification")
public String LotId;

@Column(name = "Contract_type")
public String Contract_type;

@Column(name = "bid_roll_out")
public int BidRollOut;

@Column(name = "Created_by")
public String Created_by;

@Column(name = "day_to_accept")
public int day_to_accept;

@Column(name = "Creation_date")
public Date Creation_date;


@Transient
public String BifRefFromSubmittion;

@Column(name = "basis")
public String Basis;

@Column(name = "updation_date")
public Date UpdateDate;

@Column(name = "ActiveDoc")
public String ActiveDoc;


@Column(name = "CompletedDoc")
public String CompletedDoc;


public BidCreation(int bid_id, String bidRefNo, String bidDate, String bidClosingDate, double securityDepositAmt,
                             int daystodepositAmt, int deliveryPeriod, int provisionofClaim, String lotId, String contract_type,
                             int bidRollOut, String created_by, int day_to_accept, Date creation_date, String bifRefFromSubmittion,
                             String basis, Date updateDate) {
              super();
              Bid_id = bid_id;
              BidRefNo = bidRefNo;
              BidDate = bidDate;
              BidClosingDate = bidClosingDate;
              SecurityDepositAmt = securityDepositAmt;
              DaystodepositAmt = daystodepositAmt;
              DeliveryPeriod = deliveryPeriod;
              ProvisionofClaim = provisionofClaim;
              LotId = lotId;
              Contract_type = contract_type;
              BidRollOut = bidRollOut;
              Created_by = created_by;
              this.day_to_accept = day_to_accept;
              Creation_date = creation_date;
              BifRefFromSubmittion = bifRefFromSubmittion;
              Basis = basis;
              UpdateDate = updateDate;
}



public int getBid_id() {
              return Bid_id;
}



public void setBid_id(int bid_id) {
              Bid_id = bid_id;
}



public BidCreation(int bid_id, String bidRefNo, String bidDate, String bidClosingDate, double securityDepositAmt,
                             int daystodepositAmt, int deliveryPeriod, int provisionofClaim, String lotId, String contract_type,
                             int bidRollOut, String created_by, int day_to_accept, Date creation_date, String bifRefFromSubmittion,
                             String basis, Date updateDate, String activeDoc, String completedDoc) {
              super();
              Bid_id = bid_id;
              BidRefNo = bidRefNo;
              BidDate = bidDate;
              BidClosingDate = bidClosingDate;
              SecurityDepositAmt = securityDepositAmt;
              DaystodepositAmt = daystodepositAmt;
              DeliveryPeriod = deliveryPeriod;
              ProvisionofClaim = provisionofClaim;
              LotId = lotId;
              Contract_type = contract_type;
              BidRollOut = bidRollOut;
              Created_by = created_by;
              this.day_to_accept = day_to_accept;
              Creation_date = creation_date;
              BifRefFromSubmittion = bifRefFromSubmittion;
              Basis = basis;
              UpdateDate = updateDate;
              ActiveDoc = activeDoc;
              CompletedDoc = completedDoc;
}



public String getActiveDoc() {
              return ActiveDoc;
}



public void setActiveDoc(String activeDoc) {
              ActiveDoc = activeDoc;
}



public String getCompletedDoc() {
              return CompletedDoc;
}



public void setCompletedDoc(String completedDoc) {
              CompletedDoc = completedDoc;
}



public String getBidRefNo() {
              return BidRefNo;
}



public void setBidRefNo(String bidRefNo) {
              BidRefNo = bidRefNo;
}



public String getBidDate() {
              return BidDate;
}



public void setBidDate(String bidDate) {
              BidDate = bidDate;
}



public String getBidClosingDate() {
              return BidClosingDate;
}



public void setBidClosingDate(String bidClosingDate) {
              BidClosingDate = bidClosingDate;
}



public double getSecurityDepositAmt() {
              return SecurityDepositAmt;
}



public void setSecurityDepositAmt(double securityDepositAmt) {
              SecurityDepositAmt = securityDepositAmt;
}



public int getDaystodepositAmt() {
              return DaystodepositAmt;
}



public void setDaystodepositAmt(int daystodepositAmt) {
              DaystodepositAmt = daystodepositAmt;
}



public int getDeliveryPeriod() {
              return DeliveryPeriod;
}



public void setDeliveryPeriod(int deliveryPeriod) {
              DeliveryPeriod = deliveryPeriod;
}



public int getProvisionofClaim() {
              return ProvisionofClaim;
}



public void setProvisionofClaim(int provisionofClaim) {
              ProvisionofClaim = provisionofClaim;
}



public String getLotId() {
              return LotId;
}



public void setLotId(String lotId) {
              LotId = lotId;
}



public String getContract_type() {
              return Contract_type;
}



public void setContract_type(String contract_type) {
              Contract_type = contract_type;
}



public int getBidRollOut() {
              return BidRollOut;
}



public void setBidRollOut(int bidRollOut) {
              BidRollOut = bidRollOut;
}



public String getCreated_by() {
              return Created_by;
}



public void setCreated_by(String created_by) {
              Created_by = created_by;
}



public int getDay_to_accept() {
              return day_to_accept;
}



public void setDay_to_accept(int day_to_accept) {
              this.day_to_accept = day_to_accept;
}



public Date getCreation_date() {
              return Creation_date;
}



public void setCreation_date(Date creation_date) {
              Creation_date = creation_date;
}



public String getBifRefFromSubmittion() {
              return BifRefFromSubmittion;
}



public void setBifRefFromSubmittion(String bifRefFromSubmittion) {
              BifRefFromSubmittion = bifRefFromSubmittion;
}



public String getBasis() {
              return Basis;
}



public void setBasis(String basis) {
              Basis = basis;
}



public Date getUpdateDate() {
              return UpdateDate;
}



public void setUpdateDate(Date updateDate) {
              UpdateDate = updateDate;
}



@Override
public String toString() {
              return "BidCreation [Bid_id=" + Bid_id + ", BidRefNo=" + BidRefNo + ", BidDate=" + BidDate + ", BidClosingDate="
                                           + BidClosingDate + ", SecurityDepositAmt=" + SecurityDepositAmt + ", DaystodepositAmt=" + DaystodepositAmt
                                           + ", DeliveryPeriod=" + DeliveryPeriod + ", ProvisionofClaim=" + ProvisionofClaim + ", LotId=" + LotId
                                           + ", Contract_type=" + Contract_type + ", BidRollOut=" + BidRollOut + ", Created_by=" + Created_by
                                           + ", day_to_accept=" + day_to_accept + ", Creation_date=" + Creation_date + ", BifRefFromSubmittion="
                                           + BifRefFromSubmittion + ", Basis=" + Basis + ", UpdateDate=" + UpdateDate + ", ActiveDoc=" + ActiveDoc
                                           + ", CompletedDoc=" + CompletedDoc + "]";
}



public BidCreation() {
              super();
              // TODO Auto-generated constructor stub
}

              
}
