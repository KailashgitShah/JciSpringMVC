package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "jciweighment_entry")
public class jciWeighmentEntry {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Weighment_id")
	    private Integer id;
	    
	    
	    @Column(name = "Bos_no", unique=true, nullable = false)
	    private String Bos_no;
	    
	    @Column(name = "Bos_date")
	    private Date Bos_date;
	  
	    @Column(name = "Nominal_wt")
	    private Double Nominal_wt;
	  
	    @Column(name = "Dpc_actual_wt")
	    private Double Dpc_actual_wt;
	    
	    @Column(name = "Mill_actual_wt")
	    private Double Mill_actual_wt;
	    
	    @Column(name = "Dpc_wt_doc")
	    private String Dpc_wt_doc;
	    
	    @Column(name = "mill_wt_doc")
	    private String mill_wt_doc;
	    
	    @Column(name = "mill_bos_copy")
	    private String mill_bos_copy;
	    
	    @Column(name = "Verification_status")
	    private Integer Verification_status;
	    
	    @Column(name = "Verification_date")
	    private Date Verification_date;
	    
	    @Column(name = "Ro_id")
	    private String Ro_id;
	    
	    @Column(name = "Creation_date")
	    private Date Creation_date;

	    @Column(name = "truck_gross_wt")
	    private Double truck_gross_wt;
	  
	    @Column(name = "truck_tare_wt")
	    private Double truck_tare_wt;
	    
	    @Column(name = "truck_net_wt")
	    private Double truck_net_wt;
	    
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getBos_no() {
			return Bos_no;
		}

		public void setBos_no(String bos_no) {
			Bos_no = bos_no;
		}

		public Date getBos_date() {
			return Bos_date;
		}

		public void setBos_date(Date bos_date) {
			Bos_date = bos_date;
		}

		public Double getNominal_wt() {
			return Nominal_wt;
		}

		public void setNominal_wt(Double nominal_wt) {
			Nominal_wt = nominal_wt;
		}

		public Double getDpc_actual_wt() {
			return Dpc_actual_wt;
		}

		public void setDpc_actual_wt(Double dpc_actual_wt) {
			Dpc_actual_wt = dpc_actual_wt;
		}

		public Double getMill_actual_wt() {
			return Mill_actual_wt;
		}

		public void setMill_actual_wt(Double mill_actual_wt) {
			Mill_actual_wt = mill_actual_wt;
		}

		public String getDpc_wt_doc() {
			return Dpc_wt_doc;
		}

		public void setDpc_wt_doc(String dpc_wt_doc) {
			Dpc_wt_doc = dpc_wt_doc;
		}

		public String getMill_wt_doc() {
			return mill_wt_doc;
		}

		public void setMill_wt_doc(String mill_wt_doc) {
			this.mill_wt_doc = mill_wt_doc;
		}

		public String getMill_bos_copy() {
			return mill_bos_copy;
		}

		public void setMill_bos_copy(String mill_bos_copy) {
			this.mill_bos_copy = mill_bos_copy;
		}

		public Integer getVerification_status() {
			return Verification_status;
		}

		public void setVerification_status(Integer verification_status) {
			Verification_status = verification_status;
		}

		public Date getVerification_date() {
			return Verification_date;
		}

		public void setVerification_date(Date verification_date) {
			Verification_date = verification_date;
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

		public Double getTruck_gross_wt() {
			return truck_gross_wt;
		}

		public void setTruck_gross_wt(Double truck_gross_wt) {
			this.truck_gross_wt = truck_gross_wt;
		}

		public Double getTruck_tare_wt() {
			return truck_tare_wt;
		}

		public void setTruck_tare_wt(Double truck_tare_wt) {
			this.truck_tare_wt = truck_tare_wt;
		}

		public Double getTruck_net_wt() {
			return truck_net_wt;
		}

		public void setTruck_net_wt(Double truck_net_wt) {
			this.truck_net_wt = truck_net_wt;
		}
	    
	    
}
