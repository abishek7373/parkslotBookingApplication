package model;

import java.time.LocalTime;

import model.vehicle.*;

public class SlotTicket{
	String name;
	Vehicle vehType;
	int endTime;
	int amt;
	String slotId;
	
	public SlotTicket(String name , Vehicle vehType , String slotId){
		this.name = name;
		this.vehType = vehType;
		this.slotId = slotId;
	}
	public String getSlotId(){
		return slotId;
	}
	public void setAmt(int amt){
		this.amt = amt;
	}

	public void setEndTime(int hrs){
	    	int currTime = LocalTime.now().getHour();
    		endTime = (currTime + hrs) % 24;
	}

	public void printTicket(){
		System.out.println("\n-------PARKING SLOT TICKET-------" + 
				"\nName : " + name +
				"\nSlot Id : " + slotId +
				"\nVehicle Type : " + vehType.getType() +
				"\nVehicle Number : " + vehType.getVehicleNumber() +
				"\nEnd Time : " + endTime+
				"\nTotal Amount : " + amt+
				"\n---------------------------------\n"
				);
	}
}
