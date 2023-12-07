package data.models;

public class CartItem {
   public final Product product;
   public final int count;

   public CartItem(Product product, int count) {
      this.product = product;
      this.count = count;
   }

   @Override
   public String toString() {
      return "CartItem{" +
              "product=" + product +
              ", count=" + count +
              '}';
   }
}
