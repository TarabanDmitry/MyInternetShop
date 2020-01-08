package mate.academy.internetshop.model;

import java.math.BigDecimal;

import mate.academy.internetshop.lib.IdGenerator;

public class Item {
    private long id;
    private String name;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = IdGenerator.getItemId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
