package ht;

import ht2.Chargeable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Booking implements Chargeable {
    private final String bookingId;
    private final Room room;
    private final Guest guest;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;


    public Booking(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        if(!checkOutDate.isAfter(checkInDate)){
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }
        this.bookingId = "B-" + UUID.randomUUID().toString();
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }


    public String getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public BigDecimal getTotalCost() {
        long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return room.getNightlyRate().multiply(BigDecimal.valueOf(nights));
    }

    @Override
    public BigDecimal getChargeAmount() {
        return getTotalCost();
    }

    @Override
    public String toString() {
        return "Booking[" + bookingId + ", room=" + room.getRoomId() + ", guest=" + guest.getGuestId() +
                ", from=" + checkInDate + ", to=" + checkOutDate + ", total=" + getTotalCost() + "]";
    }
}
