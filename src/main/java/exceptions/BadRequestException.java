package exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        System.out.println("Bad Request Exception");
    }
}
