package data.service;

import data.data_sources.cart.CartDataSource;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.order.OrderDataSource;
import data.models.CartItem;
import data.models.Order;
import data.models.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }

    public boolean addToCart(String productId, int count) {

        ArrayList<Product> products = getCatalog();
        for (Product product : products) {
            if (product.id.equals(productId)) {
                cartDataSource.addToCart(product, count);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CartItem> getCart() {
        return cartDataSource.getCart();
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime) {
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);
    };
}
