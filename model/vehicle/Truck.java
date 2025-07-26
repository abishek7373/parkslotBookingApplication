package model.vehicle;

public class Truck implements Vehicle {
	private String vehicleNumber;
	private String name;
        public Truck(){
                vehicleNumber = "---";
                name = "---";
        }
    	public Truck(String vehicleNumber, String name) {
        	this.vehicleNumber = vehicleNumber;
        	this.name = name;
    	}

    	public String getVehicleNumber() {
        	return vehicleNumber;
    	}

    	public String getName() {
        	return name;
    	}

    	public String getType() {
        	return "Truck";
    	}
	public int calculateFee(int hrs){
		return hrs*25;
	}
	
}


