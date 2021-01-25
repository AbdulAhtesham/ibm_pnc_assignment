package com.ahtesham.assignment.accountEventsAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahtesham.assignment.accountEventsAPI.entity.Balance;
import com.ahtesham.assignment.accountEventsAPI.repository.BalanceRepo;

@Service
public class BalanceService {

	@Autowired
	BalanceRepo balanceRepo;
	
	public double getBalance(String accountNumber) {
		return balanceRepo.findBalance(accountNumber);
	}
	
	public Balance recordBalance(Balance balance) {
		return balanceRepo.save(balance);
	}
}
