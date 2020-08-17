package com.techelevator.chucknorris;

import org.springframework.web.client.RestTemplate;

public class ChuckNorrisService {

	private final static String BASE_URL = "http://api.icndb.com/jokes/random?exclude=explicit";
	
	public Joke requestJoke(String category) {
		RestTemplate restTemplate = new RestTemplate();
		
		String url = BASE_URL;
		
		if (category != null && category.length() > 0) {
			url += "&limitTo=" + category;
		}
		
		
		Joke joke = restTemplate.getForObject(url, Joke.class);
		
		return joke;
	}
	
	
}
