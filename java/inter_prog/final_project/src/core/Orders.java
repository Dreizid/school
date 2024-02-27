package core;

import java.util.HashMap;

public class Orders {
    private HashMap<Integer, Cart> orderList = new HashMap<>();
    public Orders() {

    }

    public void addOrder(Cart cart) {
        orderList.put(orderList.size() + 1, cart);
    }

    public Cart getOrder(int index) {
        return orderList.get(index);
    }

    public int getOrderAmount() {
        return orderList.size();
    }
}
