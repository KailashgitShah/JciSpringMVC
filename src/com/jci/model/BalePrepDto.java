package com.jci.model;

import javax.persistence.Transient;

public class BalePrepDto {
	@Transient
	private int garde1;
	 
	@Transient
	private int garde2;
	 
	@Transient
	private int garde3;
	
	@Transient
	private int garde4;
	 
	@Transient
	private int garde5;
	 
	@Transient
	private int garde6;
	
	@Transient
	private int garde7;
	 
	@Transient
	private int garde8;

	public int getGarde1() {
		return garde1;
	}

	public void setGarde1(int garde1) {
		this.garde1 = garde1;
	}

	public int getGarde2() {
		return garde2;
	}

	public void setGarde2(int garde2) {
		this.garde2 = garde2;
	}

	public int getGarde3() {
		return garde3;
	}

	public void setGarde3(int garde3) {
		this.garde3 = garde3;
	}

	public int getGarde4() {
		return garde4;
	}

	public void setGarde4(int garde4) {
		this.garde4 = garde4;
	}

	public int getGarde5() {
		return garde5;
	}

	public void setGarde5(int garde5) {
		this.garde5 = garde5;
	}

	public int getGarde6() {
		return garde6;
	}

	public void setGarde6(int garde6) {
		this.garde6 = garde6;
	}

	public int getGarde7() {
		return garde7;
	}

	public void setGarde7(int garde7) {
		this.garde7 = garde7;
	}

	public int getGarde8() {
		return garde8;
	}

	public void setGarde8(int garde8) {
		this.garde8 = garde8;
	}

	@Override
	public String toString() {
		return "BalePrepDto [garde1=" + garde1 + ", garde2=" + garde2 + ", garde3=" + garde3 + ", garde4=" + garde4
				+ ", garde5=" + garde5 + ", garde6=" + garde6 + ", garde7=" + garde7 + ", garde8=" + garde8 + "]";
	}

	public BalePrepDto(int garde1, int garde2, int garde3, int garde4, int garde5, int garde6, int garde7, int garde8) {
		super();
		this.garde1 = garde1;
		this.garde2 = garde2;
		this.garde3 = garde3;
		this.garde4 = garde4;
		this.garde5 = garde5;
		this.garde6 = garde6;
		this.garde7 = garde7;
		this.garde8 = garde8;
	}

	public BalePrepDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
