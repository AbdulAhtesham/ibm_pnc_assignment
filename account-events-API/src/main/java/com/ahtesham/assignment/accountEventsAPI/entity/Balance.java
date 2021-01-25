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
public class Balance {
	
	@Id
	@GeneratedValue
	private Long balanceId;
	private String accountNumber;
	private LocalDateTime lastUpdateTimestamp;
	private double balance;
	
	
	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {	
		this.accountNumber = accountNumber;
	}

	public LocalDateTime getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setTransactionTs(LocalDateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Balance(Long balanceId, String accountNumber, LocalDateTime lastUpdateTimestamp, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.balance = balance;
		this.balanceId = balanceId;
	}

	public Balance() {
	}
}