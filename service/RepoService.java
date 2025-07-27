package service;

import java.util.*;

import repo.FloorRepo;
import model.ParkingSlot;
import model.vehicle.*;
import model.Floor;

public class RepoService{
	public void printAvailSlots(){
		for(Floor f : FloorRepo.parkingArea){
			System.out.println("\nAvailable Slots in Floor : " + f.getFloorId() + "\n");
			List<ParkingSlot> bikes = f.getBikeSlots();
			printer(bikes , "Bike");
                        List<ParkingSlot> cars = f.getCarSlots();
			printer(cars , "Car");
                        List<ParkingSlot> trucks = f.getTruckSlots();
			printer(trucks , "Truck");
		}
	}


	public void printer(List<ParkingSlot> list , String veh){
		System.out.println(veh + " Slots : ");
		int countAvail = 0;
		for(ParkingSlot v : list){
			if(!v.isBooked()){
				countAvail++;
				System.out.print(v.getSlotId() + "  ");
			}
		}
		System.out.println("\nTotal : " + countAvail+ "\n");
	}	
}
