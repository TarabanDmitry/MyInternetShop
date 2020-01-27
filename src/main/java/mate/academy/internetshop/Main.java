package mate.academy.internetshop;

import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.BucketService;
import mate.academy.internetshop.service.ItemService;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.UserService;

public class Main {

    @Inject
    private static UserService userService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Item phone = new Item("Iphone", 5000.);
        Item phone2 = new Item("Xiaomi", 3000.);
        Item phone3 = new Item("Samsung", 4000.);
        itemService.create(phone);
        itemService.create(phone2);
        itemService.create(phone3);
        System.out.println(phone);
        System.out.println(phone2);
        System.out.println(phone3);

        User buyer = new User();
        buyer.setName("John");
        buyer.setSurname("Black");
        User buyer2 = new User();
        buyer2.setName("Sam");
        buyer2.setSurname("White");
        User buyer3 = new User();
        buyer3.setName("Jack");
        buyer3.setSurname("Brown");
        userService.create(buyer);
        userService.create(buyer2);
        userService.create(buyer3);
        System.out.println(buyer);
        System.out.println(buyer2);
        System.out.println(buyer3);

    }
}
