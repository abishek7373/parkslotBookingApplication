package model;

import model.vehicle.*;

public class ParkingSlot{
	String slotId;
	Vehicle slotType;
	Boolean isBooked;
	
	public ParkingSlot(String slotId , Vehicle slotType , Boolean isBooked){
		this.slotId = slotId;
		this.slotType = slotType;
		this.isBooked = isBooked;
	}

	public String getSlotId(){
		return slotId; 
	}

	public void setSlotId(String slotId){
		this.slotId = slotId;
	}
        public String getSlotType(){
                return slotType.getType();
        }
	public Vehicle getSlotTypeV(){
		return slotType;
	}

        public void setSlotType(Vehicle slotType){
                this.slotType = slotType;
        }
        public Boolean isBooked(){
                return isBooked;
        }

        public void book(){
                isBooked = true;
        }
	
	public void unbook(){
		isBooked = false;
	}
	public String isAvail(){
		if(isBooked == true){
			return "No";
		}
		else return "Yes";
	}
	
	@Override
	public String toString(){
		return "Slot Id : " + slotId + " Slot Type : "+ getSlotType() + " Is Available : " + isAvail() + " Booked By : "+ slotType.getName();  
	}
}

