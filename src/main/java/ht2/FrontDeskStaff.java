package ht2;

import ht.Booking;
import ht.Guest;
import ht.Room;

import java.util.ArrayList;
import java.util.List;

public class FrontDeskStaff extends Staff {
    private final List<String> interactionLog;

    public FrontDeskStaff(String name) {
        super(name, "Front Desk");
        this.interactionLog = new ArrayList<>();
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is assisting guests at the front desk.");
    }

    public void checkInGuest(Guest guest, Room room) {
        String logEntry = "Checked in " + guest.getFiestName() + " to room " + room.getRoomId();
        interactionLog.add(logEntry);
        System.out.println(logEntry);
    }

    public void checkOutGuest(Guest guest, Room room) {
        String logEntry = "Checked out " + guest.getFiestName() + " from room " + room.getRoomId();
        interactionLog.add(logEntry);
        System.out.println(logEntry);
    }

    public void printInteractionLog() {
        System.out.println("Interaction Log for " + getName() + ":");
        interactionLog.forEach(System.out::println);
    }

    public void lookupBooking(List<Booking> bookings, String guestId) {
        System.out.println("Bookings for guest ID: " + guestId);
        bookings.stream()
                .filter(b -> b.getGuest().getGuestId().equals(guestId))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "FrontDeskStaff[id=" + getStaffId() + ", name=" + getName() + "]";
    }
}