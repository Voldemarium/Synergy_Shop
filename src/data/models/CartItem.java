package data.models;

public class CartItem {
   final Product product;
   final int count;

   public CartItem(Product product, int count) {
      this.product = product;
      this.count = count;
   }
}
