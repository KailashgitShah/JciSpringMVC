package com.jci.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jcibid_submission1")
public class SubmissionOfQuoteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Submission_id ")
	private int  Submission_id  ;
	
	
	@Column(name = "Bid_Reference_No")
	private String  Bid_Reference_No ;
	
	@Column( name = "Mill_code")
	private String Mill_code;
	
	
	
	@Column( name = "Mill_name")
	private String Mill_name;
	
	@Column( name = "Lot_Identification")
	private String Lot_Identification ;
	
	
	
	
	
	@Column( name = "Created_by")
	private String Created_by;
	
	@Column( name = "Creation_date")
	private Date Creation_date;
	
	@Column( name = "Bid_rank")
	private String Bid_rank;
	
	@Column( name = "basis")
	private String basis;
	
	@Column( name = "bidopeneingdate")
	private String bidopeneingdate;
	
	@Column( name = "bidclosingdate")
	private String bidclosingdate;
	
	@Column( name = "Quantity")
	private String Quantity;
	
	@Column( name = "SecurityDepositammount")
	private String SecurityDepositammount;
	
	@Column( name = "claimAllwed")
	private String claimAllwed;
	

	
	@Column( name = "region")
	private String region;
	
	@Column( name = "cropyear")
	private String cropYear;
	
	@Column( name = "jutevariety")
	private String jutevariety;
	
	@Column( name = "Grade1")
	private String Grade1;
	
	@Column( name = "Grade2")
	private String Grade2;
	
	@Column( name = "Grade3")
	private String Grade3;
	
	@Column( name = "Grade4")
	private String Grade4;
	
	@Column( name = "Grade5")
	private String Grade5;
	
	@Column( name = "Grade6")
	private String Grade6;
	
	@Column( name = "Grade7")
	private String Grade7;
	
	@Column( name = "Grade8")
	private String Grade8;
	
	@Column( name = "Quote")
	private String Quote;
	
	@Column( name = "Reserved_sell_price")
	private String Reserved_sell_price;
	
	@Column( name = "Sell_value")
	private String Sell_value;
	
	@Column( name = "totalqty")
	private String totalqty;
	
	
	@Column( name = "DeliveryType")
	private String DeliveryType;
	

	@Column( name = "submit_quote_status")
	private String submit_quote_status;
	
	
	@Column( name = "key_id")
	private String keyId;
	 
	@Column( name = "frieghtvalue")
	private String frieghtvalue;
	
	

	public String getFrieghtvalue() {
		return frieghtvalue;
	}

	public void setFrieghtvalue(String frieghtvalue) {
		this.frieghtvalue = frieghtvalue;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getDeliveryType() {
		return DeliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		DeliveryType = deliveryType;
	}

	public String getSubmit_quote_status() {
		return submit_quote_status;
	}

	public void setSubmit_quote_status(String submit_quote_status) {
		this.submit_quote_status = submit_quote_status;
	}

	public String getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(String totalqty) {
		this.totalqty = totalqty;
	}

	public int getSubmission_id() {
		return Submission_id;
	}

	public void setSubmission_id(int submission_id) {
		Submission_id = submission_id;
	}

	public String getBid_Reference_No() {
		return Bid_Reference_No;
	}

	public void setBid_Reference_No(String bid_Reference_No) {
		Bid_Reference_No = bid_Reference_No;
	}

	public String getMill_code() {
		return Mill_code;
	}

	public void setMill_code(String mill_code) {
		Mill_code = mill_code;
	}

	public String getMill_name() {
		return Mill_name;
	}

	public void setMill_name(String mill_name) {
		Mill_name = mill_name;
	}

	public String getLot_Identification() {
		return Lot_Identification;
	}

	public void setLot_Identification(String lot_Identification) {
		Lot_Identification = lot_Identification;
	}

	public String getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}

	public Date getCreation_date() {
		return Creation_date;
	}

	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}

	public String getBid_rank() {
		return Bid_rank;
	}

	public void setBid_rank(String bid_rank) {
		Bid_rank = bid_rank;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getBidopeneingdate() {
		return bidopeneingdate;
	}

	public void setBidopeneingdate(String bidopeneingdate) {
		this.bidopeneingdate = bidopeneingdate;
	}

	public String getBidclosingdate() {
		return bidclosingdate;
	}

	public void setBidclosingdate(String bidclosingdate) {
		this.bidclosingdate = bidclosingdate;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getSecurityDepositammount() {
		return SecurityDepositammount;
	}

	public void setSecurityDepositammount(String securityDepositammount) {
		SecurityDepositammount = securityDepositammount;
	}

	public String getClaimAllwed() {
		return claimAllwed;
	}

	public void setClaimAllwed(String claimAllwed) {
		this.claimAllwed = claimAllwed;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getGrade1() {
		return Grade1;
	}

	public void setGrade1(String grade1) {
		Grade1 = grade1;
	}

	public String getGrade2() {
		return Grade2;
	}

	public void setGrade2(String grade2) {
		Grade2 = grade2;
	}

	public String getGrade3() {
		return Grade3;
	}

	public void setGrade3(String grade3) {
		Grade3 = grade3;
	}

	public String getGrade4() {
		return Grade4;
	}

	public void setGrade4(String grade4) {
		Grade4 = grade4;
	}

	public String getGrade5() {
		return Grade5;
	}

	public void setGrade5(String grade5) {
		Grade5 = grade5;
	}

	public String getGrade6() {
		return Grade6;
	}

	public void setGrade6(String grade6) {
		Grade6 = grade6;
	}

	public String getGrade7() {
		return Grade7;
	}

	public void setGrade7(String grade7) {
		Grade7 = grade7;
	}

	public String getGrade8() {
		return Grade8;
	}

	public void setGrade8(String grade8) {
		Grade8 = grade8;
	}

	public String getQuote() {
		return Quote;
	}

	public void setQuote(String quote) {
		Quote = quote;
	}

	public String getReserved_sell_price() {
		return Reserved_sell_price;
	}

	public void setReserved_sell_price(String reserved_sell_price) {
		Reserved_sell_price = reserved_sell_price;
	}

	public String getSell_value() {
		return Sell_value;
	}

	public void setSell_value(String sell_value) {
		Sell_value = sell_value;
	}

	@Override
	public String toString() {
		return "SubmissionOfQuoteModel [Submission_id=" + Submission_id + ", Bid_Reference_No=" + Bid_Reference_No
				+ ", Mill_code=" + Mill_code + ", Mill_name=" + Mill_name + ", Lot_Identification=" + Lot_Identification
				+ ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + ", Bid_rank=" + Bid_rank
				+ ", basis=" + basis + ", bidopeneingdate=" + bidopeneingdate + ", bidclosingdate=" + bidclosingdate
				+ ", Quantity=" + Quantity + ", SecurityDepositammount=" + SecurityDepositammount + ", claimAllwed="
				+ claimAllwed + ", region=" + region + ", cropYear=" + cropYear + ", jutevariety=" + jutevariety
				+ ", Grade1=" + Grade1 + ", Grade2=" + Grade2 + ", Grade3=" + Grade3 + ", Grade4=" + Grade4
				+ ", Grade5=" + Grade5 + ", Grade6=" + Grade6 + ", Grade7=" + Grade7 + ", Grade8=" + Grade8 + ", Quote="
				+ Quote + ", Reserved_sell_price=" + Reserved_sell_price + ", Sell_value=" + Sell_value + "]";
	}

	public SubmissionOfQuoteModel(int submission_id, String bid_Reference_No, String mill_code, String mill_name,
			String lot_Identification, String created_by, Date creation_date, String bid_rank, String basis,
			String bidopeneingdate, String bidclosingdate, String quantity, String securityDepositammount,
			String claimAllwed, String region, String cropYear, String jutevariety, String grade1, String grade2,
			String grade3, String grade4, String grade5, String grade6, String grade7, String grade8, String quote,
			String reserved_sell_price, String sell_value) {
		super();
		Submission_id = submission_id;
		Bid_Reference_No = bid_Reference_No;
		Mill_code = mill_code;
		Mill_name = mill_name;
		Lot_Identification = lot_Identification;
		Created_by = created_by;
		Creation_date = creation_date;
		Bid_rank = bid_rank;
		this.basis = basis;
		this.bidopeneingdate = bidopeneingdate;
		this.bidclosingdate = bidclosingdate;
		Quantity = quantity;
		SecurityDepositammount = securityDepositammount;
		this.claimAllwed = claimAllwed;
		this.region = region;
		this.cropYear = cropYear;
		this.jutevariety = jutevariety;
		Grade1 = grade1;
		Grade2 = grade2;
		Grade3 = grade3;
		Grade4 = grade4;
		Grade5 = grade5;
		Grade6 = grade6;
		Grade7 = grade7;
		Grade8 = grade8;
		Quote = quote;
		Reserved_sell_price = reserved_sell_price;
		Sell_value = sell_value;
	}

	public SubmissionOfQuoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
