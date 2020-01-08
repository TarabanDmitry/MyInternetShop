package mate.academy.internetshop.model;

import java.util.List;

import mate.academy.internetshop.lib.IdGenerator;

public class Bucket {

    private Long id;
    List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = IdGenerator.getBucketId();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
