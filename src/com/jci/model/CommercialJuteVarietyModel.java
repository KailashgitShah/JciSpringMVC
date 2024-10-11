package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcijutepricesforcommercial", schema="dbo")
public class CommercialJuteVarietyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="regionid")
	private String region;

	@Column(name="cprice")
	private String cprice;

	@Column(name="effectDate")
	private String effectDate;

	@Column(name="formtype")
	private String formtype;

	@Column(name="cqty")
	private String cqty;

	@Column(name="dpc")
	private String dpc;

	@Column(name="crop_yr")
	private String crop_yr;

	@Column(name="jute_variety")
	private String jute_variety;

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

	@Column(name="status")
	private int status;

	@Column(name="created_on")
	private  String created_on;

	@Column(name="created_by")
	private String created_by;

	@Column(name="zone")
	private String zone;

	@Column(name="dpcname")
	private String dpcname;




	public String getDpcname() {
		return dpcname;
	}

	public void setDpcname(String dpcname) {
		this.dpcname = dpcname;
	}

	public String getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	public String getFormtype() {
		return formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public String getCqty() {
		return cqty;
	}

	public void setCqty(String cqty) {
		this.cqty = cqty;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDpc() {
		return dpc;
	}

	public void setDpc(String dpc) {
		this.dpc = dpc;
	}

	public String getCrop_yr() {
		return crop_yr;
	}

	public void setCrop_yr(String crop_yr) {
		this.crop_yr = crop_yr;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public CommercialJuteVarietyModel() {

	}

	public String getCprice() {
		return cprice;
	}

	public void setCprice(String cprice) {
		this.cprice = cprice;
	}

	@Override
	public String toString() {
		return "CommercialJuteVarietyModel [id=" + id + ", region=" + region + ", cprice=" + cprice + ", effectDate="
				+ effectDate + ", formtype=" + formtype + ", cqty=" + cqty + ", dpc=" + dpc + ", crop_yr=" + crop_yr
				+ ", jute_variety=" + jute_variety + ", grade1=" + grade1 + ", grade2=" + grade2 + ", grade3=" + grade3
				+ ", grade4=" + grade4 + ", grade5=" + grade5 + ", grade6=" + grade6 + ", grade7=" + grade7
				+ ", grade8=" + grade8 + ", status=" + status + ", created_on=" + created_on + ", created_by="
				+ created_by + ", zone=" + zone + "]";
	}





}
