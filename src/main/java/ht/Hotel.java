package ht;

import exception.InvalidBookingDatesException;
import exception.RoomUnavailableException;
import ht2.Chargeable;
import ht2.HotelService;
import ht2.Staff;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Booking> bookings;

    private final List<HotelService> services = new ArrayList<>();
    private final List<Staff> staffList = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public void makeBooking(Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) throws InvalidBookingDatesException, RoomUnavailableException {
        if(room.getStatus() != RoomStatus.ACTIVE){
            throw new InvalidBookingDatesException("Room is not available for booking (inactive).");
        }
        List<Booking> overlapping = bookings.stream()
                .filter(b -> b.getRoom().equals(room))
                .filter(b -> !(checkOut.isBefore(b.getCheckInDate()) || checkIn.isAfter(b.getCheckOutDate().minusDays(1))))
                .toList();
        if(!overlapping.isEmpty()){
            throw new RoomUnavailableException("Room is not available for the selected dates");
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

    //


    public void addService(HotelService service) {
        services.add(service);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void printAllServices() {
        services.forEach(System.out::println);
    }

    public void printAllStaff() {
        staffList.forEach(System.out::println);
    }

    public BigDecimal calculateTotalCharges(List<Chargeable> items) {
        return items.stream().map(Chargeable::getChargeAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings); // return a copy for safety
    }

}
