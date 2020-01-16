package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.lib.IdGenerator;
import mate.academy.internetshop.model.User;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {
        user.setId(IdGenerator.getUserId());
        Storage.users.add(user);
        return user;
    }

    @Override
    public Optional<User> get(Long userId) {
        return Storage.users
                .stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();
    }

    @Override
    public User update(User user) {
        User old = Storage.users
                .stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't update user with id "
                                + user.getId()));
        int index = Storage.users.indexOf(old);
        return Storage.users.set(index, user);
    }

    @Override
    public boolean deleteById(Long userId) {
        User old = Storage.users
                .stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't delete user with id " + userId));
        return delete(old);
    }

    @Override
    public boolean delete(User user) {
        return Storage.users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }
}

