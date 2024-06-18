package com.jci.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TopSheeetDTO {
   
	@Column(name="contract_no")
	private String contract_no;
	
	@Column(name="mill_code")
	private String mill_code;
	
	@Column(name="hodiNO")
	private String hodiNO;
	
	@Column(name="hodiDate")
	private String hodiDate;
	
	@Column(name="dateofShipment")
	private String dateofShipment;

	@Column(name="BillOfSupplyNo")
	private String billOfSupplyNo;
	
	@Column(name="invoicevalue")
	private String invoicevalue;
	
	@Column(name="NominalQty")
	private Double nominalQty;

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getMill_code() {
		return mill_code;
	}

	public void setMill_code(String mill_code) {
		this.mill_code = mill_code;
	}

	public String getHodiNO() {
		return hodiNO;
	}

	public void setHodiNO(String hodiNO) {
		this.hodiNO = hodiNO;
	}

	public String getHodiDate() {
		return hodiDate;
	}

	public void setHodiDate(String hodiDate) {
		this.hodiDate = hodiDate;
	}

	public String getDateofShipment() {
		return dateofShipment;
	}

	public void setDateofShipment(String dateofShipment) {
		this.dateofShipment = dateofShipment;
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

	public Double getNominalQty() {
		return nominalQty;
	}

	public void setNominalQty(Double nominalQty) {
		this.nominalQty = nominalQty;
	}

	public TopSheeetDTO(String contract_no, String mill_code, String hodiNO, String hodiDate, String dateofShipment,
			String billOfSupplyNo, String invoicevalue, Double nominalQty) {
		super();
		this.contract_no = contract_no;
		this.mill_code = mill_code;
		this.hodiNO = hodiNO;
		this.hodiDate = hodiDate;
		this.dateofShipment = dateofShipment;
		this.billOfSupplyNo = billOfSupplyNo;
		this.invoicevalue = invoicevalue;
		this.nominalQty = nominalQty;
	}

	public TopSheeetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
}

