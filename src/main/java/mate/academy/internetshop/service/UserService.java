package mate.academy.internetshop.service;

import mate.academy.internetshop.model.User;

public interface UserService {
    User create(User user);

    User get(Long userId);

    User update(User user);

    boolean deleteById(Long userId);

    boolean delete(User user);
}
