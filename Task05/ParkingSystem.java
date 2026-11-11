class ParkingSystem {
    static int ticketCounter = 0;

    int ticketNumber;
    String vehicleNumber;

    ParkingSystem(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        ticketCounter++;
        ticketNumber = ticketCounter;
    }

    static void showTotalTickets() {
        System.out.println("Total Tickets: " + ticketCounter);
    }

    static ParkingSystem createTicket(String vehicle) {
        return new ParkingSystem(vehicle);
    }

    void display() {
        System.out.println("Ticket: " + ticketNumber);
        System.out.println("Vehicle: " + vehicleNumber);
    }

    public static void main(String[] args) {
        ParkingSystem p1 = new ParkingSystem("TN01AB1234");
        ParkingSystem p2 = createTicket("TN02CD5678");

        p1.display();
        p2.display();

        showTotalTickets();

        p1 = null;
        System.out.println("First ticket reference released.");
        System.out.println("Object is eligible for garbage collection.");
    }
}