package com.demo.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.entities.Reward;

@Repository("jpaReward")
public class JpaRewardRepsitory implements RewardRepository {
	
	@PersistenceContext
	private	EntityManager em;

	@Override
	@Transactional
	public void addReward(Reward reward) throws SQLException {
		// TODO Auto-generated method stub
		//EntityTransaction tx =	em.getTransaction();
		//tx.begin();
		em.persist(reward);
		//	tx.commit();
	}

	@Override
	public int getTotalRewardAmount(Long accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select r from Reward r where r.accountNumber= :number");
		query.setParameter("number", accountNumber);
		Reward r = (Reward) query.getSingleResult();
		return r.getRewardAmount();
		
	}

	@Override
	public List<Reward> getAllRewardsForAccount(Long accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select r.rewardAmount from Reward r where r.accountNumber = :number");
		query.setParameter("number", accountNumber);
		List<Reward> rewardList = query.getResultList();
		return rewardList;
	}
	

}
