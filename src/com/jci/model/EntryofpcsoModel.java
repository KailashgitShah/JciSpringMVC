package com.jci.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "jcientryof_pcso", schema = "dbo")

public class EntryofpcsoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcsorefid")
	private int pcsorefid;

	@Column(name = "Jc_reference_no",length = 256)
	@NotNull
	private String reference_no;

	@Column(name = "pcso_date")
	@NotNull
	private String pcso_date;
	
	@Column(name = "pcso_req_date")
	@NotNull
	private String pcso_req_date;

	@Column(name = "letter_ref",length = 256)
	@NotNull
	private String letterRef;

	@Column(name = "Jute_ratio" , length = 256)
	@NotNull
	private String juteRatio;


	@Column(name = "dispatch_period" , length = 256)
	@NotNull
	private String dispatch_period;

	@Column(name = "Letter_path" , length = 256)
	@NotNull
	private String letterPath;

	@Column(name = "mill_code")
	@NotNull
	private String mill_code;

	@Column(name = "mill_name" , length = 256)
	@NotNull
	private String mill_name;

	@Column(name = "Allocated_qty")
	@NotNull
	private BigDecimal allocatedQty = BigDecimal.ZERO;
	

	@Column(name = "pcso_qty")
	@NotNull
	private BigDecimal pcsoQty = BigDecimal.ZERO;
	
	
	@Column(name = "pcso_req_qty")
	@NotNull
	private Double pcsoReqQty = 0.0;

	@Column(name = "created_date")
	private Date created_date;
	

	@Column(name = "cropYear" , length = 256)
	@NotNull
	private String cropYear;

	@Column(name = "Pcso_contract_flag")
	private int pcsoContractFlag = 0;

	public int getPcsorefid() {
		return pcsorefid;
	}

	public void setPcsorefid(int pcsorefid) {
		this.pcsorefid = pcsorefid;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public String getPcso_date() {
		return pcso_date;
	}

	public void setPcso_date(String pcso_date) {
		this.pcso_date = pcso_date;
	}

	public String getPcso_req_date() {
		return pcso_req_date;
	}

	public void setPcso_req_date(String pcso_req_date) {
		this.pcso_req_date = pcso_req_date;
	}

	public String getLetterRef() {
		return letterRef;
	}

	public void setLetterRef(String letterRef) {
		this.letterRef = letterRef;
	}

	public String getJuteRatio() {
		return juteRatio;
	}

	public void setJuteRatio(String juteRatio) {
		this.juteRatio = juteRatio;
	}

	public String getDispatch_period() {
		return dispatch_period;
	}

	public void setDispatch_period(String dispatch_period) {
		this.dispatch_period = dispatch_period;
	}

	public String getLetterPath() {
		return letterPath;
	}

	public void setLetterPath(String letterPath) {
		this.letterPath = letterPath;
	}

	public String getMill_code() {
		return mill_code;
	}

	public void setMill_code(String mill_code) {
		this.mill_code = mill_code;
	}

	public String getMill_name() {
		return mill_name;
	}

	public void setMill_name(String mill_name) {
		this.mill_name = mill_name;
	}

	public BigDecimal getAllocatedQty() {
		return allocatedQty;
	}

	public void setAllocatedQty(BigDecimal allocatedQty) {
		this.allocatedQty = allocatedQty;
	}

	public BigDecimal getPcsoQty() {
		return pcsoQty;
	}

	public void setPcsoQty(BigDecimal pcsoQty) {
		this.pcsoQty = pcsoQty;
	}

	public Double getPcsoReqQty() {
		return pcsoReqQty;
	}

	public void setPcsoReqQty(Double pcsoReqQty) {
		this.pcsoReqQty = pcsoReqQty;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getPcsoContractFlag() {
		return pcsoContractFlag;
	}

	public void setPcsoContractFlag(int pcsoContractFlag) {
		this.pcsoContractFlag = pcsoContractFlag;
	}
	
	

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	@Override
	public String toString() {
		return "EntryofpcsoModel [pcsorefid=" + pcsorefid + ", reference_no=" + reference_no + ", pcso_date="
				+ pcso_date + ", pcso_req_date=" + pcso_req_date + ", letterRef=" + letterRef + ", juteRatio="
				+ juteRatio + ", dispatch_period=" + dispatch_period + ", letterPath=" + letterPath + ", mill_code="
				+ mill_code + ", mill_name=" + mill_name + ", allocatedQty=" + allocatedQty + ", pcsoQty=" + pcsoQty
				+ ", pcsoReqQty=" + pcsoReqQty + ", created_date=" + created_date + ", cropYear=" + cropYear
				+ ", pcsoContractFlag=" + pcsoContractFlag + "]";
	}

	public EntryofpcsoModel(int pcsorefid, String reference_no, String pcso_date, String pcso_req_date,
			String letterRef, String juteRatio, String dispatch_period, String letterPath, String mill_code,
			String mill_name, BigDecimal allocatedQty, BigDecimal pcsoQty, Double pcsoReqQty, Date created_date,
			String cropYear, int pcsoContractFlag) {
		super();
		this.pcsorefid = pcsorefid;
		this.reference_no = reference_no;
		this.pcso_date = pcso_date;
		this.pcso_req_date = pcso_req_date;
		this.letterRef = letterRef;
		this.juteRatio = juteRatio;
		this.dispatch_period = dispatch_period;
		this.letterPath = letterPath;
		this.mill_code = mill_code;
		this.mill_name = mill_name;
		this.allocatedQty = allocatedQty;
		this.pcsoQty = pcsoQty;
		this.pcsoReqQty = pcsoReqQty;
		this.created_date = created_date;
		this.cropYear = cropYear;
		this.pcsoContractFlag = pcsoContractFlag;
	}

	public EntryofpcsoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}

