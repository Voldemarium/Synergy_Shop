package data.service;

import data.data_sources.cart.CartDataSource;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.order.OrderDataSource;
import data.models.CartItem;
import data.models.Order;
import data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog(int page, int limit) {
        return catalogDataSource.getCatalog(page, limit);
    }

    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        return catalogDataSource.getCatalog(page, limit, comparator);
    }

    public boolean addToCart(String productId, int count) {
        Product product = catalogDataSource.getProductById(productId);
        if (product != null) {
            cartDataSource.addToCart(product, count);
            return true;
        }
        return false;
    }

    public boolean removeProductFromCart(String productId) {
        ArrayList<CartItem> cart = getCart();
        for (CartItem cartItem : cart) {
            if (cartItem.product.id.equals(productId)) {
                cartDataSource.removeProductFromCart(cartItem.product);
                return true;
            }
        }
        return false;
    }

    public boolean cartClean() {
        ArrayList<CartItem> cart = getCart();
        if (!cart.isEmpty()) {
            cartDataSource.cartClean();
            return true;
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
        if (orderDataSource.getOrder() != null) {
            System.out.println("Order created");
            cartDataSource.cartClean();
            if (cartDataSource.getCart().isEmpty()) {
                System.out.println("Shopping cart cleaned");
            }
        }
    }

    public Order getOrder() {
        return orderDataSource.getOrder();
    }
}
