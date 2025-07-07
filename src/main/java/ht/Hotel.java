package ht;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Booking> bookings;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public void makeBooking(Room room, Guest guest, LocalDate checkIn, LocalDate checkOut){
        if(room.getStatus() != RoomStatus.ACTIVE){
            throw new IllegalStateException("Room is not available for booking (inactive).");
        }
        List<Booking> overlapping = bookings.stream()
                .filter(b -> b.getRoom().equals(room))
                .filter(b -> !(checkOut.isBefore(b.getCheckInDate()) || checkIn.isAfter(b.getCheckOutDate().minusDays(1))))
                .toList();
        if(!overlapping.isEmpty()){
            throw new IllegalStateException("Room is not available for the selected dates");
        }
        Booking booking = new Booking(room, guest, checkIn, checkOut);

        bookings.add(booking);
    }

    public void cancelBooking(String bookingId){
        bookings.removeIf(b -> b.getBookingId().equals(bookingId));
    }

    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut){
        return rooms.stream()
                .filter(room -> room.getStatus() == RoomStatus.ACTIVE)
                .filter(room -> bookings.stream().noneMatch(b -> b.getRoom().equals(room) &&
                        !(checkOut.isBefore(b.getCheckInDate()) || checkIn.isAfter(b.getCheckOutDate().minusDays(1)))))
                .collect(Collectors.toList());
    }

    public void printAllRooms(){
        rooms.forEach(System.out::println);
    }


    public void printAllBookings(){
        bookings.forEach(System.out::println);
    }

}
