package com.jci.model;

public class CreditNoteSettledDTO {

	private int snNo;
	private String baleMark;
	
	private String grade;
	
	private double noOfBale;

	private double actualQty;

	private double moistureMill;
	private double ncvMill;
	private double dustMill;
	private double qualityMill;
	
	private double moistureSettlement;
	private double ncvSettlement;
	private double dustSettlement;
	private double qualitySettlement;
	
	private double claimAmount;
	private String  cropYr;


	
	
	public int getSnNo() {
		return snNo;
	}

	public void setSnNo(int snNo) {
		this.snNo = snNo;
	}

	public String getBaleMark() {
		return baleMark;
	}

	public void setBaleMark(String baleMark) {
		this.baleMark = baleMark;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getNoOfBale() {
		return noOfBale;
	}

	public void setNoOfBale(double noOfBale) {
		this.noOfBale = noOfBale;
	}

	public double getActualQty() {
		return actualQty;
	}

	public void setActualQty(double actualQty) {
		this.actualQty = actualQty;
	}

	public double getMoistureMill() {
		return moistureMill;
	}

	public void setMoistureMill(double moistureMill) {
		this.moistureMill = moistureMill;
	}

	public double getNcvMill() {
		return ncvMill;
	}

	public void setNcvMill(double ncvMill) {
		this.ncvMill = ncvMill;
	}

	public double getDustMill() {
		return dustMill;
	}

	public void setDustMill(double dustMill) {
		this.dustMill = dustMill;
	}

	public double getQualityMill() {
		return qualityMill;
	}

	public void setQualityMill(double qualityMill) {
		this.qualityMill = qualityMill;
	}

	public double getMoistureSettlement() {
		return moistureSettlement;
	}

	public void setMoistureSettlement(double moistureSettlement) {
		this.moistureSettlement = moistureSettlement;
	}

	public double getNcvSettlement() {
		return ncvSettlement;
	}

	public void setNcvSettlement(double ncvSettlement) {
		this.ncvSettlement = ncvSettlement;
	}

	public double getDustSettlement() {
		return dustSettlement;
	}

	public void setDustSettlement(double dustSettlement) {
		this.dustSettlement = dustSettlement;
	}

	public double getQualitySettlement() {
		return qualitySettlement;
	}

	public void setQualitySettlement(double qualitySettlement) {
		this.qualitySettlement = qualitySettlement;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	
	

	public String getCropYr() {
		return cropYr;
	}

	public void setCropYr(String cropYr) {
		this.cropYr = cropYr;
	}

	public CreditNoteSettledDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
