package com.jci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jcicommercialsales_rsp", schema="dbo")
public class FinalizationoflotsizerspModel {
	
	
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Rsp_id")
		private int Rsp_id;
	    
	    @Column(name="Crop_year")
		private String Crop_year;
	    
	    @Column(name="Region")
		private String Region;
	    
	    @Column(name="Dpc")
		private String Dpc;
	    
	    @Column(name="Bin")
		private String Bin;
	    
	    @Column(name="Lot_Identification")
		private String Lot_Identification;
	    
	    
	    @Column(name="Lot_Size")
		private String Lot_Size;
	    
	    @Column(name="Purchase_Base_Price")
		private String Purchase_Base_Price;
	    
	    @Column(name="Pur_grd1_diff")
		private Double Pur_grd1_diff;
	    
	    @Column(name="Pur_grd2_diff")
		private Double Pur_grd2_diff;
	    
	    @Column(name="Pur_grd3_diff")
		private Double Pur_grd3_diff;
	    
	    @Column(name="Pur_grd4_diff")
	    private Double Pur_grd4_diff;
	    
	    @Column(name="Pur_grd5_diff")
		private Double Pur_grd5_diff;
	    
	    @Column(name="Pur_grd6_diff")
		private Double Pur_grd6_diff;
	    
	    @Column(name="Factor_Head_wise_rate")
		private Double Factor_Head_wise_rate;
	    
	    @Column(name="Delivery_Type")
		private String Delivery_Type;
	    
	    @Column(name="Reserved_Sale_Price")
		private Double Reserved_Sale_Price;
	    
	    @Column(name="Sell_gr1_diff")
		private Double Sell_gr1_diff;
	    
	    @Column(name="Sell_gr2_diff")
		private Double Sell_gr2_diff;
	    
	    @Column(name="Sell_gr3_diff")
		private Double Sell_gr3_diff;
	    
	    @Column(name="Sell_gr4_diff")
		private Double Sell_gr4_diff;
	    
	    @Column(name="Sell_gr5_diff")
		private Double Sell_gr5_diff;
	    
	    @Column(name="Sell_gr6_diff")
		private Double Sell_gr6_diff;
	    
	    @Column(name="Created_by")
		private String Created_by;
	    
	    @Column(name="Creation_date")
		private String Creation_date;

		public int getRsp_id() {
			return Rsp_id;
		}

		public void setRsp_id(int rsp_id) {
			Rsp_id = rsp_id;
		}

		public String getCrop_year() {
			return Crop_year;
		}

		public void setCrop_year(String crop_year) {
			Crop_year = crop_year;
		}

		public String getRegion() {
			return Region;
		}

		public void setRegion(String region) {
			Region = region;
		}

		public String getDpc() {
			return Dpc;
		}

		public void setDpc(String dpc) {
			Dpc = dpc;
		}

		public String getBin() {
			return Bin;
		}

		public void setBin(String bin) {
			Bin = bin;
		}

		public String getLot_Identification() {
			return Lot_Identification;
		}

		public void setLot_Identification(String lot_Identification) {
			Lot_Identification = lot_Identification;
		}

		public String getLot_Size() {
			return Lot_Size;
		}

		public void setLot_Size(String lot_Size) {
			Lot_Size = lot_Size;
		}

		public String getPurchase_Base_Price() {
			return Purchase_Base_Price;
		}

		public void setPurchase_Base_Price(String purchase_Base_Price) {
			Purchase_Base_Price = purchase_Base_Price;
		}

		public Double getPur_grd1_diff() {
			return Pur_grd1_diff;
		}

		public void setPur_grd1_diff(Double pur_grd1_diff) {
			Pur_grd1_diff = pur_grd1_diff;
		}

		public Double getPur_grd2_diff() {
			return Pur_grd2_diff;
		}

		public void setPur_grd2_diff(Double pur_grd2_diff) {
			Pur_grd2_diff = pur_grd2_diff;
		}

		public Double getPur_grd3_diff() {
			return Pur_grd3_diff;
		}

		public void setPur_grd3_diff(Double pur_grd3_diff) {
			Pur_grd3_diff = pur_grd3_diff;
		}

		public Double getPur_grd4_diff() {
			return Pur_grd4_diff;
		}

		public void setPur_grd4_diff(Double pur_grd4_diff) {
			Pur_grd4_diff = pur_grd4_diff;
		}

		public Double getPur_grd5_diff() {
			return Pur_grd5_diff;
		}

		public void setPur_grd5_diff(Double pur_grd5_diff) {
			Pur_grd5_diff = pur_grd5_diff;
		}

		public Double getPur_grd6_diff() {
			return Pur_grd6_diff;
		}

		public void setPur_grd6_diff(Double pur_grd6_diff) {
			Pur_grd6_diff = pur_grd6_diff;
		}

		public Double getFactor_Head_wise_rate() {
			return Factor_Head_wise_rate;
		}

		public void setFactor_Head_wise_rate(Double factor_Head_wise_rate) {
			Factor_Head_wise_rate = factor_Head_wise_rate;
		}

		public String getDelivery_Type() {
			return Delivery_Type;
		}

		public void setDelivery_Type(String delivery_Type) {
			Delivery_Type = delivery_Type;
		}

		public Double getReserved_Sale_Price() {
			return Reserved_Sale_Price;
		}

		public void setReserved_Sale_Price(Double reserved_Sale_Price) {
			Reserved_Sale_Price = reserved_Sale_Price;
		}

		public Double getSell_gr1_diff() {
			return Sell_gr1_diff;
		}

		public void setSell_gr1_diff(Double sell_gr1_diff) {
			Sell_gr1_diff = sell_gr1_diff;
		}

		public Double getSell_gr2_diff() {
			return Sell_gr2_diff;
		}

		public void setSell_gr2_diff(Double sell_gr2_diff) {
			Sell_gr2_diff = sell_gr2_diff;
		}

		public Double getSell_gr3_diff() {
			return Sell_gr3_diff;
		}

		public void setSell_gr3_diff(Double sell_gr3_diff) {
			Sell_gr3_diff = sell_gr3_diff;
		}

		public Double getSell_gr4_diff() {
			return Sell_gr4_diff;
		}

		public void setSell_gr4_diff(Double sell_gr4_diff) {
			Sell_gr4_diff = sell_gr4_diff;
		}

		public Double getSell_gr5_diff() {
			return Sell_gr5_diff;
		}

		public void setSell_gr5_diff(Double sell_gr5_diff) {
			Sell_gr5_diff = sell_gr5_diff;
		}

		public Double getSell_gr6_diff() {
			return Sell_gr6_diff;
		}

		public void setSell_gr6_diff(Double sell_gr6_diff) {
			Sell_gr6_diff = sell_gr6_diff;
		}

		public String getCreated_by() {
			return Created_by;
		}

		public void setCreated_by(String created_by) {
			Created_by = created_by;
		}

		public String getCreation_date() {
			return Creation_date;
		}

		public void setCreation_date(String creation_date) {
			Creation_date = creation_date;
		}

		public FinalizationoflotsizerspModel(int rsp_id, String crop_year, String region, String dpc, String bin,
				String lot_Identification, String lot_Size, String purchase_Base_Price, Double pur_grd1_diff,
				Double pur_grd2_diff, Double pur_grd3_diff, Double pur_grd4_diff, Double pur_grd5_diff,
				Double pur_grd6_diff, Double factor_Head_wise_rate, String delivery_Type, Double reserved_Sale_Price,
				Double sell_gr1_diff, Double sell_gr2_diff, Double sell_gr3_diff, Double sell_gr4_diff,
				Double sell_gr5_diff, Double sell_gr6_diff, String created_by, String creation_date) {
			super();
			Rsp_id = rsp_id;
			Crop_year = crop_year;
			Region = region;
			Dpc = dpc;
			Bin = bin;
			Lot_Identification = lot_Identification;
			Lot_Size = lot_Size;
			Purchase_Base_Price = purchase_Base_Price;
			Pur_grd1_diff = pur_grd1_diff;
			Pur_grd2_diff = pur_grd2_diff;
			Pur_grd3_diff = pur_grd3_diff;
			Pur_grd4_diff = pur_grd4_diff;
			Pur_grd5_diff = pur_grd5_diff;
			Pur_grd6_diff = pur_grd6_diff;
			Factor_Head_wise_rate = factor_Head_wise_rate;
			Delivery_Type = delivery_Type;
			Reserved_Sale_Price = reserved_Sale_Price;
			Sell_gr1_diff = sell_gr1_diff;
			Sell_gr2_diff = sell_gr2_diff;
			Sell_gr3_diff = sell_gr3_diff;
			Sell_gr4_diff = sell_gr4_diff;
			Sell_gr5_diff = sell_gr5_diff;
			Sell_gr6_diff = sell_gr6_diff;
			Created_by = created_by;
			Creation_date = creation_date;
		}

		@Override
		public String toString() {
			return "FinalizationoflotsizerspModel [Rsp_id=" + Rsp_id + ", Crop_year=" + Crop_year + ", Region=" + Region
					+ ", Dpc=" + Dpc + ", Bin=" + Bin + ", Lot_Identification=" + Lot_Identification + ", Lot_Size="
					+ Lot_Size + ", Purchase_Base_Price=" + Purchase_Base_Price + ", Pur_grd1_diff=" + Pur_grd1_diff
					+ ", Pur_grd2_diff=" + Pur_grd2_diff + ", Pur_grd3_diff=" + Pur_grd3_diff + ", Pur_grd4_diff="
					+ Pur_grd4_diff + ", Pur_grd5_diff=" + Pur_grd5_diff + ", Pur_grd6_diff=" + Pur_grd6_diff
					+ ", Factor_Head_wise_rate=" + Factor_Head_wise_rate + ", Delivery_Type=" + Delivery_Type
					+ ", Reserved_Sale_Price=" + Reserved_Sale_Price + ", Sell_gr1_diff=" + Sell_gr1_diff
					+ ", Sell_gr2_diff=" + Sell_gr2_diff + ", Sell_gr3_diff=" + Sell_gr3_diff + ", Sell_gr4_diff="
					+ Sell_gr4_diff + ", Sell_gr5_diff=" + Sell_gr5_diff + ", Sell_gr6_diff=" + Sell_gr6_diff
					+ ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + "]";
		}

		public FinalizationoflotsizerspModel() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	   
	    
	    
	    
	    
	    
}
