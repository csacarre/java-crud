package modules.user.controllers;

import modules.user.dtos.CreateUserRequest;
import modules.user.services.UserCreator;

public final class UserPostController {
    private final UserCreator creator;

    public UserPostController(UserCreator creator) {
        this.creator = creator;
    }

    public void run(CreateUserRequest request) {
        String id   = request.id();
        String name = request.name();

        creator.run(id, name);
    }
}
