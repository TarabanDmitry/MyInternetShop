package mate.academy.internetshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long orderId;
    private List<Item> items;
    private User user;
    private BigDecimal price;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Order(){

    }

    public Order(List<Item> items, User user) {
        this.items = new ArrayList<>(items);
        this.user = user;
    }

    public Long getId() {
        return orderId;
    }

    public void setId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> itemList) {
        this.items = itemList;
    }

    @Override
    public String toString() {
        return "Order{"
                + "orderId=" + orderId
                + ", items=" + items
                + ", user=" + user
                + ", price=" + price
                + '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setItemsList(List items) {
        this.items = items;
    }

}
