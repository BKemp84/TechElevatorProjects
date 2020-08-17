package com.techelevator.tenmo.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.model.User;

@PreAuthorize("isAuthenticated()")
@RestController
public class UserController {
	private UserDAO dao;
	
	public UserController(UserDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getUsers(){
		return dao.findAll();
	}
	
}
