package mate.academy.internetshop.model;

public class Item {
    private Long itemId;
    private String name;
    private Double price;

    public Item(Long itemId) {
        this.itemId = itemId;
    }

    public Item() {
    }

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return itemId;
    }

    public void setId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + itemId
                + ", name='" + name
                + '\''
                + ", price=" + price + '}';
    }
}
