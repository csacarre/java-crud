package modules.user.repositories;

import modules.user.dtos.FindUserResponse;
import modules.user.models.User;

public final class InMemoryUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        System.out.println(user);
    }

    @Override
    public FindUserResponse search(final String id) {
        return null;
    }

    @Override
    public void update(String id, User user) {
        System.out.println("Updated user");
    }

    @Override
    public void delete(final String id) {
        System.out.println("Deleted user");
    }
}
