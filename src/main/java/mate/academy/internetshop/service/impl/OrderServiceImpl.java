package mate.academy.internetshop.service.impl;

import java.util.List;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Override
    public Order get(Long id) {
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
        return user.getUserOrders();
    }

    @Override
    public Order completeOrder(List items, User user) {
        Order newOrder = new Order();
        newOrder.setItemsList(items);
        newOrder.setUser(user);
        orderDao.create(newOrder);
        return newOrder;
    }
}
