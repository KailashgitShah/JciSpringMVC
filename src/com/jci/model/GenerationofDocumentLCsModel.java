package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "jciboe", schema = "dbo")
public class GenerationofDocumentLCsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Boe_no" )
	private Integer Boe_no;


	
	
	@Column(name = "Boe_Date")
	private Date Boe_Date;

	@Column(name = "BOS_No" )
	private String BOS_No;
	
	
	@Column(name = "BOS_Date")
	private String BOS_Date;
	
	
	@Column(name = "Ivoice_value")
	private String Ivoice_value;
	
	@Column(name = "Instrument_no")
	private String Instrument_no;
	
	@Column(name = "Quantity")
	private String Quantity;
	
	@Column(name = "Ho_di_No")
	private String Ho_di_No;
	
	@Column(name = "Ho_di_date")
	private String Ho_di_date;
	
	
	@Column(name = "Bos_Amt")
	private String Bos_Amt;


	
	
	@Column(name = "Mill_code")
	private String Mill_code;

	public String getMill_code() {
		return Mill_code;
	}


	public void setMill_code(String mill_code) {
		Mill_code = mill_code;
	}

//
//	public int getBoe_no() {
//		return Boe_no;
//	}
//
//
//	public void setBoe_no(int boe_no) {
//		Boe_no = boe_no;
//	}


	public Date getBoe_Date() {
		return Boe_Date;
	}


	public void setBoe_Date(Date boe_Date) {
		Boe_Date = boe_Date;
	}


	public String getBOS_No() {
		return BOS_No;
	}


	public void setBOS_No(String bOS_No) {
		BOS_No = bOS_No;
	}


	public String getBOS_Date() {
		return BOS_Date;
	}


	public void setBOS_Date(String bOS_Date) {
		BOS_Date = bOS_Date;
	}


	public String getIvoice_value() {
		return Ivoice_value;
	}


	public void setIvoice_value(String ivoice_value) {
		Ivoice_value = ivoice_value;
	}


	public String getInstrument_no() {
		return Instrument_no;
	}


	public void setInstrument_no(String instrument_no) {
		Instrument_no = instrument_no;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
	}


	public String getHo_di_No() {
		return Ho_di_No;
	}


	public void setHo_di_No(String ho_di_No) {
		Ho_di_No = ho_di_No;
	}


	public String getHo_di_date() {
		return Ho_di_date;
	}


	public void setHo_di_date(String ho_di_date) {
		Ho_di_date = ho_di_date;
	}


	public String getBos_Amt() {
		return Bos_Amt;
	}


	public void setBos_Amt(String bos_Amt) {
		Bos_Amt = bos_Amt;
	}


	@Override
	public String toString() {
		return "GenerationofDocumentLCsModel [Boe_no=" + Boe_no + ", Boe_Date=" + Boe_Date + ", BOS_No=" + BOS_No
				+ ", BOS_Date=" + BOS_Date + ", Ivoice_value=" + Ivoice_value + ", Instrument_no=" + Instrument_no
				+ ", Quantity=" + Quantity + ", Ho_di_No=" + Ho_di_No + ", Ho_di_date=" + Ho_di_date + ", Bos_Amt="
				+ Bos_Amt + "]";
	}


	public GenerationofDocumentLCsModel(int boe_no, Date boe_Date, String bOS_No, String bOS_Date,
			String ivoice_value, String instrument_no, String quantity, String ho_di_No, String ho_di_date,
			String bos_Amt) {
		super();
		Boe_no = boe_no;
		Boe_Date = boe_Date;
		BOS_No = bOS_No;
		BOS_Date = bOS_Date;
		Ivoice_value = ivoice_value;
		Instrument_no = instrument_no;
		Quantity = quantity;
		Ho_di_No = ho_di_No;
		Ho_di_date = ho_di_date;
		Bos_Amt = bos_Amt;
	}


	public GenerationofDocumentLCsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

}
