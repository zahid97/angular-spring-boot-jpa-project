package com.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.entities.Reward;


@Repository("jdbcReward")
public class JdbcRewardRepositoryImpl implements RewardRepository {
	
	
	private DataSource dataSource;
	
	
	@Autowired
	public JdbcRewardRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addReward(Reward reward) throws SQLException {
		String query="insert into Reward(rewardAmount,accountNumber) values(?,?)";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, reward.getRewardAmount());
		preparedStatement.setLong(2, reward.getAccountNumber());
		
		preparedStatement.executeUpdate();

	}

	public int getTotalRewardAmount(Long accountNumber) {
		
		return 0;
	}

	@Override
	public List<Reward> getAllRewardsForAccount(Long accountNUmber) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
