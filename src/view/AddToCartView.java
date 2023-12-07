package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    final ShopService shopService;

    public AddToCartView(ShopService shopService) {
        super("add product from catalog", new ArrayList<>());
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
        System.out.println("Enter count: ");
        int count = in.nextInt();

        final boolean res = shopService.addToCart(productId, count);
        if (res) {
            System.out.println("Product added");
        } else {
            System.out.println("could not add product");
        }
        System.out.println();
    }
}
