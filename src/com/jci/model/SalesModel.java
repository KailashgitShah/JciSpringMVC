package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcisales", schema = "dbo")
public class SalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salesid")
	private int salesid;

	@Column(name = "unqno")
	private int unqno;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "vargradeqty")
	private String vargradeqty;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "createdfrom")
	private Date createdfrom;

	@Column(name = "creadtedby")
	private int creadtedby;

	@Column(name = "ipaddress")
	private String ipaddress;

	public SalesModel() {

	}

	public SalesModel(int salesid, int unqno, String jutevariety, String vargradeqty, Date createddate,
			Date createdfrom, int creadtedby, String ipaddress) {
		this.salesid = salesid;
		this.unqno = unqno;
		this.jutevariety = jutevariety;
		this.vargradeqty = vargradeqty;
		this.createddate = createddate;
		this.createdfrom = createdfrom;
		this.creadtedby = creadtedby;
		this.ipaddress = ipaddress;
	}

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public int getUnqno() {
		return unqno;
	}

	public void setUnqno(int unqno) {
		this.unqno = unqno;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getVargradeqty() {
		return vargradeqty;
	}

	public void setVargradeqty(String vargradeqty) {
		this.vargradeqty = vargradeqty;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getCreatedfrom() {
		return createdfrom;
	}

	public void setCreatedfrom(Date createdfrom) {
		this.createdfrom = createdfrom;
	}

	public int getCreadtedby() {
		return creadtedby;
	}

	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "SalesModel [salesid=" + salesid + ", unqno=" + unqno + ", jutevariety=" + jutevariety + ", vargradeqty="
				+ vargradeqty + ", createddate=" + createddate + ", createdfrom=" + createdfrom + ", creadtedby="
				+ creadtedby + ", ipaddress=" + ipaddress + "]";
	}
}
