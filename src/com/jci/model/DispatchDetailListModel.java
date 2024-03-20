package com.jci.model;

import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Transient;

	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;

	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	

	@Entity
	
	@Table(name = "jcidispatch_details_child")
	public class DispatchDetailListModel {

	    @Id
	              @GeneratedValue(strategy = GenerationType.IDENTITY)
	              @Column(name = "Dispatch_id")
	              private Integer Dispatch_id;
	              
	    @Column(name = "Challan_no")
	    private String Challan_no;
	    
	    @Column(name = "Bale_mark")
	    private String Bale_mark;
	    
	    
	    @Column(name = "Crop_year")
	    private String Crop_year;
	    
	    @Column(name = "Lot_no")
	    private Integer Lot_no;
	    
	    @Column(name = "Jute_grade")
	    private String Jute_grade;
	    
	    @Column(name = "No_of_bales")
	    private Integer No_of_bales;
	    
	    @Column(name = "Nominal_wt")
	    private Double Nominal_wt;

	    @Column(name = "Nominal_qty")
	    private Double Nominal_qty;
	    
	    @Column(name = "Rate")
	    private Double Rate;
	    
	    @Column(name = "Jute_value")
	    private Double Jute_value;
	    
	    @Column(name = "Jute_variety")
	    private String Jute_variety;
	    
	    @Column(name = "Created_Date")
	    private Date Created_Date;

	    @Column(name = "Updated_Date")
	    private Date Updated_Date;
	    
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

	              public Integer getLot_no() {
	                             return Lot_no;
	              }

	              public void setLot_no(Integer lot_no) {
	                             Lot_no = lot_no;
	              }

	              public String getJute_grade() {
	                             return Jute_grade;
	              }

	              public void setJute_grade(String jute_grade) {
	                             Jute_grade = jute_grade;
	              }

	              public Integer getNo_of_bales() {
	                             return No_of_bales;
	              }

	              public void setNo_of_bales(Integer no_of_bales) {
	                             No_of_bales = no_of_bales;
	              }

	              public Double getNominal_wt() {
	                             return Nominal_wt;
	              }

	              public void setNominal_wt(Double nominal_wt) {
	                            Nominal_wt = nominal_wt;
	              }

	              public Double getNominal_qty() {
	                             return Nominal_qty;
	              }

	              public void setNominal_qty(Double nominal_qty) {
	                             Nominal_qty = nominal_qty;
	              }

	              public Double getRate() {
	                             return Rate;
	              }

	              public void setRate(Double rate) {
	                             Rate = rate;
	              }

	              public Double getJute_value() {
	                             return Jute_value;
	              }

	              public void setJute_value(Double jute_value) {
	                             Jute_value = jute_value;
	              }

	              public String getJute_variety() {
	                             return Jute_variety;
	              }

	              public void setJute_variety(String jute_variety) {
	                             Jute_variety = jute_variety;
	              }

	              public Integer getDispatch_id() {
	                             return Dispatch_id;
	              }

	              public void setDispatch_id(Integer dispatch_id) {
	                             Dispatch_id = dispatch_id;
	              }
	              
	              

	              public String getChallan_no() {
	                             return Challan_no;
	              }

	              public void setChallan_no(String challan_no) {
	                             Challan_no = challan_no;
	              }

	              
	              
	              public Date getCreated_Date() {
	                             return Created_Date;
	              }

	              public void setCreated_Date(Date created_Date) {
	                             Created_Date = created_Date;
	              }

	              public Date getUpdated_Date() {
	                             return Updated_Date;
	              }

	              public void setUpdated_Date(Date updated_Date) {
	                             Updated_Date = updated_Date;
	              }

	              @Override
	              public String toString() {
	                             return "JciDispatchDetails [Dispatch_id=" + Dispatch_id + ", Challan_no=" + Challan_no + ", Bale_mark="
	                                                          + Bale_mark + ", Crop_year=" + Crop_year + ", Lot_no=" + Lot_no + ", Jute_grade=" + Jute_grade
	                                                          + ", No_of_bales=" + No_of_bales + ", Nominal_wt=" + Nominal_wt + ", Nominal_qty=" + Nominal_qty
	                                                          + ", Rate=" + Rate + ", Jute_value=" + Jute_value + ", Jute_variety=" + Jute_variety + ", Created_Date="
	                                                          + Created_Date + ", Updated_Date=" + Updated_Date + "]";
	              }

	              

	              
	

}
