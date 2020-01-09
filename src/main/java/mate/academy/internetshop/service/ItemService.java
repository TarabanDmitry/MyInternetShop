package mate.academy.internetshop.service;

import java.util.Optional;
import mate.academy.internetshop.model.Item;

public interface ItemService {

    Item create(Item item);

    Optional<Item> get(Long id);

    Item update(Item item);

    void deleteById(Long id);

    void delete(Item item);
}
