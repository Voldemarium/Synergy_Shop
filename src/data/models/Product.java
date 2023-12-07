package data.models;

public class Product {
    final String id;
    final String title;
    final String description;
    final int price;
    final boolean available;

    public Product(String id, String title, String description, int price, boolean available) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.available = available;
    }
}
