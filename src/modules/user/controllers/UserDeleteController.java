package modules.user.controllers;

import modules.user.services.UserDeleter;

public final class UserDeleteController {
    private final UserDeleter deleter;

    public UserDeleteController(UserDeleter deleter) {
        this.deleter = deleter;
    }

    public void run(String id) {
        deleter.run(id);
    }
}
