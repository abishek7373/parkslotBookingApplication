package model.vehicle;

public interface Vehicle {
    	String getVehicleNumber();
    	String getName();
    	String getType();
    	int calculateFee(int hrs);
}

