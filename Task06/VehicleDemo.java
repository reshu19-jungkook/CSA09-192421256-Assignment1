class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
        System.out.println("Vehicle Constructor");
    }

    void display() {
        System.out.println("Registration Number: " + regNo);
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
        System.out.println("TwoWheeler Constructor");
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
        System.out.println("Car Constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo) {
        super(regNo);
        System.out.println("ElectricCar Constructor");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {

        System.out.println("Creating TwoWheeler:");
        TwoWheeler bike = new TwoWheeler("TN01AB1234");
        bike.display();

        System.out.println("\nCreating ElectricCar:");
        ElectricCar ev = new ElectricCar("TN02CD5678");
        ev.display();
    }
}