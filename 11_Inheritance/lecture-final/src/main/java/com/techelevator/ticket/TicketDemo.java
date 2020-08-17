package com.techelevator.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDemo {

	public static void main(String[] args) {
		
		
		WillCallTicket wct = new WillCallTicket(20, "Steve");
		
		System.out.println(wct.getTotalPrice());
		
		VipTicket vip = new VipTicket(20, 15);
		
		System.out.println(vip.getTotalPrice());
		
		FreeTicket ft = new FreeTicket();
		
		System.out.println(ft.getTotalPrice());
		
		System.out.println("-----------------------");
		
		
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(wct);
		tickets.add(vip);
		tickets.add(ft);
		
		for (Ticket t : tickets) {
			System.out.println( t.getTotalPrice() );
		}

	}

}
