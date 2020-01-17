package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {

    List<User> getAll();

    Optional<User> getByToken(String token);

    Optional<User> findByLogin(String login);
}
