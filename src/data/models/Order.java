package data.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    final String name;
    final String phone;
    final String address;
    final String paymentType;
    final String deliveryTime;
    final LocalDate date;
    final ArrayList<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, LocalDate date, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.date = date;
        this.cart = cart;
    }
}
