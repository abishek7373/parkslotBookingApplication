package repo;

import java.util.*;

import model.SlotTicket;
import model.vehicle.*;

public class TicketRepo{
	public static List<SlotTicket> tickets = new ArrayList<>();
	public static void printTickets(){
		for(SlotTicket  t : tickets){
			t.printTicket();
		}
	}

}
