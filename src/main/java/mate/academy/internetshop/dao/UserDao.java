package mate.academy.internetshop.dao;

import java.util.List;
import mate.academy.internetshop.model.User;

public interface UserDao extends GenericDao<User, Long> {

    public List<User> getAll();
}
