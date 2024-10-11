package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciprocurement", schema = "dbo")
public class RawJuteProcurementAndPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ptsid")
	private int ptsid;

	@Column(name = "regionId")
	private String regionId;
	
	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	@Column(name = "status")
	private String status;

	@Column(name= "is_varified")
	private int is_varified;

	@Column(name = "farmerregno")
	private String farmerregno;

	@Column(name= "formno")
	private int formno;

	@Column(name = "slip_image")
	private String slip_image;

	@Column(name="datepurchase")
	private String datepurchase;

	@Column(name="basis")
	private String basis;

	@Column(name="cropyr")
	private String cropyr;

	@Column(name="placeofpurchase")
	private String placeofpurchase;

	@Column(name="rateslipno")
	private int rateslipno;

	@Column(name="binno")
	private int binno;

	@Column(name="jutevariety")
	private String jutevariety;

	@Column(name="grossquantity")
	private double grossquantity;

	@Column(name="deductionquantity")
	private double deductionquantity;

	@Column(name="netquantity")
	private double netquantity;

	@Column(name= "grasatrate")
	private double grasatrate;

	@Column(name= "amountpayable")
	private double amountpayable;


	@Column(name= "tallyslipno")
	private String tallyslipno;

	@Column(name= "grade1")
	private double grade1;

	@Column(name= "grade2")
	private double grade2;

	@Column(name= "grade3")
	private double grade3;

	@Column(name= "grade4")
	private double grade4;

	@Column(name= "grade5")
	private double grade5;

	@Column(name= "grade6")
	private double grade6;

	@Column(name= "grade7")
	private double grade7;

	@Column(name= "grade8")
	private double grade8;


	@Column(name="createddate")
	private Date createddate;

	@Column(name="createdfrom")
	private String createdfrom;

	@Column(name="ipaddress")
	private String ipaddress;

	@Column(name="creadtedby")
	private int creadtedby;

	@Column(name="dateof_entry")
	private String dateof_entry;

	@Column(name="td_base")
	private String td_base;
	
	@Column(name="grade1xnetqty")
	private double grade1xnetqty;

	@Column(name="grade2xnetqty")
	private double grade2xnetqty;
	
	@Column(name="grade3xnetqty")
	private double grade3xnetqty;
	
	@Column(name="grade4xnetqty")
	private double grade4xnetqty;
	
	@Column(name="grade5xnetqty")
	private double grade5xnetqty;
	
	@Column(name="grade6xnetqty")
	private double grade6xnetqty;
	
	@Column(name="grade7xnetqty")
	private double grade7xnetqty;
	
	@Column(name="grade8xnetqty")
	private double grade8xnetqty;
	

	public double getGrade1xnetqty() {
		return grade1xnetqty;
	}

	public void setGrade1xnetqty(double grade1xnetqty) {
		this.grade1xnetqty = grade1xnetqty;
	}

	public double getGrade2xnetqty() {
		return grade2xnetqty;
	}

	public void setGrade2xnetqty(double grade2xnetqty) {
		this.grade2xnetqty = grade2xnetqty;
	}

	public double getGrade3xnetqty() {
		return grade3xnetqty;
	}

	public void setGrade3xnetqty(double grade3xnetqty) {
		this.grade3xnetqty = grade3xnetqty;
	}

	public double getGrade4xnetqty() {
		return grade4xnetqty;
	}

	public void setGrade4xnetqty(double grade4xnetqty) {
		this.grade4xnetqty = grade4xnetqty;
	}

	public double getGrade5xnetqty() {
		return grade5xnetqty;
	}

	public void setGrade5xnetqty(double grade5xnetqty) {
		this.grade5xnetqty = grade5xnetqty;
	}

	public double getGrade6xnetqty() {
		return grade6xnetqty;
	}

	public void setGrade6xnetqty(double grade6xnetqty) {
		this.grade6xnetqty = grade6xnetqty;
	}

	public double getGrade7xnetqty() {
		return grade7xnetqty;
	}

	public void setGrade7xnetqty(double grade7xnetqty) {
		this.grade7xnetqty = grade7xnetqty;
	}

	public double getGrade8xnetqty() {
		return grade8xnetqty;
	}

	public void setGrade8xnetqty(double grade8xnetqty) {
		this.grade8xnetqty = grade8xnetqty;
	}

	public String getSlip_image() {
		return slip_image;
	}

	public void setSlip_image(String slip_image) {
		this.slip_image = slip_image;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIs_varified() {
		return is_varified;
	}

	public void setIs_varified(int is_varified) {
		this.is_varified = is_varified;
	}

	
	
	public String getDateof_entry() {
		return dateof_entry;
	}

	public void setDateof_entry(String dateof_entry) {
		this.dateof_entry = dateof_entry;
	}

	public int getPtsid() {
		return ptsid;
	}

	public void setPtsid(int ptsid) {
		this.ptsid = ptsid;
	}

	public String getFarmerregno() {
		return farmerregno;
	}

	public void setFarmerregno(String farmerregno) {
		this.farmerregno = farmerregno;
	}

	public int getFormno() {
		return formno;
	}

	public void setFormno(int formno) {
		this.formno = formno;
	}

	public String getDatepurchase() {
		return datepurchase;
	}

	public void setDatepurchase(String datepurchase2) {
		this.datepurchase = datepurchase2;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	public String getPlaceofpurchase() {
		return placeofpurchase;
	}

	public void setPlaceofpurchase(String placeofpurchase) {
		this.placeofpurchase = placeofpurchase;
	}

	public int getRateslipno() {
		return rateslipno;
	}

	public void setRateslipno(int rateslipno) {
		this.rateslipno = rateslipno;
	}

	public int getBinno() {
		return binno;
	}

	public void setBinno(int binno) {
		this.binno = binno;
	}

	public String getJutevariety() {
		return jutevariety;
	}

	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}

	public double getGrossquantity() {
		return grossquantity;
	}

	public void setGrossquantity(double grossquantity) {
		this.grossquantity = grossquantity;
	}

	public double getDeductionquantity() {
		return deductionquantity;
	}

	public void setDeductionquantity(double deductionquantity) {
		this.deductionquantity = deductionquantity;
	}

	public double getNetquantity() {
		return netquantity;
	}

	public void setNetquantity(double netquantity) {
		this.netquantity = netquantity;
	}

	public double getGrasatrate() {
		return grasatrate;
	}

	public void setGrasatrate(double d) {
		this.grasatrate = d;
	}

	public double getAmountpayable() {
		return amountpayable;
	}

	public void setAmountpayable(double d) {
		this.amountpayable = d;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedfrom() {
		return createdfrom;
	}

	public void setCreatedfrom(String createdfrom) {
		this.createdfrom = createdfrom;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public int getCreadtedby() {
		return creadtedby;
	}

	public void setCreadtedby(int creadtedby) {
		this.creadtedby = creadtedby;
	}

	public String getTallyslipno() {
		return tallyslipno;
	}

	public void setTallyslipno(String tallyslipno) {
		this.tallyslipno = tallyslipno;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	public double getGrade3() {
		return grade3;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}

	public double getGrade4() {
		return grade4;
	}

	public void setGrade4(double grade4) {
		this.grade4 = grade4;
	}

	public double getGrade5() {
		return grade5;
	}

	public void setGrade5(double grade5) {
		this.grade5 = grade5;
	}

	public double getGrade6() {
		return grade6;
	}

	public void setGrade6(double grade6) {
		this.grade6 = grade6;
	}

	public double getGrade7() {
		return grade7;
	}

	public void setGrade7(double grade7) {
		this.grade7 = grade7;
	}

	public double getGrade8() {
		return grade8;
	}

	public void setGrade8(double grade8) {
		this.grade8 = grade8;
	}

	public String getTd_base() {
		return td_base;
	}

	public void setTd_base(String td_base) {
		this.td_base = td_base;
	}

	@Override
	public String toString() {
		return "RawJuteProcurementAndPayment [ptsid=" + ptsid + ", regionId=" + regionId + ", status=" + status
				+ ", is_varified=" + is_varified + ", farmerregno=" + farmerregno + ", formno=" + formno
				+ ", slip_image=" + slip_image + ", datepurchase=" + datepurchase + ", basis=" + basis + ", cropyr="
				+ cropyr + ", placeofpurchase=" + placeofpurchase + ", rateslipno=" + rateslipno + ", binno=" + binno
				+ ", jutevariety=" + jutevariety + ", grossquantity=" + grossquantity + ", deductionquantity="
				+ deductionquantity + ", netquantity=" + netquantity + ", grasatrate=" + grasatrate + ", amountpayable="
				+ amountpayable + ", tallyslipno=" + tallyslipno + ", grade1=" + grade1 + ", grade2=" + grade2
				+ ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", grade6=" + grade6
				+ ", grade7=" + grade7 + ", grade8=" + grade8 + ", createddate=" + createddate + ", createdfrom="
				+ createdfrom + ", ipaddress=" + ipaddress + ", creadtedby=" + creadtedby + ", dateof_entry="
				+ dateof_entry + ", td_base=" + td_base + ", grade1xnetqty=" + grade1xnetqty + ", grade2xnetqty="
				+ grade2xnetqty + ", grade3xnetqty=" + grade3xnetqty + ", grade4xnetqty=" + grade4xnetqty
				+ ", grade5xnetqty=" + grade5xnetqty + ", grade6xnetqty=" + grade6xnetqty + ", grade7xnetqty="
				+ grade7xnetqty + ", grade8xnetqty=" + grade8xnetqty + "]";
	}


}
