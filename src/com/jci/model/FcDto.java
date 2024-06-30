package com.jci.model;

import java.util.Date;

public class FcDto {
	private String  contrcatno;
	private String auto_revolving_amount;
	private String expiry_date;
	private String last_shipment_date;
	private String instrument_Date;
	private String instrument_No;
	private String instrument_Value;
	private String composition;
	private Double qty;
	private String address;
	private String millname;
	private String bankname;
	private String bankAddress;
	private String allowedqty;
	private String jutevariety;
	private String quanity;
	private String deliveryType;
	private double total;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getContrcatno() {
		return contrcatno;
	}
	public void setContrcatno(String contrcatno) {
		this.contrcatno = contrcatno;
	}
	public String getAuto_revolving_amount() {
		return auto_revolving_amount;
	}
	public void setAuto_revolving_amount(String auto_revolving_amount) {
		this.auto_revolving_amount = auto_revolving_amount;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getLast_shipment_date() {
		return last_shipment_date;
	}
	public void setLast_shipment_date(String last_shipment_date) {
		this.last_shipment_date = last_shipment_date;
	}
	public String getInstrument_Date() {
		return instrument_Date;
	}
	public void setInstrument_Date(String instrument_Date) {
		this.instrument_Date = instrument_Date;
	}
	public String getInstrument_No() {
		return instrument_No;
	}
	public void setInstrument_No(String instrument_No) {
		this.instrument_No = instrument_No;
	}
	public String getInstrument_Value() {
		return instrument_Value;
	}
	public void setInstrument_Value(String instrument_Value) {
		this.instrument_Value = instrument_Value;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMillname() {
		return millname;
	}
	public void setMillname(String millname) {
		this.millname = millname;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getAllowedqty() {
		return allowedqty;
	}
	public void setAllowedqty(String allowedqty) {
		this.allowedqty = allowedqty;
	}
	public String getJutevariety() {
		return jutevariety;
	}
	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}
	public String getQuanity() {
		return quanity;
	}
	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	@Override
	public String toString() {
		return "FcDto [contrcatno=" + contrcatno + ", auto_revolving_amount=" + auto_revolving_amount + ", expiry_date="
				+ expiry_date + ", last_shipment_date=" + last_shipment_date + ", instrument_Date=" + instrument_Date
				+ ", instrument_No=" + instrument_No + ", instrument_Value=" + instrument_Value + ", composition="
				+ composition + ", qty=" + qty + ", address=" + address + ", millname=" + millname + ", bankname="
				+ bankname + ", bankAddress=" + bankAddress + ", allowedqty=" + allowedqty + ", jutevariety="
				+ jutevariety + ", quanity=" + quanity + ", deliveryType=" + deliveryType + "]";
	}
	public FcDto(String contrcatno, String auto_revolving_amount, String expiry_date, String last_shipment_date,
			String instrument_Date, String instrument_No, String instrument_Value, String composition, Double qty,
			String address, String millname, String bankname, String bankAddress, String allowedqty, String jutevariety,
			String quanity, String deliveryType) {
		super();
		this.contrcatno = contrcatno;
		this.auto_revolving_amount = auto_revolving_amount;
		this.expiry_date = expiry_date;
		this.last_shipment_date = last_shipment_date;
		this.instrument_Date = instrument_Date;
		this.instrument_No = instrument_No;
		this.instrument_Value = instrument_Value;
		this.composition = composition;
		this.qty = qty;
		this.address = address;
		this.millname = millname;
		this.bankname = bankname;
		this.bankAddress = bankAddress;
		this.allowedqty = allowedqty;
		this.jutevariety = jutevariety;
		this.quanity = quanity;
		this.deliveryType = deliveryType;
	}
	public FcDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
