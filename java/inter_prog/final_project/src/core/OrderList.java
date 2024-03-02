package core;

import java.util.HashMap;

public class OrderList {
    private HashMap<Integer, Order> orderList = new HashMap<>();
    public OrderList() {

    }

    public void addOrder(Order order) {
        orderList.put(orderList.size() + 1, order);
    }

    public Order getOrder(int index) {
        return orderList.get(index);
    }

    public int getOrderAmount() {
        return orderList.size();
    }
}
