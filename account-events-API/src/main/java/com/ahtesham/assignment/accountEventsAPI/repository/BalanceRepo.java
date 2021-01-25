package com.ahtesham.assignment.accountEventsAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ahtesham.assignment.accountEventsAPI.entity.Balance;


public interface BalanceRepo extends JpaRepository<Balance, String>{

	@Query("select balance from Balance where accountNumber=?1 and lastUpdateTimestamp = (select max(lastUpdateTimestamp) from Balance)")
	public Double findBalance(String accountNumber);
	
}