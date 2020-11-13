package com.demo.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TransactionDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	private Long accountNumber;
	private LocalDate transactionDate;
	private int amount;	
	
	
	private TransactionType txType;
	
	
	
	
	public TransactionDetail( Long accountNumber,
			LocalDate transactionDate, int amount, TransactionType type) {
		super();
		
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.txType = type;
	}
	
	public TransactionDetail() {
		
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public TransactionType getTxType() {
		return txType;
	}

	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}

	@Override
	public String toString() {
		return "TransactionDetail [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", txType=" + txType + "]";
	}
	
	
}
