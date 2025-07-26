package service;

import java.util.*;

import repo.FloorRepo;
import model.vehicle.*;
import model.Floor;
import model.ParkingSlot;

public class BookingService{
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
			if(slot.getSlotId().equals(slotId)){
				slot.book();
				return true;
			}
		}
		return false;
	}
}
