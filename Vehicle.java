public abstract class Vehicle {
    private String name;
    private int speed;
    private double fuelLevel;

    public Vehicle(String name, int speed, double fuelLevel) {
        this.name = name;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
    }

    // Getter
    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public double getFuelLevel() { return fuelLevel; }

    // Protected setter untuk fuelLevel
    protected void setFuelLevel(double fuelLevel) {
        this.fuelLevel = Math.max(fuelLevel, 0); // Pastikan tidak negatif
    }

    // Metode abstrak (diubah ke void)
    public abstract void move();
    public abstract void calculateFuelConsumption(double distance);
}