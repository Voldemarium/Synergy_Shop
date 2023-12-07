package view;

import common.AppView;
import data.models.CartItem;
import data.service.ShopService;
import java.util.ArrayList;


public class CartView extends AppView {
    final ShopService shopService;

    public CartView(ShopService shopService) {
        super("Cart", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        if (!cart.isEmpty()) {
            for (CartItem cartItem : cart) {
                System.out.println(cartItem);
            }
        } else {
            System.out.println("Cart is empty");
        }
        System.out.println();
    }
}
