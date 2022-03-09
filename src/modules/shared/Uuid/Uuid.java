package modules.shared.Uuid;

import java.util.UUID;
import java.util.regex.Pattern;

public final class Uuid {
    private final String value;

    public Uuid(String value) throws InvalidUuidException {
        this.ensureIsValidUuid(value);

        this.value = value;
    }

    private void ensureIsValidUuid(String value) throws InvalidUuidException {
        Pattern uuidPattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

        if (!uuidPattern.matcher(value).matches()) {
            throw new InvalidUuidException(value);
        }
    }

    public static Uuid random() throws InvalidUuidException {
        String uuid = UUID.randomUUID().toString();

        return new Uuid(uuid);
    }

    @Override
    public String toString() { return this.value; }
}
