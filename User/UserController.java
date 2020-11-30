package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping(path = "/register")
	public User save(@RequestBody User u) throws Exception  {
	return this.userService.save(u);
			
	}

	@PostMapping(path = "/login")
	public User LoggedInUser(@RequestBody User u) throws Exception {
		User u1 = this.userService.findByEmailAndPassword(u.getEmail(), u.getPassword());
		if (u1 == null) {
			throw new Exception("Bad credentials");
		}
		return u1;
	}

//	@GetMapping(path ="")
//	public List<User> findAllUsers(){
//		return this.userService.findAllUsers();
//	}


}
