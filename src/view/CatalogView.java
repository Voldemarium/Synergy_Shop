package view;

import common.AppView;
import common.AppViewCatalogs;
import data.comparators.AppComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppViewCatalogs {
    final ShopService shopService;

    public CatalogView(ShopService shopService, ArrayList<AppView> children,
                       ArrayList<AppComparator<Product>> comparators) {
        super("Catalog", children);
        this.shopService = shopService;
        this.availableComparators.addAll(comparators);
        if (!this.availableComparators.isEmpty()) {
            this.selectedComparator = this.availableComparators.get(0);
        }

    }

    @Override
    public void action() {
        ArrayList<Product> catalog = shopService.getCatalog(this.nowPage, this.pageLimit, this.selectedComparator.comparator);
        if (!catalog.isEmpty()) {
            this.hasNextPage = catalog.size() == this.pageLimit;  //нужны ли дополнительные страницы
//            System.out.println("this.hasNextPage =" + this.hasNextPage);
            for (Product product : catalog) {
                System.out.println(product);
            }
        } else {
            System.out.println("catalog is empty");
        }
        System.out.println();
    }
}
