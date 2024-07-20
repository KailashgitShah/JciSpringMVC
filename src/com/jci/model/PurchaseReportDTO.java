package com.jci.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PurchaseReportDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String datepur;
	private double grossQuan;
	private double dedQuan;
	private double netQuan;
	private int garsatR;
	private int fiberVal;
	private double basisPrice;
	private double gr1;
	private double gr2;
	private double gr3;
	private double gr4;
	private double gr5;
	private double gr6;
	private double gr7;
	private double gr8;
	private String region;
	private String placepur;
	private String basis;
	private String jutevar;
	private String fromtoDate;
	private String cropYear;
	private double gtotal;
	private double dtotal;
	private double ntotal;
	private double gatotal;
	private int ftotal;
	private double batotal;
	private double gr1tot;
	private double gr2tot;
	private double gr3tot;
	private double gr4tot;
	private double gr5tot;
	private double gr6tot;
	private double gr7tot;
	private double gr8tot;
	public String getDatepur() {
		return datepur;
	}
	public void setDatepur(String datepur) {
		this.datepur = datepur;
	}
	public double getGrossQuan() {
		return grossQuan;
	}
	public void setGrossQuan(double grossQuan) {
		this.grossQuan = grossQuan;
	}
	public double getDedQuan() {
		return dedQuan;
	}
	public void setDedQuan(double dedQuan) {
		this.dedQuan = dedQuan;
	}
	public double getNetQuan() {
		return netQuan;
	}
	public void setNetQuan(double netQuan) {
		this.netQuan = netQuan;
	}
	public int getGarsatR() {
		return garsatR;
	}
	public void setGarsatR(int garsatR) {
		this.garsatR = garsatR;
	}
	public int getFiberVal() {
		return fiberVal;
	}
	public void setFiberVal(int fiberVal) {
		this.fiberVal = fiberVal;
	}
	public double getBasisPrice() {
		return basisPrice;
	}
	public void setBasisPrice(double basisPrice) {
		this.basisPrice = basisPrice;
	}
	public double getGr1() {
		return gr1;
	}
	public void setGr1(double gr1) {
		this.gr1 = gr1;
	}
	public double getGr2() {
		return gr2;
	}
	public void setGr2(double gr2) {
		this.gr2 = gr2;
	}
	public double getGr3() {
		return gr3;
	}
	public void setGr3(double gr3) {
		this.gr3 = gr3;
	}
	public double getGr4() {
		return gr4;
	}
	public void setGr4(double gr4) {
		this.gr4 = gr4;
	}
	public double getGr5() {
		return gr5;
	}
	public void setGr5(double gr5) {
		this.gr5 = gr5;
	}
	public double getGr6() {
		return gr6;
	}
	public void setGr6(double gr6) {
		this.gr6 = gr6;
	}
	public double getGr7() {
		return gr7;
	}
	public void setGr7(double gr7) {
		this.gr7 = gr7;
	}
	public double getGr8() {
		return gr8;
	}
	public void setGr8(double gr8) {
		this.gr8 = gr8;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPlacepur() {
		return placepur;
	}
	public void setPlacepur(String placepur) {
		this.placepur = placepur;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getJutevar() {
		return jutevar;
	}
	public void setJutevar(String jutevar) {
		this.jutevar = jutevar;
	}
	public String getFromtoDate() {
		return fromtoDate;
	}
	public void setFromtoDate(String fromtoDate) {
		this.fromtoDate = fromtoDate;
	}
	public String getCropYear() {
		return cropYear;
	}
	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}
	public double getGtotal() {
		return gtotal;
	}
	public void setGtotal(double gtotal) {
		this.gtotal = gtotal;
	}
	public double getDtotal() {
		return dtotal;
	}
	public void setDtotal(double dtotal) {
		this.dtotal = dtotal;
	}
	public double getNtotal() {
		return ntotal;
	}
	public void setNtotal(double ntotal) {
		this.ntotal = ntotal;
	}
	public double getGatotal() {
		return gatotal;
	}
	public void setGatotal(double gatotal) {
		this.gatotal = gatotal;
	}
	public int getFtotal() {
		return ftotal;
	}
	public void setFtotal(int ftotal) {
		this.ftotal = ftotal;
	}
	public double getBatotal() {
		return batotal;
	}
	public void setBatotal(double batotal) {
		this.batotal = batotal;
	}
	public double getGr1tot() {
		return gr1tot;
	}
	public void setGr1tot(double gr1tot) {
		this.gr1tot = gr1tot;
	}
	public double getGr2tot() {
		return gr2tot;
	}
	public void setGr2tot(double gr2tot) {
		this.gr2tot = gr2tot;
	}
	public double getGr3tot() {
		return gr3tot;
	}
	public void setGr3tot(double gr3tot) {
		this.gr3tot = gr3tot;
	}
	public double getGr4tot() {
		return gr4tot;
	}
	public void setGr4tot(double gr4tot) {
		this.gr4tot = gr4tot;
	}
	public double getGr5tot() {
		return gr5tot;
	}
	public void setGr5tot(double gr5tot) {
		this.gr5tot = gr5tot;
	}
	public double getGr6tot() {
		return gr6tot;
	}
	public void setGr6tot(double gr6tot) {
		this.gr6tot = gr6tot;
	}
	public double getGr7tot() {
		return gr7tot;
	}
	public void setGr7tot(double gr7tot) {
		this.gr7tot = gr7tot;
	}
	public double getGr8tot() {
		return gr8tot;
	}
	public void setGr8tot(double gr8tot) {
		this.gr8tot = gr8tot;
	}
	@Override
	public String toString() {
		return "PurchaseReportDTO [datepur=" + datepur + ", grossQuan=" + grossQuan + ", dedQuan=" + dedQuan
				+ ", netQuan=" + netQuan + ", garsatR=" + garsatR + ", fiberVal=" + fiberVal + ", basisPrice="
				+ basisPrice + ", gr1=" + gr1 + ", gr2=" + gr2 + ", gr3=" + gr3 + ", gr4=" + gr4 + ", gr5=" + gr5
				+ ", gr6=" + gr6 + ", gr7=" + gr7 + ", gr8=" + gr8 + ", region=" + region + ", placepur=" + placepur
				+ ", basis=" + basis + ", jutevar=" + jutevar + ", fromtoDate=" + fromtoDate + ", cropYear=" + cropYear
				+ ", gtotal=" + gtotal + ", dtotal=" + dtotal + ", ntotal=" + ntotal + ", gatotal=" + gatotal
				+ ", ftotal=" + ftotal + ", batotal=" + batotal + ", gr1tot=" + gr1tot + ", gr2tot=" + gr2tot
				+ ", gr3tot=" + gr3tot + ", gr4tot=" + gr4tot + ", gr5tot=" + gr5tot + ", gr6tot=" + gr6tot
				+ ", gr7tot=" + gr7tot + ", gr8tot=" + gr8tot + "]";
	}
	public PurchaseReportDTO(String datepur, double grossQuan, double dedQuan, double netQuan, int garsatR,
			int fiberVal, double basisPrice, double gr1, double gr2, double gr3, double gr4, double gr5, double gr6,
			double gr7, double gr8, String region, String placepur, String basis, String jutevar, String fromtoDate,
			String cropYear, double gtotal, double dtotal, double ntotal, double gatotal, int ftotal, double batotal,
			double gr1tot, double gr2tot, double gr3tot, double gr4tot, double gr5tot, double gr6tot, double gr7tot,
			double gr8tot) {
		super();
		this.datepur = datepur;
		this.grossQuan = grossQuan;
		this.dedQuan = dedQuan;
		this.netQuan = netQuan;
		this.garsatR = garsatR;
		this.fiberVal = fiberVal;
		this.basisPrice = basisPrice;
		this.gr1 = gr1;
		this.gr2 = gr2;
		this.gr3 = gr3;
		this.gr4 = gr4;
		this.gr5 = gr5;
		this.gr6 = gr6;
		this.gr7 = gr7;
		this.gr8 = gr8;
		this.region = region;
		this.placepur = placepur;
		this.basis = basis;
		this.jutevar = jutevar;
		this.fromtoDate = fromtoDate;
		this.cropYear = cropYear;
		this.gtotal = gtotal;
		this.dtotal = dtotal;
		this.ntotal = ntotal;
		this.gatotal = gatotal;
		this.ftotal = ftotal;
		this.batotal = batotal;
		this.gr1tot = gr1tot;
		this.gr2tot = gr2tot;
		this.gr3tot = gr3tot;
		this.gr4tot = gr4tot;
		this.gr5tot = gr5tot;
		this.gr6tot = gr6tot;
		this.gr7tot = gr7tot;
		this.gr8tot = gr8tot;
	}
	public PurchaseReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}