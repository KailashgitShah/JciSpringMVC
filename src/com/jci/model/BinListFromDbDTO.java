package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BinListFromDbDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
 
	 
	private String TotalValue;
	private String TotalNetQty;
	private String TotalGarset;
	private String BinNO;
	
	private String Crop_Year;
	private String EntryDt;
	
	private String FinGain;
	public String getFinGain() {
		return FinGain;
	}
	public void setFinGain(String finGain) {
		FinGain = finGain;
	}
	private String WeightGain;
	
	public String getWeightGain() {
		return WeightGain;
	}
	public void setWeightGain(String weightGain) {
		WeightGain = weightGain;
	}
	public String getTotalValue() {
		return TotalValue;
	}
	public void setTotalValue(String totalValue) {
		TotalValue = totalValue;
	}
	public String getTotalNetQty() {
		return TotalNetQty;
	}
	public void setTotalNetQty(String totalNetQty) {
		TotalNetQty = totalNetQty;
	}
	public String getTotalGarset() {
		return TotalGarset;
	}
	public void setTotalGarset(String totalGarset) {
		TotalGarset = totalGarset;
	}
	public String getBinNO() {
		return BinNO;
	}
	public void setBinNO(String binNO) {
		BinNO = binNO;
	}
	public String getCrop_Year() {
		return Crop_Year;
	}
	public void setCrop_Year(String crop_Year) {
		Crop_Year = crop_Year;
	}
	public String getEntryDt() {
		return EntryDt;
	}
	public void setEntryDt(String entryDt) {
		EntryDt = entryDt;
	}  

}
