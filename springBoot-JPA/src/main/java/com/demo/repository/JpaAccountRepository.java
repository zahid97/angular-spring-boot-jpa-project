package com.demo.repository;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Account;

@Repository("jpaAccount")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Account findAccountByNumber(Long accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		Account a = em.find(Account.class, accountNumber);
		return a;
	}

	@Override
	public List<Account> findAllAccounts() throws SQLException {
		// TODO Auto-generated method stub
		TypedQuery<Account> query = em.createQuery("Select a from Account a", Account.class);
		List<Account> accounts = query.getResultList();
		return accounts;
	}

	@Override
	@Transactional
	public void save(Account account) throws SQLException {
		// TODO Auto-generated method stub
	//	EntityTransaction tx = em.getTransaction();
		
		em.persist(account);

	}

	@Override
	public void update(Account account) throws SQLException {
		// TODO Auto-generated method stub
		Account a = em.find(Account.class, account.getAccountNumber());
		
		if (a != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			a.setName(account.getName());
			a.setEmailAddress(account.getEmailAddress());
			a.setAddress(account.getAddress());
			a.setBenificiaries(account.getBenificiaries());
			tx.commit();
		}

	}

	@Override
	public void delete(Account account) throws SQLException {
		// TODO Auto-generated method stub
		Account a = em.find(Account.class, account.getAccountNumber());
		if (a != null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(account);
			tx.commit();
		}
	}

}
