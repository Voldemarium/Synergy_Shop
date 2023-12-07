package data.data_sources.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;
import java.util.ListIterator;

public class MockCartDataSourceImpl extends CartDataSource {
    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
    public void removeToCart(Product product) {
        ListIterator<CartItem> iterator = cart.listIterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.product.equals(product)) {
                iterator.remove();
            }
        }
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }
}
