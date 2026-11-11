package parking;

public class Ticket {
    private Vehicle vehicle;
    private Integer ticketNumber;

    public Ticket(Vehicle vehicle, Integer ticketNumber) {
        if (vehicle == null || ticketNumber == null || ticketNumber <= 0)
            throw new IllegalArgumentException("Invalid ticket details");

        this.vehicle = vehicle;
        this.ticketNumber = ticketNumber;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNumber);
        vehicle.display();
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1234", "Car", 3);

        Ticket t = new Ticket(v, 101);
        t.displayTicket();
    }
}