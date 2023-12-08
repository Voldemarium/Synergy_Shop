package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;

public class CartCleanView extends AppView {
    final ShopService shopService;

    public CartCleanView(ShopService shopService) {
        super("Shopping cart clean", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        final boolean res = shopService.cartClean();
        if (res) {
            System.out.println("The cart has been cleaned");
        } else {
            System.out.println("The cart is empty");
        }
        System.out.println();
    }
}
