package com.techelevator.auctions.controller;

import java.util.List;

import javax.swing.border.TitledBorder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDAO dao;
    private List<Auction> auctions;
    
    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
    @RequestMapping(method=RequestMethod.GET)
    public List<Auction> listAuctions(@RequestParam(defaultValue = "0.0") Double currentBid_lte, @RequestParam( defaultValue = "" , required = false)String title_like) {
    	
    	
    	if (currentBid_lte > 0 && title_like.length() >0){
	    	return dao. searchByTitleAndPrice(title_like, currentBid_lte);
	    		}
    	
    	
    	
    	if(title_like.length()>0) {
    		return dao.searchByTitle(title_like);
    		
    		
    		
    	
    	}
    		
    		if (currentBid_lte > 0) {
    			return dao.searchByPrice(currentBid_lte);
    		}
    		
    		
    	auctions = dao.list();
    	
    	
    	return auctions;
    }
    
    @RequestMapping(path="/{id}", method=RequestMethod.GET)
    public Auction getReservation(@PathVariable int id) {
    	return dao.get(id);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public Auction createAuction(@RequestBody Auction auctions) {
    	return dao.create(auctions);
    }
    
    
    	
    	
    
    
    
}  



