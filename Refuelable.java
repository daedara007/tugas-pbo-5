// ini adalah interface refuelable
public interface Refuelable {
    // ini adalah metode untuk refuel yang akan digunakan oleh class yang menggunakan interface ini
    void refuel(double amount);
    // ini adalah metode untuk isfuellow yanng akan digunakan oleh class yang menggunakan interface ini
    boolean isFuelLow();
}