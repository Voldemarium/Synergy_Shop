package data.data_sources.order;

import data.models.Order;

public class MockOrderDataSourceImpl extends OrderDataSource{
    private Order order;
    @Override
    void createOrder(Order order) {
        this.order = order;
    }

    @Override
    Order getOrder() {
        return this.order;
    }
}
