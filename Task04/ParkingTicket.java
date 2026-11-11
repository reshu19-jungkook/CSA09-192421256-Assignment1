class ParkingTicket {

    String ticketNumber;
    String vehicleNumber;
    String vehicleType;
    int floorNumber;
    int slotNumber;

    // Default constructor
    ParkingTicket() {
        this("T001", "UNKNOWN", "Car", 1, 1);
    }

    // Parameterized constructor
    ParkingTicket(String ticketNumber, String vehicleNumber,
                  String vehicleType, int floorNumber, int slotNumber) {

        this.ticketNumber = ticketNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
    }

    // Display ticket details
    void displayTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Floor Number: " + floorNumber);
        System.out.println("Slot Number: " + slotNumber);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        ParkingTicket t1 = new ParkingTicket();

        ParkingTicket t2 = new ParkingTicket(
                "T002", "TN01AB1234", "Bike", 1, 5);

        t1.displayTicket();
        t2.displayTicket();
    }
}