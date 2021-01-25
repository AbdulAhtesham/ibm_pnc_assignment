package com.ahtesham.assignment.accountEventsAPI.entity;

public enum TransactionType {
	DEPOSIT("deposit"),
	WITHDRAW("withdraw"),
	ALL("all");
	
	String type;
	TransactionType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
