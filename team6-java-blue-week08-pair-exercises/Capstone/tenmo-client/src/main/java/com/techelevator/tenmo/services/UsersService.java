package com.techelevator.tenmo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.techelevator.tenmo.models.Users;

public class UsersService {
	private String jwt;
	private String BASE_URL;
	private RestTemplate restTemplate = new RestTemplate();
	
	public UsersService(String BASE_URL, String jwt) {
		this.BASE_URL = BASE_URL;
		this.jwt = jwt;
		restTemplate = new RestTemplate();
	}
	
	public List<Users> listUsers(){
		List<Users> usersList = new ArrayList<Users>();
		String url = BASE_URL + "users";
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwt);
		HttpEntity entity = new HttpEntity<>(usersList,headers);
		
		List<Users> users = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Users>>() {}).getBody();
		return users;
	}
	


}


