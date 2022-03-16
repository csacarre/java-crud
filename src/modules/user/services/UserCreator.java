package modules.user.services;

import modules.user.models.User;
import modules.user.repositories.UserRepository;

public final class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void run(String id, String name) {
        User user = User.create(id, name);

        repository.save(user);
    }
}
