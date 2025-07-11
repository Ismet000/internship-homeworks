package ht2;

import java.util.UUID;

public abstract class Staff {
    private final String staffId;
    private final String name;
    private final String department;

    public Staff(String name, String department) {
        this.staffId = "ST-" + UUID.randomUUID();
        this.name = name;
        this.department = department;
    }

    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public abstract void performDuties();

    public void greet() {
        System.out.println("Hello, welcome to our hotel.");
    }

    public void greet(String guestName) {
        System.out.println("Hello, " + guestName + ". Welcome!");
    }
}