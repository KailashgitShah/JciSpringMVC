package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcijba", schema = "dbo")
public class JbaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jbaid")
	private int id;
	@Column(name = "jbaDate")
	private String jbaDate;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="areaCode")
	private  String areaCode;
 

	@Column(name = "createddate")
	private String createddate;


	@Column(name = "creadtedby")
	private int creadtedby;


	@Column(name="gradewisepp1")
	private  double gradewisepp1;

	@Column(name="gradewisepp2")
	private  double gradewisepp2;

	@Column(name="gradewisepp3")
	private  double gradewisepp3;

	@Column(name="gradewisepp4")
	private  double gradewisepp4;

	@Column(name="gradewisepp5")
	private  double gradewisepp5;

	@Column(name="gradewisepp6")
	private  double gradewisepp6;

	@Column(name="gradewisepp7")
	private  double gradewisepp7;

	@Column(name="gradewisepp8")
	private  double gradewisepp8;
	
	@Column(name="region")
	private  String region;
	
	@Column(name="dpcid")
	private  String dpcid;
	
	@Column(name="area_name")
	private  String areaName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJbaDate() {
		return jbaDate;
	}

	public void setJbaDate(String jbaDate) {
		this.jbaDate = jbaDate;
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

	

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getCreadtedby() {
		return creadtedby;
	}

	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}

	public double getGradewisepp1() {
		return gradewisepp1;
	}

	public void setGradewisepp1(double gradewisepp1) {
		this.gradewisepp1 = gradewisepp1;
	}

	public double getGradewisepp2() {
		return gradewisepp2;
	}

	public void setGradewisepp2(double gradewisepp2) {
		this.gradewisepp2 = gradewisepp2;
	}

	public double getGradewisepp3() {
		return gradewisepp3;
	}

	public void setGradewisepp3(double gradewisepp3) {
		this.gradewisepp3 = gradewisepp3;
	}

	public double getGradewisepp4() {
		return gradewisepp4;
	}

	public void setGradewisepp4(double gradewisepp4) {
		this.gradewisepp4 = gradewisepp4;
	}

	public double getGradewisepp5() {
		return gradewisepp5;
	}

	public void setGradewisepp5(double gradewisepp5) {
		this.gradewisepp5 = gradewisepp5;
	}

	public double getGradewisepp6() {
		return gradewisepp6;
	}

	public void setGradewisepp6(double gradewisepp6) {
		this.gradewisepp6 = gradewisepp6;
	}

	public double getGradewisepp7() {
		return gradewisepp7;
	}

	public void setGradewisepp7(double gradewisepp7) {
		this.gradewisepp7 = gradewisepp7;
	}

	public double getGradewisepp8() {
		return gradewisepp8;
	}

	public void setGradewisepp8(double gradewisepp8) {
		this.gradewisepp8 = gradewisepp8;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDpcid() {
		return dpcid;
	}

	public void setDpcid(String dpcid) {
		this.dpcid = dpcid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "JbaModel [id=" + id + ", jbaDate=" + jbaDate + ", jutevariety=" + jutevariety + ", cropyr=" + cropyr
				+ ", areaCode=" + areaCode + ", createddate=" + createddate + ", creadtedby=" + creadtedby
				+ ", gradewisepp1=" + gradewisepp1 + ", gradewisepp2=" + gradewisepp2 + ", gradewisepp3=" + gradewisepp3
				+ ", gradewisepp4=" + gradewisepp4 + ", gradewisepp5=" + gradewisepp5 + ", gradewisepp6=" + gradewisepp6
				+ ", gradewisepp7=" + gradewisepp7 + ", gradewisepp8=" + gradewisepp8 + ", region=" + region
				+ ", dpcid=" + dpcid + ", areaName=" + areaName + "]";
	}
	
	
	 
}