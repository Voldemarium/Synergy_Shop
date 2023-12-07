package data.data_sources.order;

import data.models.Order;
public abstract class OrderDataSource {
    private Order order;
    abstract void createOrder(Order order);
    abstract Order getOrder( );
}
