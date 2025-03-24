public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new LandVehicle("honda we", 650, 25, 4);
        vehicles[1] = new WaterVehicle("Kapal", 40, 15, true);
        vehicles[2] = new LandVehicle("Sepeda Motor", 80, 10, 2);

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.calculateFuelConsumption(50);

            if (vehicle instanceof Refuelable) {
                Refuelable refuelable = (Refuelable) vehicle;
                if (refuelable.isFuelLow()) {
                    System.out.println("Bahan bakar rendah! Mengisi bahan bakar...");
                    refuelable.refuel(30);
                }
            }

            System.out.printf("Bahan bakar %s: %.1f%%%n", 
                vehicle.getName(), vehicle.getFuelLevel());
        }
    }
}