package com.jci.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "jcibalepreparation", schema = "dbo")
public class BalePreparation {

	@Id
	@Column(name="bale_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int baleId;
	
	@Column(name = "packing_date")
	private String packing_date;

	@Column(name="crop_year")
	private String crop_year;

	@Column(name="bin_no")
	private String bin_no;

	@Column(name="basis")
	private String basis;
	 
	 
	@Column(name="jute_variety")
	private String jute_variety;
	 

	@Column(name="slip_no_from")
	private String slip_no_from;
	 
	@Column(name="slip_no_to")
	private String slip_no_to;
	 
	@Column(name="bale_no")
	private int bale_no;
	 
	@Column(name="created_by")
	private int created_by;
	 
	@Column(name="status")
	private int status;
	 
	@Column(name="creation_date")
	private String creation_date;
	 
	@Column(name="place_of_packing")
	private String place_of_packing;

	@Column(name="jute_grade")
	private  String jute_grade;
	
	@Transient
	private String region;
	
	
	@Transient
	private int garde1;
	 
	@Transient
	private int garde2;
	 
	@Transient
	private int garde3;
	
	@Transient
	private int garde4;
	 
	@Transient
	private int garde5;
	 
	@Transient
	private int garde6;
	
	@Transient
	private int garde7;
	 
	@Transient
	private int garde8;
	 
	@Transient
	private int total;
	
	@Transient
	private float nominalWt;
	
	@Transient
	private String username ;

	
	@Transient
	private int sum1;
	 
	@Transient
	private int sum2;
	 
	@Transient
	private int sum3;
	
	@Transient
	private int sum4;
	 
	@Transient
	private int sum5;
	 
	@Transient
	private int sum6;
	
	@Transient
	private int sum7;
	 
	@Transient
	private int sum8;
	
	@Transient
	private int sum9;
	
	@Transient
	private String dpcId;
	
	@Transient
	private String fromdate;

	@Transient
	private String todate;
	
	
	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public BalePreparation() {
		super();
	}

	
	public int getBaleId() {
		return baleId;
	}

	public void setBaleId(int baleId) {
		this.baleId = baleId;
	}

	public String getPacking_date() {
		return packing_date;
	}

	public void setPacking_date(String string) {
		this.packing_date = string;
	}

	public String getCrop_year() {
		return crop_year;
	}

	public void setCrop_year(String crop_year) {
		this.crop_year = crop_year;
	}

	public String getBin_no() {
		return bin_no;
	}

	public void setBin_no(String bin_no) {
		this.bin_no = bin_no;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
	}

	public String getSlip_no_from() {
		return slip_no_from;
	}

	public void setSlip_no_from(String slip_no_from) {
		this.slip_no_from = slip_no_from;
	}

	public String getSlip_no_to() {
		return slip_no_to;
	}

	public void setSlip_no_to(String slip_no_to) {
		this.slip_no_to = slip_no_to;
	}

	public int getBale_no() {
		return bale_no;
	}

	public void setBale_no(int bale_no) {
		this.bale_no = bale_no;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getPlace_of_packing() {
		return place_of_packing;
	}

	public void setPlace_of_packing(String place_of_packing) {
		this.place_of_packing = place_of_packing;
	}

	public String getJute_grade() {
		return jute_grade;
	}

	public void setJute_grade(String jute_grade) {
		this.jute_grade = jute_grade;
	}
	
	

	public int getGarde1() {
		return garde1;
	}


	public void setGarde1(int garde1) {
		this.garde1 = garde1;
	}


	public int getGarde2() {
		return garde2;
	}


	public void setGarde2(int garde2) {
		this.garde2 = garde2;
	}


	public int getGarde3() {
		return garde3;
	}


	public void setGarde3(int garde3) {
		this.garde3 = garde3;
	}


	public int getGarde4() {
		return garde4;
	}


	public void setGarde4(int garde4) {
		this.garde4 = garde4;
	}


	public int getGarde5() {
		return garde5;
	}


	public void setGarde5(int garde5) {
		this.garde5 = garde5;
	}


	public int getGarde6() {
		return garde6;
	}


	public void setGarde6(int garde6) {
		this.garde6 = garde6;
	}


	public int getGarde7() {
		return garde7;
	}


	public void setGarde7(int garde7) {
		this.garde7 = garde7;
	}


	public int getGarde8() {
		return garde8;
	}


	public void setGarde8(int garde8) {
		this.garde8 = garde8;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public float getNominalWt() {
		return nominalWt;
	}


	public void setNominalWt(float nominalWt) {
		this.nominalWt = nominalWt;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getSum1() {
		return sum1;
	}


	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}


	public int getSum2() {
		return sum2;
	}


	public void setSum2(int sum2) {
		this.sum2 = sum2;
	}


	public int getSum3() {
		return sum3;
	}


	public void setSum3(int sum3) {
		this.sum3 = sum3;
	}


	public int getSum4() {
		return sum4;
	}


	public void setSum4(int sum4) {
		this.sum4 = sum4;
	}


	public int getSum5() {
		return sum5;
	}


	public void setSum5(int sum5) {
		this.sum5 = sum5;
	}


	public int getSum6() {
		return sum6;
	}


	public void setSum6(int sum6) {
		this.sum6 = sum6;
	}


	public int getSum7() {
		return sum7;
	}


	public void setSum7(int sum7) {
		this.sum7 = sum7;
	}


	public int getSum8() {
		return sum8;
	}


	public void setSum8(int sum8) {
		this.sum8 = sum8;
	}


	public int getSum9() {
		return sum9;
	}


	public void setSum9(int sum9) {
		this.sum9 = sum9;
	}


	
	
	public String getDpcId() {
		return dpcId;
	}


	public void setDpcId(String dpcId) {
		this.dpcId = dpcId;
	}


	public String getFromdate() {
		return fromdate;
	}


	public String setFromdate(String fromdate) {
		return this.fromdate = fromdate;
	}


	public String getTodate() {
		return todate;
	}


	public String setTodate(String todate) {
		return this.todate = todate;
	}


	@Override
	public String toString() {
		return "BalePreparation [baleId=" + baleId + ", packing_date=" + packing_date + ", crop_year=" + crop_year
				+ ", bin_no=" + bin_no + ", basis=" + basis + ", jute_variety=" + jute_variety + ", slip_no_from="
				+ slip_no_from + ", slip_no_to=" + slip_no_to + ", bale_no=" + bale_no + ", created_by=" + created_by
				+ ", status=" + status + ", creation_date=" + creation_date + ", place_of_packing=" + place_of_packing
				+ ", jute_grade=" + jute_grade + ", region=" + region + ", garde1=" + garde1 + ", garde2=" + garde2
				+ ", garde3=" + garde3 + ", garde4=" + garde4 + ", garde5=" + garde5 + ", garde6=" + garde6
				+ ", garde7=" + garde7 + ", garde8=" + garde8 + ", total=" + total + ", nominalWt=" + nominalWt
				+ ", username=" + username + ", sum1=" + sum1 + ", sum2=" + sum2 + ", sum3=" + sum3 + ", sum4=" + sum4
				+ ", sum5=" + sum5 + ", sum6=" + sum6 + ", sum7=" + sum7 + ", sum8=" + sum8 + ", sum9=" + sum9 + "]";
	}


	public BalePreparation(int baleId, String packing_date, String crop_year, String bin_no, String basis,
			String jute_variety, String slip_no_from, String slip_no_to, int bale_no, int created_by, int status,
			String creation_date, String place_of_packing, String jute_grade, String region, int garde1, int garde2,
			int garde3, int garde4, int garde5, int garde6, int garde7, int garde8, int total, float nominalWt,
			String username, int sum1, int sum2, int sum3, int sum4, int sum5, int sum6, int sum7, int sum8, int sum9) {
		super();
		this.baleId = baleId;
		this.packing_date = packing_date;
		this.crop_year = crop_year;
		this.bin_no = bin_no;
		this.basis = basis;
		this.jute_variety = jute_variety;
		this.slip_no_from = slip_no_from;
		this.slip_no_to = slip_no_to;
		this.bale_no = bale_no;
		this.created_by = created_by;
		this.status = status;
		this.creation_date = creation_date;
		this.place_of_packing = place_of_packing;
		this.jute_grade = jute_grade;
		this.region = region;
		this.garde1 = garde1;
		this.garde2 = garde2;
		this.garde3 = garde3;
		this.garde4 = garde4;
		this.garde5 = garde5;
		this.garde6 = garde6;
		this.garde7 = garde7;
		this.garde8 = garde8;
		this.total = total;
		this.nominalWt = nominalWt;
		this.username = username;
		this.sum1 = sum1;
		this.sum2 = sum2;
		this.sum3 = sum3;
		this.sum4 = sum4;
		this.sum5 = sum5;
		this.sum6 = sum6;
		this.sum7 = sum7;
		this.sum8 = sum8;
		this.sum9 = sum9;
	}


	
}