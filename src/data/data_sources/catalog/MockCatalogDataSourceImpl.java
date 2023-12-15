package data.data_sources.catalog;

import data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockCatalogDataSourceImpl extends CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        // добавление товаров
        ArrayList<Product> products = generateProducts();
        // фильтрация по доступности, сортировка и пагинация
        Stream<Product> productStream = products.stream()
                .filter(product -> product.available)
                .sorted(comparator)
                .skip((long) page * limit)
                .limit(limit);
        return productStream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        // добавление товаров
        ArrayList<Product> products = generateProducts();
        // фильтрация по доступности и пагинация
        Stream<Product> productStream = products.stream()
                .filter(product -> product.available)
                .skip((long) page * limit)
                .limit(limit);
        return productStream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Product getProductById(String id) {
        ArrayList<Product> products = getCatalog(0, 99999);
        for (Product product : products) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }

    private static ArrayList<Product> generateProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "SmartPhone", "Best phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Some laptop", 2000, true));
        products.add(new Product("id3", "Watch", "Best phone", 500, true));
        products.add(new Product("id4", "Phone", "Simple phone", 100, true));
        for (int i = 0; i < 20; i++) {
            products.add(new Product("id" + (i + 5),
                    "Phone" + i,
                    "Simple phone",
                    100 + i * 100,
                    i % 4 != 0));
        }
        return products;
    }
}