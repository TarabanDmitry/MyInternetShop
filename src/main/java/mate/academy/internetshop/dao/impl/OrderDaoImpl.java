package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.lib.IdGenerator;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

@Dao
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order create(Order order) {
        order.setId(IdGenerator.getOrderId());
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> get(Long orderId) {
        return Storage.orders
                .stream()
                .filter(o -> o.getId().equals(orderId))
                .findFirst();
    }

    @Override
    public Order update(Order order) {
        Order old = Storage.orders
                .stream()
                .filter(o -> o.getId().equals(order.getId()))
                .findFirst().orElseThrow(() ->
                        new NoSuchElementException("Can't update order with id "
                                + order.getId()));
        int index = Storage.orders.indexOf(old);
        return Storage.orders.set(index, order);
    }

    @Override
    public boolean deleteById(Long orderId) {
        Order old = Storage.orders
                .stream()
                .filter(o -> o.getId().equals(orderId))
                .findFirst().orElseThrow(() ->
                        new NoSuchElementException("Can't delete order with id " + orderId));
        return delete(old);
    }

    @Override
    public boolean delete(Order order) {
        return Storage.orders.remove(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return Storage.orders;
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return Storage.orders
                .stream().filter(u -> u.getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

}
