package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "jcimra", schema = "dbo")
public class MarketArrivalModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mrarefid")
	private int mrarefid;

	@Column(name= "grade1")
	private double grade1;

	@Column(name= "grade2")
	private double grade2;

	@Column(name= "grade3")
	private double grade3;

	@Column(name= "grade4")
	private double grade4;

	@Column(name= "grade5")
	private double grade5;

	@Column(name= "grade6")
	private double grade6;

	@Column(name= "grade7")
	private double grade7;

	@Column(name= "grade8")
	private double grade8;

	@Column(name= "grade_rate1")
	private int grade_rate1;

	@Column(name= "grade_rate2")
	private int grade_rate2;

	@Column(name= "grade_rate3")
	private int grade_rate3;

	@Column(name= "grade_rate4")
	private int grade_rate4;

	@Column(name= "grade_rate5")
	private int grade_rate5;

	@Column(name= "grade_rate6")
	private int grade_rate6;

	@Column(name= "grade_rate7")
	private int grade_rate7;

	@Column(name= "grade_rate8")
	private int grade_rate8;
 
	@Column(name = "dpc_code")
	private String dpcnames;
	
	@Column(name = "region_id")
	private String region_id;

	@Column(name = "datearrival")
	private String datearrival;
	
	@Column(name = "basis")
	private String basis;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "cropyr")
	private String cropyr;

	@Column(name = "arrivedqty")
	private String arrivedqty;

	@Column(name = "mixmois")
	private String mixmois;

	@Column(name = "maxmois")
	private String maxmois;
 
	@Column(name = "createddate")
	private String createddate;
 
	@Column(name = "creadtedby")
	private int creadtedby;

	@Column(name = "no_arrival")
	private String no_arrival;
	

	@Transient
	private String centername;

	@Transient
	private String regionName;

	public String getRegionName() {
		return regionName;
	}



	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}



	public String getCentername() {
		return centername;
	}



	public void setCentername(String centername) {
		this.centername = centername;
	}



	public MarketArrivalModel() {

	}



	public String getCreateddate() {
		return createddate;
	}



	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}



	public MarketArrivalModel(int mrarefid, double grade1, double grade2, double grade3, double grade4, double grade5,
			double grade6, double grade7, double grade8, int grade_rate1, int grade_rate2, int grade_rate3,
			int grade_rate4, int grade_rate5, int grade_rate6, int grade_rate7, int grade_rate8, String dpcnames,
			String region_id, String datearrival, String basis, String jutevariety, String cropyr, String arrivedqty,
			String mixmois, String maxmois, String createddate, int creadtedby, String no_arrival) {
		super();
		this.mrarefid = mrarefid;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
		this.grade4 = grade4;
		this.grade5 = grade5;
		this.grade6 = grade6;
		this.grade7 = grade7;
		this.grade8 = grade8;
		this.grade_rate1 = grade_rate1;
		this.grade_rate2 = grade_rate2;
		this.grade_rate3 = grade_rate3;
		this.grade_rate4 = grade_rate4;
		this.grade_rate5 = grade_rate5;
		this.grade_rate6 = grade_rate6;
		this.grade_rate7 = grade_rate7;
		this.grade_rate8 = grade_rate8;
		this.dpcnames = dpcnames;
		this.region_id = region_id;
		this.datearrival = datearrival;
		this.basis = basis;
		this.jutevariety = jutevariety;
		this.cropyr = cropyr;
		this.arrivedqty = arrivedqty;
		this.mixmois = mixmois;
		this.maxmois = maxmois;
		this.createddate = createddate;
		this.creadtedby = creadtedby;
		this.no_arrival = no_arrival;
	}



	public int getMrarefid() {
		return mrarefid;
	}



	public void setMrarefid(int mrarefid) {
		this.mrarefid = mrarefid;
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



	public int getGrade_rate1() {
		return grade_rate1;
	}



	public void setGrade_rate1(int grade_rate1) {
		this.grade_rate1 = grade_rate1;
	}



	public int getGrade_rate2() {
		return grade_rate2;
	}



	public void setGrade_rate2(int grade_rate2) {
		this.grade_rate2 = grade_rate2;
	}



	public int getGrade_rate3() {
		return grade_rate3;
	}



	public void setGrade_rate3(int grade_rate3) {
		this.grade_rate3 = grade_rate3;
	}



	public int getGrade_rate4() {
		return grade_rate4;
	}



	public void setGrade_rate4(int grade_rate4) {
		this.grade_rate4 = grade_rate4;
	}



	public int getGrade_rate5() {
		return grade_rate5;
	}



	public void setGrade_rate5(int grade_rate5) {
		this.grade_rate5 = grade_rate5;
	}



	public int getGrade_rate6() {
		return grade_rate6;
	}



	public void setGrade_rate6(int grade_rate6) {
		this.grade_rate6 = grade_rate6;
	}



	public int getGrade_rate7() {
		return grade_rate7;
	}



	public void setGrade_rate7(int grade_rate7) {
		this.grade_rate7 = grade_rate7;
	}



	public int getGrade_rate8() {
		return grade_rate8;
	}



	public void setGrade_rate8(int grade_rate8) {
		this.grade_rate8 = grade_rate8;
	}



	public String getDpcnames() {
		return dpcnames;
	}



	public void setDpcnames(String dpcnames) {
		this.dpcnames = dpcnames;
	}



	public String getRegion_id() {
		return region_id;
	}



	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}



	public String getDatearrival() {
		return datearrival;
	}



	public void setDatearrival(String datearrival2) {
		this.datearrival = datearrival2;
	}



	public String getBasis() {
		return basis;
	}



	public void setBasis(String basis) {
		this.basis = basis;
	}



	public String getJutevariety() {
		return jutevariety;
	}



	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}



	public String getCropyr() {
		return cropyr;
	}



	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}



	public String getArrivedqty() {
		return arrivedqty;
	}



	public void setArrivedqty(String arrivedqty) {
		this.arrivedqty = arrivedqty;
	}



	public String getMixmois() {
		return mixmois;
	}



	public void setMixmois(String mixmois) {
		this.mixmois = mixmois;
	}



	public String getMaxmois() {
		return maxmois;
	}



	public void setMaxmois(String maxmois) {
		this.maxmois = maxmois;
	}







	public int getCreadtedby() {
		return creadtedby;
	}



	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}



	public String getNo_arrival() {
		return no_arrival;
	}



	public void setNo_arrival(String no_arrival) {
		this.no_arrival = no_arrival;
	}
 	
	
	
	 
}





