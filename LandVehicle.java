public class LandVehicle extends Vehicle implements Refuelable {
    private int wheels;

    public LandVehicle(String name, int speed, double fuelLevel, int wheels) {
        super(name, speed, fuelLevel);
        this.wheels = wheels;
    }

    @Override
    public void move() {
        System.out.printf(
            "%s bergerak di darat dengan %d roda pada kecepatan %d km/jam%n",
            getName(), wheels, getSpeed()
        );
    }

    @Override
    public void calculateFuelConsumption(double distance) {
        double consumption = distance / 10.0;
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