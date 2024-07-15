package com.jci.model;

public class DemandNoteDto {

	private String contractNo;
	private String contractDate;
	private Double contractqty;
	private String scheduledpaymentdate;
	private String actualpaymentdate;
	private String delaydays;
	private String paymentrefstring;
	private String paydate;

	private Double carryingcoststring;

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

	public Double getContractqty() {
		return contractqty;
	}

	public void setContractqty(Double contractqty) {
		this.contractqty = contractqty;
	}

	public String getScheduledpaymentdate() {
		return scheduledpaymentdate;
	}

	public void setScheduledpaymentdate(String scheduledpaymentdate) {
		this.scheduledpaymentdate = scheduledpaymentdate;
	}

	public String getActualpaymentdate() {
		return actualpaymentdate;
	}

	public void setActualpaymentdate(String actualpaymentdate) {
		this.actualpaymentdate = actualpaymentdate;
	}

	public String getDelaydays() {
		return delaydays;
	}

	public void setDelaydays(String delaydays) {
		this.delaydays = delaydays;
	}

	public String getPaymentrefstring() {
		return paymentrefstring;
	}

	public void setPaymentrefstring(String paymentrefstring) {
		this.paymentrefstring = paymentrefstring;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public Double getCarryingcoststring() {
		return carryingcoststring;
	}

	public void setCarryingcoststring(Double carryingcoststring) {
		this.carryingcoststring = carryingcoststring;
	}

	@Override
	public String toString() {
		return "DemandNoteDto [contractNo=" + contractNo + ", contractDate=" + contractDate + ", contractqty="
				+ contractqty + ", scheduledpaymentdate=" + scheduledpaymentdate + ", actualpaymentdate="
				+ actualpaymentdate + ", delaydays=" + delaydays + ", paymentrefstring=" + paymentrefstring
				+ ", paydate=" + paydate + ", carryingcoststring=" + carryingcoststring + "]";
	}

	public DemandNoteDto(String contractNo, String contractDate, Double contractqty, String scheduledpaymentdate,
			String actualpaymentdate, String delaydays, String paymentrefstring, String paydate,
			Double carryingcoststring) {
		super();
		this.contractNo = contractNo;
		this.contractDate = contractDate;
		this.contractqty = contractqty;
		this.scheduledpaymentdate = scheduledpaymentdate;
		this.actualpaymentdate = actualpaymentdate;
		this.delaydays = delaydays;
		this.paymentrefstring = paymentrefstring;
		this.paydate = paydate;
		this.carryingcoststring = carryingcoststring;
	}

	public DemandNoteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
