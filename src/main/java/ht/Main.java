package ht;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Luxury Stay");

        Room r1 = new Room(RoomType.STANDARD, new BigDecimal("50.00"), RoomStatus.ACTIVE);
        Room r2 = new Room(RoomType.DELUXE, new BigDecimal("80.00"), RoomStatus.ACTIVE);
        Room r3 = new Room(RoomType.SUITE, new BigDecimal("120.00"), RoomStatus.UNAVAILABLE);

        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);

        Guest g1 = new Guest("Alice", "Smith", "alice@example.com");
        Guest g2 = new Guest("Bob", "Johnson", "bob@example.com");

        LocalDate today = LocalDate.now();

        hotel.makeBooking(r1, g1, today, today.plusDays(2));
        hotel.makeBooking(r2, g2, today.plusDays(1), today.plusDays(3));

        try {
            hotel.makeBooking(r1, g2, today.plusDays(1), today.plusDays(2));
        } catch (IllegalStateException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        System.out.println("Available Rooms from today to +2 days:");
        hotel.getAvailableRooms(today, today.plusDays(2)).forEach(System.out::println);

        System.out.println("All Rooms:");
        hotel.printAllRooms();

        System.out.println("All Bookings:");
        hotel.printAllBookings();
    }
}