package com.jci.model;

import javax.persistence.Column;

public class BankDraftDTO {

	
	@Column(name="BOS_Date")
	private String bOS_Date;
	
    @Column(name="BankName")
	private String bankName;
	
	@Column(name="BankAddress")
	private String bankAddress;
	
	@Column(name="unitname")
	private String unitname;
	
	@Column(name="unitaddress")
	private String unitaddress;
	
	@Column(name="InstrumentNO")
	private String instrumentNO;
	
	@Column(name="instrumentDate")
	private String instrumentDate;

	@Column(name="BillOfSupplyNo")
	private String billOfSupplyNo;
	
	@Column(name="invoicevalue")
	private String invoicevalue;

	
	@Column(name="invoicevalueInnumber")
	private String invoicevalueInnumber;


	@Column(name="currentdate")
	private String currentdate;
	
	

	
	public String getCurrentdate() {
		return currentdate;
	}


	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}


	public String getbOS_Date() {
		return bOS_Date;
	}


	public void setbOS_Date(String bOS_Date) {
		this.bOS_Date = bOS_Date;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBankAddress() {
		return bankAddress;
	}


	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}


	public String getUnitname() {
		return unitname;
	}


	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}


	public String getUnitaddress() {
		return unitaddress;
	}


	public void setUnitaddress(String unitaddress) {
		this.unitaddress = unitaddress;
	}


	public String getInstrumentNO() {
		return instrumentNO;
	}


	public void setInstrumentNO(String instrumentNO) {
		this.instrumentNO = instrumentNO;
	}


	public String getInstrumentDate() {
		return instrumentDate;
	}


	public void setInstrumentDate(String instrumentDate) {
		this.instrumentDate = instrumentDate;
	}


	public String getBillOfSupplyNo() {
		return billOfSupplyNo;
	}


	public void setBillOfSupplyNo(String billOfSupplyNo) {
		this.billOfSupplyNo = billOfSupplyNo;
	}


	public String getInvoicevalue() {
		return invoicevalue;
	}


	public void setInvoicevalue(String invoicevalue) {
		this.invoicevalue = invoicevalue;
	}


	public String getInvoicevalueInnumber() {
		return invoicevalueInnumber;
	}


	public void setInvoicevalueInnumber(String invoicevalueInnumber) {
		this.invoicevalueInnumber = invoicevalueInnumber;
	}


	@Override
	public String toString() {
		return "BankDraftDTO [bOS_Date=" + bOS_Date + ", bankName=" + bankName + ", bankAddress=" + bankAddress
				+ ", unitname=" + unitname + ", unitaddress=" + unitaddress + ", instrumentNO=" + instrumentNO
				+ ", instrumentDate=" + instrumentDate + ", billOfSupplyNo=" + billOfSupplyNo + ", invoicevalue="
				+ invoicevalue + ", invoicevalueInnumber=" + invoicevalueInnumber + "]";
	}


	public BankDraftDTO(String bOS_Date, String bankName, String bankAddress, String unitname, String unitaddress,
			String instrumentNO, String instrumentDate, String billOfSupplyNo, String invoicevalue,
			String invoicevalueInnumber) {
		super();
		this.bOS_Date = bOS_Date;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.unitname = unitname;
		this.unitaddress = unitaddress;
		this.instrumentNO = instrumentNO;
		this.instrumentDate = instrumentDate;
		this.billOfSupplyNo = billOfSupplyNo;
		this.invoicevalue = invoicevalue;
		this.invoicevalueInnumber = invoicevalueInnumber;
	}


	public BankDraftDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



}
