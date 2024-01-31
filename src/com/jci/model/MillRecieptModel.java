package com.jci.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jcimill_receipt", schema = "dbo")
public class MillRecieptModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BIGINT" ,name = "Mr_id ")
	private BigInteger  Mr_id ;
	
	
	@Column(name = "HO_di")
	private String  HO_di ;
	
	@Column( name = "Ho_date")
	private Date Ho_date;
	
	
	
	@Column( name = "Challan_no")
	private String Challan_no;
	
	@Column( name = "Date_shipment")
	private Date Date_shipment;
	
	
	
	@Column( name = "Vehicle_no")
	private String Vehicle_no;
	
	
	
	@Column( name = "Challan_qty")
	private Double Challan_qty;
	
//	
//	@Column( name = "Jute_variety")
//	private String Jute_variety;
//	
//	
//	public String getJute_variety() {
//		return Jute_variety;
//	}
//
//
//	public void setJute_variety(String jute_variety) {
//		Jute_variety = jute_variety;
//	}


	@Column( name = "Actual_qty")
	private Double Actual_qty;
	
	@Column( name = "Bale_mark")
	private String Bale_mark;
	
	@Column( name = "Crop_year")
	private String Crop_year;
	
	@OneToOne
	@JoinColumn(name = "Dientry_id") 
	private dispatchdetailModel dispathcDetailModel;
	
	@Column(nullable = true , name = "Quality_claim")
	private String Quality_claim;
	
	
	@Column(nullable = true , name = "MoistureContent")
	private Double MoistureContent;
	
	
	@Column(nullable = true , name = "NCV_percentage")
	private Double NCV_percentage;
	
	@Column(nullable = true , name = "NCV_qty")
	private Double NCV_qty;
	
	
	
	@Column( name = "MR_no")
	private String MR_no;
	
	
	@Column( name = "Mr_date")
	private Date Mr_date;
	
	
	@Column( name = "MR_qty")
	private Double MR_qty;
	
	@Column( name = "Short_qty")
	private Double Short_qty;
	
	@Column( name = "Mill_id")
	private String Mill_id;
	
	
	@Column(name = "Claim_status"  )
	private int Claim_status;
	
	
	
	@Column( name = "Created_by")
	private String Created_by;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created_on")
	private Date Created_on;


	public BigInteger getMr_id() {
		return Mr_id;
	}


	public void setMr_id(BigInteger mr_id) {
		Mr_id = mr_id;
	}


	public String getHO_di() {
		return HO_di;
	}


	public void setHO_di(String hO_di) {
		HO_di = hO_di;
	}


	public Date getHo_date() {
		return Ho_date;
	}


	public void setHo_date(Date ho_date) {
		Ho_date = ho_date;
	}


	public String getChallan_no() {
		return Challan_no;
	}


	public void setChallan_no(String challan_no) {
		Challan_no = challan_no;
	}


	public Date getDate_shipment() {
		return Date_shipment;
	}


	public void setDate_shipment(Date row) {
		Date_shipment = row;
	}


	public String getVehicle_no() {
		return Vehicle_no;
	}


	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}


	public Double getChallan_qty() {
		return Challan_qty;
	}


	public void setChallan_qty(Double challan_qty) {
		Challan_qty = challan_qty;
	}


	public Double getActual_qty() {
		return Actual_qty;
	}


	public void setActual_qty(Double actual_qty) {
		Actual_qty = actual_qty;
	}


	public String getBale_mark() {
		return Bale_mark;
	}


	public void setBale_mark(String bale_mark) {
		Bale_mark = bale_mark;
	}


	public String getCrop_year() {
		return Crop_year;
	}


	public void setCrop_year(String crop_year) {
		Crop_year = crop_year;
	}


	public dispatchdetailModel getDispathcDetailModel() {
		return dispathcDetailModel;
	}


	public void setDispathcDetailModel(dispatchdetailModel dispathcDetailModel) {
		this.dispathcDetailModel = dispathcDetailModel;
	}


	public String getQuality_claim() {
		return Quality_claim;
	}


	public void setQuality_claim(String quality_claim) {
		Quality_claim = quality_claim;
	}


	public Double getMoistureContent() {
		return MoistureContent;
	}


	public void setMoistureContent(Double moistureContent) {
		MoistureContent = moistureContent;
	}


	public Double getNCV_percentage() {
		return NCV_percentage;
	}


	public void setNCV_percentage(Double nCV_percentage) {
		NCV_percentage = nCV_percentage;
	}


	public Double getNCV_qty() {
		return NCV_qty;
	}


	public void setNCV_qty(Double nCV_qty) {
		NCV_qty = nCV_qty;
	}


	public String getMR_no() {
		return MR_no;
	}


	public void setMR_no(String mR_no) {
		MR_no = mR_no;
	}


	public Date getMr_date() {
		return Mr_date;
	}


	public void setMr_date(Date mr_date) {
		Mr_date = mr_date;
	}


	public Double getMR_qty() {
		return MR_qty;
	}


	public void setMR_qty(Double mR_qty) {
		MR_qty = mR_qty;
	}


	public Double getShort_qty() {
		return Short_qty;
	}


	public void setShort_qty(Double short_qty) {
		Short_qty = short_qty;
	}


	public String getMill_id() {
		return Mill_id;
	}


	public void setMill_id(String mill_id) {
		Mill_id = mill_id;
	}


	public int getClaim_status() {
		return Claim_status;
	}


	public void setClaim_status(int claim_status) {
		Claim_status = claim_status;
	}


	public String getCreated_by() {
		return Created_by;
	}


	public void setCreated_by(String created_by) {
		Created_by = created_by;
	}


	public Date getCreated_on() {
		return Created_on;
	}


	public void setCreated_on(Date created_on) {
		Created_on = created_on;
	}


	public MillRecieptModel(BigInteger mr_id, String hO_di, Date ho_date, String challan_no, Date date_shipment,
			String vehicle_no, Double challan_qty, String jute_variety, Double actual_qty, String bale_mark,
			String crop_year, dispatchdetailModel dispathcDetailModel, String quality_claim, Double moistureContent,
			Double nCV_percentage, Double nCV_qty, String mR_no, Date mr_date, Double mR_qty, Double short_qty,
			String mill_id, int claim_status, String created_by, Date created_on) {
		super();
		Mr_id = mr_id;
		HO_di = hO_di;
		Ho_date = ho_date;
		Challan_no = challan_no;
		Date_shipment = date_shipment;
		Vehicle_no = vehicle_no;
		Challan_qty = challan_qty;
//		Jute_variety = jute_variety;
		Actual_qty = actual_qty;
		Bale_mark = bale_mark;
		Crop_year = crop_year;
		this.dispathcDetailModel = dispathcDetailModel;
		Quality_claim = quality_claim;
		MoistureContent = moistureContent;
		NCV_percentage = nCV_percentage;
		NCV_qty = nCV_qty;
		MR_no = mR_no;
		Mr_date = mr_date;
		MR_qty = mR_qty;
		Short_qty = short_qty;
		Mill_id = mill_id;
		Claim_status = claim_status;
		Created_by = created_by;
		Created_on = created_on;
	}


	@Override
	public String toString() {
		return "MillRecieptModel [Mr_id=" + Mr_id + ", HO_di=" + HO_di + ", Ho_date=" + Ho_date + ", Challan_no="
				+ Challan_no + ", Date_shipment=" + Date_shipment + ", Vehicle_no=" + Vehicle_no + ", Challan_qty="
				+ Challan_qty + ", Actual_qty=" + Actual_qty + ", Bale_mark="
				+ Bale_mark + ", Crop_year=" + Crop_year + ", dispathcDetailModel=" + dispathcDetailModel
				+ ", Quality_claim=" + Quality_claim + ", MoistureContent=" + MoistureContent + ", NCV_percentage="
				+ NCV_percentage + ", NCV_qty=" + NCV_qty + ", MR_no=" + MR_no + ", Mr_date=" + Mr_date + ", MR_qty="
				+ MR_qty + ", Short_qty=" + Short_qty + ", Mill_id=" + Mill_id + ", Claim_status=" + Claim_status
				+ ", Created_by=" + Created_by + ", Created_on=" + Created_on + "]";
	}


	public MillRecieptModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	

}
