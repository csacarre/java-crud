package app;

import database.DatabaseConnection;
import modules.shared.Uuid.InvalidUuidException;
import modules.shared.Uuid.Uuid;
import modules.user.controllers.UserDeleteController;
import modules.user.controllers.UserGetController;
import modules.user.controllers.UserPostController;
import modules.user.controllers.UserPutController;
import modules.user.dtos.CreateUserRequest;
import modules.user.dtos.UpdateNameRequest;
import modules.user.models.User;
import modules.user.repositories.MySQLUserRepository;
import modules.user.services.UserCreator;
import modules.user.services.UserDeleter;
import modules.user.services.UserFinder;
import modules.user.services.UserUpdater;

import java.sql.Connection;

public final class App {
    static Connection database = DatabaseConnection.connect();
    static String     id;
    static String     name;

    public static void main(String[] args) throws InvalidUuidException {
        id   = Uuid.random().toString();
        name = "David";

        createUser();
        findUser();
        updateUser();
        findUser();
        deleteUser();
    }

    private static void createUser() {
        new UserPostController(new UserCreator(new MySQLUserRepository(database))).run(new CreateUserRequest(id, name));
        System.out.println("\nCreate user");
    }

    private static void findUser() {
        User user = new UserGetController(new UserFinder(new MySQLUserRepository(database))).run(id);

        System.out.println(user.getId() + "\n" + user.getName());
    }

    private static void updateUser() {
        String newName = "Alfredo";

        new UserPutController(new UserUpdater(new MySQLUserRepository(database))).run(
            id,
            new UpdateNameRequest(newName)
        );

        System.out.println("\nUpdate user");
    }

    private static void deleteUser() {
        new UserDeleteController(new UserDeleter(new MySQLUserRepository(database))).run(id);

        System.out.println("\nDelete user");
    }
}
