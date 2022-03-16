package modules.user.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public final class User {
    private final String id;
    private final String name;
    private final String created_at;
    private final String updated_at;

    public User(String id, String name, String created_at, String updated_at) {
        this.id         = id;
        this.name       = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static User create(String id, String name) {
        String formattedDate = formattedCurrentDate();

        return new User(id, name, formattedDate, null);
    }

    public static User update(String name) {
        String formattedDate = formattedCurrentDate();

        return new User(null, name, null, formattedDate);
    }

    private static String formattedCurrentDate() {
        SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp        currentTime = new Timestamp(System.currentTimeMillis());

        return dateFormat.format(currentTime);
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public String getCreated_at() { return created_at; }

    public String getUpdated_at() { return updated_at; }
}
