package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{
	
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email , String password);

}
