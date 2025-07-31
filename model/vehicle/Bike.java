package model.vehicle;

public class Bike implements Vehicle {
        private String vehicleNumber;
        private String name;
        public Bike(){
                vehicleNumber = "---";
                name = "---";
        }
        public Bike(String vehicleNumber, String name) {
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
                return "Bike";
        }

	@Override
        public int calculateFee(int hrs){
                return hrs*10;
        }
}
