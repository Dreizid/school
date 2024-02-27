package gui.Pages;

import javax.swing.*;

import core.Cart;

import java.awt.*;

public class OrderGui extends gui.widgets.DropShadowPanel{
    private JLabel orderNumberLabel;

    private JButton viewOrderButton;

    private int orderNumber;

    private Cart cartOrder;

    public OrderGui(int orderNumber, Cart order) {
        super(10);
        this.orderNumber = orderNumber;
        this.cartOrder = order;
        setVisible(true);
        setSize(300, 300);
        initComponents();
        setLayout();
        addListeners();
        System.out.println("hi");
    }

    private void initComponents() {
        orderNumberLabel = new JLabel("Order #" + String.valueOf(orderNumber));
        viewOrderButton = new JButton("View order");
    }

    private void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(orderNumberLabel);
        add(viewOrderButton);
    }

    private void addListeners() {
        viewOrderButton.addActionListener(e -> {
            generateOrderFrame();
        });
    }

    private void generateOrderFrame() {
        JFrame orderFrame = new JFrame();
        orderFrame.setSize(400, 200);
        JPanel orderPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(orderPanel);
        cartOrder.cart.forEach((key, value) -> {
            orderPanel.add(new JLabel(key + " x " + value));
        });
        orderFrame.add(scrollPane);
        orderFrame.setVisible(true);
    }
}
