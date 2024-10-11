package com.jci.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class ImageVerificationModel {
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private String F_DOC_Mandate;
	private String F_BANK_DOC;
	private String F_ID_PROF;
	private String F_REG_FORM;
	private String slip_image;
	private String gettally;
	
	
	private String fname;
	private String regno;
	private String purchasedate;
	private String Dateofentry;
	private String basis;
	private String cropyear;
	
	private String placepurchase;
	private int rateslipno;
	private String jutevarity;
	private double grossqty;
	private double dedqty;
	private double netqty;
	private double amountpayble;
	private double garsatrate;
	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public String getDateofentry() {
		return Dateofentry;
	}
	public void setDateofentry(String dateofentry) {
		Dateofentry = dateofentry;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getCropyear() {
		return cropyear;
	}
	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}
	public String getPlacepurchase() {
		return placepurchase;
	}
	public void setPlacepurchase(String placepurchase) {
		this.placepurchase = placepurchase;
	}
	public int getRateslipno() {
		return rateslipno;
	}
	public void setRateslipno(int rateslipno) {
		this.rateslipno = rateslipno;
	}
	public String getJutevarity() {
		return jutevarity;
	}
	public void setJutevarity(String jutevarity) {
		this.jutevarity = jutevarity;
	}
	public double getGrossqty() {
		return grossqty;
	}
	public void setGrossqty(double grossqty) {
		this.grossqty = grossqty;
	}
	public double getDedqty() {
		return dedqty;
	}
	public void setDedqty(double dedqty) {
		this.dedqty = dedqty;
	}
	public double getNetqty() {
		return netqty;
	}
	public void setNetqty(double netqty) {
		this.netqty = netqty;
	}
	public double getAmountpayble() {
		return amountpayble;
	}
	public void setAmountpayble(double amountpayble) {
		this.amountpayble = amountpayble;
	}
	public double getGarsatrate() {
		return garsatrate;
	}
	public void setGarsatrate(double garsatrate) {
		this.garsatrate = garsatrate;
	}
	public String getGettally() {
		return gettally;
	}
	public void setGettally(String gettally) {
		this.gettally = gettally;
	}
	public String getF_DOC_Mandate() {
		return F_DOC_Mandate;
	}
	public void setF_DOC_Mandate(String f_DOC_Mandate) {
		F_DOC_Mandate = f_DOC_Mandate;
	}
	public String getF_BANK_DOC() {
		return F_BANK_DOC;
	}
	public void setF_BANK_DOC(String f_BANK_DOC) {
		F_BANK_DOC = f_BANK_DOC;
	}
	public String getF_ID_PROF() {
		return F_ID_PROF;
	}
	public void setF_ID_PROF(String f_ID_PROF) {
		F_ID_PROF = f_ID_PROF;
	}
	public String getF_REG_FORM() {
		return F_REG_FORM;
	}
	public void setF_REG_FORM(String f_REG_FORM) {
		F_REG_FORM = f_REG_FORM;
	}
	public String getSlip_image() {
		return slip_image;
	}
	public void setSlip_image(String slip_image) {
		this.slip_image = slip_image;
	}
	@Override
	public String toString() {
		return "ImageVerificationModel [F_DOC_Mandate=" + F_DOC_Mandate + ", F_BANK_DOC=" + F_BANK_DOC + ", F_ID_PROF="
				+ F_ID_PROF + ", F_REG_FORM=" + F_REG_FORM + ", slip_image=" + slip_image + ", gettally=" + gettally
				+ ", fname=" + fname + ", regno=" + regno + ", purchasedate=" + purchasedate + ", Dateofentry="
				+ Dateofentry + ", basis=" + basis + ", cropyear=" + cropyear + ", placepurchase=" + placepurchase
				+ ", rateslipno=" + rateslipno + ", jutevarity=" + jutevarity + ", grossqty=" + grossqty + ", dedqty="
				+ dedqty + ", netqty=" + netqty + ", amountpayble=" + amountpayble + ", garsatrate=" + garsatrate + "]";
	}


	

}
