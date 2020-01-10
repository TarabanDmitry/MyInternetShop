package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private static OrderDao orderDao;

    @Override
    public Order create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Optional<Order> get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    public List getUserOrders(User user) {
        return Storage.orders
                .stream().filter(u -> u.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public Order completeOrder(List items, User user) {
        Order newOrder = new Order(items, user.getId());
        newOrder.setItemsList(items);
        newOrder.setUser(user);
        orderDao.create(newOrder);
        return newOrder;
    }
}
