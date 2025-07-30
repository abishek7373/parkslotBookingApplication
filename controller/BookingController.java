package controller;

import java.util.*;
import service.BookingService;
import repo.TicketRepo;
import repo.FloorRepo;
import model.SlotTicket;
import model.ParkingSlot;
import model.Floor;

public class BookingController{
	BookingService bookService = new BookingService();

	public Boolean bookParkSlot(String type , String slotId, String name , int dur , String vehNum){
		int floor;
		if(slotId.contains("F1")){
			floor =  0;	
		}
		else{
			floor = 1;
		}
		return bookService.booker(slotId,type,floor , name , dur , vehNum);
	
	}

	public void removeBooking(String slotId){
		SlotTicket ticketToRemove = null;
		ParkingSlot slotToBeFreed = null;
		int floor;
                if(slotId.contains("F1")){
                        floor =  0;
                }
                else{
                        floor = 1;
                }

		Floor f = FloorRepo.parkingArea.get(floor);
		List<ParkingSlot> slots = null;
		if(slotId.contains("B")){
			slots = f.getBikeSlots();

		}
		else if (slotId.contains("C")){
			slots = f.getCarSlots();

		}
		else if (slotId.contains("T")){
			slots = f.getTruckSlots();

		}

		for(SlotTicket  t : TicketRepo.tickets){
			if(t.getSlotId().equals(slotId)){
				ticketToRemove = t;
			}
		}
		for(ParkingSlot slot : slots){
			if(slotId.equals(slot.getSlotId())){
				slotToBeFreed = slot;
			}
		}

		if(slotToBeFreed != null && ticketToRemove != null){
			bookService.unbook(slotToBeFreed , ticketToRemove);
		}
		else{
			System.out.println("No Slot Booked in the Given Slot ID");
		}

	}
}
