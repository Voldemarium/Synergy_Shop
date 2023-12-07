package data.data_sources.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {
    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
    void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
    ArrayList<CartItem> getCart() {
        return cart;
    }
}
