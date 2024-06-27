package com.jci.model;

public class DemandNoteDto {

	private String contractNo;
	private String contractDate;
	private String ContractQty;
	private String ScheduledPaymentDate;
	private String actualPaymentDate;
	private String delayDays;
	private String paymentRefString;
	private String payDate;

	private Double carryingCostString;
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractQty() {
		return ContractQty;
	}
	public void setContractQty(String contractQty) {
		ContractQty = contractQty;
	}
	public String getScheduledPaymentDate() {
		return ScheduledPaymentDate;
	}
	public void setScheduledPaymentDate(String scheduledPaymentDate) {
		ScheduledPaymentDate = scheduledPaymentDate;
	}
	public String getActualPaymentDate() {
		return actualPaymentDate;
	}
	public void setActualPaymentDate(String actualPaymentDate) {
		this.actualPaymentDate = actualPaymentDate;
	}
	public String getDelayDays() {
		return delayDays;
	}
	public void setDelayDays(String delayDays) {
		this.delayDays = delayDays;
	}
	public String getPaymentRefString() {
		return paymentRefString;
	}
	public void setPaymentRefString(String paymentRefString) {
		this.paymentRefString = paymentRefString;
	}
	
	public Double getCarryingCostString() {
		return carryingCostString;
	}
	public void setCarryingCostString(double carrying_cost) {
		this.carryingCostString = carrying_cost;
	}

	
	
	
	
}
