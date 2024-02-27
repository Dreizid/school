package gui.Pages;

import javax.swing.*;

import core.Cart;
import core.Orders;
import core.PersonClass;

import java.awt.*;

public class OrdersPage extends JPanel{
    private static OrdersPage instance;

    private Orders orders;

    private PersonClass user;

    private OrdersPage(PersonClass user) {
        this.user = user;
        this.orders = user.order;
        setVisible(true);
    }

    public static OrdersPage getInstance(PersonClass user) {
        if (instance == null) {
            instance = new OrdersPage(user);
        }
        return instance;
    }

    public void loadOrders() {
        removeAll();
        System.out.println("loading orders");
        for (int i = 1; i <= orders.getOrderAmount(); i++) {
            System.out.println(user.order.getOrder(i));
            add(new OrderGui(i, user.order.getOrder(i)));
        }
        repaint();
        revalidate();
        System.out.println("Done");
    }
}
