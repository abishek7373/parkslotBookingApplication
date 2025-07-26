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

        public String getVehicleNumber() {
                return vehicleNumber;
        }

        public String getName() {
                return name;
        }

        public String getType() {
                return "Bike";
        }

        public int calculateFee(int hrs){
                return hrs*10;
        }
}
