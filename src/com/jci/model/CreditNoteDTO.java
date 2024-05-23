package com.jci.model;

public class CreditNoteDTO {
	public int snNo;
	public String hsnNo;
	public String desc;
	public String cropYear;
	public String baleMark;
	public String juteGrade;
	public int noOfBales;
	public double nominalWt;
	public double nominalQty;
	public double rate;
	public double actQty;
	public double shrtQty;
	public double amt;


	public int getSnNo() {
		return snNo;
	}

	public void setSnNo(int snNo) {
		this.snNo = snNo;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	public String getBaleMark() {
		return baleMark;
	}

	public void setBaleMark(String baleMark) {
		this.baleMark = baleMark;
	}

	

	public String getJuteGrade() {
		return juteGrade;
	}

	public void setJuteGrade(String juteGrade) {
		this.juteGrade = juteGrade;
	}

	public int getNoOfBales() {
		return noOfBales;
	}

	public void setNoOfBales(int noOfBales) {
		this.noOfBales = noOfBales;
	}

	public double getNominalQty() {
		return nominalQty;
	}

	public void setNominalQty(double nominalQty) {
		this.nominalQty = nominalQty;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getNominalWt() {
		return nominalWt;
	}

	public void setNominalWt(double nominalWt) {
		this.nominalWt = nominalWt;
	}


	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}
	
	

	public double getActQty() {
		return actQty;
	}

	public void setActQty(double actQty) {
		this.actQty = actQty;
	}

	public double getShrtQty() {
		return shrtQty;
	}

	public void setShrtQty(double shrtQty) {
		this.shrtQty = shrtQty;
	}
	
	

	public String getHsnNo() {
		return hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		this.hsnNo = hsnNo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public CreditNoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


//   Object[] row = list.get(i);
//
//	//Object gradeObject = gradeRatio.get(i);
//
//	//double perticularShortQty = (Double) gradeObject * shortQty;
//	cropYear = (String) row[0];
//	baleMark = (String) row[1];
//	Jute_grade = (String) row[2];
//	//int noOfBales = (int) row[3];
//	//Double nominalQty = (Double) row[4];
//	Double rate = (Double) row[5];
//	Double nominalWt = (Double) row[6];
//	Double actwt = (Double) row[8];
//	Double shrtWt = (Double) row[9];
//	double amt = (double) row[10];
}
