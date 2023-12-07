package data.data_sources.catalog;

import data.models.Product;

import java.util.ArrayList;

public class MockCatalogDataSourceImpl extends CatalogDataSource{
    @Override
    ArrayList<Product> getCatalog() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "SmartPhone", "Best phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Some laptop", 2000, true));
        products.add(new Product("id3", "Watch", "Best phone", 500, true));
        products.add(new Product("id4", "Phone", "Simple phone", 100, true));
        return products;
    }
}