package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BinPurchaseMappingDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String Date_of_purchase;
	private String Dpc_code;
	private String Basis;
	private String Jute_Variety;
	
	private String Crop_Year;
	private String BinNo;
	private String GrossQty;
	private String DeductionQty;
	
	private String NetQty;
	
	
	private String GarsatRate;
	private String Value;
	

	public String getGarsatRate() {
		return GarsatRate;
	}

	public void setGarsatRate(String garsatRate) {
		GarsatRate = garsatRate;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getDate_of_purchase() {
		return Date_of_purchase;
	}

	public void setDate_of_purchase(String date_of_purchase) {
		Date_of_purchase = date_of_purchase;
	}

	public String getDpc_code() {
		return Dpc_code;
	}

	public void setDpc_code(String dpc_code) {
		Dpc_code = dpc_code;
	}

	public String getBasis() {
		return Basis;
	}

	public void setBasis(String basis) {
		Basis = basis;
	}

	public String getJute_Variety() {
		return Jute_Variety;
	}
private void sysout() {
	// TODO Auto-generated method stub

}
	public void setJute_Variety(String jute_Variety) {
		Jute_Variety = jute_Variety;
	}

	public String getCrop_Year() {
		return Crop_Year;
	}

	public void setCrop_Year(String crop_Year) {
		Crop_Year = crop_Year;
	}

	public String getBinNo() {
		return BinNo;
	}

	public void setBinNo(String binNo) {
		BinNo = binNo;
	}

	public String getGrossQty() {
		return GrossQty;
	}

	public void setGrossQty(String grossQty) {
		GrossQty = grossQty;
	}

	public String getDeductionQty() {
		return DeductionQty;
	}

	public void setDeductionQty(String deductionQty) {
		DeductionQty = deductionQty;
	}

	public String getNetQty() {
		return NetQty;
	}

	public void setNetQty(String netQty) {
		NetQty = netQty;
	}

}
