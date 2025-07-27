package service;

import java.util.*;

import repo.FloorRepo;
import model.vehicle.*;
import model.Floor;
import model.ParkingSlot;

public class BookingService{
//	private Object lock = new Object();
	public Boolean booker(String slotId , String type , int floor){
		Floor f = FloorRepo.parkingArea.get(floor);
		List<ParkingSlot> slots;
		if(type == "Bike")
		{
			slots = f.getBikeSlots();
		}
		else if (type == "Car"){
			slots = f.getCarSlots();
		}
		else{
			slots = f.getTruckSlots();
		}
		for(ParkingSlot slot : slots){
//			synchronized(lock){
			synchronized(slot){
				if(slot.getSlotId().equals(slotId)){
					System.out.println(Thread.currentThread().getName() + " Running. Booking : " + slotId);
                                	if(!slot.isBooked()){
                                        	slot.book();
			                        System.out.println(Thread.currentThread().getName() + " Terminated. SucessFull");
                                        	return true;
                                	}
                                	else{
		                                System.out.println(Thread.currentThread().getName() + " Terminated. Too Late");
                                        	return false;
                                	}
                        	}
			}
		}
		return false;
	}
}
