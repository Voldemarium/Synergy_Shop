package data.data_sources.catalog;

import data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class CatalogDataSource {
    public abstract ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator);
    public abstract ArrayList<Product> getCatalog(int page, int limit);
    public abstract Product getProductById(String id);
}
