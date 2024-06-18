package com.jci.model;

public class BillOFExchangeWithout_LC_DTO {

	private String  unitname;
	private String  unitaddress;
	private String  billofsupply;
	private String  bosdate;
	private String  invoicevalue;
	private String  cropyear;
	private String  contarctno;
	private String  contarctdate;
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
	public String getBillofsupply() {
		return billofsupply;
	}
	public void setBillofsupply(String billofsupply) {
		this.billofsupply = billofsupply;
	}
	public String getBosdate() {
		return bosdate;
	}
	public void setBosdate(String bosdate) {
		this.bosdate = bosdate;
	}
	public String getInvoicevalue() {
		return invoicevalue;
	}
	public void setInvoicevalue(String invoicevalue) {
		this.invoicevalue = invoicevalue;
	}
	public String getCropyear() {
		return cropyear;
	}
	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}
	public String getContarctno() {
		return contarctno;
	}
	public void setContarctno(String contarctno) {
		this.contarctno = contarctno;
	}
	public String getContarctdate() {
		return contarctdate;
	}
	public void setContarctdate(String contarctdate) {
		this.contarctdate = contarctdate;
	}
	public BillOFExchangeWithout_LC_DTO(String unitname, String unitaddress, String billofsupply, String bosdate,
			String invoicevalue, String cropyear, String contarctno, String contarctdate) {
		super();
		this.unitname = unitname;
		this.unitaddress = unitaddress;
		this.billofsupply = billofsupply;
		this.bosdate = bosdate;
		this.invoicevalue = invoicevalue;
		this.cropyear = cropyear;
		this.contarctno = contarctno;
		this.contarctdate = contarctdate;
	}
	public BillOFExchangeWithout_LC_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BillOFExchangeWithout_LC_DTO [unitname=" + unitname + ", unitaddress=" + unitaddress + ", billofsupply="
				+ billofsupply + ", bosdate=" + bosdate + ", invoicevalue=" + invoicevalue + ", cropyear=" + cropyear
				+ ", contarctno=" + contarctno + ", contarctdate=" + contarctdate + "]";
	}
	
	
	
}
