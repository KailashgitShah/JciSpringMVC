package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicommercialsales_rsp", schema = "dbo")
public class FinalizationoflotsizerspModel {

              @Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              @Column(name = "Rsp_id")
              private int Rsp_id;

              @Column(name = "Crop_year")
              private String crop_year;

              @Column(name = "Region")
              private String region;

              @Column(name = "Dpc")
              private String dpc;

              @Column(name = "Bin")
              private String bin;
              
              @Column(name = "Basis")
              private String basis;

              @Column(name = "Lot_Identification")
              private String lotidentification;

              @Column(name = "Lot_Size")
              private String lotsize;

              @Column(name = "Purchase_Base_Price")
              private String purchasebaseprice;
              
              @Column(name = "Rsp_grd1")
              private Double Rsp_grd1;

              @Column(name = "Rsp_grd1_diff")
              private Double Rsp_grd1_diff;

              @Column(name = "Rsp_grd2")
              private Double Rsp_grd2;

              @Column(name = "Rsp_grd2_diff")
              private Double Rsp_grd2_diff;

              @Column(name = "Rsp_grd3")
              private Double Rsp_grd3;

              @Column(name = "Rsp_grd3_diff")
              private Double Rsp_grd3_diff;

              @Column(name = "Rsp_grd4")
              private Double Rsp_grd4;

              @Column(name = "Rsp_grd4_diff")
              private Double Rsp_grd4_diff;

              @Column(name = "Rsp_grd5")
              private Double Rsp_grd5;

              @Column(name = "Rsp_grd5_diff")
              private Double Rsp_grd5_diff;

              @Column(name = "Rsp_grd6")
              private Double Rsp_grd6;

              @Column(name = "Rsp_grd6_diff")
              private Double Rsp_grd6_diff;

              @Column(name = "Rsp_grd7")
              private Double Rsp_grd7;

              @Column(name = "Rsp_grd7_diff")
              private Double Rsp_grd7_diff;

              @Column(name = "Rsp_grd8")
              private Double Rsp_grd8;

              @Column(name = "Rsp_grd8_diff")
              private Double Rsp_grd8_diff;


            

              @Column(name = "Delivery_Type")
              private String deliverytype;

              @Column(name = "Reserved_Sale_Price")
              private Double reservedsaleprice;

              @Column(name = "Sell_gr1")
              private Double Sell_gr1;

              @Column(name = "Sell_gr1_diff")
              private Double Sell_gr1_diff;

              @Column(name = "Sell_gr2")
              private Double Sell_gr2;

              @Column(name = "Sell_gr2_diff")
              private Double Sell_gr2_diff;

             @Column(name = "Sell_gr3")
              private Double Sell_gr3;

              @Column(name = "Sell_gr3_diff")
              private Double Sell_gr3_diff;

              @Column(name = "Sell_gr4")
              private Double Sell_gr4;

             @Column(name = "Sell_gr4_diff")
              private Double Sell_gr4_diff;

              @Column(name = "Sell_gr5")
              private Double Sell_gr5;

              @Column(name = "Sell_gr5_diff")
              private Double Sell_gr5_diff;

              @Column(name = "Sell_gr6")
              private Double Sell_gr6;

              @Column(name = "Sell_gr6_diff")
              private Double Sell_gr6_diff;

              @Column(name = "Sell_gr7")
              private Double Sell_gr7;

              @Column(name = "Sell_gr7_diff")
              private Double Sell_gr7_diff;

              @Column(name = "Sell_gr8")
              private Double Sell_gr8;

              @Column(name = "Sell_gr8_diff")
              private Double Sell_gr8_diff;


              @Column(name = "Created_by")
              private String Created_by;

              @Column(name = "Creation_date")
              private Date Creation_date;
             

                    @Column(name = "Garsat_Rate")
                private Double Garsat_Rate;

              public int getRsp_id() {
                          return Rsp_id;
                    }

                    public void setRsp_id(int rsp_id) {
                          Rsp_id = rsp_id;
                    }

                    public String getCrop_year() {
                          return crop_year;
                    }

                    public void setCrop_year(String crop_year) {
                          this.crop_year = crop_year;
                    }

                    public String getRegion() {
                          return region;
                    }

                    public void setRegion(String region) {
                          this.region = region;
                    }

                    public String getDpc() {
                          return dpc;
                    }

                    public void setDpc(String dpc) {
                          this.dpc = dpc;
                    }

                    public String getBin() {
                          return bin;
                    }

                    public void setBin(String bin) {
                          this.bin = bin;
                    }

                    public String getBasis() {
                          return basis;
                    }

                    public void setBasis(String basis) {
                          this.basis = basis;
                    }

                    public String getLotidentification() {
                          return lotidentification;
                    }

                    public void setLotidentification(String lotidentification) {
                          this.lotidentification = lotidentification;
                    }

                    public String getLotsize() {
                          return lotsize;
                    }

                    public void setLotsize(String lotsize) {
                          this.lotsize = lotsize;
                    }

                    public String getPurchasebaseprice() {
                          return purchasebaseprice;
                    }

                    public void setPurchasebaseprice(String purchasebaseprice) {
                          this.purchasebaseprice = purchasebaseprice;
                    }

                    public Double getRsp_grd1() {
                          return Rsp_grd1;
                    }

                    public void setRsp_grd1(Double rsp_grd1) {
                          Rsp_grd1 = rsp_grd1;
                    }

                    public Double getRsp_grd1_diff() {
                          return Rsp_grd1_diff;
                    }

                    public void setRsp_grd1_diff(Double rsp_grd1_diff) {
                          Rsp_grd1_diff = rsp_grd1_diff;
                    }

                    public Double getRsp_grd2() {
                          return Rsp_grd2;
                    }

                    public void setRsp_grd2(Double rsp_grd2) {
                          Rsp_grd2 = rsp_grd2;
                    }

                    public Double getRsp_grd2_diff() {
                          return Rsp_grd2_diff;
                    }

                    public void setRsp_grd2_diff(Double rsp_grd2_diff) {
                          Rsp_grd2_diff = rsp_grd2_diff;
                    }

                    public Double getRsp_grd3() {
                          return Rsp_grd3;
                    }

                    public void setRsp_grd3(Double rsp_grd3) {
                          Rsp_grd3 = rsp_grd3;
                    }

                    public Double getRsp_grd3_diff() {
                          return Rsp_grd3_diff;
                    }

                    public void setRsp_grd3_diff(Double rsp_grd3_diff) {
                          Rsp_grd3_diff = rsp_grd3_diff;
                    }

                    public Double getRsp_grd4() {
                          return Rsp_grd4;
                    }

                    public void setRsp_grd4(Double rsp_grd4) {
                          Rsp_grd4 = rsp_grd4;
                    }

                    public Double getRsp_grd4_diff() {
                          return Rsp_grd4_diff;
                    }

                    public void setRsp_grd4_diff(Double rsp_grd4_diff) {
                          Rsp_grd4_diff = rsp_grd4_diff;
                    }

                    public Double getRsp_grd5() {
                          return Rsp_grd5;
                    }

                    public void setRsp_grd5(Double rsp_grd5) {
                          Rsp_grd5 = rsp_grd5;
                    }

                    public Double getRsp_grd5_diff() {
                          return Rsp_grd5_diff;
                    }

                    public void setRsp_grd5_diff(Double rsp_grd5_diff) {
                          Rsp_grd5_diff = rsp_grd5_diff;
                    }

                    public Double getRsp_grd6() {
                          return Rsp_grd6;
                    }

                    public void setRsp_grd6(Double rsp_grd6) {
                          Rsp_grd6 = rsp_grd6;
                    }

                    public Double getRsp_grd6_diff() {
                          return Rsp_grd6_diff;
                    }

                    public void setRsp_grd6_diff(Double rsp_grd6_diff) {
                          Rsp_grd6_diff = rsp_grd6_diff;
                    }

                    public Double getRsp_grd7() {
                          return Rsp_grd7;
                    }

                    public void setRsp_grd7(Double rsp_grd7) {
                          Rsp_grd7 = rsp_grd7;
                    }

                    public Double getRsp_grd7_diff() {
                          return Rsp_grd7_diff;
                    }

                    public void setRsp_grd7_diff(Double rsp_grd7_diff) {
                          Rsp_grd7_diff = rsp_grd7_diff;
                    }

                    public Double getRsp_grd8() {
                          return Rsp_grd8;
                    }

                    public void setRsp_grd8(Double rsp_grd8) {
                          Rsp_grd8 = rsp_grd8;
                    }

                    public Double getRsp_grd8_diff() {
                          return Rsp_grd8_diff;
                    }

                    public void setRsp_grd8_diff(Double rsp_grd8_diff) {
                          Rsp_grd8_diff = rsp_grd8_diff;
                    }

                    public String getDeliverytype() {
                          return deliverytype;
                    }

                    public void setDeliverytype(String deliverytype) {
                          this.deliverytype = deliverytype;
                    }

                    public Double getReservedsaleprice() {
                          return reservedsaleprice;
                    }

                    public void setReservedsaleprice(Double reservedsaleprice) {
                          this.reservedsaleprice = reservedsaleprice;
                    }

                    public Double getSell_gr1() {
                          return Sell_gr1;
                    }

                    public void setSell_gr1(Double sell_gr1) {
                          Sell_gr1 = sell_gr1;
                    }

                    public Double getSell_gr1_diff() {
                          return Sell_gr1_diff;
                    }

                    public void setSell_gr1_diff(Double sell_gr1_diff) {
                          Sell_gr1_diff = sell_gr1_diff;
                    }

                    public Double getSell_gr2() {
                          return Sell_gr2;
                    }

                    public void setSell_gr2(Double sell_gr2) {
                          Sell_gr2 = sell_gr2;
                    }

                    public Double getSell_gr2_diff() {
                          return Sell_gr2_diff;
                    }

                    public void setSell_gr2_diff(Double sell_gr2_diff) {
                          Sell_gr2_diff = sell_gr2_diff;
                    }

                    public Double getSell_gr3() {
                          return Sell_gr3;
                    }

                    public void setSell_gr3(Double sell_gr3) {
                          Sell_gr3 = sell_gr3;
                    }

                    public Double getSell_gr3_diff() {
                          return Sell_gr3_diff;
                    }

                    public void setSell_gr3_diff(Double sell_gr3_diff) {
                          Sell_gr3_diff = sell_gr3_diff;
                    }

                    public Double getSell_gr4() {
                          return Sell_gr4;
                    }

                    public void setSell_gr4(Double sell_gr4) {
                          Sell_gr4 = sell_gr4;
                    }

                    public Double getSell_gr4_diff() {
                          return Sell_gr4_diff;
                    }

                    public void setSell_gr4_diff(Double sell_gr4_diff) {
                          Sell_gr4_diff = sell_gr4_diff;
                    }

                    public Double getSell_gr5() {
                          return Sell_gr5;
                    }

                    public void setSell_gr5(Double sell_gr5) {
                          Sell_gr5 = sell_gr5;
                    }

                    public Double getSell_gr5_diff() {
                          return Sell_gr5_diff;
                    }

                    public void setSell_gr5_diff(Double sell_gr5_diff) {
                          Sell_gr5_diff = sell_gr5_diff;
                    }

                    public Double getSell_gr6() {
                          return Sell_gr6;
                    }

                    public void setSell_gr6(Double sell_gr6) {
                          Sell_gr6 = sell_gr6;
                    }

                    public Double getSell_gr6_diff() {
                          return Sell_gr6_diff;
                    }

                    public void setSell_gr6_diff(Double sell_gr6_diff) {
                          Sell_gr6_diff = sell_gr6_diff;
                    }

                    public Double getSell_gr7() {
                          return Sell_gr7;
                    }

                    public void setSell_gr7(Double sell_gr7) {
                          Sell_gr7 = sell_gr7;
                    }

                    public Double getSell_gr7_diff() {
                          return Sell_gr7_diff;
                    }

                    public void setSell_gr7_diff(Double sell_gr7_diff) {
                          Sell_gr7_diff = sell_gr7_diff;
                    }

                    public Double getSell_gr8() {
                          return Sell_gr8;
                    }

                    public void setSell_gr8(Double sell_gr8) {
                          Sell_gr8 = sell_gr8;
                    }

                    public Double getSell_gr8_diff() {
                          return Sell_gr8_diff;
                    }

                    public void setSell_gr8_diff(Double sell_gr8_diff) {
                          Sell_gr8_diff = sell_gr8_diff;
                    }

                    public String getCreated_by() {
                          return Created_by;
                    }

                    public void setCreated_by(String created_by) {
                          Created_by = created_by;
                    }

                    public Date getCreation_date() {
                          return Creation_date;
                    }

                    public void setCreation_date(Date creation_date) {
                          Creation_date = creation_date;
                    }

                    public Double getGarsat_Rate() {
                          return Garsat_Rate;
                    }

                    public void setGarsat_Rate(Double garsat_Rate) {
                          Garsat_Rate = garsat_Rate;
                    }

                    @Override
                    public String toString() {
                          return "FinalizationoflotsizerspModel [Rsp_id=" + Rsp_id + ", crop_year=" + crop_year + ", region="
                                       + region + ", dpc=" + dpc + ", bin=" + bin + ", basis=" + basis + ", lotidentification="
                                       + lotidentification + ", lotsize=" + lotsize + ", purchasebaseprice=" + purchasebaseprice
                                       + ", Rsp_grd1=" + Rsp_grd1 + ", Rsp_grd1_diff=" + Rsp_grd1_diff + ", Rsp_grd2=" + Rsp_grd2
                                       + ", Rsp_grd2_diff=" + Rsp_grd2_diff + ", Rsp_grd3=" + Rsp_grd3 + ", Rsp_grd3_diff="
                                       + Rsp_grd3_diff + ", Rsp_grd4=" + Rsp_grd4 + ", Rsp_grd4_diff=" + Rsp_grd4_diff + ", Rsp_grd5="
                                       + Rsp_grd5 + ", Rsp_grd5_diff=" + Rsp_grd5_diff + ", Rsp_grd6=" + Rsp_grd6 + ", Rsp_grd6_diff="
                                       + Rsp_grd6_diff + ", Rsp_grd7=" + Rsp_grd7 + ", Rsp_grd7_diff=" + Rsp_grd7_diff + ", Rsp_grd8="
                                       + Rsp_grd8 + ", Rsp_grd8_diff=" + Rsp_grd8_diff + ", deliverytype=" + deliverytype
                                       + ", reservedsaleprice=" + reservedsaleprice + ", Sell_gr1=" + Sell_gr1 + ", Sell_gr1_diff="
                                       + Sell_gr1_diff + ", Sell_gr2=" + Sell_gr2 + ", Sell_gr2_diff=" + Sell_gr2_diff + ", Sell_gr3="
                                       + Sell_gr3 + ", Sell_gr3_diff=" + Sell_gr3_diff + ", Sell_gr4=" + Sell_gr4 + ", Sell_gr4_diff="
                                       + Sell_gr4_diff + ", Sell_gr5=" + Sell_gr5 + ", Sell_gr5_diff=" + Sell_gr5_diff + ", Sell_gr6="
                                       + Sell_gr6 + ", Sell_gr6_diff=" + Sell_gr6_diff + ", Sell_gr7=" + Sell_gr7 + ", Sell_gr7_diff="
                                       + Sell_gr7_diff + ", Sell_gr8=" + Sell_gr8 + ", Sell_gr8_diff=" + Sell_gr8_diff
                                       + ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + ", Garsat_Rate="
                                       + Garsat_Rate + "]";
                    }

                    public FinalizationoflotsizerspModel() {
                          super();
                          // TODO Auto-generated constructor stub
                    }

                    public FinalizationoflotsizerspModel(int rsp_id, String crop_year, String region, String dpc, String bin,
                                 String basis, String lotidentification, String lotsize, String purchasebaseprice, Double rsp_grd1,
                                 Double rsp_grd1_diff, Double rsp_grd2, Double rsp_grd2_diff, Double rsp_grd3, Double rsp_grd3_diff,
                                 Double rsp_grd4, Double rsp_grd4_diff, Double rsp_grd5, Double rsp_grd5_diff, Double rsp_grd6,
                                 Double rsp_grd6_diff, Double rsp_grd7, Double rsp_grd7_diff, Double rsp_grd8, Double rsp_grd8_diff,
                                 String deliverytype, Double reservedsaleprice, Double sell_gr1, Double sell_gr1_diff,
                                 Double sell_gr2, Double sell_gr2_diff, Double sell_gr3, Double sell_gr3_diff, Double sell_gr4,
                                 Double sell_gr4_diff, Double sell_gr5, Double sell_gr5_diff, Double sell_gr6, Double sell_gr6_diff,
                                 Double sell_gr7, Double sell_gr7_diff, Double sell_gr8, Double sell_gr8_diff, String created_by,
                                 Date creation_date, Double garsat_Rate) {
                          super();
                          Rsp_id = rsp_id;
                          this.crop_year = crop_year;
                          this.region = region;
                          this.dpc = dpc;
                          this.bin = bin;
                          this.basis = basis;
                          this.lotidentification = lotidentification;
                          this.lotsize = lotsize;
                          this.purchasebaseprice = purchasebaseprice;
                          Rsp_grd1 = rsp_grd1;
                          Rsp_grd1_diff = rsp_grd1_diff;
                          Rsp_grd2 = rsp_grd2;
                          Rsp_grd2_diff = rsp_grd2_diff;
                          Rsp_grd3 = rsp_grd3;
                          Rsp_grd3_diff = rsp_grd3_diff;
                          Rsp_grd4 = rsp_grd4;
                          Rsp_grd4_diff = rsp_grd4_diff;
                          Rsp_grd5 = rsp_grd5;
                          Rsp_grd5_diff = rsp_grd5_diff;
                          Rsp_grd6 = rsp_grd6;
                          Rsp_grd6_diff = rsp_grd6_diff;
                          Rsp_grd7 = rsp_grd7;
                          Rsp_grd7_diff = rsp_grd7_diff;
                          Rsp_grd8 = rsp_grd8;
                          Rsp_grd8_diff = rsp_grd8_diff;
                          this.deliverytype = deliverytype;
                          this.reservedsaleprice = reservedsaleprice;
                          Sell_gr1 = sell_gr1;
                          Sell_gr1_diff = sell_gr1_diff;
                          Sell_gr2 = sell_gr2;
                          Sell_gr2_diff = sell_gr2_diff;
                          Sell_gr3 = sell_gr3;
                          Sell_gr3_diff = sell_gr3_diff;
                          Sell_gr4 = sell_gr4;
                          Sell_gr4_diff = sell_gr4_diff;
                          Sell_gr5 = sell_gr5;
                          Sell_gr5_diff = sell_gr5_diff;
                          Sell_gr6 = sell_gr6;
                          Sell_gr6_diff = sell_gr6_diff;
                          Sell_gr7 = sell_gr7;
                          Sell_gr7_diff = sell_gr7_diff;
                          Sell_gr8 = sell_gr8;
                          Sell_gr8_diff = sell_gr8_diff;
                          Created_by = created_by;
                          Creation_date = creation_date;
                          Garsat_Rate = garsat_Rate;
                    }

             
                    
}

