package database;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
    private static       Connection connection;
    private static final String     url      = "jdbc:mysql://localhost:3360/java_crud";
    private static final String     user     = "root";
    private static final String     password = "";

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
