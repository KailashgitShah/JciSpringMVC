package com.jci.model;

public class BillOfExchangeDTO {

	private String invoicevalue;
	private String instrumentNo;
	private String instrumentDate;
	private String billofsupplyNo;
	private String bosDate;
	private String bankname;
	private String bankAddress;
	private String currentdate;
	
	
	public String getCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}
	public String getInvoicevalue() {
		return invoicevalue;
	}
	public void setInvoicevalue(String invoicevalue) {
		this.invoicevalue = invoicevalue;
	}
	public String getInstrumentNo() {
		return instrumentNo;
	}
	public void setInstrumentNo(String instrumentNo) {
		this.instrumentNo = instrumentNo;
	}
	public String getInstrumentDate() {
		return instrumentDate;
	}
	public void setInstrumentDate(String instrumentDate) {
		this.instrumentDate = instrumentDate;
	}
	public String getBillofsupplyNo() {
		return billofsupplyNo;
	}
	public void setBillofsupplyNo(String billofsupplyNo) {
		this.billofsupplyNo = billofsupplyNo;
	}
	public String getBosDate() {
		return bosDate;
	}
	public void setBosDate(String bosDate) {
		this.bosDate = bosDate;
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
	public BillOfExchangeDTO(String invoicevalue, String instrumentNo, String instrumentDate, String billofsupplyNo,
			String bosDate, String bankname, String bankAddress) {
		super();
		this.invoicevalue = invoicevalue;
		this.instrumentNo = instrumentNo;
		this.instrumentDate = instrumentDate;
		this.billofsupplyNo = billofsupplyNo;
		this.bosDate = bosDate;
		this.bankname = bankname;
		this.bankAddress = bankAddress;
	}
	public BillOfExchangeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BillOfExchangeDTO [invoicevalue=" + invoicevalue + ", instrumentNo=" + instrumentNo
				+ ", instrumentDate=" + instrumentDate + ", billofsupplyNo=" + billofsupplyNo + ", bosDate=" + bosDate
				+ ", bankname=" + bankname + ", bankAddress=" + bankAddress + "]";
	}
	
	
	
	
}
