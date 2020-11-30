package com.demo.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private long mobileNum;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	Set<Order> order = new HashSet<>();
	
	public User() {
		super();
	}

	

	public User(long mobileNum, String username, String password, String email, String address) {
		super();
		this.mobileNum = mobileNum;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}



	public User(Long id, String username, String password, String email,Long mobileNum,String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNum = mobileNum;
		this.address = address;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	
	
}
