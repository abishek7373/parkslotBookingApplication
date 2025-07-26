package controller;

import service.BookingService;

public class BookingController{
	BookingService bookService = new BookingService();

	public Boolean bookParkSlot(String type , String slotId){
		int floor;
		if(slotId.contains("F1")){
			floor =  0;	
		}
		else{
			floor = 1;
		}
		return bookService.booker(slotId,type,floor);
	}
}
