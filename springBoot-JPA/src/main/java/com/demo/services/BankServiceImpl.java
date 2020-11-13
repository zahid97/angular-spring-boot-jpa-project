package com.demo.services;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.demo.entities.Account;
import com.demo.entities.TransactionDetail;
import com.demo.entities.TransactionType;
import com.demo.repository.AccountRepository;
import com.demo.repository.RewardRepository;
import com.demo.repository.TransactionRepository;


@Component
public class BankServiceImpl implements BankService {
	
	@Autowired
	@Qualifier("jpaAccount")
	private AccountRepository accountRepository;
	
	@Autowired
	@Qualifier("jpaTransaction")	
	private TransactionRepository transactionRepository;
	
	@Autowired
	@Qualifier("jpaReward")
	private RewardRepository rewardRepository;	
	
	@Autowired
	private EmailService emailService;
	




	public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
		
		Long transactionId= debit(amount,fromAccountNumber);
							credit(amount, toAccountNumber);
		
		return transactionId;
	}

	public Long debit(int amount, Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.debit(amount);		
		accountRepository.update(account);
		TransactionDetail fromTransactionDetail= 
				new TransactionDetail(accountNumber,LocalDate.now(),amount,TransactionType.DEBIT);

		Long transactionId=transactionRepository.addTransaction(fromTransactionDetail);
		
		if(emailService!=null){
			emailService.sendMail(account.getEmailAddress(),
					"admin@mybank.com", amount+" has been debited from your account");
		}
		
		return transactionId;

	}

	public Long credit(int amount, Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.credit(amount);		
		accountRepository.update(account);
		TransactionDetail toTransactionDetail= 
				new TransactionDetail(accountNumber,LocalDate.now(),amount,TransactionType.CREDIT);

		Long transactionId=transactionRepository.addTransaction(toTransactionDetail);
		if(emailService!=null){
			emailService.sendMail(account.getEmailAddress(), "admin@mybank.com", amount+" has been credited into your account");
		}
		
		return transactionId;

		
	}

	public void createNewAccount(Account account) throws SQLException {
		accountRepository.save(account);
		
	}

	public void deActivateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(false);		
		accountRepository.update(account);
		
	}

	public void activateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(true);		
		accountRepository.update(account);
		
	}

	public List<Account> getAllAccounts() throws SQLException {
		System.out.println("BankServiceImpl.getAllAccounts()");
		return accountRepository.findAllAccounts();
	}


	public AccountRepository getAccountRepository() {
		return accountRepository;
	}


	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}


	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}


	public RewardRepository getRewardRepository() {
		return rewardRepository;
	}


	public void setRewardRepository(RewardRepository rewardRepository) {
		this.rewardRepository = rewardRepository;
	}


	public EmailService getEmailService() {
		return emailService;
	}


	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	

}
