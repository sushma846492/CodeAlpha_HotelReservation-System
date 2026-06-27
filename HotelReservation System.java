import java.io.*;
import java.util.*;

class Hotel {
    String roomType;
    boolean booked;

    Hotel(String roomType) {
        this.roomType = roomType;
        this.booked = false;
    }
}

public class HotelReservation {
    static ArrayList<Hotel> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        rooms.add(new Hotel("Standard"));
        rooms.add(new Hotel("Deluxe"));
        rooms.add(new Hotel("Suite"));

        while (true) {
            System.out.println("\n1.Book Room  2.Cancel Booking  3.View Rooms  4.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    cancelBooking();
                    break;
                case 3:
                    viewRooms();
                    break;
                case 4:
                    return;
            }
        }
    }

    static void bookRoom() throws Exception {
        viewRooms();
        System.out.print("Enter room number (1-3): ");
        int n = sc.nextInt() - 1;

        if (!rooms.get(n).booked) {
            System.out.print("Enter payment amount: ");
            double payment = sc.nextDouble();
            System.out.println("Payment Successful: " + payment);

            rooms.get(n).booked = true;

            FileWriter fw = new FileWriter("booking.txt", true);
            fw.write(rooms.get(n).roomType + " booked\n");
            fw.close();

            System.out.println("Room Booked!");
        } else {
            System.out.println("Room already booked.");
        }
    }

    static void cancelBooking() {
        System.out.print("Enter room number to cancel: ");
        int n = sc.nextInt() - 1;
        rooms.get(n).booked = false;
        System.out.println("Booking Cancelled.");
    }

    static void viewRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println((i + 1) + ". " + rooms.get(i).roomType +
                    " - " + (rooms.get(i).booked ? "Booked" : "Available"));
        }
    }
}