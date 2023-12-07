package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveToCartView extends AppView {
    final ShopService shopService;

    public RemoveToCartView(ShopService shopService) {
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
        final boolean res = shopService.removeToCart(productId);
        if (res) {
            System.out.println("Product removed");
        } else {
            System.out.println("could not remove product");
        }
        System.out.println();
    }
}
