package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcicommercialsales_grades", schema = "dbo")
public class FinalizationoflotsizegradesModel {

              @Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              @Column(name = "grd_id")
              private int grd_id;
              
              @Column(name = "binNo")
              private String BinNo;

              public String getBinNo() {
                             return BinNo;
              }

              public void setBinNo(String binNo) {
                             BinNo = binNo;
              }

              @Column(name = "LotIdentification")
              private String lotidentification;

              @Column(name = "JuteVariety")
              private String Jute_Variety;

              @Column(name = "Gr_1")
              private String Gr1;

              @Column(name = "Gr_2")
              private String Gr2;

              @Column(name = "Gr_3")
              private String Gr3;

              @Column(name = "Gr_4")
              private String Gr4;

              @Column(name = "Gr_5")
              private String Gr5;

              @Column(name = "Gr_6")
              private String Gr6;
              
              @Column(name = "Gr_7")
              private String Gr7;
              
              @Column(name = "Gr_8")
              private String Gr8;

              @Column(name = "Created_by")
              private String Created_by;

              @Column(name = "Creation_date")
              private Date Creation_date;

              @Column(name = "Crop_year")
              private String Crop_year;

              @Column(name = "Region")
              private String Region;

              @Column(name = "dpc")
              private String dpc;
              
              @Column(name = "NetQty")
              private String NetQty;

              public String getNetQty() {
                             return NetQty;
              }

              public void setNetQty(String netQty) {
                             NetQty = netQty;
              }

              public int getGrd_id() {
                             return grd_id;
              }

              public void setGrd_id(int grd_id) {
                             this.grd_id = grd_id;
              }

              public String getLotidentification() {
                             return lotidentification;
              }

              public void setLotidentification(String lotidentification) {
                             this.lotidentification = lotidentification;
              }

              public String getJute_Variety() {
                             return Jute_Variety;
              }

              public void setJute_Variety(String jute_Variety) {
                             Jute_Variety = jute_Variety;
              }

              public String getGr1() {
                             return Gr1;
              }

              public void setGr1(String gr1) {
                             Gr1 = gr1;
              }

              public String getGr2() {
                             return Gr2;
              }

              public void setGr2(String gr2) {
                             Gr2 = gr2;
              }

              public String getGr3() {
                             return Gr3;
              }

              public void setGr3(String gr3) {
                             Gr3 = gr3;
              }

              public String getGr4() {
                             return Gr4;
              }

              public void setGr4(String gr4) {
                             Gr4 = gr4;
              }

              public String getGr5() {
                             return Gr5;
              }

              public void setGr5(String gr5) {
                             Gr5 = gr5;
              }

              public String getGr6() {
                             return Gr6;
              }

              public void setGr6(String gr6) {
                             Gr6 = gr6;
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

              public void setCreation_date(Date d) {
                             Creation_date = d;
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
                             return dpc;
              }

              public void setDpc(String dpc) {
                             this.dpc = dpc;
              }
              
              

              public String getGr7() {
                             return Gr7;
              }

              public void setGr7(String gr7) {
                             Gr7 = gr7;
              }

              public String getGr8() {
                             return Gr8;
              }

              public void setGr8(String gr8) {
                             Gr8 = gr8;
              }

              
              public FinalizationoflotsizegradesModel() {
                             super();
                             // TODO Auto-generated constructor stub
              }

              @Override
              public String toString() {
                             return "FinalizationoflotsizegradesModel [grd_id=" + grd_id + ", BinNo=" + BinNo + ", lotidentification="
                                                          + lotidentification + ", Jute_Variety=" + Jute_Variety + ", Gr1=" + Gr1 + ", Gr2=" + Gr2 + ", Gr3="
                                                          + Gr3 + ", Gr4=" + Gr4 + ", Gr5=" + Gr5 + ", Gr6=" + Gr6 + ", Gr7=" + Gr7 + ", Gr8=" + Gr8
                                                          + ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + ", Crop_year=" + Crop_year
                                                          + ", Region=" + Region + ", dpc=" + dpc + ", NetQty=" + NetQty + "]";
              }

              public FinalizationoflotsizegradesModel(int grd_id, String binNo, String lotidentification, String jute_Variety,
                                           String gr1, String gr2, String gr3, String gr4, String gr5, String gr6, String gr7, String gr8,
                                           String created_by, Date creation_date, String crop_year, String region, String dpc, String netQty) {
                             super();
                             this.grd_id = grd_id;
                             BinNo = binNo;
                             this.lotidentification = lotidentification;
                             Jute_Variety = jute_Variety;
                             Gr1 = gr1;
                             Gr2 = gr2;
                             Gr3 = gr3;
                             Gr4 = gr4;
                             Gr5 = gr5;
                             Gr6 = gr6;
                             Gr7 = gr7;
                             Gr8 = gr8;
                             Created_by = created_by;
                             Creation_date = creation_date;
                             Crop_year = crop_year;
                             Region = region;
                             this.dpc = dpc;
                             NetQty = netQty;
              }
          
}
