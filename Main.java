import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

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
	static ThreadFactory namedThreadFactory = new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("unBookingThread" + counter.getAndIncrement());
                return t;
            }
        };
	static ThreadFactory bookingThreadFactory = new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("bookingThread" + counter.getAndIncrement());
                return t;
            }
        };


	static ExecutorService Threadexecutors = Executors.newFixedThreadPool(20, bookingThreadFactory);
	static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(20 , namedThreadFactory);

	static void callThreads(){
		System.out.println();
                //Thread thread1 = new Thread(() -> {
		Threadexecutors.execute(() -> {
			String slotId = "F13B";
			int dur = 20;
                        if(bookCon.bookParkSlot("Bike" , "F13B" , Thread.currentThread().getName() , 20 , "TN38AC12")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
                   	        //new Thread(() -> {
                                //        try{
                                //                Thread.sleep(20 * 1000);
                                //                bookCon.removeBooking("F13B");
                                //                System.out.println("Slot Id : F13B  is free to Book now . ");
                                //        }catch(InterruptedException e){
                                //                e.printStackTrace();
                                //        }
                                //}).start();
				scheduler.schedule(() -> {
                			bookCon.removeBooking(slotId);
                			System.out.println("Slot Id : " + slotId + " is free to Book now.");
            			}, dur, TimeUnit.SECONDS);

			}
                        else{
                                System.out.println("Already Booked Cannot book for "+ Thread.currentThread().getName());
                        }

//                      readCon.showAvail();

		});
                //Thread thread2 = new Thread(() -> {
		Threadexecutors.execute(() -> {
			String slotId = "F13B";
			int dur = 40;
                        if(bookCon.bookParkSlot("Bike" , "F13B" , Thread.currentThread().getName() , 40 , "TN42ZA77")){
                                System.out.println("F13B Booked SuccessFully for " + Thread.currentThread().getName());
				//new Thread(() -> {
                                //        try{
                                //                Thread.sleep(40 * 1000);
                                //                bookCon.removeBooking("F13B");
                                //                System.out.println("Slot Id : F13B  is free to Book now . ");
                                //        }catch(InterruptedException e){
                                //                e.printStackTrace();
                                //        }
                                //}).start();
				scheduler.schedule(() -> {
                                        bookCon.removeBooking(slotId);
                                        System.out.println("Slot Id : " + slotId + " is free to Book now.");
                                }, dur, TimeUnit.SECONDS); 

                        }
                        else{
                                System.out.println("Already Booked Cannot book for " + Thread.currentThread().getName());
                        }

//                        readCon.showAvail();

                });

                //Thread thread3 = new Thread(() -> {
		Threadexecutors.execute(() -> {
			String slotId = "F13C";
			int dur = 30;
                        if(bookCon.bookParkSlot("Car" , "F13C"  , Thread.currentThread().getName() , 30 , "TN7AB002")){
                                System.out.println("F13C Booked SuccessFully for "+ Thread.currentThread().getName());
				//new Thread(() -> {
                                //        try{
                                //                Thread.sleep(30 * 1000);
                                //                bookCon.removeBooking("F13C");
                                //                System.out.println("Slot Id : F13C is free to Book now . ");
                                //        }catch(InterruptedException e){
                                //                e.printStackTrace();
                                //        }
                                //}).start();
				scheduler.schedule(() -> {
                                        bookCon.removeBooking(slotId);
                                        System.out.println("Slot Id : " + slotId + " is free to Book now.");
                                }, dur, TimeUnit.SECONDS);

                        }
                        else{
                                System.out.println("Already Booked Cannot book for "+Thread.currentThread().getName());
                        }

//                        readCon.showAvail();

                });



//                thread1.start();
//                thread2.start();
//                thread3.start();
//
//                try{
//                        thread1.join();
//                        thread2.join();
//                        thread3.join();
//                }
//                catch(InterruptedException e){
//                        e.printStackTrace();
//                }
                readCon.showAvail();

	}

public static void userInput(){
    	System.out.print("\n-> Enter Your Name : ");
    	String name = sc.next();

    	System.out.print("\n-> Enter Your Vehicle Type (Bike / Car / Truck) : ");
    	String vehicleType = sc.next();

    	System.out.print("\n-> Enter the SlotId : ");
    	String slotId = sc.next();

    	System.out.print("\n-> Enter Your Vehicle Number : ");
    	String vehNum = sc.next();

    	System.out.print("\n-> Enter How much Hours You want this Slot : ");
    	int dur = sc.nextInt();


    	Threadexecutors.execute(() -> {
        	if (bookCon.bookParkSlot(vehicleType, slotId, name, dur, vehNum)) {
            		System.out.println(slotId + " Booked SuccessFully to " + name);
            		scheduler.schedule(() -> {
                		bookCon.removeBooking(slotId);
                		System.out.println("Slot Id : " + slotId + " is free to Book now.");
            		}, dur, TimeUnit.SECONDS);
        	} else {
            		System.out.println("Better Luck Next Time");
        	}
    	});
}


	public static void showAllSlots(){
			System.out.println();
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
			System.out.println();


	}
	public static void main(String[] args){
		while(true){
			System.out.println("------------------------------ Parking Slot Booking Application -----------------------------");
			System.out.println("1) MultiThread Inputs");
			System.out.println("2) User Input");
			System.out.println("3) Exit");
			System.out.print("-> Enter Your Choice : ");
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
					Threadexecutors.shutdown();
					scheduler.shutdown();
					return ;
				case 4:
					TicketRepo.printTickets();
					break;
				case 5:
					showAllSlots();
					break;
				case 6:
					System.out.print("-> Enter Slot Id to UnBook : ");
					String slotId = sc.next();
					bookCon.removeBooking(slotId);
					break;
				default:
					System.out.println("-> Enter Correct Input.");
					break;
			}


		}
	}
}
