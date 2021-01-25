package com.ahtesham.assignment.accountEventsAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahtesham.assignment.accountEventsAPI.entity.Transaction;

@Repository
public interface TransactionsRepo extends JpaRepository<Transaction, String>{
	
	@Query(value = "SELECT * FROM Transaction WHERE account_number = ?1)", 
			nativeQuery = true)
	public List<Transaction> transactionsAllTypeNoRange(String accountNumber);
	
	@Query(value = "SELECT * FROM Transaction WHERE account_number = ?1 AND (DATE(transaction_Ts) BETWEEN ?2 AND ?3)",
			nativeQuery = true)
	public List<Transaction> transactionsAllTypeByRange(String accountNumber, String fromDate, String toDate);
	
	@Query(value = "SELECT * FROM Transaction WHERE account_number = ?1 AND (DATE(transaction_ts) BETWEEN ?2 AND ?3) AND type=?4", 
			nativeQuery = true)
	public List<Transaction> transactionsOneTypeByRange(String accountNumber, String fromDate, String toDate, String type);
	
}