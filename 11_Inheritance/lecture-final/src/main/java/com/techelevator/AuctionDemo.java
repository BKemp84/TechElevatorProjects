package com.techelevator;

public class AuctionDemo {

	public static void main(String[] args) {
	
		Auction auction = new Auction("Book");
		auction.placeBid(new Bid("John", 10));
		
		BuyoutAuction buyoutAuction = new BuyoutAuction("Record", 10);
		buyoutAuction.placeBid(new Bid("John", 15));
		
		ReserveAuction reserveAuction = new ReserveAuction("fork", 2);
		reserveAuction.placeBid(new Bid("John", 5));


	}

}
