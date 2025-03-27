// ini adalah class abstract vehicle yang akan diwariskan ke tiap subclassnya
public abstract class Vehicle {
    // ini adalah field atau atrributenya yang private semuanya
    private String name;
    private int speed;
    private double fuelLevel;
    private double efficiency;
    private double Fconsumption;

    // ini adalah contructor menginisiasi semua field
    public Vehicle(String name, int speed, double fuelLevel, double efficiency) {
        this.name = name;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
        this.efficiency = efficiency;
    }

    // Getter karena fieldnya private sehingga bisa diakses oleh kelas lain nantinya
    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public double getFuelLevel() { return fuelLevel; }
    public double getEfficiency() { return efficiency; }
    public double getFconsumption() { return Fconsumption; }

    // Protected setter untuk fuelLevel
    protected void setFuelLevel(double fuelLevel) {
        this.fuelLevel = Math.min(Math.max(fuelLevel, 0), 100); // Pastikan tidak negatif
    }

    protected void setFConsumption(double Fconsumption) {
        this.Fconsumption = Math.min(Math.max(Fconsumption, 0), 100); // Pastikan tidak negatif
    }

    // Metode abstrak untuk move dan caclculatefuelconsumption
    public abstract void move();
    public abstract void calculateFuelConsumption(double distance);
    // metode tambahan untuk mengecek efficiency
    public abstract void CheckEfficiency();
    // metode tambahan untuk stop
    public abstract void stop();
}