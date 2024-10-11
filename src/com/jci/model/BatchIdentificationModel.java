package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcibin", schema = "dbo")
public class BatchIdentificationModel {

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
	
	@Column(name = "date")
	private String date;
	
	@Column(name="basis")
	private String basis;

	@Column(name="carryoverlossqty")
	private  String carryoverlossqty;

	@Column(name="carryropeqty")
	private  String carryropeqty;

	@Column(name="loosejuteamount")
	private  double loosejuteamount;
	
	@Column(name="ropeamount")
	private  double ropeamount;
	
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

	public BatchIdentificationModel() {

	}

	

	public double getLoosejuteamount() {
		return loosejuteamount;
	}

	public void setLoosejuteamount(double loosejuteamount) {
		this.loosejuteamount = loosejuteamount;
	}

	public double getRopeamount() {
		return ropeamount;
	}

	public void setRopeamount(double ropeamount) {
		this.ropeamount = ropeamount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BatchIdentificationModel(int id, String dpcnames, String cropyr, String binnumber, String jutevariety,
			String date, String basis, String carryoverlossqty, String carryropeqty) {
		super();
		this.id = id;
		this.dpcnames = dpcnames;
		this.cropyr = cropyr;
		this.binnumber = binnumber;
		this.jutevariety = jutevariety;
		this.date = date;
		this.basis = basis;
		this.carryoverlossqty = carryoverlossqty;
		this.carryropeqty = carryropeqty;
	}

	public BatchIdentificationModel(int id, String dpcnames, String cropyr, String binnumber, String jutevariety,
			String date, String basis, String carryoverlossqty, String carryropeqty, double loosejuteamount,
			double ropeamount) {
		super();
		this.id = id;
		this.dpcnames = dpcnames;
		this.cropyr = cropyr;
		this.binnumber = binnumber;
		this.jutevariety = jutevariety;
		this.date = date;
		this.basis = basis;
		this.carryoverlossqty = carryoverlossqty;
		this.carryropeqty = carryropeqty;
		this.loosejuteamount = loosejuteamount;
		this.ropeamount = ropeamount;
	}

	@Override
	public String toString() {
		return "BatchIdentificationModel [id=" + id + ", dpcnames=" + dpcnames + ", cropyr=" + cropyr + ", binnumber="
				+ binnumber + ", jutevariety=" + jutevariety + ", date=" + date + ", basis=" + basis
				+ ", carryoverlossqty=" + carryoverlossqty + ", carryropeqty=" + carryropeqty + ", loosejuteamount="
				+ loosejuteamount + ", ropeamount=" + ropeamount + "]";
	}

}