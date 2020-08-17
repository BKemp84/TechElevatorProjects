package com.techelevator.tenmo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Accounts;

public class AccountsService{
	private String jwt;
	private String BASE_URL;
	private RestTemplate restTemplate = new RestTemplate();
	
	public AccountsService(String BASE_URL, String jwt) {
		this.BASE_URL = BASE_URL;
		this.jwt = jwt;
		restTemplate = new RestTemplate();
	}
	
	public Accounts getAccount() {
		String url = BASE_URL + "accounts";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwt);
		HttpEntity entity = new HttpEntity<>(headers);
		Accounts account = new Accounts();
		try {
		account = restTemplate.exchange(url, HttpMethod.GET, entity, Accounts.class).getBody();
		} catch (RestClientResponseException ex) {
			// do somethin with exception
			throw ex;
		}
		return account;
	}
	
	public List<Accounts> listAllAccounts(){
		List<Accounts> usersList = new ArrayList<Accounts>();
		String url = BASE_URL + "";
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwt);
		HttpEntity entity = new HttpEntity<>(usersList,headers);
		
		List<Accounts> users = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Accounts>>() {}).getBody();
		return users;
	}
	
	
}
