package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.exceptions.AuthenticationException;
import mate.academy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {

    List<User> getAll();

    User login(String login, String password) throws AuthenticationException;

    Optional<User> getByToken(String token);

    Optional<User> findByLogin(String login);
}
