package exception;

public class InvalidBookingDatesException extends Exception{
    public InvalidBookingDatesException() { super(); }
    public InvalidBookingDatesException(String message) { super(message); }
}
