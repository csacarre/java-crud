package modules.user.services;

import modules.user.models.User;
import modules.user.repositories.UserRepository;

public final class UserUpdater {
    UserRepository repository;

    public UserUpdater(UserRepository repository) {
        this.repository = repository;
    }

    public void run(String id, String name) {
        User user = User.update(name);

        repository.update(id, user);
    }
}
