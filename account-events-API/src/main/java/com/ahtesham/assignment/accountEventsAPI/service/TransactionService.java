package com.ahtesham.assignment.accountEventsAPI.service;

import java.time.LocalDate; 
import java.time.YearMonth;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahtesham.assignment.accountEventsAPI.entity.Transaction;
import com.ahtesham.assignment.accountEventsAPI.entity.TransactionReq;
import com.ahtesham.assignment.accountEventsAPI.exception.AccountNumberMissingException;
import com.ahtesham.assignment.accountEventsAPI.repository.TransactionsRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionsRepo transactionsRepo;

	String fromDate = null;
	String toDate = null;
	String type = null;
	String accountNumber = null;
	TransactionReq request;

	public List<Transaction> getTransactionHistory(TransactionReq request) throws AccountNumberMissingException {
		
		String period = null;

		// Exception if account number missing
		// Fetch all transactions if only account number supplied
		if (request.getAccountNumber() == null) {
			throw new AccountNumberMissingException();
		} else {
			this.request = request;
			accountNumber = request.getAccountNumber();
			if ((request.getFromDate() == null || request.getToDate() == null) && request.getPeriod() == null
					&& request.getType() == null) {
				
				return getAllTransactions(accountNumber);
			}
		}

		// Set period if empty
		if (request.getFromDate() != null && request.getToDate() != null) {
			fromDate = request.getFromDate();
			toDate = request.getToDate();
			period = "FLEXIBLE_RANGE";
		} else if (request.getPeriod() != null) {
			period = request.getPeriod();
		}

		// Set date range by period supplied
		constructDatesFromPeriod(period);

		// Call repo and return transactions
		if (request.getType() == null) {
			return getAllTypeTransactions(accountNumber, fromDate, toDate);
		} else {
			type = request.getType();
			return getSpecificTypeTransaction(accountNumber, fromDate, toDate, type);
		}

	}

	private void constructDatesFromPeriod(String period) {
		switch (period) {
		case "TODAY": {
			LocalDate ldt = LocalDate.now();
			fromDate = ldt.toString();
			LocalDate fdt = LocalDate.now();
			toDate = fdt.toString();
			System.out.println(String.format("From date : %s, To Date : %s", fromDate, toDate));
		}
			break;
		case "LAST_7_DAYS": {
			LocalDate ldt = LocalDate.now().minusDays(7);
			fromDate = ldt.toString();
		}
			break;
		case "LAST_30_DAYS": {
			LocalDate ldt = LocalDate.now().minusDays(30);
			fromDate = ldt.toString();
		}
			break;
		case "LAST_MONTH": {

			LocalDate date = LocalDate.now().minusMonths(1);
			YearMonth ym = YearMonth.from(date);
			toDate = ym.atEndOfMonth().toString();
			fromDate = ym.atDay(1).toString();
		}
			break;
		}
	}

	private List<Transaction> getAllTransactions(String accountNumber) {
		return transactionsRepo.transactionsAllTypeNoRange(accountNumber);
	}

	private List<Transaction> getSpecificTypeTransaction(String accountNumber, String fromDate, String toDate,
			String type) {
		return transactionsRepo.transactionsOneTypeByRange(accountNumber, fromDate, toDate, type);
	}

	private List<Transaction> getAllTypeTransactions(String accountNumber, String fromDate, String toDate) {	
		return transactionsRepo.transactionsAllTypeByRange(accountNumber, fromDate, toDate);
	}

	public Transaction addTransaction(Transaction transaction) {
		return transactionsRepo.save(transaction);
	}
}
