import java.util.HashMap;

class ParkingTest {
    static HashMap<String, String> vehicles = new HashMap<>();

    static void enterVehicle(String regNo, String type) {
        if (type == null || 
            !(type.equals("Car") || type.equals("Bike"))) {
            System.out.println("Invalid vehicle type");
            return;
        }

        if (vehicles.containsKey(regNo)) {
            System.out.println("Duplicate registration");
            return;
        }

        vehicles.put(regNo, type);
        System.out.println(regNo + " entered successfully");
    }

    static void exitVehicle(String regNo) {
        if (vehicles.remove(regNo) != null)
            System.out.println(regNo + " exited successfully");
        else
            System.out.println("Invalid registration");
    }

    public static void main(String[] args) {
        enterVehicle("TN01AB1234", "Car");
        enterVehicle("TN02CD5678", "Bike");
        enterVehicle("TN01AB1234", "Car");
        enterVehicle("TN03EF9012", "Bus");

        exitVehicle("TN01AB1234");
        exitVehicle("TN99XX0000");

        System.out.println("Remaining Vehicles: " + vehicles.size());
    }
}