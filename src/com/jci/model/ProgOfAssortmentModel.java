package com.jci.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcipoa", schema = "dbo")
public class ProgOfAssortmentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poaid")
	private int poaid;

	@Column(name = "dateofpacking")
	private String dateofpacking;

	@Column(name = "basis")
	private String basis;

	@Column(name = "cropyr")
	private String cropyr;

	@Column(name = "placeofpacking")
	private String placeofpacking;

	@Column(name = "binno")
	private String binno;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "jutegrade")
	private int jutegrade;

	@Column(name = "balecheckslipnofrom")
	private String balecheckslipnofrom;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "ipaddress")
	private String ipaddress;

	@Column(name = "balecheckslipnoto")
	private String balecheckslipnoto;

	@Column(name = "numberofbales")
	private int numberofbales;

	public ProgOfAssortmentModel() {

	}

	public ProgOfAssortmentModel(int poaid, String dateofpacking, String basis, String cropyr, String placeofpacking,
			String binno, String jutevariety, int jutegrade, String balecheckslipnofrom, Date createddate,
			String ipaddress, String balecheckslipnoto, int numberofbales) {
		this.poaid = poaid;
		this.dateofpacking = dateofpacking;
		this.basis = basis;
		this.cropyr = cropyr;
		this.placeofpacking = placeofpacking;
		this.binno = binno;
		this.jutevariety = jutevariety;
		this.jutegrade = jutegrade;
		this.balecheckslipnofrom = balecheckslipnofrom;
		this.createddate = createddate;
		this.ipaddress = ipaddress;
		this.balecheckslipnoto = balecheckslipnoto;
		this.numberofbales = numberofbales;
	}

	public int getPoaid() {
		return poaid;
	}

	public void setPoaid(int poaid) {
		this.poaid = poaid;
	}

	public String getDateofpacking() {
		return dateofpacking;
	}

	public void setDateofpacking(String dateofpacking) {
		this.dateofpacking = dateofpacking;
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

	public String getPlaceofpacking() {
		return placeofpacking;
	}

	public void setPlaceofpacking(String placeofpacking) {
		this.placeofpacking = placeofpacking;
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

	public int getJutegrade() {
		return jutegrade;
	}

	public void setJutegrade(int jutegrade) {
		this.jutegrade = jutegrade;
	}

	public String getBalecheckslipnofrom() {
		return balecheckslipnofrom;
	}

	public void setBalecheckslipnofrom(String balecheckslipnofrom) {
		this.balecheckslipnofrom = balecheckslipnofrom;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getBalecheckslipnoto() {
		return balecheckslipnoto;
	}

	public void setBalecheckslipnoto(String balecheckslipnoto) {
		this.balecheckslipnoto = balecheckslipnoto;
	}

	public int getNumberofbales() {
		return numberofbales;
	}

	public void setNumberofbales(int numberofbales) {
		this.numberofbales = numberofbales;
	}

	@Override
	public String toString() {
		return "ProgOfAssortment [poaid=" + poaid + ", dateofpacking=" + dateofpacking + ", basis=" + basis
				+ ", cropyr=" + cropyr + ", placeofpacking=" + placeofpacking + ", binno=" + binno + ", jutevariety="
				+ jutevariety + ", jutegrade=" + jutegrade + ", balecheckslipnofrom=" + balecheckslipnofrom
				+ ", createddate=" + createddate + ", ipaddress=" + ipaddress + ", balecheckslipnoto="
				+ balecheckslipnoto + ", numberofbales=" + numberofbales + "]";
	}
}
