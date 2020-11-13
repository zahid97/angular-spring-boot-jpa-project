package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reward {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rewardConfirmationNumber;
	private int rewardAmount;
	private Long accountNumber;
	
	public Reward() {
		super();
	}
	
	
	public Reward(int rewardAmount, Long accountNumber) {
		super();
		this.rewardAmount = rewardAmount;
		this.accountNumber = accountNumber;
	}
	
	
	public Reward(Long rewardConfirmationNumber, int rewardAmount, Long accountNumber) {
		super();
		this.rewardConfirmationNumber = rewardConfirmationNumber;
		this.rewardAmount = rewardAmount;
		this.accountNumber = accountNumber;
	}


	public int getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(int rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getRewardConfirmationNumber() {
		return rewardConfirmationNumber;
	}
	public void setRewardConfirmationNumber(Long rewardConfirmationNumber) {
		this.rewardConfirmationNumber = rewardConfirmationNumber;
	}
	
	
	
	
	

}
