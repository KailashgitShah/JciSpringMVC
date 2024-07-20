package com.jci.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DailyReportDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String datepurd;
	private double grossQuand;
	private double dedQuand;
	private double netQuand;
	private int garsatRd;
	private int fiberVald;
	private double basisPriced;
	private double gr1d;
	private double gr2d;
	private double gr3d;
	private double gr4d;
	private double gr5d;
	private double gr6d;
	private double gr7d;
	private double gr8d;
	private String regiond;
	private String placepurd;
	private String basisd;
	private String jutevard;
	private int dpcidd; 
	private String fromtodated;
	private String cropYeard;
	private double gtotald;
	private double dtotald;
	private double ntotald;
	private double gatotald;
	private int ftotald;
	private double batotald;
	private double gr1totd;
	private double gr2totd;
	private double gr3totd;
	private double gr4totd;
	private double gr5totd;
	private double gr6totd;
	private double gr7totd;
	private double gr8totd;
	public String getDatepurd() {
		return datepurd;
	}
	public void setDatepurd(String datepurd) {
		this.datepurd = datepurd;
	}
	public double getGrossQuand() {
		return grossQuand;
	}
	public void setGrossQuand(double grossQuand) {
		this.grossQuand = grossQuand;
	}
	public double getDedQuand() {
		return dedQuand;
	}
	public void setDedQuand(double dedQuand) {
		this.dedQuand = dedQuand;
	}
	public double getNetQuand() {
		return netQuand;
	}
	public void setNetQuand(double netQuand) {
		this.netQuand = netQuand;
	}
	public int getGarsatRd() {
		return garsatRd;
	}
	public void setGarsatRd(int garsatRd) {
		this.garsatRd = garsatRd;
	}
	public int getFiberVald() {
		return fiberVald;
	}
	public void setFiberVald(int fiberVald) {
		this.fiberVald = fiberVald;
	}
	public double getBasisPriced() {
		return basisPriced;
	}
	public void setBasisPriced(double basisPriced) {
		this.basisPriced = basisPriced;
	}
	public double getGr1d() {
		return gr1d;
	}
	public void setGr1d(double gr1d) {
		this.gr1d = gr1d;
	}
	public double getGr2d() {
		return gr2d;
	}
	public void setGr2d(double gr2d) {
		this.gr2d = gr2d;
	}
	public double getGr3d() {
		return gr3d;
	}
	public void setGr3d(double gr3d) {
		this.gr3d = gr3d;
	}
	public double getGr4d() {
		return gr4d;
	}
	public void setGr4d(double gr4d) {
		this.gr4d = gr4d;
	}
	public double getGr5d() {
		return gr5d;
	}
	public void setGr5d(double gr5d) {
		this.gr5d = gr5d;
	}
	public double getGr6d() {
		return gr6d;
	}
	public void setGr6d(double gr6d) {
		this.gr6d = gr6d;
	}
	public double getGr7d() {
		return gr7d;
	}
	public void setGr7d(double gr7d) {
		this.gr7d = gr7d;
	}
	public double getGr8d() {
		return gr8d;
	}
	public void setGr8d(double gr8d) {
		this.gr8d = gr8d;
	}
	public String getRegiond() {
		return regiond;
	}
	public void setRegiond(String regiond) {
		this.regiond = regiond;
	}
	public String getPlacepurd() {
		return placepurd;
	}
	public void setPlacepurd(String placepurd) {
		this.placepurd = placepurd;
	}
	public String getBasisd() {
		return basisd;
	}
	public void setBasisd(String basisd) {
		this.basisd = basisd;
	}
	public String getJutevard() {
		return jutevard;
	}
	public void setJutevard(String jutevard) {
		this.jutevard = jutevard;
	}
	public int getDpcidd() {
		return dpcidd;
	}
	public void setDpcidd(int dpcidd) {
		this.dpcidd = dpcidd;
	}
	public String getFromtodated() {
		return fromtodated;
	}
	public void setFromtodated(String fromtodated) {
		this.fromtodated = fromtodated;
	}
	public String getCropYeard() {
		return cropYeard;
	}
	public void setCropYeard(String cropYeard) {
		this.cropYeard = cropYeard;
	}
	public double getGtotald() {
		return gtotald;
	}
	public void setGtotald(double gtotald) {
		this.gtotald = gtotald;
	}
	public double getDtotald() {
		return dtotald;
	}
	public void setDtotald(double dtotald) {
		this.dtotald = dtotald;
	}
	public double getNtotald() {
		return ntotald;
	}
	public void setNtotald(double ntotald) {
		this.ntotald = ntotald;
	}
	public double getGatotald() {
		return gatotald;
	}
	public void setGatotald(double gatotald) {
		this.gatotald = gatotald;
	}
	public int getFtotald() {
		return ftotald;
	}
	public void setFtotald(int ftotald) {
		this.ftotald = ftotald;
	}
	public double getBatotald() {
		return batotald;
	}
	public void setBatotald(double batotald) {
		this.batotald = batotald;
	}
	public double getGr1totd() {
		return gr1totd;
	}
	public void setGr1totd(double gr1totd) {
		this.gr1totd = gr1totd;
	}
	public double getGr2totd() {
		return gr2totd;
	}
	public void setGr2totd(double gr2totd) {
		this.gr2totd = gr2totd;
	}
	public double getGr3totd() {
		return gr3totd;
	}
	public void setGr3totd(double gr3totd) {
		this.gr3totd = gr3totd;
	}
	public double getGr4totd() {
		return gr4totd;
	}
	public void setGr4totd(double gr4totd) {
		this.gr4totd = gr4totd;
	}
	public double getGr5totd() {
		return gr5totd;
	}
	public void setGr5totd(double gr5totd) {
		this.gr5totd = gr5totd;
	}
	public double getGr6totd() {
		return gr6totd;
	}
	public void setGr6totd(double gr6totd) {
		this.gr6totd = gr6totd;
	}
	public double getGr7totd() {
		return gr7totd;
	}
	public void setGr7totd(double gr7totd) {
		this.gr7totd = gr7totd;
	}
	public double getGr8totd() {
		return gr8totd;
	}
	public void setGr8totd(double gr8totd) {
		this.gr8totd = gr8totd;
	}
	@Override
	public String toString() {
		return "DailyReportDTO [datepurd=" + datepurd + ", grossQuand=" + grossQuand + ", dedQuand=" + dedQuand
				+ ", netQuand=" + netQuand + ", garsatRd=" + garsatRd + ", fiberVald=" + fiberVald + ", basisPriced="
				+ basisPriced + ", gr1d=" + gr1d + ", gr2d=" + gr2d + ", gr3d=" + gr3d + ", gr4d=" + gr4d + ", gr5d="
				+ gr5d + ", gr6d=" + gr6d + ", gr7d=" + gr7d + ", gr8d=" + gr8d + ", regiond=" + regiond
				+ ", placepurd=" + placepurd + ", basisd=" + basisd + ", jutevard=" + jutevard + ", dpcidd=" + dpcidd
				+ ", fromtodated=" + fromtodated + ", cropYeard=" + cropYeard + ", gtotald=" + gtotald + ", dtotald="
				+ dtotald + ", ntotald=" + ntotald + ", gatotald=" + gatotald + ", ftotald=" + ftotald + ", batotald="
				+ batotald + ", gr1totd=" + gr1totd + ", gr2totd=" + gr2totd + ", gr3totd=" + gr3totd + ", gr4totd="
				+ gr4totd + ", gr5totd=" + gr5totd + ", gr6totd=" + gr6totd + ", gr7totd=" + gr7totd + ", gr8totd="
				+ gr8totd + "]";
	}
	public DailyReportDTO(String datepurd, double grossQuand, double dedQuand, double netQuand, int garsatRd,
			int fiberVald, double basisPriced, double gr1d, double gr2d, double gr3d, double gr4d, double gr5d,
			double gr6d, double gr7d, double gr8d, String regiond, String placepurd, String basisd, String jutevard,
			int dpcidd, String fromtodated, String cropYeard, double gtotald, double dtotald, double ntotald,
			double gatotald, int ftotald, double batotald, double gr1totd, double gr2totd, double gr3totd,
			double gr4totd, double gr5totd, double gr6totd, double gr7totd, double gr8totd) {
		super();
		this.datepurd = datepurd;
		this.grossQuand = grossQuand;
		this.dedQuand = dedQuand;
		this.netQuand = netQuand;
		this.garsatRd = garsatRd;
		this.fiberVald = fiberVald;
		this.basisPriced = basisPriced;
		this.gr1d = gr1d;
		this.gr2d = gr2d;
		this.gr3d = gr3d;
		this.gr4d = gr4d;
		this.gr5d = gr5d;
		this.gr6d = gr6d;
		this.gr7d = gr7d;
		this.gr8d = gr8d;
		this.regiond = regiond;
		this.placepurd = placepurd;
		this.basisd = basisd;
		this.jutevard = jutevard;
		this.dpcidd = dpcidd;
		this.fromtodated = fromtodated;
		this.cropYeard = cropYeard;
		this.gtotald = gtotald;
		this.dtotald = dtotald;
		this.ntotald = ntotald;
		this.gatotald = gatotald;
		this.ftotald = ftotald;
		this.batotald = batotald;
		this.gr1totd = gr1totd;
		this.gr2totd = gr2totd;
		this.gr3totd = gr3totd;
		this.gr4totd = gr4totd;
		this.gr5totd = gr5totd;
		this.gr6totd = gr6totd;
		this.gr7totd = gr7totd;
		this.gr8totd = gr8totd;
	}
	public DailyReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}