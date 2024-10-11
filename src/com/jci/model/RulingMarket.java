package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcirulingmarket", schema = "dbo")
public class RulingMarket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jcirulingmarketid")
	private int jcirulingmarketid;

	@Column(name="dpcname")
	private String dpcname;

	@Column(name="noofarrival")
	private String noofarrival;

	@Column(name="dateofarrival")
	private String dateofarrival;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="cropyear")
	private String cropyear;

	@Column(name = "arrivedquantity")
	private double arrivedquantity;

	@Column(name = "minmoisture")
	private int minmoisture;

	@Column(name = "maxmoisture")
	private int maxmoisture;

	@Column(name = "gradewisefield")
	private int gradewisefield;

	@Column(name = "gradewiserate")
	private int gradewiserate;

	@Column(name = "estimatedgradecomposition")
	private int estimatedgradecomposition;

	@Column(name = "createdby")
	private int createdby;

	@Column(name= "createddate")
	private Date createddate;

	@Column(name="status")
	private int status;

	public RulingMarket() {

	}

	public RulingMarket(int jcirulingmarketid, String dpcname, String noofarrival, String dateofarrival,
			String jutevariety, String cropyear, double arrivedquantity, int minmoisture, int maxmoisture,
			int gradewisefield, int gradewiserate, int estimatedgradecomposition, int createdby, Date createddate,
			int status) {
		this.jcirulingmarketid = jcirulingmarketid;
		this.dpcname = dpcname;
		this.noofarrival = noofarrival;
		this.dateofarrival = dateofarrival;
		this.jutevariety = jutevariety;
		this.cropyear = cropyear;
		this.arrivedquantity = arrivedquantity;
		this.minmoisture = minmoisture;
		this.maxmoisture = maxmoisture;
		this.gradewisefield = gradewisefield;
		this.gradewiserate = gradewiserate;
		this.estimatedgradecomposition = estimatedgradecomposition;
		this.createdby = createdby;
		this.createddate = createddate;
		this.status = status;
	}

	public int getJcirulingmarketid() {
		return jcirulingmarketid;
	}

	public void setJcirulingmarketid(int jcirulingmarketid) {
		this.jcirulingmarketid = jcirulingmarketid;
	}

	public String getDpcname() {
		return dpcname;
	}

	public void setDpcname(String dpcname) {
		this.dpcname = dpcname;
	}

	public String getNoofarrival() {
		return noofarrival;
	}

	public void setNoofarrival(String noofarrival) {
		this.noofarrival = noofarrival;
	}

	public String getDateofarrival() {
		return dateofarrival;
	}

	public void setDateofarrival(String dateofarrival) {
		this.dateofarrival = dateofarrival;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public String getCropyear() {
		return cropyear;
	}

	public void setCropyear(String cropyear) {
		this.cropyear = cropyear;
	}

	public double getArrivedquantity() {
		return arrivedquantity;
	}

	public void setArrivedquantity(double arrivedquantity) {
		this.arrivedquantity = arrivedquantity;
	}

	public int getMinmoisture() {
		return minmoisture;
	}

	public void setMinmoisture(int minmoisture) {
		this.minmoisture = minmoisture;
	}

	public int getMaxmoisture() {
		return maxmoisture;
	}

	public void setMaxmoisture(int maxmoisture) {
		this.maxmoisture = maxmoisture;
	}

	public int getGradewisefield() {
		return gradewisefield;
	}

	public void setGradewisefield(int gradewisefield) {
		this.gradewisefield = gradewisefield;
	}

	public int getGradewiserate() {
		return gradewiserate;
	}

	public void setGradewiserate(int gradewiserate) {
		this.gradewiserate = gradewiserate;
	}

	public int getEstimatedgradecomposition() {
		return estimatedgradecomposition;
	}

	public void setEstimatedgradecomposition(int estimatedgradecomposition) {
		this.estimatedgradecomposition = estimatedgradecomposition;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RulingMarket [jcirulingmarketid=" + jcirulingmarketid + ", dpcname=" + dpcname + ", noofarrival="
				+ noofarrival + ", dateofarrival=" + dateofarrival + ", jutevariety=" + jutevariety + ", cropyear="
				+ cropyear + ", arrivedquantity=" + arrivedquantity + ", minmoisture=" + minmoisture + ", maxmoisture="
				+ maxmoisture + ", gradewisefield=" + gradewisefield + ", gradewiserate=" + gradewiserate
				+ ", estimatedgradecomposition=" + estimatedgradecomposition + ", createdby=" + createdby
				+ ", createddate=" + createddate + ", status=" + status + "]";
	}
}
