package com.techelevator.hotels;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {

	private static final String API_BASE_URL = "http://localhost:3000/";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
    public static void main(String[] args) {
        new App().run();
    }

    public void run() {
        Hotel[] hotels = null;
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 999;

        printGreeting();

        while(menuSelection != 0) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
            if (menuSelection == 1) {
                printHotels( requestHotels() );
            } else if (menuSelection == 2) {
                printReviews( requestReviews() );
            } else if (menuSelection == 3) {
               printHotel( requestHotelById( 1 ) );
            } else if (menuSelection == 4) {
                printReviews( requestReviewsByHotelId( 1 ) );
            } else if (menuSelection == 5) {
                printHotels( requestHotelsByStarRating( 4 ) );
            } else if (menuSelection == 6) {
                System.out.println( requestCity() );
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            menuSelection = 999;
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            printGreeting();
        }
        scanner.close();
        System.exit(0);
    }

    private City requestCity() {
    	City city = restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
    	return city;
    }
    
    
    private Hotel[] requestHotelsByStarRating(int stars) {
    	String url = API_BASE_URL + "hotels?stars=" + stars; 
    	return restTemplate.getForObject(url, Hotel[].class);
    }
    
    
    private Review[] requestReviewsByHotelId(int hotelId) {
    	String url = API_BASE_URL + "hotels/" + hotelId + "/reviews";
    	return restTemplate.getForObject(url, Review[].class);
    }
    
    private Hotel requestHotelById(int id) {
    	String url = API_BASE_URL + "hotels/" + id;
    	Hotel hotel =  restTemplate.getForObject(url, Hotel.class);
    	return hotel;
    }
    
    private Hotel[] requestHotels() {
    	Hotel[] hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
    	return hotels;
    }
    
    private Review[] requestReviews() {
    	Review[] reviews = restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
    	return reviews;
    }
    
    
    private static void printGreeting() {
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Hotels. Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("6: Custom Query");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
    }

    private static void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    private static void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    private static void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

}
