package modules.user.repositories;

import modules.user.dtos.FindUserResponse;
import modules.user.exceptions.UserNotExists;
import modules.user.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public final class MySQLUserRepository implements UserRepository {
    private final Connection connection;

    public MySQLUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (id, name, created_at) VALUES ('%s', '%s', '%s')";
        query = String.format(query, user.getId(), user.getName(), user.getCreated_at());

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FindUserResponse search(String id) {
        String query = "SELECT * FROM users WHERE id = '%s'";
        query = String.format(query, id);

        try {
            Statement statement = connection.createStatement();
            ResultSet result    = statement.executeQuery(query);

            if (result.next()) {
                return new FindUserResponse(result.getString("id"), result.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(String id, User user) {
        String query = "UPDATE users SET name = '%s', updated_at = '%s' WHERE id = '%s'";
        query = String.format(query, user.getName(), user.getUpdated_at(), id);

        try {
            Statement statement = connection.createStatement();
            int       result    = statement.executeUpdate(query);

            if (result == 0) {
                throw new UserNotExists(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM users WHERE id = '%s'";
        query = String.format(query, id);

        try {
            Statement statement = connection.createStatement();
            int       result    = statement.executeUpdate(query);

            if (result == 0) {
                throw new UserNotExists(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
