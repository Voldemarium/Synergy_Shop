package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveProductFromCartView extends AppView {
    final ShopService shopService;

    public RemoveProductFromCartView(ShopService shopService) {
        super("remove product from cart", new ArrayList<>());
        this.shopService = shopService;
    }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id product: ");
        String productId = in.next();
        if (productId == null) {
            return;
        }
        final boolean res = shopService.removeProductFromCart(productId);
        if (res) {
            System.out.println("Product removed");
        } else {
            System.out.println("could not remove product");
        }
        System.out.println();
    }
}
