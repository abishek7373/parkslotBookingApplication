import java.util.*;

import repo.FloorRepo;
import model.Floor;
import model.ParkingSlot;
import service.RepoService;
import controller.RepoReadController;

class Main{
	public static void main(String[] args){
//		for(Floor f : FloorRepo.parkingArea){
//			List<ParkingSlot> bikes = f.getBikeSlots();
//			System.out.println("Floor : " + f.getFloorId() + "BIkes");
//			for(ParkingSlot bike : bikes){
//				System.out.println(bike.toString());
//			}
//                       System.out.println("Floor : " + f.getFloorId() + "Cars");
//
//			List<ParkingSlot> cars = f.getCarSlots();
//                        for(ParkingSlot car : cars){
//                              System.out.println(car.toString());
//                       }
//                        System.out.println("Floor : " + f.getFloorId() + "Trucks");
//
//			List<ParkingSlot> trucks = f.getTruckSlots();
//                        for(ParkingSlot truck : trucks){
//                                System.out.println(truck.toString());
//                        }
//			
//		}

//		RepoService repoService = new RepoService();
//		repoService.printAvailSlots();
		RepoReadController readCon = new RepoReadController();
		readCon.showAvail();

		
	}
}
