package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicomme", schema = "dbo")
public class CommercialCeilingPriceIntimationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "refid")
	private int refid;

	@Column(name = "dpccode")
	private String dpccode;

	@Column(name = "dateofentry")
	private Date dateofentry;

	@Column(name = "dateofeffect")
	private Date dateofeffect;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "ceilingquantity")
	private String ceilingquantity;

	@Column(name = "jutegrade")
	private String jutegrade;

	@Column(name = "ceilingprice")
	private String ceilingprice;

	@Column(name = "createddate")
	private Date createddate;

	public CommercialCeilingPriceIntimationModel() {

	}



	public int getRrefid() {
		return refid;
	}

	public void setRpmrefid(int rrefid) {
		this.refid = rrefid;
	}

	public String getDpccode() {
		return dpccode;
	}

	public void setDpccode(String dpccode) {
		this.dpccode = dpccode;
	}

	public Date getDateofentry() {
		return dateofentry;
	}

	public void setDateofentry(Date dateofentry) {
		this.dateofentry = dateofentry;
	}

	public Date getDateofeffect() {
		return dateofeffect;
	}

	public void setDateofeffect(Date dateofeffect) {
		this.dateofeffect = dateofeffect;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getCeilingquantity() {
		return ceilingquantity;
	}

	public void setCeilingquantity(String ceilingquantity) {
		this.ceilingquantity = ceilingquantity;
	}

	public String getJutegrade() {
		return jutegrade;
	}

	public void setJutegrade(String jutegrade) {
		this.jutegrade = jutegrade;
	}

	public String getCeilingprice() {
		return ceilingprice;
	}

	public void setCeilingprice(String ceilingprice) {
		this.ceilingprice = ceilingprice;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public CommercialCeilingPriceIntimationModel(int refid, String dpccode, Date dateofentry, Date dateofeffect,
			String jutevariety, String ceilingquantity, String jutegrade, String ceilingprice, Date createddate) {
		super();
		this.refid = refid;
		this.dpccode = dpccode;
		this.dateofentry = dateofentry;
		this.dateofeffect = dateofeffect;
		this.jutevariety = jutevariety;
		this.ceilingquantity = ceilingquantity;
		this.jutegrade = jutegrade;
		this.ceilingprice = ceilingprice;
		this.createddate = createddate;
	}




	@Override
	public String toString() {
		return "CommercialCeilingPriceIntimationModel [refid=" + refid + ", dpccode=" + dpccode + ", dateofentry="
				+ dateofentry + ", dateofeffect=" + dateofeffect + ", jutevariety=" + jutevariety + ", ceilingquantity="
				+ ceilingquantity + ", jutegrade=" + jutegrade + ", ceilingprice=" + ceilingprice + ", createddate="
				+ createddate + "]";
	}




}
