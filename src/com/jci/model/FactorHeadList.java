package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jciFactorsList", schema = "dbo")
public class FactorHeadList {
              @Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              @Column(name = "id")
              private int id;
              
              private String LotNumber;
              
              private String BinNumber;
              
              private String Region;
              
              private String Factor1;
              private Double Cost1;
              
                private String Factor2;
                  private Double Cost2;
                  
                  private String Factor3;
                  private Double Cost3;
                  
                  private String Factor4;
                  private Double Cost4;
                  
                  private String Factor5;
                  private Double Cost5;
                  
                  private String Factor6;
                  private Double Cost6;
                  
                  private String Factor7;
                  private Double Cost7;
                  
                  private String Factor8;
                  private Double Cost8;
                  
                  private String Factor9;
                  private Double Cost9;
                  
               
              
              private String CreatedBy;
              
              @Column(name = "created_date")
              private Date created_date;
              
              private int Period;

              public int getId() {
                             return id;
              }

              public void setId(int id) {
                             this.id = id;
              }

              public String getLotNumber() {
                             return LotNumber;
              }

              public void setLotNumber(String lotNumber) {
                             LotNumber = lotNumber;
              }

              public String getBinNumber() {
                             return BinNumber;
              }

              public void setBinNumber(String binNumber) {
                             BinNumber = binNumber;
              }

              public String getRegion() {
                             return Region;
              }

              public void setRegion(String region) {
                             Region = region;
              }

              public String getFactor1() {
                             return Factor1;
              }

              public void setFactor1(String factor1) {
                             Factor1 = factor1;
              }

              public Double getCost1() {
                             return Cost1;
              }

              public void setCost1(Double cost1) {
                             Cost1 = cost1;
              }

              public String getFactor2() {
                             return Factor2;
              }

              public void setFactor2(String factor2) {
                             Factor2 = factor2;
              }

              public Double getCost2() {
                             return Cost2;
              }

              public void setCost2(Double cost2) {
                             Cost2 = cost2;
              }

              public String getFactor3() {
                             return Factor3;
              }

              public void setFactor3(String factor3) {
                             Factor3 = factor3;
              }

              public Double getCost3() {
                             return Cost3;
              }

              public void setCost3(Double cost3) {
                             Cost3 = cost3;
              }

              public String getFactor4() {
                             return Factor4;
              }

              public void setFactor4(String factor4) {
                             Factor4 = factor4;
              }

              public Double getCost4() {
                             return Cost4;
              }

              public void setCost4(Double cost4) {
                             Cost4 = cost4;
              }

              public String getFactor5() {
                             return Factor5;
              }

              public void setFactor5(String factor5) {
                             Factor5 = factor5;
              }

              public Double getCost5() {
                             return Cost5;
              }

              public void setCost5(Double cost5) {
                             Cost5 = cost5;
              }

              public String getFactor6() {
                             return Factor6;
              }

              public void setFactor6(String factor6) {
                             Factor6 = factor6;
              }

              public Double getCost6() {
                             return Cost6;
              }

              public void setCost6(Double cost6) {
                             Cost6 = cost6;
              }

              public String getFactor7() {
                             return Factor7;
              }

              public void setFactor7(String factor7) {
                             Factor7 = factor7;
              }

              public Double getCost7() {
                             return Cost7;
              }

              public void setCost7(Double cost7) {
                             Cost7 = cost7;
              }

              public String getFactor8() {
                             return Factor8;
              }

              public void setFactor8(String factor8) {
                             Factor8 = factor8;
              }

              public Double getCost8() {
                             return Cost8;
              }

              public void setCost8(Double cost8) {
                             Cost8 = cost8;
              }

              public String getFactor9() {
                             return Factor9;
              }

              public void setFactor9(String factor9) {
                             Factor9 = factor9;
              }

              public Double getCost9() {
                             return Cost9;
              }

              public void setCost9(Double cost9) {
                             Cost9 = cost9;
              }

              public String getCreatedBy() {
                             return CreatedBy;
              }

              public void setCreatedBy(String createdBy) {
                             CreatedBy = createdBy;
              }

              public Date getCreated_date() {
                             return created_date;
              }

              public void setCreated_date(Date created_date) {
                             this.created_date = created_date;
              }

              public int getPeriod() {
                             return Period;
              }

              public void setPeriod(int period) {
                             Period = period;
              }

              @Override
              public String toString() {
                             return "FactorHeadList [id=" + id + ", LotNumber=" + LotNumber + ", BinNumber=" + BinNumber + ", Region="
                                                          + Region + ", Factor1=" + Factor1 + ", Cost1=" + Cost1 + ", Factor2=" + Factor2 + ", Cost2=" + Cost2
                                                          + ", Factor3=" + Factor3 + ", Cost3=" + Cost3 + ", Factor4=" + Factor4 + ", Cost4=" + Cost4
                                                          + ", Factor5=" + Factor5 + ", Cost5=" + Cost5 + ", Factor6=" + Factor6 + ", Cost6=" + Cost6
                                                          + ", Factor7=" + Factor7 + ", Cost7=" + Cost7 + ", Factor8=" + Factor8 + ", Cost8=" + Cost8
                                                          + ", Factor9=" + Factor9 + ", Cost9=" + Cost9 + ", CreatedBy=" + CreatedBy + ", created_date="
                                                          + created_date + ", Period=" + Period + "]";
              }

              public FactorHeadList(int id, String lotNumber, String binNumber, String region, String factor1, Double cost1,
                                           String factor2, Double cost2, String factor3, Double cost3, String factor4, Double cost4, String factor5,
                                           Double cost5, String factor6, Double cost6, String factor7, Double cost7, String factor8, Double cost8,
                                           String factor9, Double cost9, String createdBy, Date created_date, int period) {
                             super();
                             this.id = id;
                             LotNumber = lotNumber;
                             BinNumber = binNumber;
                             Region = region;
                             Factor1 = factor1;
                             Cost1 = cost1;
                             Factor2 = factor2;
                             Cost2 = cost2;
                             Factor3 = factor3;
                             Cost3 = cost3;
                             Factor4 = factor4;
                             Cost4 = cost4;
                             Factor5 = factor5;
                             Cost5 = cost5;
                             Factor6 = factor6;
                             Cost6 = cost6;
                             Factor7 = factor7;
                             Cost7 = cost7;
                             Factor8 = factor8;
                             Cost8 = cost8;
                             Factor9 = factor9;
                             Cost9 = cost9;
                             CreatedBy = createdBy;
                             this.created_date = created_date;
                             Period = period;
              }

              public FactorHeadList() {
                             super();
                             // TODO Auto-generated constructor stub
              }

              
}
