package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PurchaseRegisterDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String regionId;
	private String centername;
	private String tallyslipno;
	private String datepurchase;
	private String farmerregno;
	private String placeofpurchase;
	private String cropyr;
	private String basis;
	private String jutevariety;
	private double gross_qty;
	private double deduc_qty;
	private double net_qty;
	private double amountpayable;
	private double garsat;
	private String td_base;
	private int binno;
	private String F_name;
	private String farmername;
	private int rate_slipno;
	private String tally_status;
	private String FDtoTD;
	
	
	public String getFDtoTD() {
		return FDtoTD;
	}
	public void setFDtoTD(String fDtoTD) {
		FDtoTD = fDtoTD;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	
	
	public String getF_name() {
		return F_name;
	}
	public void setF_name(String f_name) {
		F_name = f_name;
	}
	public int getRate_slipno() {
		return rate_slipno;
	}
	public void setRate_slipno(int rate_slipno) {
		this.rate_slipno = rate_slipno;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getTallyslipno() {
		return tallyslipno;
	}
	public void setTallyslipno(String tallyslipno) {
		this.tallyslipno = tallyslipno;
	}
	public String getDatepurchase() {
		return datepurchase;
	}
	public void setDatepurchase(String datepurchase) {
		this.datepurchase = datepurchase;
	}
	public String getFarmerregno() {
		return farmerregno;
	}
	public void setFarmerregno(String farmerregno) {
		this.farmerregno = farmerregno;
	}
	public String getPlaceofpurchase() {
		return placeofpurchase;
	}
	public void setPlaceofpurchase(String placeofpurchase) {
		this.placeofpurchase = placeofpurchase;
	}
	public String getCropyr() {
		return cropyr;
	}
	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getJutevariety() {
		return jutevariety;
	}
	public void setJutevariety(String jutevariety) {
		this.jutevariety = jutevariety;
	}
	public double getGross_qty() {
		return gross_qty;
	}
	public void setGross_qty(double gross_qty) {
		this.gross_qty = gross_qty;
	}
	public double getDeduc_qty() {
		return deduc_qty;
	}
	public void setDeduc_qty(double deduc_qty) {
		this.deduc_qty = deduc_qty;
	}
	public double getNet_qty() {
		return net_qty;
	}
	public void setNet_qty(double net_qty) {
		this.net_qty = net_qty;
	}
	public double getAmountpayable() {
		return amountpayable;
	}
	public void setAmountpayable(double amountpayable) {
		this.amountpayable = amountpayable;
	}
	public double getGarsat() {
		return garsat;
	}
	public void setGarsat(double garsat) {
		this.garsat = garsat;
	}
	public String getTd_base() {
		return td_base;
	}
	public void setTd_base(String td_base) {
		this.td_base = td_base;
	}
	public int getBinno() {
		return binno;
	}
	public void setBinno(int binno) {
		this.binno = binno;
	}
	public String getTally_status() {
		return tally_status;
	}
	public void setTally_status(String tally_status) {
		this.tally_status = tally_status;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "PurchaseRegisterDTO [regionId=" + regionId + ", centername=" + centername + ", tallyslipno="
				+ tallyslipno + ", datepurchase=" + datepurchase + ", farmerregno=" + farmerregno + ", placeofpurchase="
				+ placeofpurchase + ", cropyr=" + cropyr + ", basis=" + basis + ", jutevariety=" + jutevariety
				+ ", gross_qty=" + gross_qty + ", deduc_qty=" + deduc_qty + ", net_qty=" + net_qty + ", amountpayable="
				+ amountpayable + ", garsat=" + garsat + ", td_base=" + td_base + ", binno=" + binno + ", F_name="
				+ F_name + ", farmername=" + farmername + ", rate_slipno=" + rate_slipno + ", tally_status="
				+ tally_status + ", FDtoTD=" + FDtoTD + "]";
	}
	
	public PurchaseRegisterDTO(String regionId, String centername, String tallyslipno, String datepurchase,
			String farmerregno, String placeofpurchase, String cropyr, String basis, String jutevariety,
			double gross_qty, double deduc_qty, double net_qty, double amountpayable, double garsat, String td_base,
			int binno, String f_name, String farmername, int rate_slipno, String tally_status, String fDtoTD) {
		super();
		this.regionId = regionId;
		this.centername = centername;
		this.tallyslipno = tallyslipno;
		this.datepurchase = datepurchase;
		this.farmerregno = farmerregno;
		this.placeofpurchase = placeofpurchase;
		this.cropyr = cropyr;
		this.basis = basis;
		this.jutevariety = jutevariety;
		this.gross_qty = gross_qty;
		this.deduc_qty = deduc_qty;
		this.net_qty = net_qty;
		this.amountpayable = amountpayable;
		this.garsat = garsat;
		this.td_base = td_base;
		this.binno = binno;
		F_name = f_name;
		this.farmername = farmername;
		this.rate_slipno = rate_slipno;
		this.tally_status = tally_status;
		FDtoTD = fDtoTD;
	}
	public PurchaseRegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
