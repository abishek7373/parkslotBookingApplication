package service;

import java.util.*;
import model.SlotTicket;
import repo.TicketRepo;
import repo.FloorRepo;
import model.vehicle.*;
import model.Floor;
import model.ParkingSlot;

public class BookingService{
//	private Object lock = new Object();
	public Boolean booker(String slotId , String type , int floor , String name , int dur , String vehNum){
		Floor f = FloorRepo.parkingArea.get(floor);
		List<ParkingSlot> slots;
		Vehicle veh;
		if(type.equals("Bike"))
		{
//			System.out.println("Inside Bike Block");
			slots = f.getBikeSlots();
			veh = new Bike(vehNum , name);
		}
		else if (type.equals("Car")){
//			System.out.println("Inside Car Block");
			slots = f.getCarSlots();
			veh = new Car(vehNum , name);

		}
		else{
			slots = f.getTruckSlots();
			veh = new Truck(vehNum , name);

		}
		for(ParkingSlot slot : slots){
//			synchronized(lock){
			synchronized(slot){
				if(slot.getSlotId().equals(slotId)){
					System.out.println("\n"+Thread.currentThread().getName() + " Running. Booking : " + slotId);
                                	if(!slot.isBooked()){
                                        	slot.book();
						slot.setSlotType(veh);
						SlotTicket ticket = new SlotTicket(name , veh , slotId);
						int amt = veh.calculateFee(dur);
						ticket.setAmt(amt);
						ticket.setEndTime(dur);
						TicketRepo.tickets.add(ticket);
						ticket.printTicket();
			                        System.out.println(Thread.currentThread().getName() + " Terminated. SucessFull");
                                        	return true;
                                	}
                                	else{
		                                System.out.println(Thread.currentThread().getName() + " Terminated. Too Late \n Already Booked");
                                        	return false;
                                	}
                        	}
			}
		}
		System.out.println("No Such Slot Id Enter The Correct Slot Id");
		return false;
	}

	public void unbook(ParkingSlot slot , SlotTicket ticket){
		TicketRepo.tickets.remove(ticket);
		String slotType = slot.getSlotType();
		Vehicle slotTypeV = slot.getSlotTypeV();
		String name = slotTypeV.getName();
		slot.unbook();
		if(slotType.equals("Bike")){
			slot.setSlotType(new Bike());	
		}
		else if(slotType.equals("Car")){
			slot.setSlotType(new Car());
		}
		else if(slotType.equals("Truck")){
			slot.setSlotType(new Truck());
		}
		System.out.println("Ticket is Expiered.\nThank You " + name);
	}
}
