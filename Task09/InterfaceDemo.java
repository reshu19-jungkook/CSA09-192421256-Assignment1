interface Chargeable {
    double chargingFee(int units);

    default void chargingStatus() {
        System.out.println("Charging facility available");
    }

    static int standardRate() {
        return 12;
    }
}

interface Payable {
    void makePayment(double amount);
}

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);

    void display() {
        System.out.println("Registration: " + regNo);
    }
}

class ElectricCar extends Vehicle
        implements Chargeable, Payable {

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }

    @Override
    public double chargingFee(int units) {
        return units * Chargeable.standardRate();
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment: Rs " + amount);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {

        ElectricCar ev = new ElectricCar("TN03C3");

        ev.display();

        System.out.println(
            "Parking Fee: Rs " + ev.calculateFee(2));

        System.out.println(
            "Charging Fee: Rs " + ev.chargingFee(10));

        ev.chargingStatus();

        ev.makePayment(180);
    }
}