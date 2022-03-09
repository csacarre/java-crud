package modules.user.exceptions;

public final class UserNotExists extends Exception {
    public UserNotExists(String value) {
        super(String.format("The user with id <%s> not exists", value));
    }
}
