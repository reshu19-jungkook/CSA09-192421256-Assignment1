import java.time.LocalDate;
import java.time.LocalTime;

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return hours * 30;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return 20;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return hours * 60;
    }

    double calculateFee(int hours, LocalTime entryTime) {
        if (!entryTime.isBefore(LocalTime.of(9, 0))
                && entryTime.isBefore(LocalTime.of(17, 0))) {
            return calculateFee(hours);
        }
        return hours * 30;
    }
}

class VisitorPass {
    LocalDate issueDate;

    VisitorPass(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    boolean isValid(LocalDate currentDate) {
        return issueDate.equals(currentDate);
    }
}

class ParkingFacility {
    String[][] slots;

    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    void allocate(String regNo) {
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[i].length; j++) {
                if (slots[i][j] == null) {
                    slots[i][j] = regNo;
                    System.out.println(regNo +
                            " allocated: Floor " + (i + 1) +
                            ", Slot " + (j + 1));
                    return;
                }
            }
        }

        System.out.println("Parking Full");
    }
}

public class ParkingAdaptation {
    public static void main(String[] args) {

        Vehicle car = new Car("TN01AB1234");
        Vehicle bike = new EBike("TN02CD5678");
        DeliveryVan van = new DeliveryVan("TN03EF9012");

        System.out.println("Car Fee: Rs " + car.calculateFee(2));
        System.out.println("E-Bike Flat Fee: Rs " + bike.calculateFee(2));

        System.out.println("Delivery Van Fee: Rs " +
                van.calculateFee(2, LocalTime.of(10, 0)));

        VisitorPass pass = new VisitorPass(LocalDate.now());
        System.out.println("Visitor Pass Valid: " +
                pass.isValid(LocalDate.now()));

        ParkingFacility parking =
                new ParkingFacility(new int[]{2, 3, 2, 4, 3});

        parking.allocate("TN01AB1234");
        parking.allocate("TN02CD5678");
        parking.allocate("TN03EF9012");
    }
}