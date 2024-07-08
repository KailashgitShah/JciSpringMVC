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
	

	@Column(name = "Serialno")
	private String Serialno;

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
	
	@Column(name = "contractno")
	private String contractno;
	
	@Column(name = "instrumentno")
	private String instrumentno;
	
	@Column(name = "instrumentdate")
	private String instrumentdate;
	

	@Column(name = "balanceammount")
	private String balanceammount;
	
	

	public String getBalanceammount() {
		return balanceammount;
	}

	public void setBalanceammount(String balanceammount) {
		this.balanceammount = balanceammount;
	}

	public String getInstrumentno() {
		return instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		this.instrumentno = instrumentno;
	}

	public String getInstrumentdate() {
		return instrumentdate;
	}

	public void setInstrumentdate(String instrumentdate) {
		this.instrumentdate = instrumentdate;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

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

	public String getSerialno() {
		return Serialno;
	}

	public void setSerialno(String serialno) {
		Serialno = serialno;
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

	@Override
	public String toString() {
		return "GenerationofDocumentLCsModel [boe_no=" + boe_no + ", boe_Date=" + boe_Date + ", bOS_No=" + bOS_No
				+ ", bOS_Date=" + bOS_Date + ", ivoice_value=" + ivoice_value + ", Serialno=" + Serialno
				+ ", mill_code=" + mill_code + ", topsheetpath=" + topsheetpath + ", bankdrftpath=" + bankdrftpath
				+ ", billofexchangepath=" + billofexchangepath + ", challanono=" + challanono + "]";
	}

	public GenerationofDocumentLCsModel(Integer boe_no, Date boe_Date, String bOS_No, String bOS_Date,
			String ivoice_value, String serialno, String mill_code, String topsheetpath, String bankdrftpath,
			String billofexchangepath, String challanono) {
		super();
		this.boe_no = boe_no;
		this.boe_Date = boe_Date;
		this.bOS_No = bOS_No;
		this.bOS_Date = bOS_Date;
		this.ivoice_value = ivoice_value;
		Serialno = serialno;
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
	
	
	

	
	
	
	

}
