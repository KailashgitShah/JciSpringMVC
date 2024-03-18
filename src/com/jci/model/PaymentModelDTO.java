package com.jci.model;

public class PaymentModelDTO {
private int PaymentDTO_id;
	
	private String  Contarct_No;
	private String  Instrument_Value;
	private String  Instrument_date;
	private String  Qty_paid;
	
	private String  Qty_remaining;

	public int getPaymentDTO_id() {
		return PaymentDTO_id;
	}

	public void setPaymentDTO_id(int paymentDTO_id) {
		PaymentDTO_id = paymentDTO_id;
	}

	public String getContarct_No() {
		return Contarct_No;
	}

	public void setContarct_No(String contarct_No) {
		Contarct_No = contarct_No;
	}

	public String getInstrument_Value() {
		return Instrument_Value;
	}

	public void setInstrument_Value(String instrument_Value) {
		Instrument_Value = instrument_Value;
	}

	public String getInstrument_date() {
		return Instrument_date;
	}

	public void setInstrument_date(String instrument_date) {
		Instrument_date = instrument_date;
	}

	public String getQty_paid() {
		return Qty_paid;
	}

	public void setQty_paid(String qty_paid) {
		Qty_paid = qty_paid;
	}

	public String getQty_remaining() {
		return Qty_remaining;
	}

	public void setQty_remaining(String qty_remaining) {
		Qty_remaining = qty_remaining;
	}
	
	
}
