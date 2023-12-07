package data.data_sources.cart;

import data.models.CartItem;
import data.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {
    public abstract void addToCart(Product product, int count);
    public abstract void removeToCart(Product product);

    public abstract ArrayList<CartItem> getCart();

}

/* Фичи:
     - просмотр каталога
        - добавление в корзину по id
           - сколько штук
     - просмотр корзины
     - оформить заказ
        -ввод данных пользователем
 */