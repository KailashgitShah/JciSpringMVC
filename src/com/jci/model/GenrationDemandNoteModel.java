package com.jci.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcidemand_note", schema = "dbo")
public class GenrationDemandNoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BIGINT", name = "Dn_id")
	private int Dn_id;
	
	@Column(name = "Demand_note_no")
	private String Demand_note_no;
	
	@Column(name = "Demand_note_date" )
	private Date Demand_note_date;
	
	@Column(name = "Contract_no" )
	private String Contract_no;
	
	@Column(name = "Contract_date" )
	private String Contract_date;
	
	@Column(name = "Payment_due_date" )
	private String Payment_due_date;
	
	@Column(name = "Payment_date" )
	private String Payment_date;
	
	@Column(name = "Delay_period" )
	private String Delay_period;
	
	@Column(name = "Payment_ref" )
	private String Payment_ref;
	
	@Column(name = "Contracted_qty")
	private double Contracted_qty;
	
	@Column(name = "Unit_charge" )
	private double Unit_charge;
	
	@Column(name = "Carrying_cost" )
	private double Carrying_cost;
	
	@Column(name = "Waiver_flag")
	private int Waiver_flag;
	
	@Column(name = "Remarks" )
	private String Remarks;
	
	@Column(name = "Waiver_approved_by" )
	private String Waiver_approved_by;
	
	@Column(name = "Dn_status")
	private int Dn_status;
	
	@Column(name = "Created_by" )
	private String Created_by;
	
	@Column(name = "Created_on")
	private Date Created_on;
	
	@Column(name = "StateCode")
	private String StateCode;

	
	
	public String getStateCode() {
		return StateCode;
	}
	

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public int getDn_id() {
		return Dn_id;
	}

	public void setDn_id(int dn_id) {
		Dn_id = dn_id;
	}

	public String getDemand_note_no() {
		return Demand_note_no;
	}

	public void setDemand_note_no(String demand_note_no) {
		Demand_note_no = demand_note_no;
	}

	public Date getDemand_note_date() {
		return Demand_note_date;
	}

	public void setDemand_note_date(Date demand_note_date) {
		Demand_note_date = demand_note_date;
	}

	public String getContract_no() {
		return Contract_no;
	}

	public void setContract_no(String element) {
		Contract_no = element;
	}

	public String getContract_date() {
		return Contract_date;
	}

	public void setContract_date(String string) {
		Contract_date = string;
	}

	public String getPayment_due_date() {
		return Payment_due_date;
	}

	public void setPayment_due_date(String element) {
		Payment_due_date = element;
	}

	public String getPayment_date() {
		return Payment_date;
	}

	public void setPayment_date(String element) {
		Payment_date = element;
	}

	public String getDelay_period() {
		return Delay_period;
	}

	public void setDelay_period(String delay_period) {
		Delay_period = delay_period;
	}

	public String getPayment_ref() {
		return Payment_ref;
	}

	public void setPayment_ref(String payment_ref) {
		Payment_ref = payment_ref;
	}

	public double getContracted_qty() {
		return Contracted_qty;
	}

	public void setContracted_qty(double contracted_qty) {
		Contracted_qty = contracted_qty;
	}

	public double getUnit_charge() {
		return Unit_charge;
	}

	public void setUnit_charge(double unit_charge) {
		Unit_charge = unit_charge;
	}

	public double getCarrying_cost() {
		return Carrying_cost;
	}

	public void setCarrying_cost(double carrying_cost) {
		Carrying_cost = carrying_cost;
	}

	public int getWaiver_flag() {
		return Waiver_flag;
	}

	public void setWaiver_flag(int waiver_flag) {
		Waiver_flag = waiver_flag;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getWaiver_approved_by() {
		return Waiver_approved_by;
	}

	public void setWaiver_approved_by(String waiver_approved_by) {
		Waiver_approved_by = waiver_approved_by;
	}

	public int getDn_status() {
		return Dn_status;
	}

	public void setDn_status(int dn_status) {
		Dn_status = dn_status;
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

	public void setCreated_on(Date instdate4) {
		Created_on = instdate4;
	}

	@Override
	public String toString() {
		return "GenrationDemandNoteModel [Dn_id=" + Dn_id + ", Demand_note_no=" + Demand_note_no + ", Demand_note_date="
				+ Demand_note_date + ", Contract_no=" + Contract_no + ", Contract_date=" + Contract_date
				+ ", Payment_due_date=" + Payment_due_date + ", Payment_date=" + Payment_date + ", Delay_period="
				+ Delay_period + ", Payment_ref=" + Payment_ref + ", Contracted_qty=" + Contracted_qty
				+ ", Unit_charge=" + Unit_charge + ", Carrying_cost=" + Carrying_cost + ", Waiver_flag=" + Waiver_flag
				+ ", Remarks=" + Remarks + ", Waiver_approved_by=" + Waiver_approved_by + ", Dn_status=" + Dn_status
				+ ", Created_by=" + Created_by + ", Created_on=" + Created_on + ", StateCode=" + StateCode + "]";
	}

	public GenrationDemandNoteModel(int dn_id, String demand_note_no, Date demand_note_date, String contract_no,
			String contract_date, String payment_due_date, String payment_date, String delay_period, String payment_ref,
			double contracted_qty, double unit_charge, double carrying_cost, int waiver_flag, String remarks,
			String waiver_approved_by, int dn_status, String created_by, Date created_on, String stateCode) {
		super();
		Dn_id = dn_id;
		Demand_note_no = demand_note_no;
		Demand_note_date = demand_note_date;
		Contract_no = contract_no;
		Contract_date = contract_date;
		Payment_due_date = payment_due_date;
		Payment_date = payment_date;
		Delay_period = delay_period;
		Payment_ref = payment_ref;
		Contracted_qty = contracted_qty;
		Unit_charge = unit_charge;
		Carrying_cost = carrying_cost;
		Waiver_flag = waiver_flag;
		Remarks = remarks;
		Waiver_approved_by = waiver_approved_by;
		Dn_status = dn_status;
		Created_by = created_by;
		Created_on = created_on;
		StateCode = stateCode;
	}

	public GenrationDemandNoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
