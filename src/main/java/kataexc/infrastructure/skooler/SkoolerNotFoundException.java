package kataexc.infrastructure.skooler;

public class SkoolerNotFoundException extends RuntimeException {
    public SkoolerNotFoundException(String polygram) {
        super("Skooler " + polygram + " not found");
    }
}
