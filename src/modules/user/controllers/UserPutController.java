package modules.user.controllers;

import modules.user.dtos.UpdateNameRequest;
import modules.user.services.UserUpdater;

public final class UserPutController {
    private final UserUpdater updater;

    public UserPutController(UserUpdater updater) {
        this.updater = updater;
    }

    public void run(String id, UpdateNameRequest request) {
        String name = request.getName();

        updater.run(id, name);
    }
}
