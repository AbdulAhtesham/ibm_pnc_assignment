package com.ahtesham.assignment.accountEventsAPI.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long transactionId;
	private String accountNumber;
	private String type;
	private LocalDateTime transactionTs;
	private Double amount;

	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getTransactionTs() {
		return transactionTs;
	}
	public void setTransactionTs(LocalDateTime transactionTs) {
		this.transactionTs = transactionTs;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transaction(Long transactionId, String accountNumber, String type, LocalDateTime transactionTs, Double amount) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.transactionTs = transactionTs;
		this.amount = amount;
		this.transactionId = transactionId;
	}
	public Transaction() {
		super();
	}
	
}
