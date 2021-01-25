package com.ahtesham.assignment.accountEventsAPI.entity;

public class TransactionReq {
	
	private String accountNumber;
	private String type;
	private String fromDate;
	private String toDate;
	private String period;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public TransactionReq(String accountNumber, String type, String fromDate, String toDate, String period) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.period = period;
	}

}
