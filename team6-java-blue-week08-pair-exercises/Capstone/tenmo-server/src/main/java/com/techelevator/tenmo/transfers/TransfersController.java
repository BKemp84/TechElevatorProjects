package com.techelevator.tenmo.transfers;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("isAuthenticated()")
@RestController
public class TransfersController {
	private TransfersDao dao;
	
	public TransfersController(TransfersDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(path = "/account/transfers", method = RequestMethod.GET)
	public List<Transfers> listXfer(Principal principal){
		return dao.listXfer(principal.getName());
	} 
	
	@RequestMapping(path = "/account/transfers", method = RequestMethod.POST)
	public Transfers request(Principal principal,@RequestBody TransferDto dto) {
		return dao.request(principal.getName(), dto.getAmount(), dto.getAccountSelection(), dto.getReqSendSelection());
	}
	
	@RequestMapping(path = "account/transfers/pending", method = RequestMethod.GET)
	public List<Transfers> listPending(Principal principal){
		return dao.viewPendingXfers(principal.getName());
	}
	
	@RequestMapping(path = "account/transfers/status", method = RequestMethod.PUT)
	public void confDeny(@RequestBody ConfDenyDto dto) {
		dao.confDeny(dto.getStatusSelection(), dto.getIdSelection());
	}
	
	@RequestMapping(path = "account/transfers/math", method = RequestMethod.PUT)
	public void additionSubtraction(@RequestBody AddSubDto dto) {
		dao.additionSubtraction(dto.getUserName(), dto.getAmount(), dto.getIsAddition(), dto.getCurrentBalance());
	}
}
