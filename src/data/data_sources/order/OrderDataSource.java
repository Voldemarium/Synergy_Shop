package data.data_sources.order;

import data.models.Order;
public abstract class OrderDataSource {
    private Order order;
    public abstract void createOrder(Order order);
    public abstract Order getOrder( );
}
