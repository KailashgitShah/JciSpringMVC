package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcidpc", schema="dbo")
public class DailyPurchaseConfModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dpcid")
	private int dpcid;

	@Column(name="formno")
	private String formno;

	@Column(name="datepurchase")
	private String datepurchase;

	
	@Column(name="basis")
	private String basis;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="placeofpurchase")
	private String placeofpurchase;

	@Column(name="binno")
	private int binno;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="gquantity")
	private String gquantity;

	@Column(name="dquantity")
	private String dquantity;

	@Column(name="netquantity")
	private double netquantity;
	
	@Column(name="grasatrate")
	private double garsat;

	@Column(name="td5base")
	private double tdbase;
	
	@Column(name="fibervalue")
	private double fibervalue;

	@Column(name="grade1")
	private double grade1;

	@Column(name="grade2")
	private double grade2;

	@Column(name="grade3")
	private double grade3;

	@Column(name="grade4")
	private double grade4;

	@Column(name="grade5")
	private double grade5;

	@Column(name="grade6")
	private double grade6;

	@Column(name="grade7")
	private double grade7;

	@Column(name="grade8")
	private double grade8;

	@Column(name="ipaddress")
	private String ipaddress;

	@Column(name="createdby")
	private int createdby;

	@Column(name="rateslipno")
	private String rateslipno;
	
	@Column(name="grade1xnetqty")
	private double grade1xnetqty;

	@Column(name="grade2xnetqty")
	private double grade2xnetqty;
	
	@Column(name="grade3xnetqty")
	private double grade3xnetqty;
	
	@Column(name="grade4xnetqty")
	private double grade4xnetqty;
	
	@Column(name="grade5xnetqty")
	private double grade5xnetqty;
	
	@Column(name="grade6xnetqty")
	private double grade6xnetqty;
	
	@Column(name="grade7xnetqty")
	private double grade7xnetqty;
	
	@Column(name="grade8xnetqty")
	private double grade8xnetqty;
	
	public DailyPurchaseConfModel() {

	}

	public int getDpcid() {
		return dpcid;
	}

	public void setDpcid(int dpcid) {
		this.dpcid = dpcid;
	}

	public String getFormno() {
		return formno;
	}

	public void setFormno(String formno) {
		this.formno = formno;
	}

	public String getDatepurchase() {
		return datepurchase;
	}

	public void setDatepurchase(String datepurchase) {
		this.datepurchase = datepurchase;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getPlaceofpurchase() {
		return placeofpurchase;
	}

	public void setPlaceofpurchase(String placeofpurchase) {
		this.placeofpurchase = placeofpurchase;
	}

	public int getBinno() {
		return binno;
	}

	public void setBinno(int binno) {
		this.binno = binno;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getGquantity() {
		return gquantity;
	}

	public void setGquantity(String gquantity) {
		this.gquantity = gquantity;
	}

	public String getDquantity() {
		return dquantity;
	}

	public void setDquantity(String dquantity) {
		this.dquantity = dquantity;
	}

	public double getNetquantity() {
		return netquantity;
	}

	public void setNetquantity(double netquantity) {
		this.netquantity = netquantity;
	}

	public double getGarsat() {
		return garsat;
	}

	public void setGarsat(double garsat) {
		this.garsat = garsat;
	}

	public double getTdbase() {
		return tdbase;
	}

	public void setTdbase(double tdbase) {
		this.tdbase = tdbase;
	}

	 

	public double getFibervalue() {
		return fibervalue;
	}

	public void setFibervalue(double fibervalue) {
		this.fibervalue = fibervalue;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}

	public double getGrade4() {
		return grade4;
	}

	public void setGrade4(double grade4) {
		this.grade4 = grade4;
	}

	public double getGrade5() {
		return grade5;
	}

	public void setGrade5(double grade5) {
		this.grade5 = grade5;
	}

	public double getGrade6() {
		return grade6;
	}

	public void setGrade6(double grade6) {
		this.grade6 = grade6;
	}

	public double getGrade7() {
		return grade7;
	}

	public void setGrade7(double grade7) {
		this.grade7 = grade7;
	}

	public double getGrade8() {
		return grade8;
	}

	public void setGrade8(double grade8) {
		this.grade8 = grade8;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getRateslipno() {
		return rateslipno;
	}

	public void setRateslipno(String rateslipno) {
		this.rateslipno = rateslipno;
	}

	public double getGrade1xnetqty() {
		return grade1xnetqty;
	}

	public void setGrade1xnetqty(double grade1xnetqty) {
		this.grade1xnetqty = grade1xnetqty;
	}

	public double getGrade2xnetqty() {
		return grade2xnetqty;
	}

	public void setGrade2xnetqty(double grade2xnetqty) {
		this.grade2xnetqty = grade2xnetqty;
	}

	public double getGrade3xnetqty() {
		return grade3xnetqty;
	}

	public void setGrade3xnetqty(double grade3xnetqty) {
		this.grade3xnetqty = grade3xnetqty;
	}

	public double getGrade4xnetqty() {
		return grade4xnetqty;
	}

	public void setGrade4xnetqty(double grade4xnetqty) {
		this.grade4xnetqty = grade4xnetqty;
	}

	public double getGrade5xnetqty() {
		return grade5xnetqty;
	}

	public void setGrade5xnetqty(double grade5xnetqty) {
		this.grade5xnetqty = grade5xnetqty;
	}

	public double getGrade6xnetqty() {
		return grade6xnetqty;
	}

	public void setGrade6xnetqty(double grade6xnetqty) {
		this.grade6xnetqty = grade6xnetqty;
	}

	public double getGrade7xnetqty() {
		return grade7xnetqty;
	}

	public void setGrade7xnetqty(double grade7xnetqty) {
		this.grade7xnetqty = grade7xnetqty;
	}

	public double getGrade8xnetqty() {
		return grade8xnetqty;
	}

	public void setGrade8xnetqty(double grade8xnetqty) {
		this.grade8xnetqty = grade8xnetqty;
	}

	public DailyPurchaseConfModel(int dpcid, String formno, String datepurchase, String basis, String cropyr,
			String placeofpurchase, int binno, String jutevariety, String gquantity, String dquantity,
			double netquantity, double garsat, double tdbase, int fibervalue, double grade1, double grade2,
			double grade3, double grade4, double grade5, double grade6, double grade7, double grade8, String ipaddress,
			int createdby, String rateslipno, double grade1xnetqty, double grade2xnetqty, double grade3xnetqty,
			double grade4xnetqty, double grade5xnetqty, double grade6xnetqty, double grade7xnetqty,
			double grade8xnetqty) {
		//super();
		this.dpcid = dpcid;
		this.formno = formno;
		this.datepurchase = datepurchase;
		this.basis = basis;
		this.cropyr = cropyr;
		this.placeofpurchase = placeofpurchase;
		this.binno = binno;
		this.jutevariety = jutevariety;
		this.gquantity = gquantity;
		this.dquantity = dquantity;
		this.netquantity = netquantity;
		this.garsat = garsat;
		this.tdbase = tdbase;
		this.fibervalue = fibervalue;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
		this.grade4 = grade4;
		this.grade5 = grade5;
		this.grade6 = grade6;
		this.grade7 = grade7;
		this.grade8 = grade8;
		this.ipaddress = ipaddress;
		this.createdby = createdby;
		this.rateslipno = rateslipno;
		this.grade1xnetqty = grade1xnetqty;
		this.grade2xnetqty = grade2xnetqty;
		this.grade3xnetqty = grade3xnetqty;
		this.grade4xnetqty = grade4xnetqty;
		this.grade5xnetqty = grade5xnetqty;
		this.grade6xnetqty = grade6xnetqty;
		this.grade7xnetqty = grade7xnetqty;
		this.grade8xnetqty = grade8xnetqty;
	}
	
	

	}
