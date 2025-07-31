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

	@Override
    	public String getVehicleNumber() {
        	return vehicleNumber;
    	}

	@Override
    	public String getName() {
        	return name;
    	}

	@Override
    	public String getType() {
        	return "Car";
    	}

	@Override
    	public int calculateFee(int hrs){
    		return hrs*20;
    	}
}

