package ht;

import ht2.Bookable;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Room implements Bookable {
    private final String roomId;
    private final RoomType roomType;
    private final BigDecimal nightlyRate;
    private RoomStatus status;
    private boolean booked;


    public Room(RoomType roomType, BigDecimal nightlyRate, RoomStatus status) {
        this.roomId = "R-" + UUID.randomUUID().toString();
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
        this.status = status;
    }


    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public BigDecimal getNightlyRate() {
        return nightlyRate;
    }

    public RoomStatus getStatus() {
        return status;
    }

    //

    @Override
    public boolean isBooked() {
        return booked;
    }

    @Override
    public void setBooked(boolean booked) {
        this.booked =booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId.equals(room.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }


}
