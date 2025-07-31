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
        	return "Truck";
    	}

	@Override
	public int calculateFee(int hrs){
		return hrs*25;
	}
	
}


