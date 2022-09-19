package exceptions;

public class LocationDoesNotExistsException extends RuntimeException {
    public LocationDoesNotExistsException(String address) {
        System.out.println("Given Location "+ address + "does not exists");
    }
}
