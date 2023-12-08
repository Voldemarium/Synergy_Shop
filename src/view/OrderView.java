package view;

import common.AppView;
import data.models.Order;
import data.service.ShopService;

import java.util.ArrayList;

public class OrderView extends AppView {
    final ShopService shopService;
     public OrderView(ShopService shopService) {
        super("Order view", new ArrayList<>());
         this.shopService = shopService;
     }

    @Override
    public void action() {
        Order order = shopService.getOrder();
        if (order != null) {
            System.out.println(order);
        } else {
            System.out.println("Order is empty");
        }
        System.out.println();
    }
}
