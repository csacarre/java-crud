package modules.user.controllers;

import modules.user.models.User;
import modules.user.services.UserFinder;

public final class UserGetController {
    private final UserFinder finder;

    public UserGetController(UserFinder finder) {
        this.finder = finder;
    }

    public User run(String id) {
        return finder.run(id);
    }
}
