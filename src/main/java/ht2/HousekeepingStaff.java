package ht2;

import ht.Room;

import java.util.ArrayList;
import java.util.List;

public class HousekeepingStaff extends Staff {
    private final List<String> cleanedRoomsToday;
    private final List<String> maintenanceReports;

    public HousekeepingStaff(String name) {
        super(name, "Housekeeping");
        this.cleanedRoomsToday = new ArrayList<>();
        this.maintenanceReports = new ArrayList<>();
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is cleaning assigned rooms.");
    }

    public void cleanRoom(Room room) {
        cleanedRoomsToday.add(room.getRoomId());
        System.out.println(getName() + " cleaned room " + room.getRoomId());
    }

    public void reportIssue(Room room, String issueDescription) {
        String report = "Room " + room.getRoomId() + ": " + issueDescription;
        maintenanceReports.add(report);
        System.out.println(getName() + " reported issue: " + report);
    }

    public void printCleanedRooms() {
        System.out.println("Cleaned Rooms Today by " + getName() + ":");
        cleanedRoomsToday.forEach(System.out::println);
    }

    public void printMaintenanceReports() {
        System.out.println("Maintenance Reports by " + getName() + ":");
        maintenanceReports.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "HousekeepingStaff[id=" + getStaffId() + ", name=" + getName() + "]";
    }
}
