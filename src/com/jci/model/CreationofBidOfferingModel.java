package com.jci.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcibid_creation",schema = "dbo")
public class CreationofBidOfferingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_id")
	private int bid_id;
	
	@Column(name = "bid_reference_no")
	private String bid_reference_no;
	
	@Column(name = "bid_date")
	private String bid_date;
	
	@Column(name = "bid_closing_date")
	private String bid_closing_date;
	
	@Column(name = "security_deposit_amount")
	private Double security_deposit_amount;
	
	@Column(name = "day_to_accept")
	private int day_to_accept;
	
	@Column(name = "day_to_deposit_amount")
	private int day_to_deposit_amount;
	
	@Column(name = "delivery_period")
	private int delivery_period;
	
	@Column(name = "provision_claim")
	private int provision_claim;
	
	@Column(name = "lot_identification")
	private String lot_idnetification;
	
	@Column(name = "contract_type")
	private String contract_type;
	
	@Column(name = "bid_roll_out")
	private int bid_roll_out;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "creation_date")
	private Date creation_date;

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public String getBid_reference_no() {
		return bid_reference_no;
	}

	public void setBid_reference_no(String bid_reference_no) {
		this.bid_reference_no = bid_reference_no;
	}

	public String getBid_date() {
		return bid_date;
	}

	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}

	public String getBid_closing_date() {
		return bid_closing_date;
	}

	public void setBid_closing_date(String bid_closing_date) {
		this.bid_closing_date = bid_closing_date;
	}

	public Double getSecurity_deposit_amount() {
		return security_deposit_amount;
	}

	public void setSecurity_deposit_amount(Double security_deposit_amount) {
		this.security_deposit_amount = security_deposit_amount;
	}

	public int getDay_to_accept() {
		return day_to_accept;
	}

	public void setDay_to_accept(int day_to_accept) {
		this.day_to_accept = day_to_accept;
	}

	public int getDay_to_deposit_amount() {
		return day_to_deposit_amount;
	}

	public void setDay_to_deposit_amount(int day_to_deposit_amount) {
		this.day_to_deposit_amount = day_to_deposit_amount;
	}

	public int getDelivery_period() {
		return delivery_period;
	}

	public void setDelivery_period(int delivery_period) {
		this.delivery_period = delivery_period;
	}

	public int getProvision_claim() {
		return provision_claim;
	}

	public void setProvision_claim(int provision_claim) {
		this.provision_claim = provision_claim;
	}

	public String getLot_idnetification() {
		return lot_idnetification;
	}

	public void setLot_idnetification(String lot_idnetification) {
		this.lot_idnetification = lot_idnetification;
	}

	public String getContract_type() {
		return contract_type;
	}

	public void setContract_type(String contract_type) {
		this.contract_type = contract_type;
	}

	public int getBid_roll_out() {
		return bid_roll_out;
	}

	public void setBid_roll_out(int bid_roll_out) {
		this.bid_roll_out = bid_roll_out;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public String toString() {
		return "CreationofBidOfferingModel [bid_id=" + bid_id + ", bid_reference_no=" + bid_reference_no + ", bid_date="
				+ bid_date + ", bid_closing_date=" + bid_closing_date + ", security_deposit_amount="
				+ security_deposit_amount + ", day_to_accept=" + day_to_accept + ", day_to_deposit_amount="
				+ day_to_deposit_amount + ", delivery_period=" + delivery_period + ", provision_claim="
				+ provision_claim + ", lot_idnetification=" + lot_idnetification + ", contract_type=" + contract_type
				+ ", bid_roll_out=" + bid_roll_out + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ "]";
	}

	public CreationofBidOfferingModel(int bid_id, String bid_reference_no, String bid_date, String bid_closing_date,
			Double security_deposit_amount, int day_to_accept, int day_to_deposit_amount, int delivery_period,
			int provision_claim, String lot_idnetification, String contract_type, int bid_roll_out, String created_by,
			Date creation_date) {
		super();
		this.bid_id = bid_id;
		this.bid_reference_no = bid_reference_no;
		this.bid_date = bid_date;
		this.bid_closing_date = bid_closing_date;
		this.security_deposit_amount = security_deposit_amount;
		this.day_to_accept = day_to_accept;
		this.day_to_deposit_amount = day_to_deposit_amount;
		this.delivery_period = delivery_period;
		this.provision_claim = provision_claim;
		this.lot_idnetification = lot_idnetification;
		this.contract_type = contract_type;
		this.bid_roll_out = bid_roll_out;
		this.created_by = created_by;
		this.creation_date = creation_date;
	}

	public CreationofBidOfferingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	
	
	
	
	