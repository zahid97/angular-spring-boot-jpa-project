package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User save(User u) throws Exception {
		String tempEmail = u.getEmail();
		User u1 = findByEmail(tempEmail);
		if (u1 != null) {
			throw new Exception("User with" + tempEmail + "already exists");
		} else {

			return this.userRepo.save(u);
		}

	}

	public User findByEmail(String email) {
		User u = this.userRepo.findByEmail(email);
		return u;
	}

	public User findByEmailAndPassword(String email, String password) {
		return this.userRepo.findByEmailAndPassword(email, password);
	}

//	public List<User> findAllUsers(){
//		return this.userRepo.findAll();
//	}
//	

}
