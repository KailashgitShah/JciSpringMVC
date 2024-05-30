package com.jci.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GenrationDEmandDto {
	

	
	private Date   Contract_date;
	private String Payment_duedate;
	private String Contract_cancel_date;
	private String Instrument_No;
	private String Contracted_qty;
	private String Carrying_Cost_Charged;
	
	
	
	public String getInstrument_No() {
		return Instrument_No;
	}
	public void setInstrument_No(String instrument_No) {
		Instrument_No = instrument_No;
	}
	
	
	public Date getContract_date() {
		return Contract_date;
	}
	public void setContract_date(Date contract_date) {
		Contract_date = contract_date;
	}
	public String getPayment_duedate() {
		return Payment_duedate;
	}
	public void setPayment_duedate(String payment_duedate) {
		Payment_duedate = payment_duedate;
	}
	public String getContract_cancel_date() {
		return Contract_cancel_date;
	}
	public void setContract_cancel_date(String contract_cancel_date) {
		Contract_cancel_date = contract_cancel_date;
	}

	public String getContracted_qty() {
		return Contracted_qty;
	}
	public void setContracted_qty(String contracted_qty) {
		Contracted_qty = contracted_qty;
	}
	public String getCarrying_Cost_Charged() {
		return Carrying_Cost_Charged;
	}
	public void setCarrying_Cost_Charged(String carrying_Cost_Charged) {
		Carrying_Cost_Charged = carrying_Cost_Charged;
	}

	public GenrationDEmandDto(String contract_no, Date contract_date, String payment_duedate,
			String contract_cancel_date, int payment_id, String contracted_qty, String carrying_Cost_Charged,
			Double actual_qty, Double short_qty) {
		super();
		this.
		Contract_date = contract_date;
		Payment_duedate = payment_duedate;
		Contract_cancel_date = contract_cancel_date;
		Contracted_qty = contracted_qty;
		Carrying_Cost_Charged = carrying_Cost_Charged;
		
	}
	@Override
	public String toString() {
		return "GenrationDEmandDto [ Contract_date=" + Contract_date
				+ ", Payment_duedate=" + Payment_duedate + ", Contract_cancel_date=" + Contract_cancel_date
				+ ",Contracted_qty=" + Contracted_qty + ", Carrying_Cost_Charged="
				+ Carrying_Cost_Charged +  "]";
	}
	public GenrationDEmandDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
