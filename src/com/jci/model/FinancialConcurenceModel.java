package com.jci.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "jcifinancial_concurrence", schema = "dbo")
public class FinancialConcurenceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fc_id")
	private int Fc_id;
	
	@Column(name = "Contractno")
	private String fullcontractno;
	
	@Column(name = "FC_Issue_Date")
	private Date FC_Issue_Date;
	
	@Column(name = "FC_Ref_No")
	private String FC_Ref_No;
	
	@Column(name = "Contracted_Qty")
	private String Contracted_Qty;
	
	@Column(name = "QtyAllowed")
	private String QtyAllowed;
	
	@Column(name = "Carrying_Cost_Charged")
	private BigInteger Carrying_Cost_Charged;
	
	@Column(name = "Created_date")
	private Date Created_date;
	
	@Column(name = "Remarks")
	private  String  Remarks;
	
//	@Column(name = "FnYr")
//	private  String  fnYr;
	
	@Column(name = "fcdocumentDownload")
	private  String  fcdocumentDownload;

	public String getFcdocumentDownload() {
		return fcdocumentDownload;
	}

	public void setFcdocumentDownload(String fcdocumentDownload) {
		this.fcdocumentDownload = fcdocumentDownload;
	}

	public int getFc_id() {
		return Fc_id;
	}

	public void setFc_id(int fc_id) {
		Fc_id = fc_id;
	}

	public String getFullcontractno() {
		return fullcontractno;
	}

	public void setFullcontractno(String fullcontractno) {
		this.fullcontractno = fullcontractno;
	}

	public Date getFC_Issue_Date() {
		return FC_Issue_Date;
	}

	public void setFC_Issue_Date(Date fC_Issue_Date) {
		FC_Issue_Date = fC_Issue_Date;
	}

	public String getFC_Ref_No() {
		return FC_Ref_No;
	}

	public void setFC_Ref_No(String fC_Ref_No) {
		FC_Ref_No = fC_Ref_No;
	}

	public String getContracted_Qty() {
		return Contracted_Qty;
	}

	public void setContracted_Qty(String contracted_Qty) {
		Contracted_Qty = contracted_Qty;
	}

	public String getQtyAllowed() {
		return QtyAllowed;
	}

	public void setQtyAllowed(String qtyAllowed) {
		QtyAllowed = qtyAllowed;
	}

	public BigInteger getCarrying_Cost_Charged() {
		return Carrying_Cost_Charged;
	}

	public void setCarrying_Cost_Charged(BigInteger carrying_Cost_Charged) {
		Carrying_Cost_Charged = carrying_Cost_Charged;
	}

	public Date getCreated_date() {
		return Created_date;
	}

	public void setCreated_date(Date created_date) {
		Created_date = created_date;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	

//	public String getFnYr() {
//		return fnYr;
//	}
//
//	public void setFnYr(String fnYr) {
//		this.fnYr = fnYr;
//	}
	

	public FinancialConcurenceModel(int fc_id, String fullcontractno, Date fC_Issue_Date, String fC_Ref_No,
			String contracted_Qty, String qtyAllowed, BigInteger carrying_Cost_Charged, Date created_date, String remarks) {
		super();
		Fc_id = fc_id;
		this.fullcontractno = fullcontractno;
		FC_Issue_Date = fC_Issue_Date;
		FC_Ref_No = fC_Ref_No;
		Contracted_Qty = contracted_Qty;
		QtyAllowed = qtyAllowed;
		Carrying_Cost_Charged = carrying_Cost_Charged;
		Created_date = created_date;
		Remarks = remarks;
	}

	public FinancialConcurenceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FinancialConcurenceModel [Fc_id=" + Fc_id + ", fullcontractno=" + fullcontractno + ", FC_Issue_Date="
				+ FC_Issue_Date + ", FC_Ref_No=" + FC_Ref_No + ", Contracted_Qty=" + Contracted_Qty + ", QtyAllowed="
				+ QtyAllowed + ", Carrying_Cost_Charged=" + Carrying_Cost_Charged + ", Created_date=" + Created_date
				+ ", Remarks=" + Remarks + "]";
	}
	
	
	
	
}