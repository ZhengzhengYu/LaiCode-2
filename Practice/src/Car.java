public class Car {
    public static String brand;
    public static String model;
    public final int year;
    public int mileage;
    public String plateNumber;
    public String color;
    public String ownersName;

    public Car(int year) {
        this.year = year;
    }

    public void Drive() {

    }

    public void changeOwner(String name) {
        ownersName = name;
    }
}
