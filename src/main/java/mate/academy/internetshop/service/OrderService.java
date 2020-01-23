package mate.academy.internetshop.service;

import java.util.List;

import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public interface OrderService {

    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void deleteById(Long id);

    void delete(Order order);

    List<Order> getUserOrders(User user);

    Order completeOrder(List items, User user);

    List<Order> getAll();
}
