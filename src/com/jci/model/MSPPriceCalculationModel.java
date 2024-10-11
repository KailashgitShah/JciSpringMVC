package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jcimspgradesprice", schema = "dbo")
public class MSPPriceCalculationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msp_id")
	private int msp_id;

	@Column(name = "jute_variety")
	private String jute_variety ;

	@Column(name = "grade1")
	private double grade1 ;

	@Column(name = "grade2")
	private double grade2 ;

	@Column(name = "grade3")
	private double grade3 ;

	@Column(name = "grade4")
	private double grade4 ;

	@Column(name = "grade5")
	private double grade5 ;

	@Column(name = "grade6")
	private double grade6 ;

	@Column(name = "grade7")
	private double grade7 ;

	@Column(name = "grade8")
	private double grade8 ;

	@Column(name = "crop_yr")
	private String crop_yr ;

	@Column(name = "created_date")
	private Date created_date ;

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date date) {
		this.created_date = date;
	}

	public int getmsp_id() {
		return msp_id;
	}

	public void setmsp_id(int msp_id) {
		this.msp_id = msp_id;
	}

	public String getJute_variety() {
		return jute_variety;
	}

	public void setJute_variety(String jute_variety) {
		this.jute_variety = jute_variety;
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

	public String getCrop_yr() {
		return crop_yr;
	}

	public void setCrop_yr(String crop_yr) {
		this.crop_yr = crop_yr;
	}

	@Override
	public String toString() {
		return "MSPPriceCalculationModel [Msp_id=" + msp_id + ", jute_variety=" + jute_variety + ", grade1=" + grade1
				+ ", grade2=" + grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5
				+ ", grade6=" + grade6 + ", grade7=" + grade7 + ", grade8=" + grade8 + ", crop_yr=" + crop_yr
				+ ", getMsp_id()=" + getmsp_id() + ", getJute_variety()=" + getJute_variety() + ", getGrade1()="
				+ getGrade1() + ", getGrade2()=" + getGrade2() + ", getGrade3()=" + getGrade3() + ", getGrade4()="
				+ getGrade4() + ", getGrade5()=" + getGrade5() + ", getGrade6()=" + getGrade6() + ", getGrade7()="
				+ getGrade7() + ", getGrade8()=" + getGrade8() + ", getCrop_yr()=" + getCrop_yr() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



	public MSPPriceCalculationModel(int msp_id, String jute_variety, double grade1, double grade2, double grade3,
			double grade4, double grade5, double grade6, double grade7, double grade8, String crop_yr) {

		this.msp_id = msp_id;
		this.jute_variety = jute_variety;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
		this.grade4 = grade4;
		this.grade5 = grade5;
		this.grade6 = grade6;
		this.grade7 = grade7;
		this.grade8 = grade8;
		this.crop_yr = crop_yr;
	}

	public MSPPriceCalculationModel() {

	}




}
