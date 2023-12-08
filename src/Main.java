import common.AppView;
import common.PageLoop;
import data.data_sources.cart.CartDataSource;
import data.data_sources.cart.MockCartDataSourceImpl;
import data.data_sources.catalog.CatalogDataSource;
import data.data_sources.catalog.MockCatalogDataSourceImpl;
import data.data_sources.order.MockOrderDataSourceImpl;
import data.data_sources.order.OrderDataSource;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();

        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);
        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        AppView catalogView = new CatalogView(shopService, catalogChildren);


        AppView removeToCartView = new RemoveProductFromCartView(shopService);
        AppView cartCleanView = new CartCleanView(shopService);
        AppView createOrderView = new CreateOrderView(shopService);
        ArrayList<AppView> cartChildren = new ArrayList<>();
        cartChildren.add(removeToCartView);
        cartChildren.add(cartCleanView);
        cartChildren.add(createOrderView);
        AppView cartView = new CartView(shopService, cartChildren);

        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();  // запуск главной страницы
    }
}