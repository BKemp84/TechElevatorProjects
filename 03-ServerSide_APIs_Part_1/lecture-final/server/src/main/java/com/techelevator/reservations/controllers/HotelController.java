package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Returns All reservations
     * URL:  http://localhost:8080/reservations
     * RequestMethod says to only call listReservations() when that URL is requested as 
     * a GET request
     * @return - Spring Boot will serialize the returned object into JSON and return it to 
     * the client as the response.
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservations() {
    	List<Reservation> reservations = reservationDAO.findAll();
    	return reservations;
    }
    
    /**
     * Gets the reservation for the Reservation Id provided in the Path
     * URL:  http://localhost:8080/reservations/2  ( 2 = can be any reservation id )
     * In the RequestMapping:  {reservationId}  tells Spring Boot to assign the value in that
     * location in the path to the variable with the same name and the @PathVariable annotation in 
     * the method arguments:  @PathVariable int reservationId
     * @param reservationId
     * @return
     */
    @RequestMapping(path="/reservations/{reservationId}", method=RequestMethod.GET)
    public Reservation getReservation(@PathVariable int reservationId) {
    	return reservationDAO.get(reservationId);
    }
    
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
    	return reservationDAO.findByHotel(hotelId);
    }
    
    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable("id") int hotelId) {
    	return reservationDAO.create(reservation, hotelId);
    }
    
    //  http://localhost:8080/hotels/filter?state=oh&city=columbus
    @RequestMapping(path="/hotels/filter", method=RequestMethod.GET)
    public List<Hotel> filterByStateAndCity( @RequestParam String state,  @RequestParam(required=false) String city ) {
    	
    	List<Hotel> filteredHotels = new ArrayList<Hotel>();
    	
    	List<Hotel> hotels = hotelDAO.list();
    	
    	for (Hotel hotel : hotels) {
    		if (city != null) {
    			if (hotel.getAddress().getCity().equalsIgnoreCase(city) && 
    					hotel.getAddress().getState().equalsIgnoreCase(state) ) {
    				filteredHotels.add(hotel);
    			} 
    		} else {
    			if (hotel.getAddress().getState().equalsIgnoreCase(state) ) {
    				filteredHotels.add(hotel);
    			} 
    		}
    	}
    	
    	return filteredHotels;
    }
    
    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }

}
