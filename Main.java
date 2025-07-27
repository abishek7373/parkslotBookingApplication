import java.util.*;

import repo.FloorRepo;
import model.Floor;
import model.ParkingSlot;
import service.RepoService;
import controller.RepoReadController;
import controller.BookingController;
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
//		readCon.showAvail();
		BookingController bookCon = new BookingController();
		Thread thread1 = new Thread(() -> {
	                if(bookCon.bookParkSlot("Bike" , "F13B")){
        	                System.out.println("F13B Booked SuccessFully Thread-0");
               		}
               		else{
                       		System.out.println("Already Booked Cannot book Thread-0");
                	}

//                	readCon.showAvail();

		});
		Thread thread2 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Bike" , "F13B")){
                                System.out.println("F13B Booked SuccessFully Thread-1");
                        }
                        else{
                        	System.out.println("Already Booked Cannot book Thread-1");
                        }

//                        readCon.showAvail();

                });

                Thread thread3 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Car" , "F13C")){
                                System.out.println("F13C Booked SuccessFully Thread-2");
                        }
                        else{
                                System.out.println("Already Booked Cannot book Thread-2");
                        }

//                        readCon.showAvail();

                });



		thread1.start();
		thread2.start();
		thread3.start();

		try{
			thread1.join();
			thread2.join();
			thread3.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		readCon.showAvail();
	}
}
