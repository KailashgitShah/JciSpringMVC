package com.jci.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LedgerReportDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String cropyear;
	private String basis;
	private String farmerRegNo;
	private String farmerName;
	private String mobNo;
	private String address;
	private String aadharNo;
	private String bankName;
	private String ifscCode;
	private String acNo;
	private String dateofPur;
	private String dpc;
	private String tallySlip;
	private int rateSlip;
	private double grossQty;
	private double dedQty;
	private double netQty;
	private double grasatrate;
	private String payDate;
	private double cumQty;
	public String getCropyear() {
		return cropyear;
	}
	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getFarmerRegNo() {
		return farmerRegNo;
	}
	public void setFarmerRegNo(String farmerRegNo) {
		this.farmerRegNo = farmerRegNo;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getDateofPur() {
		return dateofPur;
	}
	public void setDateofPur(String dateofPur) {
		this.dateofPur = dateofPur;
	}
	public String getDpc() {
		return dpc;
	}
	public void setDpc(String dpc) {
		this.dpc = dpc;
	}
	public String getTallySlip() {
		return tallySlip;
	}
	public void setTallySlip(String tallySlip) {
		this.tallySlip = tallySlip;
	}
	public int getRateSlip() {
		return rateSlip;
	}
	public void setRateSlip(int rateSlip) {
		this.rateSlip = rateSlip;
	}
	public double getGrossQty() {
		return grossQty;
	}
	public void setGrossQty(double grossQty) {
		this.grossQty = grossQty;
	}
	public double getDedQty() {
		return dedQty;
	}
	public void setDedQty(double dedQty) {
		this.dedQty = dedQty;
	}
	public double getNetQty() {
		return netQty;
	}
	public void setNetQty(double netQty) {
		this.netQty = netQty;
	}
	public double getGrasatrate() {
		return grasatrate;
	}
	public void setGrasatrate(double grasatrate) {
		this.grasatrate = grasatrate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public double getCumQty() {
		return cumQty;
	}
	public void setCumQty(double cumQty) {
		this.cumQty = cumQty;
	}
	@Override
	public String toString() {
		return "LedgerReportDTO [cropyear=" + cropyear + ", basis=" + basis + ", farmerRegNo=" + farmerRegNo
				+ ", farmerName=" + farmerName + ", mobNo=" + mobNo + ", address=" + address + ", aadharNo=" + aadharNo
				+ ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", acNo=" + acNo + ", dateofPur=" + dateofPur
				+ ", dpc=" + dpc + ", tallySlip=" + tallySlip + ", rateSlip=" + rateSlip + ", grossQty=" + grossQty
				+ ", dedQty=" + dedQty + ", netQty=" + netQty + ", grasatrate=" + grasatrate + ", payDate=" + payDate
				+ ", cumQty=" + cumQty + "]";
	}
	public LedgerReportDTO(String cropyear, String basis, String farmerRegNo, String farmerName, String mobNo,
			String address, String aadharNo, String bankName, String ifscCode, String acNo, String dateofPur,
			String dpc, String tallySlip, int rateSlip, double grossQty, double dedQty, double netQty,
			double grasatrate, String payDate, double cumQty) {
		super();
		this.cropyear = cropyear;
		this.basis = basis;
		this.farmerRegNo = farmerRegNo;
		this.farmerName = farmerName;
		this.mobNo = mobNo;
		this.address = address;
		this.aadharNo = aadharNo;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.acNo = acNo;
		this.dateofPur = dateofPur;
		this.dpc = dpc;
		this.tallySlip = tallySlip;
		this.rateSlip = rateSlip;
		this.grossQty = grossQty;
		this.dedQty = dedQty;
		this.netQty = netQty;
		this.grasatrate = grasatrate;
		this.payDate = payDate;
		this.cumQty = cumQty;
	}
	public LedgerReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}