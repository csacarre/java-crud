package modules.user.services;


import modules.user.dtos.FindUserResponse;
import modules.user.exceptions.UserNotExists;
import modules.user.models.User;
import modules.user.repositories.UserRepository;

public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User run(String id) {
        FindUserResponse response = null;

        try {
            response = repository.search(id);

            if (null == response) {
                throw new UserNotExists(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert response != null;
        return User.create(response.id(), response.name());
    }
}
