package ht;

import exception.InvalidBookingDatesException;
import exception.RoomUnavailableException;
import ht2.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        Hotel hotel = new Hotel("Luxury Stay");
//
//        Room r1 = new Room(RoomType.STANDARD, new BigDecimal("50.00"), RoomStatus.ACTIVE);
//        Room r2 = new Room(RoomType.DELUXE, new BigDecimal("80.00"), RoomStatus.ACTIVE);
//        Room r3 = new Room(RoomType.SUITE, new BigDecimal("120.00"), RoomStatus.UNAVAILABLE);
//
//        hotel.addRoom(r1);
//        hotel.addRoom(r2);
//        hotel.addRoom(r3);
//
//        Guest g1 = new Guest("Alice", "Smith", "alice@example.com");
//        Guest g2 = new Guest("Bob", "Johnson", "bob@example.com");
//
//        LocalDate today = LocalDate.now();
//
//        hotel.makeBooking(r1, g1, today, today.plusDays(2));
//        hotel.makeBooking(r2, g2, today.plusDays(1), today.plusDays(3));
//
//        try {
//            hotel.makeBooking(r1, g2, today.plusDays(1), today.plusDays(2));
//        } catch (IllegalStateException e) {
//            System.out.println("Booking failed: " + e.getMessage());
//        }
//
//        System.out.println("Available Rooms from today to +2 days:");
//        hotel.getAvailableRooms(today, today.plusDays(2)).forEach(System.out::println);
//
//        System.out.println("All Rooms:");
//        hotel.printAllRooms();
//
//        System.out.println("All Bookings:");
//        hotel.printAllBookings();


        Hotel hotel = new Hotel("Luxury Stay");


        Room r1 = new Room(RoomType.STANDARD, new BigDecimal("50.00"), RoomStatus.ACTIVE);
        Room r2 = new Room(RoomType.DELUXE, new BigDecimal("80.00"), RoomStatus.ACTIVE);
        Room r3 = new Room(RoomType.SUITE, new BigDecimal("120.00"), RoomStatus.UNAVAILABLE);

        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);

        Guest g1 = new Guest("Alice", "Smith", "alice@example.com");
        Guest g2 = new Guest("Bob", "Johnson", "bob@example.com");

        SpaTreatment spa = new SpaTreatment("Aromatherapy", new BigDecimal("30.00"), 60);
        LaundryService laundry = new LaundryService("Standard Laundry", new BigDecimal("10.00"), 5);

        hotel.addService(spa);
        hotel.addService(laundry);

        FrontDeskStaff frontDesk = new FrontDeskStaff("Elena");
        HousekeepingStaff housekeeper = new HousekeepingStaff("Mario");

        hotel.addStaff(frontDesk);
        hotel.addStaff(housekeeper);

        System.out.println("\n--- Staff Duties ---");
        frontDesk.performDuties();
        frontDesk.greet();
        frontDesk.greet(g1.getFiestName());

        housekeeper.performDuties();

        LocalDate today = LocalDate.now();

        try {
            hotel.makeBooking(r1, g1, today, today.plusDays(2));
            frontDesk.checkInGuest(g1, r1);
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 1 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(r2, g2, today.plusDays(1), today.plusDays(3));
            frontDesk.checkInGuest(g2, r2);
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 2 failed: " + e.getMessage());
        }

        try {
            hotel.makeBooking(r1, g2, today.plusDays(1), today.plusDays(2)); // Overlapping booking
            frontDesk.checkInGuest(g2, r1); // Only runs if booking succeeds
        } catch (RoomUnavailableException | InvalidBookingDatesException e) {
            System.out.println("Booking 3 failed: " + e.getMessage());
        }

        housekeeper.cleanRoom(r1);
        housekeeper.cleanRoom(r2);
        housekeeper.reportIssue(r2, "Broken air conditioner");

        System.out.println("\n--- Available Rooms ---");
        hotel.getAvailableRooms(today, today.plusDays(2)).forEach(System.out::println);

        System.out.println("\n--- All Rooms ---");
        hotel.printAllRooms();

        System.out.println("\n--- All Bookings ---");
        hotel.printAllBookings();

        System.out.println("\n--- All Services ---");
        hotel.printAllServices();

        System.out.println("\n--- All Staff ---");
        hotel.printAllStaff();


        System.out.println("\n--- Front Desk Log ---");
        frontDesk.printInteractionLog();

        System.out.println("\n--- Housekeeping Logs ---");
        housekeeper.printCleanedRooms();
        housekeeper.printMaintenanceReports();

        System.out.println("\n--- Lookup Booking by Guest ---");
        frontDesk.lookupBooking(hotel.getBookings(), g1.getGuestId());

        System.out.println("\n--- Financial Summary ---");
        List<Chargeable> items = new ArrayList<>();
        items.add(spa);
        items.add(laundry);
        items.addAll(hotel.getBookings());

        BigDecimal total = hotel.calculateTotalCharges(items);
        System.out.println("Total Charges for all bookings & services: " + total);

    }
}