// ini adalah class utama vehicledemo
public class VehicleDemo {
    public static void main(String[] args) {
        // ini adalah arraynya dengan format ("nama kendaraan", "kecepatan kendaraan", "jumlah bahan bakar", "jumlah roda untuk kendaraan darat atau true or false untuk kendaraan air","efisiensi")
        Vehicle[] vehicles = new Vehicle[3];
        // array untuk kendaraan pertama
        vehicles[0] = new LandVehicle("honda civic", 100, 100, 4, 15);
        // array untuk kendaraan kedua
        vehicles[1] = new WaterVehicle("Kapal lawd", 60, 100, true, 7);
        // array untuk kendaraan ketiga
        vehicles[2] = new LandVehicle("Ducati Panigale V4", 299, 100, 2,13);

        // ini adalah perulangan untuk memanggil move, calculatefuelconsumption, dan checkefficiency
        for (Vehicle vehicle : vehicles) {
            // untuk memanggil metode move
            vehicle.move();
            // untuk memanggil metode calculate fuelconsumption
            vehicle.calculateFuelConsumption(200);
            // untuk memanggil metode efisiensi kendaraan ini
            vehicle.CheckEfficiency();
            // untuk memanggil metode stop
            vehicle.stop();

            // percabangan berfungsi untuk cek sisa bahan bakar dan mengisi bahan bakar jika dibawah batas yang ditentukan
            if (vehicle instanceof Refuelable) {
                Refuelable refuelable = (Refuelable) vehicle;
                if (refuelable.isFuelLow()) {
                    System.out.println("Bahan bakar rendah! Mengisi bahan bakar...");
                    refuelable.refuel(40);

                    System.out.printf("Bahan bakar %s: %.1f%%%n", 
                    vehicle.getName(), vehicle.getFuelLevel());
                }
            }
            System.out.println("");
        }
    }
}