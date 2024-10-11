package com.jci.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "labelGeneration", schema = "dbo")
public class labelGenerationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "basis")
	private String basis;
	
	@Column(name = "label1")
	private String label1;

	@Column(name = "label2")
	private String label2;
	
	@Column(name = "label3")
	private String label3;
	
	@Column(name = "label4")
	private String label4;
	
	@Column(name = "label5")
	private String label5;
	
	@Column(name = "label6")
	private String label6;
	
	@Column(name = "label7")
	private String label7;
	
	@Column(name = "label8")
	private String label8;
	
	@Column(name = "label9")
	private String label9;
	
	@Column(name = "label10")
	private String label10;
	
	@Column(name = "label11")
	private String label11;
	
	@Column(name = "label12")
	private String label12;
	
	@Column(name = "label13")
	private String label13;
	
	@Column(name = "label14")
	private String label14;
	
	@Column(name = "createdOn")
	private Date createdOn;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "cropyr")
	private String cropyr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getLabel1() {
		return label1;
	}

	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public String getLabel3() {
		return label3;
	}

	public void setLabel3(String label3) {
		this.label3 = label3;
	}

	public String getLabel4() {
		return label4;
	}

	public void setLabel4(String label4) {
		this.label4 = label4;
	}

	public String getLabel5() {
		return label5;
	}

	public void setLabel5(String label5) {
		this.label5 = label5;
	}

	public String getLabel6() {
		return label6;
	}

	public void setLabel6(String label6) {
		this.label6 = label6;
	}

	public String getLabel7() {
		return label7;
	}

	public void setLabel7(String label7) {
		this.label7 = label7;
	}

	public String getLabel8() {
		return label8;
	}

	public void setLabel8(String label8) {
		this.label8 = label8;
	}

	public String getLabel9() {
		return label9;
	}

	public void setLabel9(String label9) {
		this.label9 = label9;
	}

	public String getLabel10() {
		return label10;
	}

	public void setLabel10(String label10) {
		this.label10 = label10;
	}

	public String getLabel11() {
		return label11;
	}

	public void setLabel11(String label11) {
		this.label11 = label11;
	}

	public String getLabel12() {
		return label12;
	}

	public void setLabel12(String label12) {
		this.label12 = label12;
	}

	public String getLabel13() {
		return label13;
	}

	public void setLabel13(String label13) {
		this.label13 = label13;
	}

	public String getLabel14() {
		return label14;
	}

	public void setLabel14(String label14) {
		this.label14 = label14;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public labelGenerationModel() {
		
	}

	public String getCropyr() {
		return cropyr;
	}

	public void setCropyr(String cropyr) {
		this.cropyr = cropyr;
	}

	@Override
	public String toString() {
		return "labelGenerationModel [id=" + id + ", basis=" + basis + ", label1=" + label1 + ", label2=" + label2
				+ ", label3=" + label3 + ", label4=" + label4 + ", label5=" + label5 + ", label6=" + label6
				+ ", label7=" + label7 + ", label8=" + label8 + ", label9=" + label9 + ", label10=" + label10
				+ ", label11=" + label11 + ", label12=" + label12 + ", label13=" + label13 + ", label14=" + label14
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", cropyr=" + cropyr + "]";
	}

	public labelGenerationModel(int id, String basis, String label1, String label2, String label3, String label4,
			String label5, String label6, String label7, String label8, String label9, String label10, String label11,
			String label12, String label13, String label14, Date createdOn, String createdBy, String cropyr) {
		super();
		this.id = id;
		this.basis = basis;
		this.label1 = label1;
		this.label2 = label2;
		this.label3 = label3;
		this.label4 = label4;
		this.label5 = label5;
		this.label6 = label6;
		this.label7 = label7;
		this.label8 = label8;
		this.label9 = label9;
		this.label10 = label10;
		this.label11 = label11;
		this.label12 = label12;
		this.label13 = label13;
		this.label14 = label14;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.cropyr = cropyr;
	}
	
	

	
	                                                 

}
