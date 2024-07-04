package com.jci.model;

public class BillofSupplyDocDTO {
 private  int siNo;
 private  String hsn;
 private  String description;
 private  String cropyear;
 private  String balemark;
 private  String variety;
 private  int no_of_bales;
 private  double nominalWt;
 private  String unit;
 private  Double rate;
 private  Double qty;
 private  Double alltotal;
 private  Double total;
public int getSiNo() {
	return siNo;
}
public void setSiNo(int siNo) {
	this.siNo = siNo;
}
public String getHsn() {
	return hsn;
}
public void setHsn(String hsn) {
	this.hsn = hsn;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCropyear() {
	return cropyear;
}
public void setCropyear(String cropyear) {
	this.cropyear = cropyear;
}
public String getBalemark() {
	return balemark;
}
public void setBalemark(String balemark) {
	this.balemark = balemark;
}
public String getVariety() {
	return variety;
}
public void setVariety(String variety) {
	this.variety = variety;
}
public int getNo_of_bales() {
	return no_of_bales;
}
public void setNo_of_bales(int no_of_bales) {
	this.no_of_bales = no_of_bales;
}
public double getNominalWt() {
	return nominalWt;
}
public void setNominalWt(double nominalWt) {
	this.nominalWt = nominalWt;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public Double getRate() {
	return rate;
}
public void setRate(Double rate) {
	this.rate = rate;
}
public Double getQty() {
	return qty;
}
public void setQty(Double qty) {
	this.qty = qty;
}
public Double getAlltotal() {
	return alltotal;
}
public void setAlltotal(Double alltotal) {
	this.alltotal = alltotal;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
@Override
public String toString() {
	return "BillofSupplyDocDTO [siNo=" + siNo + ", hsn=" + hsn + ", description=" + description + ", cropyear="
			+ cropyear + ", balemark=" + balemark + ", variety=" + variety + ", no_of_bales=" + no_of_bales
			+ ", nominalWt=" + nominalWt + ", unit=" + unit + ", rate=" + rate + ", qty=" + qty + ", alltotal="
			+ alltotal + ", total=" + total + "]";
}
public BillofSupplyDocDTO(int siNo, String hsn, String description, String cropyear, String balemark, String variety,
		int no_of_bales, double nominalWt, String unit, Double rate, Double qty, Double alltotal, Double total) {
	super();
	this.siNo = siNo;
	this.hsn = hsn;
	this.description = description;
	this.cropyear = cropyear;
	this.balemark = balemark;
	this.variety = variety;
	this.no_of_bales = no_of_bales;
	this.nominalWt = nominalWt;
	this.unit = unit;
	this.rate = rate;
	this.qty = qty;
	this.alltotal = alltotal;
	this.total = total;
}
public BillofSupplyDocDTO() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
}
