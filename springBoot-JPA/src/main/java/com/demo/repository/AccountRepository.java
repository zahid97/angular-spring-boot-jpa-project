package com.demo.repository;

import java.sql.SQLException;
import java.util.List;

import com.demo.entities.Account;



public interface AccountRepository {
	
	
	public Account findAccountByNumber(Long accountNUmber) throws SQLException;
	public List<Account> findAllAccounts() throws SQLException;
	public void save(Account account) throws SQLException;
	public void update(Account account)throws SQLException;
	public void delete(Account account) throws SQLException;
}
