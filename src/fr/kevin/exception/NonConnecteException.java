package fr.kevin.exception;

public class NonConnecteException extends Exception {

    public NonConnecteException() {
        super();
    }

    public NonConnecteException(String message) {
        super(message);
    }

    public NonConnecteException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
