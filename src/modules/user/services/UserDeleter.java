package modules.user.services;

import modules.user.repositories.UserRepository;

public final class UserDeleter {
    UserRepository repository;

    public UserDeleter(UserRepository repository) {
        this.repository = repository;
    }

    public void run(String id) {
        this.repository.delete(id);
    }
}
