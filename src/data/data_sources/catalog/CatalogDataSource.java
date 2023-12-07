package data.data_sources.catalog;

import data.models.Product;

import java.util.ArrayList;

public abstract class CatalogDataSource {
    abstract ArrayList<Product> getCatalog();
}
