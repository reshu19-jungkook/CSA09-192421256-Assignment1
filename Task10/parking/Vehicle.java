package parking;

public class Vehicle {
    private String regNo;
    private String vehicleType;
    private Integer parkingHours;

    public Vehicle(String regNo, String vehicleType, Integer parkingHours) {
        setRegNo(regNo);
        setVehicleType(vehicleType);
        setParkingHours(parkingHours);
    }

    public void setRegNo(String regNo) {
        if (regNo == null || regNo.trim().isEmpty())
            throw new IllegalArgumentException("Invalid registration number");
        this.regNo = regNo;
    }

    public void setVehicleType(String vehicleType) {
        if (vehicleType == null || vehicleType.trim().isEmpty())
            throw new IllegalArgumentException("Invalid vehicle type");
        this.vehicleType = vehicleType;
    }

    public void setParkingHours(Integer parkingHours) {
        if (parkingHours == null || parkingHours <= 0)
            throw new IllegalArgumentException("Invalid parking hours");
        this.parkingHours = parkingHours;
    }

    public void display() {
        System.out.println("Registration: " + regNo);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Parking Hours: " + parkingHours);
    }
}