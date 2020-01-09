package mate.academy.internetshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bucket {

    private User user;
    private Long userId;
    private List<Item> items;
    private Long bucketId;
    private BigDecimal price;

    public Bucket() {
        items = new ArrayList<>();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bucket{"
                + "user=" + user
                + ", items=" + items
                + ", bucketId=" + bucketId
                + ", price=" + price
                + '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return bucketId;
    }

    public void setId(Long bucketId) {
        this.bucketId = bucketId;
    }

}
