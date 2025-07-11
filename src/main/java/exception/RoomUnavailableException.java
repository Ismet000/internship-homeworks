package exception;

public class RoomUnavailableException extends Exception{
    public RoomUnavailableException() { super(); }
    public RoomUnavailableException(String message) { super(message); }
}
