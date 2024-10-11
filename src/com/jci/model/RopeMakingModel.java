package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "jcirop", schema = "dbo")
public class RopeMakingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpmrefid")
	private int rpmrefid;
	
	@Column(name = "datereport")
	private String datereport;
	
	@Column(name="region")
	private String region;
	
	 
	@Column(name="basis")
	private String basis;
	
	@Column(name="cropyr")
	private String cropyr;
	
	@Column(name="placeofactivity")
	private String placeofactivity;
		
	@Column(name="binno")
	private String binno;
		
	@Column(name="jutevariety")
	private  String jutevariety;

	@Column(name="createddate")
	private String createddate;

 
	
	@Column(name="creadtedby")
	private  String creadtedby;
	
 
	
	@Column(name="ropemade")
	private  String ropemade;
	
	@Column(name="ropeused")
	private  String ropeused;
	
	@Column(name="rope_balance")
	private  String rope_balance;
	
	



	public int getRpmrefid() {
		return rpmrefid;
	}

	public void setRpmrefid(int rpmrefid) {
		this.rpmrefid = rpmrefid;
	}

	public String getDatereport() {
		return datereport;
	}

	public void setDatereport(String datereport2) {
		this.datereport = datereport2;
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


	public String getPlaceofactivity() {
		return placeofactivity;
	}

	public void setPlaceofactivity(String placeofactivity) {
		this.placeofactivity = placeofactivity;
	}

	public String getBinno() {
		return binno;
	}

	public void setBinno(String binno) {
		this.binno = binno;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}





	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getCreadtedby() {
		return creadtedby;
	}

	public void setCreadtedby(String regionId) {
		this.creadtedby = regionId;
	}



	public String getRopemade() {
		return ropemade;
	}

	public void setRopemade(String ropemade) {
		this.ropemade = ropemade;
	}

	public String getRopeused() {
		return ropeused;
	}

	public void setRopeused(String ropeused) {
		this.ropeused = ropeused;
	}

	public String getRope_balance() {
		return rope_balance;
	}

	public void setRope_balance(String rope_balance) {
		this.rope_balance = rope_balance;
	}

 

	public String getRegion() {
		return region;
 
	}

 
	public void setRegion(String region) {
		this.region = region;

	}

 

    

}

