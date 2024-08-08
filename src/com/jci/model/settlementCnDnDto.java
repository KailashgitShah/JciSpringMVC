package com.jci.model;

public class settlementCnDnDto {
	private String content;
	private String todayDate;
    private String bankName;
    private String address;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public settlementCnDnDto() {
		super();
	}
	public settlementCnDnDto(String content, String todayDate, String bankName, String address) {
		super();
		this.content = content;
		this.todayDate = todayDate;
		this.bankName = bankName;
		this.address = address;
	}
	@Override
	public String toString() {
		return "settlementCnDnDto [content=" + content + ", todayDate=" + todayDate + ", bankName=" + bankName
				+ ", address=" + address + "]";
	}
    
    
    
    
}
