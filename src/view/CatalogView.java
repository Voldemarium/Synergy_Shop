package view;

import common.AppView;
import data.comparators.PriceComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {
    final ShopService shopService;
     public CatalogView(ShopService shopService, ArrayList<AppView> children) {
        super("Catalog", children);
         this.shopService = shopService;
     }

    @Override
    public void action() {
         PriceComparator priceComparator = new PriceComparator(false);
        ArrayList<Product> catalog = shopService.getCatalog(0, 10, priceComparator);
        if (!catalog.isEmpty()) {
            for (Product product : catalog) {
                System.out.println(product);
            }
        } else {
            System.out.println("catalog is empty");
        }
        System.out.println();
    }
}
