package com.techelevator.tenmo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Accounts;
import com.techelevator.tenmo.models.AddSubDto;
import com.techelevator.tenmo.models.ConfDenyDto;
import com.techelevator.tenmo.models.Transfers;
import com.techelevator.tenmo.models.TransfersDto;
import com.techelevator.tenmo.models.Users;

public class TransfersService {
	private String jwt;
	private String BASE_URL;
	private RestTemplate restTemplate = new RestTemplate();

	public TransfersService(String BASE_URL, String jwt) {
		this.BASE_URL = BASE_URL;
		this.jwt = jwt;
		restTemplate = new RestTemplate();
	}

	public List<Transfers> listXfers(boolean pendNorm) {
		List<Transfers> xferList = new ArrayList<Transfers>();
		String url = BASE_URL;
		if (pendNorm == true) {
			url += "account/transfers";
		} else if (pendNorm == false) {
			url += "account/transfers/pending";
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwt);
		HttpEntity entity = new HttpEntity<>(xferList, headers);

		List<Transfers> xfers = restTemplate
				.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transfers>>() {
				}).getBody();
		return xfers;
	}

	public Transfers request(int amount, int accountSelection, int reqSendSelection) {
		Transfers transfer = new Transfers();
		String url = BASE_URL + "account/transfers";
		TransfersDto dto = new TransfersDto();
		dto.setAmount(amount);
		dto.setAccountSelection(accountSelection);
		dto.setReqSendSelection(reqSendSelection);
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwt);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity<>(dto, headers);
		transfer = restTemplate.exchange(url, HttpMethod.POST, entity, Transfers.class).getBody();
		return transfer;
	}

	public boolean confDeny(int statusSelection, int idSelection, List<Transfers> xfers, List<Accounts> account) {
		boolean canDenyOrConf = true;
		Transfers ts = null;
		HashMap<Long, BigDecimal> accountIdBalance = new HashMap<Long, BigDecimal>();
		for (Accounts a : account) {
			accountIdBalance.put(a.getUser_id(), a.getBalance());
		}

		for (Transfers t : xfers) {
			if (t.getTransfer_id() == idSelection) {
				ts = t;
				break;
			}
		}

		BigDecimal accountBalance = accountIdBalance.get(ts.getAcount_from());
		BigDecimal amountSub = ts.getAmount();

		if (accountBalance.compareTo(amountSub) == -1 || ts.getTransfer_status_id() == 2
				|| ts.getTransfer_status_id() == 3) {
			canDenyOrConf = false;
			System.out.println("Check balance or whether is has been approved/denied already");
			return false;
		}

		if (canDenyOrConf == true) {
			String url = BASE_URL + "account/transfers/status";
			ConfDenyDto dto = new ConfDenyDto();
			dto.setStatusSelection(statusSelection);
			dto.setIdSelection(idSelection);
			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(jwt);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity entity = new HttpEntity<>(dto, headers);
			restTemplate.exchange(url, HttpMethod.PUT, entity, Transfers.class);
			return true;
		} 
		return false;
	}

	public void additionSubtraction(List<Users> users, boolean isAddition, BigDecimal currentBalance, int idSelection,
			int amount, Transfers xfer, List<Transfers> xfers) {
		Transfers ts = null;
		boolean isRequest = false;
		HashMap<Integer, String> fromNames = new HashMap<Integer, String>();
		for (Users u : users) {
			fromNames.put(u.getId(), u.getUsername());
		}
		for (Transfers t : xfers) {
			if (t.getTransfer_id() == idSelection) {
				ts = t;
				break;
			}
		}
		BigDecimal bigAmount = BigDecimal.valueOf(amount);
		if (isAddition) {

			String url = BASE_URL + "account/transfers/math";
			AddSubDto dto = new AddSubDto();
			dto.setUserName(fromNames.get(idSelection));
			dto.setAmount(bigAmount);
			dto.setIsAddition(isAddition);
			dto.setCurrentBalance(currentBalance);

			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(jwt);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity entity = new HttpEntity<>(dto, headers);

			restTemplate.exchange(url, HttpMethod.PUT, entity, Transfers.class);
		}

		else if (!isAddition) {
			String url = BASE_URL + "account/transfers/math";
			AddSubDto dto = new AddSubDto();
			dto.setUserName(fromNames.get((int) xfer.getAcount_from()));
			dto.setAmount(xfer.getAmount());
			dto.setIsAddition(isAddition);
			dto.setCurrentBalance(currentBalance);

			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(jwt);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity entity = new HttpEntity<>(dto, headers);

			restTemplate.exchange(url, HttpMethod.PUT, entity, Transfers.class);
		}
	}
}
