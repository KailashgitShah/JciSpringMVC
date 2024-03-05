package com.jci.model;


import java.util.*;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "jciDI_ho", schema = "dbo")

public class JciDIHoModel {

                @Id
                   @GeneratedValue(strategy = GenerationType.IDENTITY)
                    @Column(name = "DI_HO_ID")
                    private Long DI_HO_ID ; // Primary key, assumed to be BigInt
   
                    @Column(name = "DI_no", unique = true) 
                    private String DI_no; 
                  
                   
                    @Column(name = "DI_Date", nullable = false)
                    private String DI_Date; 
                    
                    @Column(name = "Contract_No", nullable = false) 
                    private String Contract_No;
                    
                   
                    @Column(name = "Contract_Date", nullable = false) 
                    private String Contract_Date;
                    
                    @Column(name = "Crop_year", nullable = false) 
                    private String Crop_year;
                    
                    @Column(name = "FC_Ref_No", nullable = false) 
                    private String FC_Ref_No;
                    
                    @Column(name = "Contracted_Qty",nullable = false) 
                    private double Contracted_Qty;
                    
                    @Column(name = "Allowed_qty",nullable = false) 
                    private double Allowed_qty;
                    
                    @Column(name = "Regional_office",nullable = false) 
                    private String Regional_office;
                   
                    @Column(name = "DPC") 
                    private String DPC;
                    
                    
                    @Column(name = "Last_date_of_Shipment") 
                    private String Last_date_of_Shipment;
                    
                    @Column(name = "Jute_variety",nullable = false) 
                    private String Jute_variety;
                    @Column(name = "Remarks",nullable = false) 
                    private String Remarks;

                                @Column(name = "Gr1_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr1_qty; // Double column with default value 0.0
                    
                    @Column(name = "Gr2_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr2_qty; // Double column with default value 0.0
                    
                    @Column(name = "Gr3_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr3_qty; // Double column with default value 0.0
                   
                    @Column(name = "Gr4_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr4_qty; // Double column with default value 0.0
                   
                    @Column(name = "Gr5_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr5_qty; // Double column with default value 0.0
                   
                    @Column(name = "Gr6_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr6_qty; // Double column with default value 0.0
                   
                    @Column(name = "Gr7_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr7_qty; // Double column with default value 0.0
                   
                    @Column(name = "Gr8_qty", columnDefinition = "Decimal(10,2) default '0.0'")
                    private double Gr8_qty; // Double column with default value 0.0
                   
                    @Column(name = "Created_by",nullable = false) 
                    private String Created_by;
                    
                    @Column(name = "Creation_date",nullable = false) 
                    private String Creation_date;

                                
                                public Long getDI_HO_ID() {
                                                return DI_HO_ID;
                                }

                                public void setDI_HO_ID(Long dI_HO_ID) {
                                                DI_HO_ID = dI_HO_ID;
                                }

                                public String getDI_no() {
                                                return DI_no;
                                }

                                public void setDI_no(String dI_no) {
                                                DI_no = dI_no;
                                }

                                public String getDI_Date() {
                                                return DI_Date;
                                }

                                public void setDI_Date(String dI_Date) {
                                                DI_Date = dI_Date;
                                }

                                public String getContract_No() {
                                                return Contract_No;
                                }

                                public void setContract_No(String contract_No) {
                                                Contract_No = contract_No;
                                }

                                public String getContract_Date() {
                                                return Contract_Date;
                                }

                                public void setContract_Date(String dpcdate) {
                                                Contract_Date = dpcdate;
                                }

                                public String getCrop_year() {
                                                return Crop_year;
                                }

                                public void setCrop_year(String crop_year) {
                                                Crop_year = crop_year;
                                }

                                public String getFC_Ref_No() {
                                                return FC_Ref_No;
                                }

                                public void setFC_Ref_No(String fC_Ref_No) {
                                                FC_Ref_No = fC_Ref_No;
                                }

                                public double getContracted_Qty() {
                                                return Contracted_Qty;
                                }

                                public void setContracted_Qty(double contracted_Qty) {
                                                Contracted_Qty = contracted_Qty;
                                }

                                public double getAllowed_qty() {
                                                return Allowed_qty;
                                }

                                public void setAllowed_qty(double allowed_qty) {
                                                Allowed_qty = allowed_qty;
                                }

                                public String getRegional_office() {
                                                return Regional_office;
                                }

                                public void setRegional_office(String regional_office) {
                                                Regional_office = regional_office;
                                }

                                public String getDPC() {
                                                return DPC;
                                }

                                public void setDPC(String dPC) {
                                                DPC = dPC;
                                }

                                public String getLast_date_of_Shipment() {
                                                return Last_date_of_Shipment;
                                }

                                public void setLast_date_of_Shipment(String last_date_of_Shipment) {
                                                Last_date_of_Shipment = last_date_of_Shipment;
                                }

                                public String getJute_variety() {
                                                return Jute_variety;
                                }

                                public void setJute_variety(String jute_variety) {
                                                Jute_variety = jute_variety;
                                }

                                public String getRemarks() {
                                                return Remarks;
                                }

                                public void setRemarks(String remarks) {
                                                Remarks = remarks;
                                }

                                public double getGr1_qty() {
                                                return Gr1_qty;
                                }

                                public void setGr1_qty(double gr1_qty) {
                                                Gr1_qty = gr1_qty;
                                }

                                public double getGr2_qty() {
                                                return Gr2_qty;
                                }

                                public void setGr2_qty(double gr2_qty) {
                                                Gr2_qty = gr2_qty;
                                }

                                public double getGr3_qty() {
                                                return Gr3_qty;
                                }

                                public void setGr3_qty(double gr3_qty) {
                                                Gr3_qty = gr3_qty;
                                }

                                public double getGr4_qty() {
                                                return Gr4_qty;
                                }

                                public void setGr4_qty(double gr4_qty) {
                                                Gr4_qty = gr4_qty;
                                }

                                public double getGr5_qty() {
                                                return Gr5_qty;
                                }

                                public void setGr5_qty(double gr5_qty) {
                                                Gr5_qty = gr5_qty;
                                }

                                public double getGr6_qty() {
                                                return Gr6_qty;
                                }

                                public void setGr6_qty(double gr6_qty) {
                                                Gr6_qty = gr6_qty;
                                }

                                public double getGr7_qty() {
                                                return Gr7_qty;
                                }

                                public void setGr7_qty(double gr7_qty) {
                                                Gr7_qty = gr7_qty;
                                }

                                public double getGr8_qty() {
                                                return Gr8_qty;
                                }

                                public void setGr8_qty(double gr8_qty) {
                                                Gr8_qty = gr8_qty;
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

                                public void setCreation_date(String currentTimestamp) {
                                                Creation_date = currentTimestamp;
                                }

                                @Override
                                public String toString() {
                                                return "JciDIHoModel [DI_HO_ID=" + DI_HO_ID + ", DI_no=" + DI_no + ", DI_Date=" + DI_Date + ", Contract_No="
                                                                                + Contract_No + ", Contract_Date=" + Contract_Date + ", Crop_year=" + Crop_year + ", FC_Ref_No="
                                                                                + FC_Ref_No + ", Contracted_Qty=" + Contracted_Qty + ", Allowed_qty=" + Allowed_qty
                                                                                + ", Regional_office=" + Regional_office + ", DPC=" + DPC + ", Last_date_of_Shipment="
                                                                                + Last_date_of_Shipment + ", Jute_variety=" + Jute_variety + ", Remarks=" + Remarks + ", Gr1_qty="
                                                                                + Gr1_qty + ", Gr2_qty=" + Gr2_qty + ", Gr3_qty=" + Gr3_qty + ", Gr4_qty=" + Gr4_qty + ", Gr5_qty="
                                                                                + Gr5_qty + ", Gr6_qty=" + Gr6_qty + ", Gr7_qty=" + Gr7_qty + ", Gr8_qty=" + Gr8_qty
                                                                                + ", Created_by=" + Created_by + ", Creation_date=" + Creation_date + "]";
                                }

                
                    
                  

                

}
