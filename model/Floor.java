package model;

import java.util.*;
import model.ParkingSlot;

public class Floor{
	List<ParkingSlot> bikeSlots = new ArrayList<>();
	List<ParkingSlot> carSlots = new ArrayList<>();
	List<ParkingSlot> truckSlots = new ArrayList<>();
	String floorId;
	public Floor(List<ParkingSlot> bikes , List<ParkingSlot> cars , List<ParkingSlot> trucks , String floorId){
		bikeSlots = bikes;
		carSlots = cars;
		truckSlots = trucks;
		this.floorId = floorId;
	}

	public String getFloorId(){
		return floorId;
	}

	public List<ParkingSlot> getBikeSlots(){
		return bikeSlots;
	}

	public List<ParkingSlot> getCarSlots(){
		return carSlots;
	}

	public List<ParkingSlot> getTruckSlots(){
		return truckSlots;
	}
}
