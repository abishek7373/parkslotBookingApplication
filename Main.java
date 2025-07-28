import java.util.*;

import repo.FloorRepo;
import model.Floor;
import model.ParkingSlot;
import service.RepoService;
import controller.RepoReadController;
import controller.BookingController;

class Main{
	static RepoReadController readCon = new RepoReadController();
        static BookingController  bookCon = new BookingController();
	static Scanner sc = new Scanner(System.in);


	static void callThreads(){
		System.out.println();
                Thread thread1 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Bike" , "F13B")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
                        }
                        else{
                                System.out.println("Already Booked Cannot book for "+ Thread.currentThread().getName());
                        }

//                      readCon.showAvail();

                });
                Thread thread2 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Bike" , "F13B")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
                        }
                        else{
                                System.out.println("Already Booked Cannot book for " + Thread.currentThread().getName());
                        }

//                        readCon.showAvail();

                });

                Thread thread3 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Car" , "F13C")){
                                System.out.println("F13C Booked SuccessFully for "+ Thread.currentThread().getName());
                        }
                        else{
                                System.out.println("Already Booked Cannot book for "+Thread.currentThread().getName());
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

	public static void userInput(){
		System.out.print("\nEnter Your Name : ");
                String name = sc.next();
                while(true){
                        System.out.print("\nEnter Your Vehicle Type (Bike / Car / Truck) : ");
                        String vehicleType = sc.next();
                        readCon.showAvail(vehicleType);
                        System.out.print("\nEnter the SlotId : ");
                        String slotId = sc.next();
                        if(bookCon.bookParkSlot(vehicleType , slotId)){
                                System.out.println(slotId + " Booked SuccessFully to " + name);
                        }
                        else{
                                System.out.println("Already Booked Cannot book");
                        }
                        System.out.print("Do You Want To Exit : ");
                        String termination = sc.next();
                        if(termination.equals("Yes")) break;
                }

	}


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
		System.out.println("------------------------------ Parking Slot Booking Application -----------------------------");
//		userInput();
//		callThreads();
		while(true){
			System.out.println("1) MultiThread Inputs");
			System.out.println("2) User Input");
			System.out.println("3) Exit");
			System.out.print("Enter Your Choice : ");
			int ch = sc.nextInt();
				
			switch(ch){
				case 1:
					callThreads();
					break;
				case 2:
					userInput();
					break;
				case 3:
					return ;
			}


		}
	}
}
