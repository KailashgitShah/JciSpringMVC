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
	private Integer boe_no;


	
	
	@Column(name = "Boe_Date")
	private Date boe_Date;

	@Column(name = "BOS_No" )
	private String bOS_No;
	
	
	@Column(name = "BOS_Date")
	private String bOS_Date;
	
	
	@Column(name = "Ivoice_value")
	private String ivoice_value;
	
	@Column(name = "Instrument_no")
	private String instrument_no;
	
	@Column(name = "Quantity")
	private String quantity;
	
	@Column(name = "Ho_di_No")
	private String ho_di_No;
	
	@Column(name = "Ho_di_date")
	private String ho_di_date;
	
	
	@Column(name = "Bos_Amt")
	private String bos_Amt;


	
	
	@Column(name = "Mill_code")
	private String mill_code;
	
	@Column(name = "topsheetpath")
	private String topsheetpath;
	
	@Column(name = "bankdrftpath")
	private String bankdrftpath;
	
	@Column(name = "billofexchangepath")
	private String billofexchangepath;
	
	@Column(name = "challanono")
	private String challanono;

	public Integer getBoe_no() {
		return boe_no;
	}

	public void setBoe_no(Integer boe_no) {
		this.boe_no = boe_no;
	}

	public Date getBoe_Date() {
		return boe_Date;
	}

	public void setBoe_Date(Date boe_Date) {
		this.boe_Date = boe_Date;
	}

	public String getbOS_No() {
		return bOS_No;
	}

	public void setbOS_No(String bOS_No) {
		this.bOS_No = bOS_No;
	}

	public String getbOS_Date() {
		return bOS_Date;
	}

	public void setbOS_Date(String bOS_Date) {
		this.bOS_Date = bOS_Date;
	}

	public String getIvoice_value() {
		return ivoice_value;
	}

	public void setIvoice_value(String ivoice_value) {
		this.ivoice_value = ivoice_value;
	}

	public String getInstrument_no() {
		return instrument_no;
	}

	public void setInstrument_no(String instrument_no) {
		this.instrument_no = instrument_no;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getHo_di_No() {
		return ho_di_No;
	}

	public void setHo_di_No(String ho_di_No) {
		this.ho_di_No = ho_di_No;
	}

	public String getHo_di_date() {
		return ho_di_date;
	}

	public void setHo_di_date(String ho_di_date) {
		this.ho_di_date = ho_di_date;
	}

	public String getBos_Amt() {
		return bos_Amt;
	}

	public void setBos_Amt(String bos_Amt) {
		this.bos_Amt = bos_Amt;
	}

	public String getMill_code() {
		return mill_code;
	}

	public void setMill_code(String mill_code) {
		this.mill_code = mill_code;
	}

	public String getTopsheetpath() {
		return topsheetpath;
	}

	public void setTopsheetpath(String topsheetpath) {
		this.topsheetpath = topsheetpath;
	}

	public String getBankdrftpath() {
		return bankdrftpath;
	}

	public void setBankdrftpath(String bankdrftpath) {
		this.bankdrftpath = bankdrftpath;
	}

	public String getBillofexchangepath() {
		return billofexchangepath;
	}

	public void setBillofexchangepath(String billofexchangepath) {
		this.billofexchangepath = billofexchangepath;
	}

	public String getChallanono() {
		return challanono;
	}

	public void setChallanono(String challanono) {
		this.challanono = challanono;
	}

	public GenerationofDocumentLCsModel(Integer boe_no, Date boe_Date, String bOS_No, String bOS_Date,
			String ivoice_value, String instrument_no, String quantity, String ho_di_No, String ho_di_date,
			String bos_Amt, String mill_code, String topsheetpath, String bankdrftpath, String billofexchangepath,
			String challanono) {
		super();
		this.boe_no = boe_no;
		this.boe_Date = boe_Date;
		this.bOS_No = bOS_No;
		this.bOS_Date = bOS_Date;
		this.ivoice_value = ivoice_value;
		this.instrument_no = instrument_no;
		this.quantity = quantity;
		this.ho_di_No = ho_di_No;
		this.ho_di_date = ho_di_date;
		this.bos_Amt = bos_Amt;
		this.mill_code = mill_code;
		this.topsheetpath = topsheetpath;
		this.bankdrftpath = bankdrftpath;
		this.billofexchangepath = billofexchangepath;
		this.challanono = challanono;
	}

	public GenerationofDocumentLCsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GenerationofDocumentLCsModel [boe_no=" + boe_no + ", boe_Date=" + boe_Date + ", bOS_No=" + bOS_No
				+ ", bOS_Date=" + bOS_Date + ", ivoice_value=" + ivoice_value + ", instrument_no=" + instrument_no
				+ ", quantity=" + quantity + ", ho_di_No=" + ho_di_No + ", ho_di_date=" + ho_di_date + ", bos_Amt="
				+ bos_Amt + ", mill_code=" + mill_code + ", topsheetpath=" + topsheetpath + ", bankdrftpath="
				+ bankdrftpath + ", billofexchangepath=" + billofexchangepath + ", challanono=" + challanono + "]";
	}
	
	
	
	
	
	

}
