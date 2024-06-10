package com.jci.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;


public class ClaimSettlementReport {
	private String millname;
	private String contract_no;
	private String di_no;
	private String di_date;
	private String roCode;
	private String regionName;
	private String challan;
	private String mr_no;
	private Date  mrDate;
	private String cropYear;
	private String bale_mark;
	private String juteVariety;
	private String grade;
	private Double no_of_bales;
	private Double actualqty;
    private Double mrQty;
	private Double qualityPercent;
	private Double moisturePercent;
	private Double dustAmount;
	private Double ncvPercentage;
	private String settlement;
	public String getMillname() {
		return millname;
	}
	public void setMillname(String millname) {
		this.millname = millname;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getDi_no() {
		return di_no;
	}
	public void setDi_no(String di_no) {
		this.di_no = di_no;
	}
	public String getDi_date() {
		return di_date;
	}
	public void setDi_date(String di_date) {
		this.di_date = di_date;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getChallan() {
		return challan;
	}
	public void setChallan(String challan) {
		this.challan = challan;
	}
	public String getMr_no() {
		return mr_no;
	}
	public void setMr_no(String mr_no) {
		this.mr_no = mr_no;
	}
	
	public Date getMrDate() {
		return mrDate;
	}
	public void setMrDate(Date mrDate) {
		this.mrDate = mrDate;
	}
	public String getCropYear() {
		return cropYear;
	}
	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}
	public String getBale_mark() {
		return bale_mark;
	}
	public void setBale_mark(String bale_mark) {
		this.bale_mark = bale_mark;
	}
	public String getJuteVariety() {
		return juteVariety;
	}
	public void setJuteVariety(String juteVariety) {
		this.juteVariety = juteVariety;
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
	public Double getActualqty() {
		return actualqty;
	}
	public void setActualqty(Double actualqty) {
		this.actualqty = actualqty;
	}
	public Double getMrQty() {
		return mrQty;
	}
	public void setMrQty(Double mrQty) {
		this.mrQty = mrQty;
	}
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
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	
	public String getRoCode() {
		return roCode;
	}
	public void setRoCode(String roCode) {
		this.roCode = roCode;
	}
	
	public ClaimSettlementReport() {
		super();
	}
	public ClaimSettlementReport(String millname, String contract_no, String di_no, String di_date, String roCode,
			String regionName, String challan, String mr_no, Date mrDate, String cropYear, String bale_mark,
			String juteVariety, String grade, Double no_of_bales, Double actualqty, Double mrQty, Double qualityPercent,
			Double moisturePercent, Double dustAmount, Double ncvPercentage, String settlement) {
		super();
		this.millname = millname;
		this.contract_no = contract_no;
		this.di_no = di_no;
		this.di_date = di_date;
		this.roCode = roCode;
		this.regionName = regionName;
		this.challan = challan;
		this.mr_no = mr_no;
		this.mrDate = mrDate;
		this.cropYear = cropYear;
		this.bale_mark = bale_mark;
		this.juteVariety = juteVariety;
		this.grade = grade;
		this.no_of_bales = no_of_bales;
		this.actualqty = actualqty;
		this.mrQty = mrQty;
		this.qualityPercent = qualityPercent;
		this.moisturePercent = moisturePercent;
		this.dustAmount = dustAmount;
		this.ncvPercentage = ncvPercentage;
		this.settlement = settlement;
	}
	@Override
	public String toString() {
		return "ClaimSettlementReport [millname=" + millname + ", contract_no=" + contract_no + ", di_no=" + di_no
				+ ", di_date=" + di_date + ", roCode=" + roCode + ", regionName=" + regionName + ", challan=" + challan
				+ ", mr_no=" + mr_no + ", mrDate=" + mrDate + ", cropYear=" + cropYear + ", bale_mark=" + bale_mark
				+ ", juteVariety=" + juteVariety + ", grade=" + grade + ", no_of_bales=" + no_of_bales + ", actualqty="
				+ actualqty + ", mrQty=" + mrQty + ", qualityPercent=" + qualityPercent + ", moisturePercent="
				+ moisturePercent + ", dustAmount=" + dustAmount + ", ncvPercentage=" + ncvPercentage + ", settlement="
				+ settlement + "]";
	}
	
	

}
