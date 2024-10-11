package com.jci.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "verificationtallyslip", schema = "dbo")
public class VerifyTallySlip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tallyid")
	private int tallyid;

	@Column(name = "farmerregno")
	private String farmerRegNo;

	@Column(name = "tallyNo")
	private String tallyNo;

	@Column(name ="puchasedate")
	private String puchasedate;

	@Column(name = "errors")
	private String errors;

	@Column(name = "status")
	private String status;


	@Column(name = "is_varified")
	private int is_varified;

	@Column(name = "rateslipno")
	private int rateslipno;

	@Column(name = "binno")
	private int binno;

	@Column(name = "jutevariety")
	private String jutevariety;

	@Column(name = "netquantity")
	private double netquantity;

	@Column(name = "garsatrate")
	private double garsatrate;


	@Column(name = "tallySlipImg")
	private String tallySlipImg;

	@Column(name = "facheck_flag")
	private String facheck_flag;

	@Column(name = "region_id")
	private String region_id;
	
	@Column(name = "zone_id")
	private String zone_id;
	
	@Transient
	private String basis;
	
	@Transient
	private String centername;
	
	@Transient
	private String farmer_name;
	
	

	public String getFarmer_name() {
		return farmer_name;
	}

	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getZone_id() {
		return zone_id;
	}

	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getFacheck_flag() {
		return facheck_flag;
	}

	public void setFacheck_flag(String facheck_flag) {
		this.facheck_flag = facheck_flag;
	}


	private double grossqty;



	@Column(name = "amountpayable")
	private double amountpayable;

	@Column(name = "createdby")
	private int createdby;

	@Column(name = "placeOfPurchase")
	private String placeOfPurchase;

	@Column(name = "drumWiseQuantity1")
	private double drumWiseQuantity1;

	@Column(name = "drumWiseQuantity2")
	private double drumWiseQuantity2;

	@Column(name = "drumWiseQuantity3")
	private double drumWiseQuantity3;

	@Column(name = "drumWiseQuantity4")
	private double drumWiseQuantity4;

	@Column(name = "drumWiseQuantity5")
	private double drumWiseQuantity5;

	@Column(name = "drumWiseQuantity6")
	private double drumWiseQuantity6;

	@Column(name = "drumWiseQuantity7")
	private double drumWiseQuantity7;

	@Column(name = "drumWiseQuantity8")
	private double drumWiseQuantity8;

	@Column(name = "drumWiseQuantity9")
	private double drumWiseQuantity9;

	@Column(name = "drumWiseQuantity10")
	private double drumWiseQuantity10;

	@Column(name = "drumWiseQuantity11")
	private double drumWiseQuantity11;

	@Column(name = "drumWiseQuantity12")
	private double drumWiseQuantity12;

	@Column(name = "drumWiseQuantity13")
	private double drumWiseQuantity13;

	@Column(name = "drumWiseQuantity14")
	private double drumWiseQuantity14;

	@Column(name = "drumWiseQuantity15")
	private double drumWiseQuantity15;

	@Column(name = "drumWiseQuantity16")
	private double drumWiseQuantity16;

	@Column(name = "drumWiseQuantity17")
	private double drumWiseQuantity17;

	@Column(name = "drumWiseQuantity18")
	private double drumWiseQuantity18;

	@Column(name = "drumWiseQuantity19")
	private double drumWiseQuantity19;

	@Column(name = "drumWiseQuantity20")
	private double drumWiseQuantity20;

	@Column(name = "drumWiseQuantity21")
	private double drumWiseQuantity21;

	@Column(name = "drumWiseQuantity22")
	private double drumWiseQuantity22;

	@Column(name = "drumWiseQuantity23")
	private double drumWiseQuantity23;


	@Column(name = "drumWiseQuantity24")
	private double drumWiseQuantity24;

	@Column(name = "drumWiseQuantity25")
	private double drumWiseQuantity25;

	@Column(name = "drumWiseQuantity26")
	private double drumWiseQuantity26;

	@Column(name = "drumWiseQuantity27")
	private double drumWiseQuantity27;

	@Column(name = "drumWiseQuantity28")
	private double drumWiseQuantity28;

	@Column(name = "drumWiseQuantity29")
	private double drumWiseQuantity29;

	@Column(name = "drumWiseQuantity30")
	private double drumWiseQuantity30;

	@Column(name = "drumWiseQuantity31")
	private double drumWiseQuantity31;

	@Column(name = "drumWiseQuantity32")
	private double drumWiseQuantity32;

	@Column(name = "drumWiseQuantity33")
	private double drumWiseQuantity33;

	@Column(name = "drumWiseQuantity34")
	private double drumWiseQuantity34;

	@Column(name = "drumWiseQuantity35")
	private double drumWiseQuantity35;

	@Column(name = "drumWiseQuantity36")
	private double drumWiseQuantity36;

	@Column(name = "drumWiseQuantity37")
	private double drumWiseQuantity37;

	@Column(name = "drumWiseQuantity38")
	private double drumWiseQuantity38;

	@Column(name = "drumWiseQuantity39")
	private double drumWiseQuantity39;

	@Column(name = "drumWiseQuantity40")
	private double drumWiseQuantity40;

	@Column(name = "drumWiseQuantity41")
	private double drumWiseQuantity41;

	@Column(name = "drumWiseQuantity42")
	private double drumWiseQuantity42;

	@Column(name = "drumWiseQuantity43")
	private double drumWiseQuantity43;

	@Column(name = "drumWiseQuantity44")
	private double drumWiseQuantity44;

	@Column(name = "drumWiseQuantity45")
	private double drumWiseQuantity45;

	@Column(name = "drumWiseQuantity46")
	private double drumWiseQuantity46;

	@Column(name = "drumWiseQuantity47")
	private double drumWiseQuantity47;

	@Column(name = "drumWiseQuantity48")
	private double drumWiseQuantity48;

	@Column(name = "drumWiseQuantity49")
	private double drumWiseQuantity49;

	@Column(name = "drumWiseQuantity50")
	private double drumWiseQuantity50;
	
	@Column(name = "payment_status")
	private int payment_status;

	@Transient
	String dop;
	
	@Transient
	String popname;
	
	
	












	
	
	public String getPopname() {
		return popname;
	}







	public void setPopname(String popname) {
		this.popname = popname;
	}







	public String getDop() {
		return dop;
	}







	public void setDop(String dop) {
		this.dop = dop;
	}







	public int getTallyid() {
		return tallyid;
	}







	public void setTallyid(int tallyid) {
		this.tallyid = tallyid;
	}







	public String getFarmerRegNo() {
		return farmerRegNo;
	}







	public void setFarmerRegNo(String farmerRegNo) {
		this.farmerRegNo = farmerRegNo;
	}







	public String getTallyNo() {
		return tallyNo;
	}







	public void setTallyNo(String tallyNo) {
		this.tallyNo = tallyNo;
	}





	public String getPuchasedate() {
		return puchasedate;
	}

 
	public void setPuchasedate(String puchasedate) {
		this.puchasedate = puchasedate;
 
	}

	public String getErrors() {
		return errors;
	}







	public void setErrors(String errors) {
		this.errors = errors;
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







	public double getNetquantity() {
		return netquantity;
	}







	public void setNetquantity(double netquantity) {
		this.netquantity = netquantity;
	}







	public double getGarsatrate() {
		return garsatrate;
	}







	public void setGarsatrate(double garsatrate) {
		this.garsatrate = garsatrate;
	}







	public String getTallySlipImg() {
		return tallySlipImg;
	}







	public void setTallySlipImg(String tallySlipImg) {
		this.tallySlipImg = tallySlipImg;
	}







	public double getGrossqty() {
		return grossqty;
	}







	public void setGrossqty(double grossqty) {
		this.grossqty = grossqty;
	}







	public double getAmountpayable() {
		return amountpayable;
	}







	public void setAmountpayable(double amountpayable) {
		this.amountpayable = amountpayable;
	}







	public int getCreatedby() {
		return createdby;
	}







	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}







	public String getPlaceOfPurchase() {
		return placeOfPurchase;
	}







	public void setPlaceOfPurchase(String placeOfPurchase) {
		this.placeOfPurchase = placeOfPurchase;
	}







	public double getDrumWiseQuantity1() {
		return drumWiseQuantity1;
	}







	public void setDrumWiseQuantity1(double drumWiseQuantity1) {
		this.drumWiseQuantity1 = drumWiseQuantity1;
	}







	public double getDrumWiseQuantity2() {
		return drumWiseQuantity2;
	}







	public void setDrumWiseQuantity2(double drumWiseQuantity2) {
		this.drumWiseQuantity2 = drumWiseQuantity2;
	}







	public double getDrumWiseQuantity3() {
		return drumWiseQuantity3;
	}







	public void setDrumWiseQuantity3(double drumWiseQuantity3) {
		this.drumWiseQuantity3 = drumWiseQuantity3;
	}







	public double getDrumWiseQuantity4() {
		return drumWiseQuantity4;
	}







	public void setDrumWiseQuantity4(double drumWiseQuantity4) {
		this.drumWiseQuantity4 = drumWiseQuantity4;
	}







	public double getDrumWiseQuantity5() {
		return drumWiseQuantity5;
	}







	public void setDrumWiseQuantity5(double drumWiseQuantity5) {
		this.drumWiseQuantity5 = drumWiseQuantity5;
	}







	public double getDrumWiseQuantity6() {
		return drumWiseQuantity6;
	}







	public void setDrumWiseQuantity6(double drumWiseQuantity6) {
		this.drumWiseQuantity6 = drumWiseQuantity6;
	}







	public double getDrumWiseQuantity7() {
		return drumWiseQuantity7;
	}







	public void setDrumWiseQuantity7(double drumWiseQuantity7) {
		this.drumWiseQuantity7 = drumWiseQuantity7;
	}







	public double getDrumWiseQuantity8() {
		return drumWiseQuantity8;
	}







	public void setDrumWiseQuantity8(double drumWiseQuantity8) {
		this.drumWiseQuantity8 = drumWiseQuantity8;
	}







	public double getDrumWiseQuantity9() {
		return drumWiseQuantity9;
	}







	public void setDrumWiseQuantity9(double drumWiseQuantity9) {
		this.drumWiseQuantity9 = drumWiseQuantity9;
	}







	public double getDrumWiseQuantity10() {
		return drumWiseQuantity10;
	}







	public void setDrumWiseQuantity10(double drumWiseQuantity10) {
		this.drumWiseQuantity10 = drumWiseQuantity10;
	}







	public double getDrumWiseQuantity11() {
		return drumWiseQuantity11;
	}







	public void setDrumWiseQuantity11(double drumWiseQuantity11) {
		this.drumWiseQuantity11 = drumWiseQuantity11;
	}







	public double getDrumWiseQuantity12() {
		return drumWiseQuantity12;
	}







	public void setDrumWiseQuantity12(double drumWiseQuantity12) {
		this.drumWiseQuantity12 = drumWiseQuantity12;
	}







	public double getDrumWiseQuantity13() {
		return drumWiseQuantity13;
	}







	public void setDrumWiseQuantity13(double drumWiseQuantity13) {
		this.drumWiseQuantity13 = drumWiseQuantity13;
	}







	public double getDrumWiseQuantity14() {
		return drumWiseQuantity14;
	}







	public void setDrumWiseQuantity14(double drumWiseQuantity14) {
		this.drumWiseQuantity14 = drumWiseQuantity14;
	}







	public double getDrumWiseQuantity15() {
		return drumWiseQuantity15;
	}







	public void setDrumWiseQuantity15(double drumWiseQuantity15) {
		this.drumWiseQuantity15 = drumWiseQuantity15;
	}







	public double getDrumWiseQuantity16() {
		return drumWiseQuantity16;
	}







	public void setDrumWiseQuantity16(double drumWiseQuantity16) {
		this.drumWiseQuantity16 = drumWiseQuantity16;
	}







	public double getDrumWiseQuantity17() {
		return drumWiseQuantity17;
	}







	public void setDrumWiseQuantity17(double drumWiseQuantity17) {
		this.drumWiseQuantity17 = drumWiseQuantity17;
	}







	public double getDrumWiseQuantity18() {
		return drumWiseQuantity18;
	}







	public void setDrumWiseQuantity18(double drumWiseQuantity18) {
		this.drumWiseQuantity18 = drumWiseQuantity18;
	}







	public double getDrumWiseQuantity19() {
		return drumWiseQuantity19;
	}







	public void setDrumWiseQuantity19(double drumWiseQuantity19) {
		this.drumWiseQuantity19 = drumWiseQuantity19;
	}







	public double getDrumWiseQuantity20() {
		return drumWiseQuantity20;
	}







	public void setDrumWiseQuantity20(double drumWiseQuantity20) {
		this.drumWiseQuantity20 = drumWiseQuantity20;
	}







	public double getDrumWiseQuantity21() {
		return drumWiseQuantity21;
	}







	public void setDrumWiseQuantity21(double drumWiseQuantity21) {
		this.drumWiseQuantity21 = drumWiseQuantity21;
	}







	public double getDrumWiseQuantity22() {
		return drumWiseQuantity22;
	}







	public void setDrumWiseQuantity22(double drumWiseQuantity22) {
		this.drumWiseQuantity22 = drumWiseQuantity22;
	}







	public double getDrumWiseQuantity23() {
		return drumWiseQuantity23;
	}







	public void setDrumWiseQuantity23(double drumWiseQuantity23) {
		this.drumWiseQuantity23 = drumWiseQuantity23;
	}







	public double getDrumWiseQuantity24() {
		return drumWiseQuantity24;
	}







	public void setDrumWiseQuantity24(double drumWiseQuantity24) {
		this.drumWiseQuantity24 = drumWiseQuantity24;
	}







	public double getDrumWiseQuantity25() {
		return drumWiseQuantity25;
	}







	public void setDrumWiseQuantity25(double drumWiseQuantity25) {
		this.drumWiseQuantity25 = drumWiseQuantity25;
	}







	public double getDrumWiseQuantity26() {
		return drumWiseQuantity26;
	}







	public void setDrumWiseQuantity26(double drumWiseQuantity26) {
		this.drumWiseQuantity26 = drumWiseQuantity26;
	}







	public double getDrumWiseQuantity27() {
		return drumWiseQuantity27;
	}







	public void setDrumWiseQuantity27(double drumWiseQuantity27) {
		this.drumWiseQuantity27 = drumWiseQuantity27;
	}







	public double getDrumWiseQuantity28() {
		return drumWiseQuantity28;
	}







	public void setDrumWiseQuantity28(double drumWiseQuantity28) {
		this.drumWiseQuantity28 = drumWiseQuantity28;
	}







	public double getDrumWiseQuantity29() {
		return drumWiseQuantity29;
	}







	public void setDrumWiseQuantity29(double drumWiseQuantity29) {
		this.drumWiseQuantity29 = drumWiseQuantity29;
	}







	public double getDrumWiseQuantity30() {
		return drumWiseQuantity30;
	}







	public void setDrumWiseQuantity30(double drumWiseQuantity30) {
		this.drumWiseQuantity30 = drumWiseQuantity30;
	}







	public double getDrumWiseQuantity31() {
		return drumWiseQuantity31;
	}







	public void setDrumWiseQuantity31(double drumWiseQuantity31) {
		this.drumWiseQuantity31 = drumWiseQuantity31;
	}







	public double getDrumWiseQuantity32() {
		return drumWiseQuantity32;
	}







	public void setDrumWiseQuantity32(double drumWiseQuantity32) {
		this.drumWiseQuantity32 = drumWiseQuantity32;
	}







	public double getDrumWiseQuantity33() {
		return drumWiseQuantity33;
	}







	public void setDrumWiseQuantity33(double drumWiseQuantity33) {
		this.drumWiseQuantity33 = drumWiseQuantity33;
	}







	public double getDrumWiseQuantity34() {
		return drumWiseQuantity34;
	}







	public void setDrumWiseQuantity34(double drumWiseQuantity34) {
		this.drumWiseQuantity34 = drumWiseQuantity34;
	}







	public double getDrumWiseQuantity35() {
		return drumWiseQuantity35;
	}







	public void setDrumWiseQuantity35(double drumWiseQuantity35) {
		this.drumWiseQuantity35 = drumWiseQuantity35;
	}







	public double getDrumWiseQuantity36() {
		return drumWiseQuantity36;
	}







	public void setDrumWiseQuantity36(double drumWiseQuantity36) {
		this.drumWiseQuantity36 = drumWiseQuantity36;
	}







	public double getDrumWiseQuantity37() {
		return drumWiseQuantity37;
	}







	public void setDrumWiseQuantity37(double drumWiseQuantity37) {
		this.drumWiseQuantity37 = drumWiseQuantity37;
	}







	public double getDrumWiseQuantity38() {
		return drumWiseQuantity38;
	}







	public void setDrumWiseQuantity38(double drumWiseQuantity38) {
		this.drumWiseQuantity38 = drumWiseQuantity38;
	}







	public double getDrumWiseQuantity39() {
		return drumWiseQuantity39;
	}







	public void setDrumWiseQuantity39(double drumWiseQuantity39) {
		this.drumWiseQuantity39 = drumWiseQuantity39;
	}







	public double getDrumWiseQuantity40() {
		return drumWiseQuantity40;
	}







	public void setDrumWiseQuantity40(double drumWiseQuantity40) {
		this.drumWiseQuantity40 = drumWiseQuantity40;
	}







	public double getDrumWiseQuantity41() {
		return drumWiseQuantity41;
	}







	public void setDrumWiseQuantity41(double drumWiseQuantity41) {
		this.drumWiseQuantity41 = drumWiseQuantity41;
	}







	public double getDrumWiseQuantity42() {
		return drumWiseQuantity42;
	}







	public void setDrumWiseQuantity42(double drumWiseQuantity42) {
		this.drumWiseQuantity42 = drumWiseQuantity42;
	}







	public double getDrumWiseQuantity43() {
		return drumWiseQuantity43;
	}







	public void setDrumWiseQuantity43(double drumWiseQuantity43) {
		this.drumWiseQuantity43 = drumWiseQuantity43;
	}







	public double getDrumWiseQuantity44() {
		return drumWiseQuantity44;
	}







	public void setDrumWiseQuantity44(double drumWiseQuantity44) {
		this.drumWiseQuantity44 = drumWiseQuantity44;
	}







	public double getDrumWiseQuantity45() {
		return drumWiseQuantity45;
	}







	public void setDrumWiseQuantity45(double drumWiseQuantity45) {
		this.drumWiseQuantity45 = drumWiseQuantity45;
	}







	public double getDrumWiseQuantity46() {
		return drumWiseQuantity46;
	}







	public void setDrumWiseQuantity46(double drumWiseQuantity46) {
		this.drumWiseQuantity46 = drumWiseQuantity46;
	}







	public double getDrumWiseQuantity47() {
		return drumWiseQuantity47;
	}







	public void setDrumWiseQuantity47(double drumWiseQuantity47) {
		this.drumWiseQuantity47 = drumWiseQuantity47;
	}







	public double getDrumWiseQuantity48() {
		return drumWiseQuantity48;
	}







	public void setDrumWiseQuantity48(double drumWiseQuantity48) {
		this.drumWiseQuantity48 = drumWiseQuantity48;
	}







	public double getDrumWiseQuantity49() {
		return drumWiseQuantity49;
	}







	public void setDrumWiseQuantity49(double drumWiseQuantity49) {
		this.drumWiseQuantity49 = drumWiseQuantity49;
	}







	public double getDrumWiseQuantity50() {
		return drumWiseQuantity50;
	}







	public void setDrumWiseQuantity50(double drumWiseQuantity50) {
		this.drumWiseQuantity50 = drumWiseQuantity50;
	}

	
	






	public int getPayment_status() {
		return payment_status;
	}







	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}







	public VerifyTallySlip() {

	}






	@Override
	public String toString() {
		return "VerifyTallySlip [tallyid=" + tallyid + ", farmerRegNo=" + farmerRegNo + ", tallyNo=" + tallyNo
				+ ", puchasedate=" + puchasedate + ", errors=" + errors + ", status=" + status + ", is_varified="
				+ is_varified + ", rateslipno=" + rateslipno + ", binno=" + binno + ", jutevariety=" + jutevariety
				+ ", netquantity=" + netquantity + ", garsatrate=" + garsatrate + ", tallySlipImg=" + tallySlipImg
				+ ", facheck_flag=" + facheck_flag + ", region_id=" + region_id + ", zone_id=" + zone_id + ", basis="
				+ basis + ", centername=" + centername + ", farmer_name=" + farmer_name + ", grossqty=" + grossqty
				+ ", amountpayable=" + amountpayable + ", createdby=" + createdby + ", placeOfPurchase="
				+ placeOfPurchase + ", drumWiseQuantity1=" + drumWiseQuantity1 + ", drumWiseQuantity2="
				+ drumWiseQuantity2 + ", drumWiseQuantity3=" + drumWiseQuantity3 + ", drumWiseQuantity4="
				+ drumWiseQuantity4 + ", drumWiseQuantity5=" + drumWiseQuantity5 + ", drumWiseQuantity6="
				+ drumWiseQuantity6 + ", drumWiseQuantity7=" + drumWiseQuantity7 + ", drumWiseQuantity8="
				+ drumWiseQuantity8 + ", drumWiseQuantity9=" + drumWiseQuantity9 + ", drumWiseQuantity10="
				+ drumWiseQuantity10 + ", drumWiseQuantity11=" + drumWiseQuantity11 + ", drumWiseQuantity12="
				+ drumWiseQuantity12 + ", drumWiseQuantity13=" + drumWiseQuantity13 + ", drumWiseQuantity14="
				+ drumWiseQuantity14 + ", drumWiseQuantity15=" + drumWiseQuantity15 + ", drumWiseQuantity16="
				+ drumWiseQuantity16 + ", drumWiseQuantity17=" + drumWiseQuantity17 + ", drumWiseQuantity18="
				+ drumWiseQuantity18 + ", drumWiseQuantity19=" + drumWiseQuantity19 + ", drumWiseQuantity20="
				+ drumWiseQuantity20 + ", drumWiseQuantity21=" + drumWiseQuantity21 + ", drumWiseQuantity22="
				+ drumWiseQuantity22 + ", drumWiseQuantity23=" + drumWiseQuantity23 + ", drumWiseQuantity24="
				+ drumWiseQuantity24 + ", drumWiseQuantity25=" + drumWiseQuantity25 + ", drumWiseQuantity26="
				+ drumWiseQuantity26 + ", drumWiseQuantity27=" + drumWiseQuantity27 + ", drumWiseQuantity28="
				+ drumWiseQuantity28 + ", drumWiseQuantity29=" + drumWiseQuantity29 + ", drumWiseQuantity30="
				+ drumWiseQuantity30 + ", drumWiseQuantity31=" + drumWiseQuantity31 + ", drumWiseQuantity32="
				+ drumWiseQuantity32 + ", drumWiseQuantity33=" + drumWiseQuantity33 + ", drumWiseQuantity34="
				+ drumWiseQuantity34 + ", drumWiseQuantity35=" + drumWiseQuantity35 + ", drumWiseQuantity36="
				+ drumWiseQuantity36 + ", drumWiseQuantity37=" + drumWiseQuantity37 + ", drumWiseQuantity38="
				+ drumWiseQuantity38 + ", drumWiseQuantity39=" + drumWiseQuantity39 + ", drumWiseQuantity40="
				+ drumWiseQuantity40 + ", drumWiseQuantity41=" + drumWiseQuantity41 + ", drumWiseQuantity42="
				+ drumWiseQuantity42 + ", drumWiseQuantity43=" + drumWiseQuantity43 + ", drumWiseQuantity44="
				+ drumWiseQuantity44 + ", drumWiseQuantity45=" + drumWiseQuantity45 + ", drumWiseQuantity46="
				+ drumWiseQuantity46 + ", drumWiseQuantity47=" + drumWiseQuantity47 + ", drumWiseQuantity48="
				+ drumWiseQuantity48 + ", drumWiseQuantity49=" + drumWiseQuantity49 + ", drumWiseQuantity50="
				+ drumWiseQuantity50 + ", payment_status=" + payment_status + ", dop=" + dop + ", popname=" + popname
				+ "]";
	}

	public VerifyTallySlip(int tallyid, String farmerRegNo, String tallyNo, String puchasedate, String errors,
			String status, int is_varified, int rateslipno, int binno, String jutevariety, double netquantity,
			double garsatrate, String tallySlipImg, double grossqty, double amountpayable, int createdby,
			String placeOfPurchase, double drumWiseQuantity1, double drumWiseQuantity2, double drumWiseQuantity3,
			double drumWiseQuantity4, double drumWiseQuantity5, double drumWiseQuantity6, double drumWiseQuantity7,
			double drumWiseQuantity8, double drumWiseQuantity9, double drumWiseQuantity10, double drumWiseQuantity11,
			double drumWiseQuantity12, double drumWiseQuantity13, double drumWiseQuantity14, double drumWiseQuantity15,
			double drumWiseQuantity16, double drumWiseQuantity17, double drumWiseQuantity18, double drumWiseQuantity19,
			double drumWiseQuantity20, double drumWiseQuantity21, double drumWiseQuantity22, double drumWiseQuantity23,
			double drumWiseQuantity24, double drumWiseQuantity25, double drumWiseQuantity26, double drumWiseQuantity27,
			double drumWiseQuantity28, double drumWiseQuantity29, double drumWiseQuantity30, double drumWiseQuantity31,
			double drumWiseQuantity32, double drumWiseQuantity33, double drumWiseQuantity34, double drumWiseQuantity35,
			double drumWiseQuantity36, double drumWiseQuantity37, double drumWiseQuantity38, double drumWiseQuantity39,
			double drumWiseQuantity40, double drumWiseQuantity41, double drumWiseQuantity42, double drumWiseQuantity43,
			double drumWiseQuantity44, double drumWiseQuantity45, double drumWiseQuantity46, double drumWiseQuantity47,
			double drumWiseQuantity48, double drumWiseQuantity49, double drumWiseQuantity50, int payment_status,
			String dop, String popname, String facheck_flag, String region_id, String zone_id, String centername, String basis, String farmer_name) {
		super();
		this.tallyid = tallyid;
		this.farmerRegNo = farmerRegNo;
		this.tallyNo = tallyNo;
		this.puchasedate = puchasedate;
		this.errors = errors;
		this.status = status;
		this.is_varified = is_varified;
		this.rateslipno = rateslipno;
		this.binno = binno;
		this.jutevariety = jutevariety;
		this.netquantity = netquantity;
		this.garsatrate = garsatrate;
		this.tallySlipImg = tallySlipImg;
		this.grossqty = grossqty;
		this.amountpayable = amountpayable;
		this.createdby = createdby;
		this.placeOfPurchase = placeOfPurchase;
		this.drumWiseQuantity1 = drumWiseQuantity1;
		this.drumWiseQuantity2 = drumWiseQuantity2;
		this.drumWiseQuantity3 = drumWiseQuantity3;
		this.drumWiseQuantity4 = drumWiseQuantity4;
		this.drumWiseQuantity5 = drumWiseQuantity5;
		this.drumWiseQuantity6 = drumWiseQuantity6;
		this.drumWiseQuantity7 = drumWiseQuantity7;
		this.drumWiseQuantity8 = drumWiseQuantity8;
		this.drumWiseQuantity9 = drumWiseQuantity9;
		this.drumWiseQuantity10 = drumWiseQuantity10;
		this.drumWiseQuantity11 = drumWiseQuantity11;
		this.drumWiseQuantity12 = drumWiseQuantity12;
		this.drumWiseQuantity13 = drumWiseQuantity13;
		this.drumWiseQuantity14 = drumWiseQuantity14;
		this.drumWiseQuantity15 = drumWiseQuantity15;
		this.drumWiseQuantity16 = drumWiseQuantity16;
		this.drumWiseQuantity17 = drumWiseQuantity17;
		this.drumWiseQuantity18 = drumWiseQuantity18;
		this.drumWiseQuantity19 = drumWiseQuantity19;
		this.drumWiseQuantity20 = drumWiseQuantity20;
		this.drumWiseQuantity21 = drumWiseQuantity21;
		this.drumWiseQuantity22 = drumWiseQuantity22;
		this.drumWiseQuantity23 = drumWiseQuantity23;
		this.drumWiseQuantity24 = drumWiseQuantity24;
		this.drumWiseQuantity25 = drumWiseQuantity25;
		this.drumWiseQuantity26 = drumWiseQuantity26;
		this.drumWiseQuantity27 = drumWiseQuantity27;
		this.drumWiseQuantity28 = drumWiseQuantity28;
		this.drumWiseQuantity29 = drumWiseQuantity29;
		this.drumWiseQuantity30 = drumWiseQuantity30;
		this.drumWiseQuantity31 = drumWiseQuantity31;
		this.drumWiseQuantity32 = drumWiseQuantity32;
		this.drumWiseQuantity33 = drumWiseQuantity33;
		this.drumWiseQuantity34 = drumWiseQuantity34;
		this.drumWiseQuantity35 = drumWiseQuantity35;
		this.drumWiseQuantity36 = drumWiseQuantity36;
		this.drumWiseQuantity37 = drumWiseQuantity37;
		this.drumWiseQuantity38 = drumWiseQuantity38;
		this.drumWiseQuantity39 = drumWiseQuantity39;
		this.drumWiseQuantity40 = drumWiseQuantity40;
		this.drumWiseQuantity41 = drumWiseQuantity41;
		this.drumWiseQuantity42 = drumWiseQuantity42;
		this.drumWiseQuantity43 = drumWiseQuantity43;
		this.drumWiseQuantity44 = drumWiseQuantity44;
		this.drumWiseQuantity45 = drumWiseQuantity45;
		this.drumWiseQuantity46 = drumWiseQuantity46;
		this.drumWiseQuantity47 = drumWiseQuantity47;
		this.drumWiseQuantity48 = drumWiseQuantity48;
		this.drumWiseQuantity49 = drumWiseQuantity49;
		this.drumWiseQuantity50 = drumWiseQuantity50;
		this.payment_status = payment_status;
		this.dop = dop;
		this.popname = popname;
		this.facheck_flag = facheck_flag;
		this.region_id = region_id;
		this.zone_id = zone_id;
		this.centername = centername;
		this.basis = basis;
		this.farmer_name = farmer_name;
		
	}







}
