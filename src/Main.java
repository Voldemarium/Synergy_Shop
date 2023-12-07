import data.data_sources.cart.CartDataSource;
import data.data_sources.cart.MockCartDataSourceImpl;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.catalog.MockCatalogDataSourceImpl;
import data.data_sources.order.MockOrderDataSourceImpl;
import data.data_sources.order.OrderDataSource;
import data.service.ShopService;

public class Main {
    public static void main(String[] args) {
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();

        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);
        System.out.println(shopService.getCatalog());
        System.out.println(shopService.getCart());
        System.out.println(shopService.addToCart("id1", 5));
        System.out.println(shopService.addToCart("id5", 5));
        System.out.println(shopService.getCart());



    }
}