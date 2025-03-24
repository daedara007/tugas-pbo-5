public class WaterVehicle extends Vehicle implements Refuelable {
    private boolean hasPropeller;

    public WaterVehicle(String name, int speed, double fuelLevel, boolean hasPropeller) {
        super(name, speed, fuelLevel);
        this.hasPropeller = hasPropeller;
    }

    @Override
    public void move() {
        System.out.printf(
            "%s bergerak di air dengan kecepatan %d km/jam, menggunakan baling-baling: %b%n",
            getName(), getSpeed(), hasPropeller
        );
    }

    @Override
    public void calculateFuelConsumption(double distance) {
        double consumption = distance / 8.0;
        double newFuel = getFuelLevel() - consumption;
        setFuelLevel(newFuel); // Gunakan setter
    }

    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount); // Otomatis dibatasi oleh setter
    }

    @Override
    public boolean isFuelLow() {
        return getFuelLevel() < 20;
    }
}