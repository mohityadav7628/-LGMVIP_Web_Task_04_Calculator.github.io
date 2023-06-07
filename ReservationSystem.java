import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private Map<String, Boolean> seats;

    public ReservationSystem() {
        seats = new HashMap<>();
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 1; i <= 10; i++) {
            seats.put("A" + i, false);
            seats.put("B" + i, false);
            seats.put("C" + i, false);
        }
    }

    private void displaySeats() {
        System.out.println("Current seat status:");
        for (Map.Entry<String, Boolean> entry : seats.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Booked" : "Available"));
        }
    }

    private boolean isSeatAvailable(String seatNumber) {
        return seats.containsKey(seatNumber) && !seats.get(seatNumber);
    }

    private void reserveSeat(String seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            seats.put(seatNumber, true);
            System.out.println("Seat " + seatNumber + " reserved successfully.");
        } else {
            System.out.println("Seat " + seatNumber + " is not available.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("1. Display available seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displaySeats();
                    break;
                case "2":
                    System.out.print("Enter the seat number to reserve: ");
                    String seatNumber = scanner.nextLine();
                    reserveSeat(seatNumber);
                    break;
                case "3":
                    System.out.println("Exiting the reservation system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (!choice.equals("3"));
        scanner.close();
    }

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.run();
    }
}
