// ini adalah subclass landvehicle yang mewarisi class vehicle dan mengambil interface refuelable
public class LandVehicle extends Vehicle implements Refuelable {
    // Field tambahan untuk wheels class landvehicle
    private int wheels;

    // ini adalah constructor untuk field yang dibutuhkan
    public LandVehicle(String name, int speed, double fuelLevel, int wheels, double efficiency) {
        super(name, speed, fuelLevel, efficiency);
        this.wheels = wheels;
    }

    // ini adalah metode move yang diambil dari metode abstrak class utamanya
    // fungsinya untuk menampilkan pesan
    @Override
    public void move() {
        System.out.printf(
            "%s bergerak di darat dengan %d roda pada kecepatan %d km/jam%n",
            getName(), wheels, getSpeed()
        );
    }

    // ini adalah metode calculatefuelconsumption yang diambil dari metode abstrak class utamanya
    // fungisnya untuk menghitung jumlah komsumsi bahan bakarnya
    @Override
    public void calculateFuelConsumption(double distance) {
        double efficiency = getEfficiency();
        double consumption = distance / efficiency;

        setFConsumption(consumption); // berfungsi untuk membatasi consumption agar tidak melebih 100% atau negatif
        consumption = getFconsumption(); // ini berfungsi mengambil kembali hasil batasnya dan di assign kembali ke variabel consumpotion

        double newFuel = getFuelLevel() - consumption;
        setFuelLevel(newFuel); // untuk set nilai akhir fuelnya

        System.out.printf("Konsumsi bahan bakar untuk %.1f km: %.1f%%, Sisa bahan bakar: %.1f%%%n",
        distance, consumption, getFuelLevel()
        );
    }

    // ini adalah metode refuel yang diambil dari interface refuelable
    // fungsinya
    @Override
    public void refuel(double amount) {
        setFuelLevel(getFuelLevel() + amount); // Otomatis dibatasi oleh setter
    }

    // ini adalah metode isfuellow yang diambil dari interface refuelable
    // fungsinya untuk cek sisa bahan bakar
    @Override
    public boolean isFuelLow() {
        return getFuelLevel() < 20;
    }

    // ini adlaah metode untuk mengecek efficiency yang diambil dari class utamanya yaitu vehicle
    @Override
    public void CheckEfficiency(){
        double efficiency = getEfficiency();
        System.out.println("Efisiensi kendaraan ini adalah " + efficiency + " km/%");
    }

    // ini adalah metode stop yang diambil dari class vehicle
    @Override
    public void stop() {
        System.out.printf ("%s berhenti di darat.%n", getName());
    }
}