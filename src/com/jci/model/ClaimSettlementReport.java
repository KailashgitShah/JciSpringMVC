package com.jci.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ClaimSettlementReport {
	private String contract_no;
	private String di_no;
	private String challan;
	private String bale_mark;
	private String mr_no;
	private String grade;
	private Double no_of_bales;
	private Double quantity;
	private Double qualityPercent;
	private Double moisturePercent;
	private Double dustAmount;
	private Double ncvPercentage;
	private String millname;
	private String juteVariety;
	private String invoiceValue;
	private String consigneeAddress;
	private String dateIns;
	private String cropYear;
	private String settlement;
	
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
//	public String getDi_no() {
//		return Di_no;
//	}
//	public void setDi_no(String di_no) {
//		Di_no = di_no;
//	}
	public String getMr_no() {
		return mr_no;
	}
	public void setMr_no(String mr_no) {
		this.mr_no = mr_no;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Double getNo_of_bales() {
		return no_of_bales;
	}
	public void setNo_of_bales(Double no_of_bales) {
		this.no_of_bales = no_of_bales;
	}
	
//	public Double getQuantity() {
//		return Quantity;
//	}
//	public void setQuantity(Double quantity) {
//		Quantity = quantity;
//	}
	public Double getQualityPercent() {
		return qualityPercent;
	}
	public void setQualityPercent(Double qualityPercent) {
		this.qualityPercent = qualityPercent;
	}
	public Double getMoisturePercent() {
		return moisturePercent;
	}
	public void setMoisturePercent(Double moisturePercent) {
		this.moisturePercent = moisturePercent;
	}
	
	public String getChallan() {
		return challan;
	}
	public void setChallan(String challan) {
		this.challan = challan;
	}
	
	public String getBale_mark() {
		return bale_mark;
	}
	public void setBale_mark(String bale_mark) {
		this.bale_mark = bale_mark;
	}
	
	public String getDi_no() {
		return di_no;
	}
	public void setDi_no(String di_no) {
		this.di_no = di_no;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public Double getDustAmount() {
		return dustAmount;
	}
	public void setDustAmount(Double dustAmount) {
		this.dustAmount = dustAmount;
	}
	public Double getNcvPercentage() {
		return ncvPercentage;
	}
	public void setNcvPercentage(Double ncvPercentage) {
		this.ncvPercentage = ncvPercentage;
	}
	
	public String getMillname() {
		return millname;
	}
	public void setMillname(String millname) {
		this.millname = millname;
	}
	
	public String getJuteVariety() {
		return juteVariety;
	}
	public void setJuteVariety(String juteVariety) {
		this.juteVariety = juteVariety;
	}
	
	public String getInvoiceValue() {
		return invoiceValue;
	}
	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}
	
	
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	
	public String getDateIns() {
		return dateIns;
	}
	public void setDateIns(String dateIns) {
		this.dateIns = dateIns;
	}
	
	public String getCropYear() {
		return cropYear;
	}
	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public ClaimSettlementReport() {
		super();
	}
	public ClaimSettlementReport(String contract_no, String di_no, String challan, String bale_mark, String mr_no,
			String grade, Double no_of_bales, Double quantity, Double qualityPercent, Double moisturePercent,
			Double dustAmount, Double ncvPercentage, String millname, String juteVariety, String invoiceValue,
			String consigneeAddress, String dateIns, String cropYear, String settlement) {
		super();
		this.contract_no = contract_no;
		this.di_no = di_no;
		this.challan = challan;
		this.bale_mark = bale_mark;
		this.mr_no = mr_no;
		this.grade = grade;
		this.no_of_bales = no_of_bales;
		this.quantity = quantity;
		this.qualityPercent = qualityPercent;
		this.moisturePercent = moisturePercent;
		this.dustAmount = dustAmount;
		this.ncvPercentage = ncvPercentage;
		this.millname = millname;
		this.juteVariety = juteVariety;
		this.invoiceValue = invoiceValue;
		this.consigneeAddress = consigneeAddress;
		this.dateIns = dateIns;
		this.cropYear = cropYear;
		this.settlement = settlement;
	}
	@Override
	public String toString() {
		return "ClaimSettlementReport [contract_no=" + contract_no + ", di_no=" + di_no + ", challan=" + challan
				+ ", bale_mark=" + bale_mark + ", mr_no=" + mr_no + ", grade=" + grade + ", no_of_bales=" + no_of_bales
				+ ", quantity=" + quantity + ", qualityPercent=" + qualityPercent + ", moisturePercent="
				+ moisturePercent + ", dustAmount=" + dustAmount + ", ncvPercentage=" + ncvPercentage + ", millname="
				+ millname + ", juteVariety=" + juteVariety + ", invoiceValue=" + invoiceValue + ", consigneeAddress="
				+ consigneeAddress + ", dateIns=" + dateIns + ", cropYear=" + cropYear + ", settlement=" + settlement
				+ "]";
	}
	
	
	
	

}
