package mate.academy.internetshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bucket {

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
                + ", items=" + items
                + ", bucketId=" + bucketId
                + ", price=" + price
                + '}';
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
