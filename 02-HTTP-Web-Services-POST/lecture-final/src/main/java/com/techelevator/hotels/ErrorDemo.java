package com.techelevator.hotels;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class ErrorDemo {

	private static final String API_BASE_URL = "http://localhost:3000/";
	
	public static void main(String[] args) {
		
		ConsoleService consoleService = new ConsoleService();
		HotelService hotelService = new HotelService(API_BASE_URL);
		
		Hotel hotel = hotelService.getHotel(1);
		
		if (hotel != null) {
			consoleService.printHotel(hotel);
		}
	}

}
