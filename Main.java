import java.util.*;

import repo.TicketRepo;
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
                        if(bookCon.bookParkSlot("Bike" , "F13B" , "thread1" , 5 , "TN38AC12")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
                   	        new Thread(() -> {
                                        try{
                                                Thread.sleep(20 * 1000);
                                                bookCon.removeBooking("F13B");
                                                System.out.println("Slot Id : F13B  is free to Book now . ");
                                        }catch(InterruptedException e){
                                                e.printStackTrace();
                                        }
                                }).start();

			}
                        else{
                                System.out.println("Already Booked Cannot book for "+ Thread.currentThread().getName());
                        }

//                      readCon.showAvail();

		});
                Thread thread2 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Bike" , "F13B" , "thread2" , 3 , "TN42ZA77")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
				new Thread(() -> {
                                        try{
                                                Thread.sleep(30 * 1000);
                                                bookCon.removeBooking("F13B");
                                                System.out.println("Slot Id : F13B  is free to Book now . ");
                                        }catch(InterruptedException e){
                                                e.printStackTrace();
                                        }
                                }).start();


                        }
                        else{
                                System.out.println("Already Booked Cannot book for " + Thread.currentThread().getName());
                        }

//                        readCon.showAvail();

                });

                Thread thread3 = new Thread(() -> {
                        if(bookCon.bookParkSlot("Car" , "F13C"  , "thread3" , 7 , "TN7AB002")){
                                System.out.println("F13C Booked SuccessFully for "+ Thread.currentThread().getName());
				new Thread(() -> {
                                        try{
                                                Thread.sleep(30 * 1000);
                                                bookCon.removeBooking("F13C");
                                                System.out.println("Slot Id : F13C is free to Book now . ");
                                        }catch(InterruptedException e){
                                                e.printStackTrace();
                                        }
                                }).start();


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
			System.out.print("\nEnter Your Vehicle Number : ");
			String vehNum = sc.next();
			System.out.println("Enter How much Hours You want this Slot : ");
			int dur = sc.nextInt();
                        if(bookCon.bookParkSlot(vehicleType , slotId , name , dur , vehNum)){
                                System.out.println(slotId + " Booked SuccessFully to " + name);
                        	new Thread(() -> {
					try{
						Thread.sleep(dur * 1000);
						bookCon.removeBooking(slotId);
						System.out.println("Slot Id : " + slotId + " is free to Book now . ");
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}).start();
			}
                        else{
                                System.out.println("Better Luck Next Time");
                        }
                        System.out.print("Do You Want To Exit : ");
                        String termination = sc.next();
                        if(termination.equals("Yes")) break;
                }

	}

	public static void showAllSlots(){
		      	for(Floor f : FloorRepo.parkingArea){
                      		List<ParkingSlot> bikes = f.getBikeSlots();
                      		System.out.println("Floor : " + f.getFloorId() + "BIkes");
                      		for(ParkingSlot bike : bikes){
                              		System.out.println(bike.toString());
                      		}
                       		System.out.println("Floor : " + f.getFloorId() + "Cars");

                      		List<ParkingSlot> cars = f.getCarSlots();
                        	for(ParkingSlot car : cars){
                              		System.out.println(car.toString());
                       		}
                        	System.out.println("Floor : " + f.getFloorId() + "Trucks");

                      		List<ParkingSlot> trucks = f.getTruckSlots();
                        	for(ParkingSlot truck : trucks){
                                	System.out.println(truck.toString());
                        	}
                      
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
			int ch = 0;
			try{
				ch = sc.nextInt();
			}
			catch(Exception e){
				System.out.println("Wrong Input Type. Enter a Number from (1 , 2 , 3) .");
				sc.nextLine();
			}	
			switch(ch){
				case 1:
					callThreads();
					break;
				case 2:
					userInput();
					break;
				case 3:
					return ;
				case 4:
					TicketRepo.printTickets();
					break;
				case 5:
					showAllSlots();
					break;
				case 6:
					System.out.print("Enter Slot Id to UnBook : ");
					String slotId = sc.next();
					bookCon.removeBooking(slotId);
					break;
				default:
					System.out.println("Enter Correct Input.");
					break;
			}


		}
	}
}
