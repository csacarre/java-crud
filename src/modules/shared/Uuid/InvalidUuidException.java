package modules.shared.Uuid;

public final class InvalidUuidException extends Exception {
    public InvalidUuidException(String value) {
        super(String.format("The uuid <%s> is not a valid uuid", value));
    }
}
