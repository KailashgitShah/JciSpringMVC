package com.jci.model;

import java.util.Date;

public class FcDto {

	private String composition;
	private Double qty;
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "FcDto [composition=" + composition + ", qty=" + qty + "]";
	}
	public FcDto(String composition, Double qty) {
		super();
		this.composition = composition;
		this.qty = qty;
	}
	public FcDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
