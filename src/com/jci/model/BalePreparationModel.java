package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "jcibin", schema = "dbo")
public class BalePreparationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "binno")
	private int id;

	@Column(name = "dpcnames")
	private String dpcnames;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="binnumber")
	private String binnumber;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="basis")
	private String basis;

	@Column(name="carryoverlossqty")
	private  String carryoverlossqty;

	@Column(name="carryropeqty")
	private  String carryropeqty;

	@Transient
	private String region;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDpcnames() {
		return dpcnames;
	}

	public void setDpcnames(String dpcnames) {
		this.dpcnames = dpcnames;
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getBinnumber() {
		return binnumber;
	}

	public void setBinnumber(String binnumber) {
		this.binnumber = binnumber;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getCarryoverlossqty() {
		return carryoverlossqty;
	}

	public void setCarryoverlossqty(String carryoverlossqty) {
		this.carryoverlossqty = carryoverlossqty;
	}

	public String getCarryropeqty() {
		return carryropeqty;
	}

	public void setCarryropeqty(String carryropeqty) {
		this.carryropeqty = carryropeqty;
	}

	public BalePreparationModel() {

	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BalePreparationModel(int id, String dpcnames, String cropyr, String binnumber, String jutevariety,
			String basis, String carryoverlossqty, String carryropeqty, String region) {
		super();
		this.id = id;
		this.dpcnames = dpcnames;
		this.cropyr = cropyr;
		this.binnumber = binnumber;
		this.jutevariety = jutevariety;
		this.basis = basis;
		this.carryoverlossqty = carryoverlossqty;
		this.carryropeqty = carryropeqty;
		this.region = region;
	}

	@Override
	public String toString() {
		return "BalePreparationModel [id=" + id + ", dpcnames=" + dpcnames + ", cropyr=" + cropyr + ", binnumber="
				+ binnumber + ", jutevariety=" + jutevariety + ", basis=" + basis + ", carryoverlossqty="
				+ carryoverlossqty + ", carryropeqty=" + carryropeqty + ", region=" + region + "]";
	}

	

	
}