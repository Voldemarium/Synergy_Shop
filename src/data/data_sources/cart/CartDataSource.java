package data.data_sources.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {
    public abstract void addToCart(Product product, int count);
    public abstract void removeProductFromCart(Product product);
    public abstract void cartClean();

    public abstract ArrayList<CartItem> getCart();

}
