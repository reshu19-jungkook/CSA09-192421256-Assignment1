class Vehicle {
    final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double calculateFee(int minutes) {
        return 0;
    }

    @Override
    public String toString() {
        return "Registration Number: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vehicle &&
               regNo.equals(((Vehicle) obj).regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * 30;
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * 50;
    }
}

public class VehicleOverrideDemo {
    public static void main(String[] args) {
        Vehicle bike = new TwoWheeler("TN01A1");
        Vehicle car = new Car("TN02B2");
        Vehicle ev = new ElectricCar("TN03C3");

        System.out.println(bike);
        System.out.println("Bike Fee: Rs " + bike.calculateFee(130));

        System.out.println(car);
        System.out.println("Car Fee: Rs " + car.calculateFee(130));

        System.out.println(ev);
        System.out.println("Electric Car Fee: Rs " + ev.calculateFee(130));

        System.out.println("Same Registration: " +
            new Car("TN02B2").equals(new ElectricCar("TN02B2")));
    }
}