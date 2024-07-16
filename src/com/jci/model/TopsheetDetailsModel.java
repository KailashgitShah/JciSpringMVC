package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcitopsheet", schema = "dbo")
public class TopsheetDetailsModel {
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "topSheet_id")
	    private Long topSheet_id ; // Primary key, assumed to be BigInt
	    private String bosDate;
	    private String billOfSupplyNo;
	    private String topSheetCreateDate;
	    private String invoiceValue;
	    private String amount;
	    private String topsheet_generated_id;
	    private String contract_no;
	    private String contract_identification_no;
	    private String contract_date;
	    private String cropYear;
	    private String millcode;
	    private String millname;
	    private String milladdress;
	    private String hodiNo;
	    private String hodiDate;
	    private String balanceAmount;
	    private String topSheetNl;
	    private String boeNl;
	    
		public Long getTopSheet_id() {
			return topSheet_id;
		}
		public void setTopSheet_id(Long topSheet_id) {
			this.topSheet_id = topSheet_id;
		}
		public String getBosDate() {
			return bosDate;
		}
		public void setBosDate(String bosDate) {
			this.bosDate = bosDate;
		}
		public String getBillOfSupplyNo() {
			return billOfSupplyNo;
		}
		public void setBillOfSupplyNo(String billOfSupplyNo) {
			this.billOfSupplyNo = billOfSupplyNo;
		}
		public String getTopSheetCreateDate() {
			return topSheetCreateDate;
		}
		public void setTopSheetCreateDate(String topSheetCreateDate) {
			this.topSheetCreateDate = topSheetCreateDate;
		}
		public String getInvoiceValue() {
			return invoiceValue;
		}
		public void setInvoiceValue(String invoiceValue) {
			this.invoiceValue = invoiceValue;
		}
		
		
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getTopsheet_generated_id() {
			return topsheet_generated_id;
		}
		public void setTopsheet_generated_id(String topsheet_generated_id) {
			this.topsheet_generated_id = topsheet_generated_id;
		}
		
		public String getContract_no() {
			return contract_no;
		}
		public void setContract_no(String contract_no) {
			this.contract_no = contract_no;
		}
		public String getContract_identification_no() {
			return contract_identification_no;
		}
		public void setContract_identification_no(String contract_identification_no) {
			this.contract_identification_no = contract_identification_no;
		}
		public String getContract_date() {
			return contract_date;
		}
		public void setContract_date(String contract_date) {
			this.contract_date = contract_date;
		}
		public String getCropYear() {
			return cropYear;
		}
		public void setCropYear(String cropYear) {
			this.cropYear = cropYear;
		}
		public String getMillcode() {
			return millcode;
		}
		public void setMillcode(String millcode) {
			this.millcode = millcode;
		}
		public String getMillname() {
			return millname;
		}
		public void setMillname(String millname) {
			this.millname = millname;
		}
		public String getMilladdress() {
			return milladdress;
		}
		public void setMilladdress(String milladdress) {
			this.milladdress = milladdress;
		}
		
		
		public String getHodiNo() {
			return hodiNo;
		}
		public void setHodiNo(String hodiNo) {
			this.hodiNo = hodiNo;
		}
		public String getHodiDate() {
			return hodiDate;
		}
		public void setHodiDate(String hodiDate) {
			this.hodiDate = hodiDate;
		}
		
		public String getBalanceAmount() {
			return balanceAmount;
		}
		public void setBalanceAmount(String balanceAmount) {
			this.balanceAmount = balanceAmount;
		}
		
		public String getTopSheetNl() {
			return topSheetNl;
		}
		public void setTopSheetNl(String topSheetNl) {
			this.topSheetNl = topSheetNl;
		}
		public String getBoeNl() {
			return boeNl;
		}
		public void setBoeNl(String boeNl) {
			this.boeNl = boeNl;
		}
		public TopsheetDetailsModel() {
			super();
		}
		public TopsheetDetailsModel(Long topSheet_id, String bosDate, String billOfSupplyNo, String topSheetCreateDate,
				String invoiceValue, String amount, String topsheet_generated_id, String contract_no,
				String contract_identification_no, String contract_date, String cropYear, String millcode,
				String millname, String milladdress, String hodiNo, String hodiDate, String balanceAmount,
				String topSheetNl, String boeNl) {
			super();
			this.topSheet_id = topSheet_id;
			this.bosDate = bosDate;
			this.billOfSupplyNo = billOfSupplyNo;
			this.topSheetCreateDate = topSheetCreateDate;
			this.invoiceValue = invoiceValue;
			this.amount = amount;
			this.topsheet_generated_id = topsheet_generated_id;
			this.contract_no = contract_no;
			this.contract_identification_no = contract_identification_no;
			this.contract_date = contract_date;
			this.cropYear = cropYear;
			this.millcode = millcode;
			this.millname = millname;
			this.milladdress = milladdress;
			this.hodiNo = hodiNo;
			this.hodiDate = hodiDate;
			this.balanceAmount = balanceAmount;
			this.topSheetNl = topSheetNl;
			this.boeNl = boeNl;
		}
		@Override
		public String toString() {
			return "TopsheetDetailsModel [topSheet_id=" + topSheet_id + ", bosDate=" + bosDate + ", billOfSupplyNo="
					+ billOfSupplyNo + ", topSheetCreateDate=" + topSheetCreateDate + ", invoiceValue=" + invoiceValue
					+ ", amount=" + amount + ", topsheet_generated_id=" + topsheet_generated_id + ", contract_no="
					+ contract_no + ", contract_identification_no=" + contract_identification_no + ", contract_date="
					+ contract_date + ", cropYear=" + cropYear + ", millcode=" + millcode + ", millname=" + millname
					+ ", milladdress=" + milladdress + ", hodiNo=" + hodiNo + ", hodiDate=" + hodiDate
					+ ", balanceAmount=" + balanceAmount + ", topSheetNl=" + topSheetNl + ", boeNl=" + boeNl + "]";
		}
		
		

}
