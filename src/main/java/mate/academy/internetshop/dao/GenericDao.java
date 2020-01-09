package mate.academy.internetshop.dao;

import java.util.Optional;

public interface GenericDao<T, I> {
    T create(T t);

    Optional<T> get(I id);

    T update(T t);

    boolean deleteById(I id);

    boolean delete(T t);
}
