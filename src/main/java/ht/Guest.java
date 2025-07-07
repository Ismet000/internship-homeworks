package ht;

import java.util.Objects;
import java.util.UUID;

public class Guest {
    private final String guestId;
    private final String fiestName;
    private final String lastName;
    private final String email;

    public Guest(String fiestName, String lastName, String email) {
        this.guestId = "G-" + UUID.randomUUID().toString();
        this.fiestName = fiestName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getFiestName() {
        return fiestName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(guestId, guest.guestId) && Objects.equals(fiestName, guest.fiestName) && Objects.equals(lastName, guest.lastName) && Objects.equals(email, guest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, fiestName, lastName, email);
    }


    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + guestId + '\'' +
                ", fiestName='" + fiestName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
