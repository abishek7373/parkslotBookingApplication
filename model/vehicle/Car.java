package model.vehicle;

public class Car implements Vehicle {
    	private String vehicleNumber;
    	private String name;
        public Car(){
                vehicleNumber = "---";
                name = "---";
        }
    	public Car(String vehicleNumber, String name) {
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
        	return "Car";
    	}

    	public int calculateFee(int hrs){
    		return hrs*20;
    	}
}

