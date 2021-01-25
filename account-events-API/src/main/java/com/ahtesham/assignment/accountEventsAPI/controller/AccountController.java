package com.ahtesham.assignment.accountEventsAPI.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahtesham.assignment.accountEventsAPI.entity.Balance;
import com.ahtesham.assignment.accountEventsAPI.entity.Transaction;
import com.ahtesham.assignment.accountEventsAPI.entity.TransactionReq;
import com.ahtesham.assignment.accountEventsAPI.service.BalanceService;
import com.ahtesham.assignment.accountEventsAPI.service.TransactionService;

@RestController
@RequestMapping(path = "/")
public class AccountController {

	@Autowired
	TransactionService tranService;

	@Autowired
	BalanceService balService;

	@GetMapping(path = "/balance/{accountNumber}")
	public ResponseEntity<String> getBalance(@PathVariable String accountNumber) {
		return ResponseEntity.status(HttpStatus.FOUND).body(String.valueOf(balService.getBalance(accountNumber)));
	}

	/*
	 * @GetMapping(path = "/transactionHistory/{type}/{period}") public
	 * List<Transaction> getTransactionHistory(@RequestBody(required = false)
	 * DateRange request,
	 * 
	 * @PathVariable String period, @PathVariable String type) {
	 * 
	 * return tranService.getTransactionHistory(request, period, type); }
	 */
	
	@GetMapping(path = "/transactionHistory/")
	public ResponseEntity<List<Transaction>> getsTransactionHistory(@RequestBody TransactionReq request) {
		List<Transaction> transactionList;
		transactionList =tranService.getTransactionHistory(request);	
		return ResponseEntity.status(HttpStatus.OK).body(transactionList);
	}
	
	@PostMapping(path = "/transaction")
	public ResponseEntity<Void> recordTransaction(@RequestBody Transaction transaction){
		tranService.addTransaction(transaction);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/balance")
	public ResponseEntity<Void> recordBalance(@RequestBody Balance balance){
		balService.recordBalance(balance);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
