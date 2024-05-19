package common;

public class OpcionNoValidaException extends Exception {
    public OpcionNoValidaException () {
    }
    public OpcionNoValidaException (String message) {
        super(message);
    }
}
