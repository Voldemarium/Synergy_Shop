package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateOrderView extends AppView {
    final ShopService shopService;
     public CreateOrderView(ShopService shopService) {
        super("Create order", new ArrayList<>());
         this.shopService = shopService;
     }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        System.out.println("Enter your phone: ");
        String phone = in.nextLine();
        System.out.println("Enter your address: ");
        String address = in.nextLine();
        System.out.println("Enter your payment type: ");
        String paymentType = in.next();
        System.out.println("Enter your delivery time: ");
        String deliveryTime = in.next();
        shopService.createOrder(name, phone, address, paymentType, deliveryTime);
        System.out.println();
    }
}
