package exceptions;

public class InputStreamException extends Exception {

    // Parameterless Constructor
    public InputStreamException() {
    }

    // Constructor that accepts a message
    public InputStreamException(String message) {
        super(message);
    }
}
