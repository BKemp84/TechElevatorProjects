package com.techelevator.tenmo.accounts;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.model.User;
@PreAuthorize("isAuthenticated()")
@RestController
public class AccountsController {
	private AccountsDao dao;
	
	public AccountsController(AccountsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/accounts", method = RequestMethod.GET)
	public Accounts get(Principal principle) {
		return dao.getAccount(principle.getName());
	}
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<Accounts> list(){
		return dao.list();
	}
	
//	@RequestMapping(path = "/accounts", method = RequestMethod.PUT)
//	public void send(BigDecimal sendAmount, int otherUserId, Principal principal) {
//		dao.updateBalance(sendAmount, otherUserId, principal.getName());
//	}
}
