package com.jci.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcioperationfreesales_cost", catalog="XMWJCI", schema = "dbo")
public class OperationFreeSales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofc_id")
	private int ofc_id;
	
	@Column(name = "crop_year")
	private String crop_year;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "dpc")
	private String dpc;
	
	@Column(name = "operation_cost_head")
	private String operation_cost_head;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "is_transport")
	private int is_transport;
	
	@Column(name = "valid_till")
	private String valid_till;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "basis")
	private String basis;



	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public int getOfc_id() {
		return ofc_id;
	}

	public void setOfc_id(int ofc_id) {
		this.ofc_id = ofc_id;
	}

	public String getCrop_year() {
		return crop_year;
	}

	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
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

	public String getOperation_cost_head() {
		return operation_cost_head;
	}

	public void setOperation_cost_head(String operation_cost_head) {
		this.operation_cost_head = operation_cost_head;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getIs_transport() {
		return is_transport;
	}

	public void setIs_transport(int is_transport) {
		this.is_transport = is_transport;
	}

	public String getValid_till() {
		return valid_till;
	}

	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public OperationFreeSales(int ofc_id, String crop_year, String region, String dpc, String operation_cost_head,
			double rate, String unit, int is_transport, String valid_till, String created_by, Date created_date,
			String basis) {
		super();
		this.ofc_id = ofc_id;
		this.crop_year = crop_year;
		this.region = region;
		this.dpc = dpc;
		this.operation_cost_head = operation_cost_head;
		this.rate = rate;
		this.unit = unit;
		this.is_transport = is_transport;
		this.valid_till = valid_till;
		this.created_by = created_by;
		this.created_date = created_date;
		this.basis = basis;
	}

	public OperationFreeSales() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OperationFreeSales [ofc_id=" + ofc_id + ", crop_year=" + crop_year + ", region=" + region + ", dpc="
				+ dpc + ", operation_cost_head=" + operation_cost_head + ", rate=" + rate + ", unit=" + unit
				+ ", is_transport=" + is_transport + ", valid_till=" + valid_till + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", basis=" + basis + "]";
	}

	
}

