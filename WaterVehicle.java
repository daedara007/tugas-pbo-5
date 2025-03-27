// ini adalah subclass watervehicle yang akan mewarisi dari class utamanya yaitu vehicle dan mengambil interface refuelable
public class WaterVehicle extends Vehicle implements Refuelable {
    // field tambahannya untuk sublass ini
    private boolean hasPropeller;

    // ini adalah constructor untuk attribute yang dibutuhkan dan diambil dari class utama
    public WaterVehicle(String name, int speed, double fuelLevel, boolean hasPropeller, double efficiency) {
        super(name, speed, fuelLevel, efficiency);
        this.hasPropeller = hasPropeller;
    }

    // metode move yang juga diambil dari class utamanya
    // fungsinya untuk menampilkan pesan
    @Override
    public void move() {
        System.out.printf(
            "%s bergerak di air dengan kecepatan %d km/jam, menggunakan baling-baling: %b%n",
            getName(), getSpeed(), hasPropeller
        );
    }

    // metode calculatefuelconsumption yang diambil dari class utamanya
    // fungsinya untuk menghitung konsumsi bahan bakar
    @Override
    public void calculateFuelConsumption(double distance) {
        double efficiency = getEfficiency();
        double consumption = distance / efficiency;

        setFConsumption(consumption); // untuk membatasi jumlah konsumsi bahan bakarnya
        consumption = getFconsumption(); // untuk mengambil kembali hasil batasnya

        double newFuel = getFuelLevel() - consumption;
        setFuelLevel(newFuel); // untuk set nilai akhir fuelnya
        System.out.printf("Konsumsi bahan bakar untuk %.1f km: %.1f%%, Sisa bahan bakar: %.1f%%%n",
        distance, consumption, getFuelLevel()
        );
    }

    // metode yang diambil dari interface refuelable
    // fungsinya untuk mengisi ulang bahan bakar
    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount); // Otomatis dibatasi oleh setter
    }

    // metode yang diambil dari interface refuelable
    // fungsinya untuk mengecek sisa bahan bakar
    @Override
    public boolean isFuelLow() {
        return getFuelLevel() < 20;
    }

    // ini adalah metode untuk cek efficiency yang diambil dari class vehicle
    @Override
    public void CheckEfficiency() {
        double efficiency = getEfficiency();
        System.out.println("Efisiensi kendaraan air ini adalah " + efficiency + " km/%");
    }

    // ini adalah metode untuk stop yang diambil dari class vehicle
    @Override
    public void stop() {
        System.out.printf("%s berhenti di air.%n", getName());
    }
}