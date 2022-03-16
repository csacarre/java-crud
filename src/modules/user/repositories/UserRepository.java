package modules.user.repositories;

import modules.user.dtos.FindUserResponse;
import modules.user.models.User;

public interface UserRepository {
    void save(User user);

    FindUserResponse search(String id);

    void update(String id, User user);

    void delete(String id);
}
