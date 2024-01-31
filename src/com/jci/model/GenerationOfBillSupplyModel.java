package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "jcibos_generation")
public class GenerationOfBillSupplyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Bos_id")
	private Integer Bos_id;

	@Column(name = "Challan_No", unique = true, nullable = false)
	private String Challan_No;

	@Column(name = "Challan_date", nullable = false)
	private String Challan_date;

	@Column(name = "Shipment_details", nullable = false)
	private String Shipment_details;

	@Column(name = "Shipment_value", nullable = false)
	private String Shipment_value;

	@Column(name = "SGST_amt", nullable = false)
	private String SGST_amt;

	@Column(name = "CGST_amt", nullable = false)
	private String CGST_amt;

	@Column(name = "IGST_amt", nullable = false)
	private String IGST_amt;

	@Column(name = "TCS_amt", nullable = false)
	private String TCS_amt;

	@Column(name = "TDS_amt", nullable = false)
	private String TDS_amt;

	@Column(name = "Invoice_value", nullable = false)
	private String Invoice_value;

	@Column(name = "Bill_of_supply_no", unique = true, nullable = false)
	private String Bill_of_supply_no;

	@Column(name = "BOS_date", nullable = false)
	private String BOS_date;

	@Column(name = "Supplier_name", nullable = false)
	private String Supplier_name;

	@Column(name = "Supplier_gSTN", nullable = false)
	private String Supplier_gSTN;

	@Column(name = "Supplier_address", nullable = false)
	private String Supplier_address;

	@Column(name = "Recipient_name", nullable = false)
	private String Recipient_name;

	@Column(name = "Recipient_gSTN", nullable = false)
	private String Recipient_gSTN;

	@Column(name = "Recipient_address", nullable = false)
	private String Recipient_address;

	@Column(name = "Consignee_name", nullable = false)
	private String Consignee_name;

	@Column(name = "Consignee_gSTN", nullable = false)
	private String Consignee_gSTN;

	@Column(name = "Consignee_address", nullable = false)
	private String Consignee_address;

	@Column(name = "Bos_file_path")
	private String Bos_file_path;

	@Column(name = "Ro_id", nullable = false)
	private String Ro_id;

	@Column(name = "Creation_date", nullable = false)
	private Date Creation_date;
	
	@Column(name = "Contract_no", nullable = false)
	private String Contract_no;
	
	@Column(name = "Remarks")
	private String Remarks;

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public Integer getBos_id() {
		return Bos_id;
	}

	public void setBos_id(Integer bos_id) {
		Bos_id = bos_id;
	}

	public String getChallan_No() {
		return Challan_No;
	}

	public void setChallan_No(String challan_No) {
		Challan_No = challan_No;
	}

	public String getChallan_date() {
		return Challan_date;
	}

	public void setChallan_date(String challan_date) {
		Challan_date = challan_date;
	}

	public String getShipment_details() {
		return Shipment_details;
	}

	public void setShipment_details(String shipment_details) {
		Shipment_details = shipment_details;
	}

	public String getShipment_value() {
		return Shipment_value;
	}

	public void setShipment_value(String shipment_value) {
		Shipment_value = shipment_value;
	}

	public String getSGST_amt() {
		return SGST_amt;
	}

	public void setSGST_amt(String sGST_amt) {
		SGST_amt = sGST_amt;
	}

	public String getCGST_amt() {
		return CGST_amt;
	}

	public void setCGST_amt(String cGST_amt) {
		CGST_amt = cGST_amt;
	}

	public String getIGST_amt() {
		return IGST_amt;
	}

	public void setIGST_amt(String iGST_amt) {
		IGST_amt = iGST_amt;
	}

	public String getTCS_amt() {
		return TCS_amt;
	}

	public void setTCS_amt(String tCS_amt) {
		TCS_amt = tCS_amt;
	}

	public String getTDS_amt() {
		return TDS_amt;
	}

	public void setTDS_amt(String tDS_amt) {
		TDS_amt = tDS_amt;
	}

	public String getInvoice_value() {
		return Invoice_value;
	}

	public void setInvoice_value(String invoice_value) {
		Invoice_value = invoice_value;
	}

	public String getBill_of_supply_no() {
		return Bill_of_supply_no;
	}

	public void setBill_of_supply_no(String bill_of_supply_no) {
		Bill_of_supply_no = bill_of_supply_no;
	}

	public String getBOS_date() {
		return BOS_date;
	}

	public void setBOS_date(String bOS_date) {
		BOS_date = bOS_date;
	}

	public String getSupplier_name() {
		return Supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		Supplier_name = supplier_name;
	}

	public String getSupplier_gSTN() {
		return Supplier_gSTN;
	}

	public void setSupplier_gSTN(String supplier_gSTN) {
		Supplier_gSTN = supplier_gSTN;
	}

	public String getSupplier_address() {
		return Supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		Supplier_address = supplier_address;
	}

	public String getRecipient_name() {
		return Recipient_name;
	}

	public void setRecipient_name(String recipient_name) {
		Recipient_name = recipient_name;
	}

	public String getRecipient_gSTN() {
		return Recipient_gSTN;
	}

	public void setRecipient_gSTN(String recipient_gSTN) {
		Recipient_gSTN = recipient_gSTN;
	}

	public String getRecipient_address() {
		return Recipient_address;
	}

	public void setRecipient_address(String recipient_address) {
		Recipient_address = recipient_address;
	}

	public String getConsignee_name() {
		return Consignee_name;
	}

	public void setConsignee_name(String consignee_name) {
		Consignee_name = consignee_name;
	}

	public String getConsignee_gSTN() {
		return Consignee_gSTN;
	}

	public void setConsignee_gSTN(String consignee_gSTN) {
		Consignee_gSTN = consignee_gSTN;
	}

	public String getConsignee_address() {
		return Consignee_address;
	}

	public void setConsignee_address(String consignee_address) {
		Consignee_address = consignee_address;
	}

	public String getBos_file_path() {
		return Bos_file_path;
	}

	public void setBos_file_path(String bos_file_path) {
		Bos_file_path = bos_file_path;
	}

	public String getRo_id() {
		return Ro_id;
	}

	public void setRo_id(String ro_id) {
		Ro_id = ro_id;
	}

	public Date getCreation_date() {
		return Creation_date;
	}

	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}

	public String getContract_no() {
		return Contract_no;
	}

	public void setContract_no(String contract_no) {
		Contract_no = contract_no;
	}

	public GenerationOfBillSupplyModel(Integer bos_id, String challan_No, String challan_date, String shipment_details,
			String shipment_value, String sGST_amt, String cGST_amt, String iGST_amt, String tCS_amt, String tDS_amt,
			String invoice_value, String bill_of_supply_no, String bOS_date, String supplier_name, String supplier_gSTN,
			String supplier_address, String recipient_name, String recipient_gSTN, String recipient_address,
			String consignee_name, String consignee_gSTN, String consignee_address, String bos_file_path, String ro_id,
			Date creation_date, String contract_no) {
		super();
		Bos_id = bos_id;
		Challan_No = challan_No;
		Challan_date = challan_date;
		Shipment_details = shipment_details;
		Shipment_value = shipment_value;
		SGST_amt = sGST_amt;
		CGST_amt = cGST_amt;
		IGST_amt = iGST_amt;
		TCS_amt = tCS_amt;
		TDS_amt = tDS_amt;
		Invoice_value = invoice_value;
		Bill_of_supply_no = bill_of_supply_no;
		BOS_date = bOS_date;
		Supplier_name = supplier_name;
		Supplier_gSTN = supplier_gSTN;
		Supplier_address = supplier_address;
		Recipient_name = recipient_name;
		Recipient_gSTN = recipient_gSTN;
		Recipient_address = recipient_address;
		Consignee_name = consignee_name;
		Consignee_gSTN = consignee_gSTN;
		Consignee_address = consignee_address;
		Bos_file_path = bos_file_path;
		Ro_id = ro_id;
		Creation_date = creation_date;
		Contract_no = contract_no;
	}

	public GenerationOfBillSupplyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GenerationOfBillSupplyModel [Bos_id=" + Bos_id + ", Challan_No=" + Challan_No + ", Challan_date="
				+ Challan_date + ", Shipment_details=" + Shipment_details + ", Shipment_value=" + Shipment_value
				+ ", SGST_amt=" + SGST_amt + ", CGST_amt=" + CGST_amt + ", IGST_amt=" + IGST_amt + ", TCS_amt="
				+ TCS_amt + ", TDS_amt=" + TDS_amt + ", Invoice_value=" + Invoice_value + ", Bill_of_supply_no="
				+ Bill_of_supply_no + ", BOS_date=" + BOS_date + ", Supplier_name=" + Supplier_name + ", Supplier_gSTN="
				+ Supplier_gSTN + ", Supplier_address=" + Supplier_address + ", Recipient_name=" + Recipient_name
				+ ", Recipient_gSTN=" + Recipient_gSTN + ", Recipient_address=" + Recipient_address
				+ ", Consignee_name=" + Consignee_name + ", Consignee_gSTN=" + Consignee_gSTN + ", Consignee_address="
				+ Consignee_address + ", Bos_file_path=" + Bos_file_path + ", Ro_id=" + Ro_id + ", Creation_date="
				+ Creation_date + ", Contract_no=" + Contract_no + "]";
	}
	
	


}
