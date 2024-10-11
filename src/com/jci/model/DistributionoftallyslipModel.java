package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcislip")

public class DistributionoftallyslipModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "refid")
	private int refid;

	@Column(name = "dpccode")
	private String dpccode;

	@Column(name = "dateofreceipt")
	private String dateofreceipt;

	@Column(name = "slipreceived")
	private String slipreceived;

	@Column(name = "seriesstartfrom")
	private String seriesstartfrom;

	@Column(name = "seriestoend")
	private String seriestoend;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "zone")
	private String zone;
	
	@Column(name = "region")
	private String region;
	
	public DistributionoftallyslipModel() {

	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getDpccode() {
		return dpccode;
	}

	public void setDpccode(String dpccode) {
		this.dpccode = dpccode;
	}

	public String getDateofreceipt() {
		return dateofreceipt;
	}

	public void setDateofreceipt(String dateofreceipt) {
		this.dateofreceipt = dateofreceipt;
	}

	public String getSlipreceived() {
		return slipreceived;
	}

	public void setSlipreceived(String slipreceived) {
		this.slipreceived = slipreceived;
	}

	public String getSeriesstartfrom() {
		return seriesstartfrom;
	}

	public void setSeriesstartfrom(String seriesstartfrom) {
		this.seriesstartfrom = seriesstartfrom;
	}

	public String getSeriestoend() {
		return seriestoend;
	}

	public void setSeriestoend(String seriestoend) {
		this.seriestoend = seriestoend;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "DistributionoftallyslipModel [refid=" + refid + ", dpccode=" + dpccode + ", dateofreceipt="
				+ dateofreceipt + ", slipreceived=" + slipreceived + ", seriesstartfrom=" + seriesstartfrom
				+ ", seriestoend=" + seriestoend + ", createddate=" + createddate + ", zone=" + zone + ", region="
				+ region + "]";
	}


	

}

