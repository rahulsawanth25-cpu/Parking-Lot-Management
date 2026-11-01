
import java.util.Scanner;

public class Main {

    static final int TOTAL_SLOTS = 5;
    static String[] parking = new String[TOTAL_SLOTS];
    static int parkedCount = 0;

    // Vehicle Entry
    static void vehicleEntry(Scanner sc) {

        if (parkedCount == TOTAL_SLOTS) {
            System.out.println("Parking is FULL!");
            return;
        }

        System.out.print("Enter vehicle number: ");
        String vehicle = sc.nextLine().trim();

        if (vehicle.isEmpty()) {
            System.out.println("Vehicle number cannot be empty!");
            return;
        }

        // Check duplicate vehicle
        for (int i = 0; i < parkedCount; i++) {
            if (parking[i].equalsIgnoreCase(vehicle)) {
                System.out.println("Vehicle is already parked!");
                return;
            }
        }

        parking[parkedCount] = vehicle;
        parkedCount++;

        System.out.println("Vehicle parked successfully!");
    }

    // Vehicle Exit
    static void vehicleExit(Scanner sc) {

        System.out.print("Enter vehicle number to exit: ");
        String vehicle = sc.nextLine().trim();

        for (int i = 0; i < parkedCount; i++) {

            if (parking[i].equalsIgnoreCase(vehicle)) {

                for (int j = i; j < parkedCount - 1; j++) {
                    parking[j] = parking[j + 1];
                }

                parkedCount--;
                parking[parkedCount] = null;

                System.out.println("Vehicle exited successfully!");
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Display Parked Vehicles
    static void displayVehicles() {

        if (parkedCount == 0) {
            System.out.println("No vehicles are parked.");
            return;
        }

        System.out.println("\nParked Vehicles:");

        for (int i = 0; i < parkedCount; i++) {
            System.out.println((i + 1) + ". " + parking[i]);
        }
    }

    // Available Slots
    static void availableSlots() {

        System.out.println("Available Slots: "
                + (TOTAL_SLOTS - parkedCount));
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== PARKING LOT MANAGEMENT =====");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Display Parked Vehicles");
            System.out.println("4. Available Slots");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    vehicleEntry(sc);
                    break;

                case 2:
                    vehicleExit(sc);
                    break;

                case 3:
                    displayVehicles();
                    break;

                case 4:
                    availableSlots();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Parking Lot Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
