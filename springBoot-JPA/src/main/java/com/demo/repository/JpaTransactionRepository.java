package com.demo.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.entities.TransactionDetail;

@Repository("jpaTransaction")
public class JpaTransactionRepository implements TransactionRepository{
	
	@PersistenceContext
		EntityManager em;

	@Override
	@Transactional
	public Long addTransaction(TransactionDetail transactionDetail) throws SQLException {
		// TODO Auto-generated method stub
		//em.getTransaction().begin();
		em.persist(transactionDetail);
		//em.getTransaction().commit();
		return null;
	}

	@Override
	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException {
		// TODO Auto-generated method stub
	TypedQuery<TransactionDetail> query =	em.createQuery("Select t From TransactionDetail t where t.accountNumber=:number ", TransactionDetail.class);
	query.setParameter("number", accountNumber)	;
	List<TransactionDetail> transactionList = query.getResultList();
	return transactionList;
	}

}
