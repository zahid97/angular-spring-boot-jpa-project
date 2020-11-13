package com.demo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demo.entities.Account;
import com.demo.entities.Address;
import com.demo.entities.Reward;
import com.demo.entities.TransactionDetail;
import com.demo.entities.TransactionType;
import com.demo.repository.JpaRewardRepsitory;
import com.demo.repository.JpaTransactionRepository;
import com.demo.services.BankService;
import com.demo.services.BankServiceImpl;

//@ComponentScan(basePackages = {"com.demo.repository","com.demo.services","com.demo.entities"})
@SpringBootApplication
public class SpringBootJpaApplication {
	@Autowired
	private BankService service;
   
	public static void main(String[] args) throws SQLException {
	ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class);
	BankService service = context.getBean(BankService.class);
	JpaRewardRepsitory	jp = context.getBean(JpaRewardRepsitory.class);
	JpaTransactionRepository jp1 = context.getBean(JpaTransactionRepository.class);
//	Account account = new Account("zahid" , true , 1800, "zak@gmail.com" , "Mumbai" , "India");
//	service.createNewAccount(account);
//	List<Account> accounts = service.getAllAccounts();
//	for(Account a : accounts) {
//		System.out.println(a.getBalance());
//	}
	
//	Reward r = new Reward(100,4L);
//	jp.addReward(r);
	
//	System.out.println(jp.getTotalRewardAmount(4L));
	
//	
	List<Reward> rList = jp.getAllRewardsForAccount(4L);
	System.out.println(rList);
//	
//	jp1.addTransaction(new TransactionDetail(4L,LocalDate.of(2020, 11, 13),2000,TransactionType.DEBIT));
//	jp1.addTransaction(new TransactionDetail(4L,LocalDate.of(2020, 11, 13),2000,TransactionType.CREDIT));
//	List<TransactionDetail>transactionList = jp1.getAllTransactionDetailsByAccountNumber(4L);
//	for(TransactionDetail t:transactionList) {
//		System.out.println(t);
//}
	}
}
