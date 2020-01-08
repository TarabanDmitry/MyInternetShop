package mate.academy.internetshop.dao;

public interface GenericDao<T, I> {
    T create(T t);

    T get(I id);

    T update(T t);

    boolean deleteById(I id);

    boolean delete(T t);
}
