package com.jci.model;

public class boenonlcDTO {
	private String bos_no;
	private String bos_date;
	private String invoiceValue;
	private String contract_no;
	private String millcode;
	private String millname;
	private String milladdress;
	private String contractdate;
	private String cropyear;
	private String todayDate;
	private String allBos;
    private Double sumInvoice;
	public String getBos_no() {
		return bos_no;
	}
	public void setBos_no(String bos_no) {
		this.bos_no = bos_no;
	}
	public String getBos_date() {
		return bos_date;
	}
	public void setBos_date(String bos_date) {
		this.bos_date = bos_date;
	}
	public String getInvoiceValue() {
		return invoiceValue;
	}
	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getMillcode() {
		return millcode;
	}
	public void setMillcode(String millcode) {
		this.millcode = millcode;
	}
	public String getMillname() {
		return millname;
	}
	public void setMillname(String millname) {
		this.millname = millname;
	}
	public String getMilladdress() {
		return milladdress;
	}
	public void setMilladdress(String milladdress) {
		this.milladdress = milladdress;
	}
	public String getContractdate() {
		return contractdate;
	}
	public void setContractdate(String contractdate) {
		this.contractdate = contractdate;
	}
	public String getCropyear() {
		return cropyear;
	}
	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	
	public String getAllBos() {
		return allBos;
	}
	public void setAllBos(String allBos) {
		this.allBos = allBos;
	}
	
	
	public Double getSumInvoice() {
		return sumInvoice;
	}
	public void setSumInvoice(Double sumInvoice) {
		this.sumInvoice = sumInvoice;
	}
	public boenonlcDTO() {
		super();
	}
	public boenonlcDTO(String bos_no, String bos_date, String invoiceValue, String contract_no, String millcode,
			String millname, String milladdress, String contractdate, String cropyear, String todayDate, String allBos,
			Double sumInvoice) {
		super();
		this.bos_no = bos_no;
		this.bos_date = bos_date;
		this.invoiceValue = invoiceValue;
		this.contract_no = contract_no;
		this.millcode = millcode;
		this.millname = millname;
		this.milladdress = milladdress;
		this.contractdate = contractdate;
		this.cropyear = cropyear;
		this.todayDate = todayDate;
		this.allBos = allBos;
		this.sumInvoice = sumInvoice;
	}
	@Override
	public String toString() {
		return "boenonlcDTO [bos_no=" + bos_no + ", bos_date=" + bos_date + ", invoiceValue=" + invoiceValue
				+ ", contract_no=" + contract_no + ", millcode=" + millcode + ", millname=" + millname
				+ ", milladdress=" + milladdress + ", contractdate=" + contractdate + ", cropyear=" + cropyear
				+ ", todayDate=" + todayDate + ", allBos=" + allBos + ", sumInvoice=" + sumInvoice + "]";
	}
	
	
	

}
