package com.jci.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InventoryDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String Roname;
	private String Rocode;
	private double grade1;
	private double grade2;
	private double grade3;
	private double grade4;
	private double grade5;
	private double grade6;
	private double grade7;
	private double grade8;
	public String getRoname() {
		return Roname;
	}
	public void setRoname(String roname) {
		Roname = roname;
	}
	public String getRocode() {
		return Rocode;
	}
	public void setRocode(String rocode) {
		Rocode = rocode;
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
	@Override
	public String toString() {
		return "InventoryDTO [Roname=" + Roname + ", Rocode=" + Rocode + ", grade1=" + grade1 + ", grade2=" + grade2
				+ ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5 + ", grade6=" + grade6
				+ ", grade7=" + grade7 + ", grade8=" + grade8 + "]";
	}
	
	  

}
