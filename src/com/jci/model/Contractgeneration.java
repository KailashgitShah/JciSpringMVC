package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicontract" , schema = "dbo")
public class Contractgeneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private Long contract_id;

	@Column(name = "Pcso_date", length = 250)
	private String Pcso_date; //

	@Column(name = "Contract_identification_no", length = 255)
	private String Contract_identification_no;

	@Column(name = "Contract_no")
	private String Contract_no;

	@Column(name = "Contract_date", nullable = false)
	private String Contract_date;

	@Column(name = "Contract_qty", nullable = false)
	private String Contract_qty;

	@Column(name = "Contract_value", nullable = false)
	private double Contract_value;
	
	@Column(name = "Mill_code", nullable = false)
	private String Mill_code;

	@Column(name = "Mill_name", nullable = false)
	private String Mill_name;

	@Column(name = "Mill_qty", nullable = false)
	private double Mill_qty;

	@Column(name = "Delivery_type", nullable = false)
	private String Delivery_type;

	@Column(name = "Grade_composition", nullable = false)
	private String  Grade_composition;

	@Column(name = "Payment_duedate", nullable = false)
	private String Payment_duedate;

	@Column(name = "Contract_cancellation_flag")
	private int Contract_cancellation_flag = 0;

	@Column(name = "Contract_cancel_date")
	private String Contract_cancel_date;

	@Column(name = "Contract_acceptance_flag")
	private int Contract_acceptance_flag = 0;

	@Column(name = "Contract_acceptance_date")
	private String Contract_acceptance_date;

	@Column(name = "Contract_acceptance_doc", length = 250)
	private String Contract_acceptance_doc;

	@Column(name = "Intial_Payment_date")
	private String Intial_Payment_date;

	@Column(name = "Intial_Payment_flag")
	private int Intial_Payment_flag = 0;

	@Column(name = "Contract_status")
	private String Contract_status = "Mill Acceptance Pending";

	@Column(name = "Created_date")
	private Date Created_date;
	
	@Column(name = "CropYear")
	private String cropYear;

	@Column(name = "Created_by")
	private int Created_by;
	
	@Column(name = "SortingId")
	private int SortingId;
	

	@Column(name = "Jute_value")
	private double Jute_value;


	public Long getContract_id() {
		return contract_id;
	}

	public void setContract_id(Long contract_id) {
		this.contract_id = contract_id;
	}

	public String getPcso_date() {
		return Pcso_date;
	}

	public void setPcso_date(String pcso_date) {
		Pcso_date = pcso_date;
	}

	public String getContract_identification_no() {
		return Contract_identification_no;
	}

	public void setContract_identification_no(String contract_identification_no) {
		Contract_identification_no = contract_identification_no;
	}

	public String getContract_no() {
		return Contract_no;
	}

	public void setContract_no(String contract_no) {
		Contract_no = contract_no;
	}

	public String getContract_date() {
		return Contract_date;
	}

	public void setContract_date(String contract_date) {
		Contract_date = contract_date;
	}

	public String getContract_qty() {
		return Contract_qty;
	}

	public void setContract_qty(String contract_qty) {
		Contract_qty = contract_qty;
	}

	public double getContract_value() {
		return Contract_value;
	}

	public void setContract_value(double contract_value) {
		Contract_value = contract_value;
	}

	public String getMill_code() {
		return Mill_code;
	}

	public void setMill_code(String mill_code) {
		Mill_code = mill_code;
	}

	public String getMill_name() {
		return Mill_name;
	}

	public void setMill_name(String mill_name) {
		Mill_name = mill_name;
	}

	public double getMill_qty() {
		return Mill_qty;
	}

	public void setMill_qty(double mill_qty) {
		Mill_qty = mill_qty;
	}

	public String getDelivery_type() {
		return Delivery_type;
	}

	public void setDelivery_type(String delivery_type) {
		Delivery_type = delivery_type;
	}



	public String getGrade_composition() {
		return Grade_composition;
	}

	public void setGrade_composition(String grade_composition) {
		Grade_composition = grade_composition;
	}

	public String getPayment_duedate() {
		return Payment_duedate;
	}

	public void setPayment_duedate(String payment_duedate) {
		Payment_duedate = payment_duedate;
	}

	public int getContract_cancellation_flag() {
		return Contract_cancellation_flag;
	}

	public void setContract_cancellation_flag(int contract_cancellation_flag) {
		Contract_cancellation_flag = contract_cancellation_flag;
	}

	public String getContract_cancel_date() {
		return Contract_cancel_date;
	}

	public void setContract_cancel_date(String contract_cancel_date) {
		Contract_cancel_date = contract_cancel_date;
	}

	public int getContract_acceptance_flag() {
		return Contract_acceptance_flag;
	}

	public void setContract_acceptance_flag(int contract_acceptance_flag) {
		Contract_acceptance_flag = contract_acceptance_flag;
	}

	public String getContract_acceptance_date() {
		return Contract_acceptance_date;
	}

	public void setContract_acceptance_date(String contract_acceptance_date) {
		Contract_acceptance_date = contract_acceptance_date;
	}

	public String getContract_acceptance_doc() {
		return Contract_acceptance_doc;
	}

	public void setContract_acceptance_doc(String contract_acceptance_doc) {
		Contract_acceptance_doc = contract_acceptance_doc;
	}

	public String getIntial_Payment_date() {
		return Intial_Payment_date;
	}

	public void setIntial_Payment_date(String intial_Payment_date) {
		Intial_Payment_date = intial_Payment_date;
	}

	public int getIntial_Payment_flag() {
		return Intial_Payment_flag;
	}

	public void setIntial_Payment_flag(int intial_Payment_flag) {
		Intial_Payment_flag = intial_Payment_flag;
	}

	public String getContract_status() {
		return Contract_status;
	}

	public void setContract_status(String contract_status) {
		Contract_status = contract_status;
	}

	public Date getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(Date created_date) {
		Created_date = created_date;
	}

	public int getCreated_by() {
		return Created_by;
	}

	public void setCreated_by(int created_by) {
		Created_by = created_by;
	}
	  
	
	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}
	
	public int getSortingId() {
		return SortingId;
	}

	public void setSortingId(int sortingId) {
		SortingId = sortingId;
	}

	public double getJute_value() {
		return Jute_value;
	}

	public void setJute_value(double jute_value) {
		Jute_value = jute_value;
	}

	@Override
	public String toString() {
		return "Contractgeneration [contract_id=" + contract_id + ", Pcso_date=" + Pcso_date
				+ ", Contract_identification_no=" + Contract_identification_no + ", Contract_no=" + Contract_no
				+ ", Contract_date=" + Contract_date + ", Contract_qty=" + Contract_qty + ", Contract_value="
				+ Contract_value + ", Jute_value=" + Jute_value + ", Mill_code=" + Mill_code + ", Mill_name="
				+ Mill_name + ", Mill_qty=" + Mill_qty + ", Delivery_type=" + Delivery_type + ", Grade_composition="
				+ Grade_composition + ", Payment_duedate=" + Payment_duedate + ", Contract_cancellation_flag="
				+ Contract_cancellation_flag + ", Contract_cancel_date=" + Contract_cancel_date
				+ ", Contract_acceptance_flag=" + Contract_acceptance_flag + ", Contract_acceptance_date="
				+ Contract_acceptance_date + ", Contract_acceptance_doc=" + Contract_acceptance_doc
				+ ", Intial_Payment_date=" + Intial_Payment_date + ", Intial_Payment_flag=" + Intial_Payment_flag
				+ ", Contract_status=" + Contract_status + ", Created_date=" + Created_date + ", cropYear=" + cropYear
				+ ", Created_by=" + Created_by + ", SortingId=" + SortingId + "]";
	}

	public Contractgeneration(Long contract_id, String pcso_date, String contract_identification_no, String contract_no,
			String contract_date, String contract_qty, double contract_value, double jute_value, String mill_code,
			String mill_name, double mill_qty, String delivery_type, String grade_composition, String payment_duedate,
			int contract_cancellation_flag, String contract_cancel_date, int contract_acceptance_flag,
			String contract_acceptance_date, String contract_acceptance_doc, String intial_Payment_date,
			int intial_Payment_flag, String contract_status, Date created_date, String cropYear, int created_by,
			int sortingId) {
		super();
		this.contract_id = contract_id;
		Pcso_date = pcso_date;
		Contract_identification_no = contract_identification_no;
		Contract_no = contract_no;
		Contract_date = contract_date;
		Contract_qty = contract_qty;
		Contract_value = contract_value;
		Jute_value = jute_value;
		Mill_code = mill_code;
		Mill_name = mill_name;
		Mill_qty = mill_qty;
		Delivery_type = delivery_type;
		Grade_composition = grade_composition;
		Payment_duedate = payment_duedate;
		Contract_cancellation_flag = contract_cancellation_flag;
		Contract_cancel_date = contract_cancel_date;
		Contract_acceptance_flag = contract_acceptance_flag;
		Contract_acceptance_date = contract_acceptance_date;
		Contract_acceptance_doc = contract_acceptance_doc;
		Intial_Payment_date = intial_Payment_date;
		Intial_Payment_flag = intial_Payment_flag;
		Contract_status = contract_status;
		Created_date = created_date;
		this.cropYear = cropYear;
		Created_by = created_by;
		SortingId = sortingId;
	}

	public Contractgeneration() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	
}
