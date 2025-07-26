package repo;

import java.util.*;
import model.vehicle.*;
import model.ParkingSlot;
import model.Floor;


public class FloorRepo{
	public static List<Floor> parkingArea = new ArrayList<>();

	static {
		List<ParkingSlot> bikeSlotsF1 = new ArrayList<>();
		bikeSlotsF1.add(new ParkingSlot("F11B" , new Bike() , false));
                bikeSlotsF1.add(new ParkingSlot("F12B" , new Bike() , false));
                bikeSlotsF1.add(new ParkingSlot("F13B" , new Bike() , false));
                bikeSlotsF1.add(new ParkingSlot("F14B" , new Bike() , false));
		List<ParkingSlot> carSlotsF1 = new ArrayList<>();
		carSlotsF1.add(new ParkingSlot("F11C" , new Car() , false));
                carSlotsF1.add(new ParkingSlot("F12C" , new Car() , false));
                carSlotsF1.add(new ParkingSlot("F13C" , new Car() , false));
		List<ParkingSlot> truckSlotsF1 = new ArrayList<>();
		truckSlotsF1.add(new ParkingSlot("F11T" , new Truck() , false));
		truckSlotsF1.add(new ParkingSlot("F12T" , new Truck() , false));
		truckSlotsF1.add(new ParkingSlot("F13T" , new Truck() , false));
		
		Floor floor1 = new Floor(bikeSlotsF1 , carSlotsF1 , truckSlotsF1 , "F1");

                List<ParkingSlot> bikeSlotsF2 = new ArrayList<>();
                bikeSlotsF2.add(new ParkingSlot("F21B" , new Bike() , false));
                bikeSlotsF2.add(new ParkingSlot("F22B" , new Bike() , false));
                bikeSlotsF2.add(new ParkingSlot("F23B" , new Bike() , false));
                bikeSlotsF2.add(new ParkingSlot("F24B" , new Bike() , false));
                List<ParkingSlot> carSlotsF2 = new ArrayList<>();
                carSlotsF2.add(new ParkingSlot("F21C" , new Car() , false));
                carSlotsF2.add(new ParkingSlot("F22C" , new Car() , false));
                carSlotsF2.add(new ParkingSlot("F23C" , new Car() , false));
                List<ParkingSlot> truckSlotsF2 = new ArrayList<>();
                truckSlotsF2.add(new ParkingSlot("F21T" , new Truck() , false));
                truckSlotsF2.add(new ParkingSlot("F22T" , new Truck() , false));
                truckSlotsF2.add(new ParkingSlot("F23T" , new Truck() , false));

                Floor floor2 = new Floor(bikeSlotsF2 , carSlotsF2 , truckSlotsF2 , "F2");
		
		parkingArea.add(floor1);
		parkingArea.add(floor2);
	}

}
