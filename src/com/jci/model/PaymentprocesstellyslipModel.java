package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "jcitallyslippayment", schema = "dbo")
public class PaymentprocesstellyslipModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int payment_id;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "debitAC_no")
	private String debitAC_no;
	
	@Column(name = "beneficiary_IFSC_code")
	private String beneficiary_IFSC_code;
	
	@Column(name = "beneficiaryAC_No")
	private String beneficiaryAC_No;
	
	@Column(name = "AC_type")
	private String AC_type;
	
	@Column(name = "beneficiary_name")
	private String beneficiary_name;
	
	@Column(name = "beneficiary_branch")
	private String beneficiary_branch; 
	
	@Column(name = "JCI_Ref")
	private String JCI_Ref;
	
	@Column(name = "sender")
	private String sender;
	
	@Column(name = "beneficiary_bank")
	private String beneficiary_bank;
	
	@Column(name = "purchase_date")
	private String purchase_date;
	
	@Column(name = "UTR_no")
	private String UTR_no;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "excel_link")
	private String excel_link;
	
	@Column(name = "dpc_name")
	private String dpc_name;
    
	@Column(name = "farmerreg_no")
   	private String farmerreg_no;
	
	@Column(name = "Region_id")
   	private String Region_id;
	

	public String getRegion_id() {
		return Region_id;
	}

	public void setRegion_id(String region_id) {
		Region_id = region_id;
	}

	public String getDpc_name() {
		return dpc_name;
	}

	public void setDpc_name(String dpc_name) {
		this.dpc_name = dpc_name;
	}

	public String getFarmerreg_no() {
		return farmerreg_no;
	}

	public void setFarmerreg_no(String farmerreg_no) {
		this.farmerreg_no = farmerreg_no;
	}

	public String getExcel_link() {
		return excel_link;
	}

	public void setExcel_link(String excel_link) {
		this.excel_link = excel_link;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDebitAC_no() {
		return debitAC_no;
	}

	public void setDebitAC_no(String debitAC_no) {
		this.debitAC_no = debitAC_no;
	}

	public String getBeneficiary_IFSC_code() {
		return beneficiary_IFSC_code;
	}

	public void setBeneficiary_IFSC_code(String beneficiary_IFSC_code) {
		this.beneficiary_IFSC_code = beneficiary_IFSC_code;
	}

	public String getBeneficiaryAC_No() {
		return beneficiaryAC_No;
	}

	public void setBeneficiaryAC_No(String beneficiaryAC_No) {
		this.beneficiaryAC_No = beneficiaryAC_No;
	}

	public String getAC_type() {
		return AC_type;
	}

	public void setAC_type(String aC_type) {
		AC_type = aC_type;
	}

	public String getBeneficiary_name() {
		return beneficiary_name;
	}

	public void setBeneficiary_name(String beneficiary_name) {
		this.beneficiary_name = beneficiary_name;
	}

	public String getBeneficiary_branch() {
		return beneficiary_branch;
	}

	public void setBeneficiary_branch(String beneficiary_branch) {
		this.beneficiary_branch = beneficiary_branch;
	}

	public String getJCI_Ref() {
		return JCI_Ref;
	}

	public void setJCI_Ref(String jCI_Ref) {
		JCI_Ref = jCI_Ref;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getBeneficiary_bank() {
		return beneficiary_bank;
	}

	public void setBeneficiary_bank(String beneficiary_bank) {
		this.beneficiary_bank = beneficiary_bank;
	}

	 
	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getUTR_no() {
		return UTR_no;
	}

	public void setUTR_no(String uTR_no) {
		UTR_no = uTR_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "PaymentprocesstellyslipModel [payment_id=" + payment_id + ", amount=" + amount + ", debitAC_no="
				+ debitAC_no + ", beneficiary_IFSC_code=" + beneficiary_IFSC_code + ", beneficiaryAC_No="
				+ beneficiaryAC_No + ", AC_type=" + AC_type + ", beneficiary_name=" + beneficiary_name
				+ ", beneficiary_branch=" + beneficiary_branch + ", JCI_Ref=" + JCI_Ref + ", sender=" + sender
				+ ", beneficiary_bank=" + beneficiary_bank + ", purchase_date=" + purchase_date + ", UTR_no=" + UTR_no
				+ ", date=" + date + ", excel_link=" + excel_link + ", dpc_name=" + dpc_name + ", farmerreg_no="
				+ farmerreg_no + ", Region_id=" + Region_id + "]";
	}

	

	public PaymentprocesstellyslipModel(int payment_id, double amount, String debitAC_no, String beneficiary_IFSC_code,
			String beneficiaryAC_No, String aC_type, String beneficiary_name, String beneficiary_branch, String jCI_Ref,
			String sender, String beneficiary_bank, String purchase_date, String uTR_no, String date, String excel_link,
			String dpc_name, String farmerreg_no, String region_id) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.debitAC_no = debitAC_no;
		this.beneficiary_IFSC_code = beneficiary_IFSC_code;
		this.beneficiaryAC_No = beneficiaryAC_No;
		AC_type = aC_type;
		this.beneficiary_name = beneficiary_name;
		this.beneficiary_branch = beneficiary_branch;
		JCI_Ref = jCI_Ref;
		this.sender = sender;
		this.beneficiary_bank = beneficiary_bank;
		this.purchase_date = purchase_date;
		UTR_no = uTR_no;
		this.date = date;
		this.excel_link = excel_link;
		this.dpc_name = dpc_name;
		this.farmerreg_no = farmerreg_no;
		Region_id = region_id;
	}

	public PaymentprocesstellyslipModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
