package com.jci.model;

import java.util.Date;

public class TopSheetDto {
	private String contract_no;
	private String challan_no;
	private String di_No;
	private String di_Date;
	private String dateOfShipment;
	private String bos_no;
	private Double quantity;
	private String invoiceValue;
	private Date instrument_Date;
	private String millName;
	private String millcode;
	private String todayDate;
	private Double totalQuantity;
	private Double totalAmount;
	public String getChallan_no() {
		return challan_no;
	}
	public void setChallan_no(String challan_no) {
		this.challan_no = challan_no;
	}
	public String getDi_No() {
		return di_No;
	}
	public void setDi_No(String di_No) {
		this.di_No = di_No;
	}
	public String getDi_Date() {
		return di_Date;
	}
	public void setDi_Date(String di_Date) {
		this.di_Date = di_Date;
	}
	
	public String getBos_no() {
		return bos_no;
	}
	public void setBos_no(String bos_no) {
		this.bos_no = bos_no;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getInvoiceValue() {
		return invoiceValue;
	}
	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}
	public Date getInstrument_Date() {
		return instrument_Date;
	}
	public void setInstrument_Date(Date instrument_Date) {
		this.instrument_Date = instrument_Date;
	}
	public String getMillName() {
		return millName;
	}
	public void setMillName(String millName) {
		this.millName = millName;
	}
	public String getMillcode() {
		return millcode;
	}
	public void setMillcode(String millcode) {
		this.millcode = millcode;
	}
	
	
	
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
		
	}
	
	
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	
	public Double getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getDateOfShipment() {
		return dateOfShipment;
	}
	public void setDateOfShipment(String dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}
	public TopSheetDto() {
		super();
	}
	public TopSheetDto(String contract_no, String challan_no, String di_No, String di_Date, String dateOfShipment,
			String bos_no, Double quantity, String invoiceValue, Date instrument_Date, String millName, String millcode,
			String todayDate, Double totalQuantity, Double totalAmount) {
		super();
		this.contract_no = contract_no;
		this.challan_no = challan_no;
		this.di_No = di_No;
		this.di_Date = di_Date;
		this.dateOfShipment = dateOfShipment;
		this.bos_no = bos_no;
		this.quantity = quantity;
		this.invoiceValue = invoiceValue;
		this.instrument_Date = instrument_Date;
		this.millName = millName;
		this.millcode = millcode;
		this.todayDate = todayDate;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "TopSheetDto [contract_no=" + contract_no + ", challan_no=" + challan_no + ", di_No=" + di_No
				+ ", di_Date=" + di_Date + ", dateOfShipment=" + dateOfShipment + ", bos_no=" + bos_no + ", quantity="
				+ quantity + ", invoiceValue=" + invoiceValue + ", instrument_Date=" + instrument_Date + ", millName="
				+ millName + ", millcode=" + millcode + ", todayDate=" + todayDate + ", totalQuantity=" + totalQuantity
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
}
