package gui.Pages;

import javax.swing.*;

import core.OrderList;
import core.PersonClass;
import gui.Components.OrderGui;
import gui.widgets.DropShadowPanel;

import java.awt.*;
import java.util.ArrayList;

public class OrdersPage extends JPanel{
    private static OrdersPage instance;

    private static String[] headerTitles = {"Order number", "Date", "Status", "Total"};

    private static ImageIcon noOrderIcon = new ImageIcon("src\\gui\\static\\images\\noorder.png");

    protected JPanel noOrderPanel,
                    ordersPanel,
                    headerPanel;

    protected DropShadowPanel mainPanel;

    protected GridBagConstraints gbc,
                                noOrdergbc;

    protected JLabel noOrderLabel,
                    noOrderDescription,
                    noOrderDescription2;

    private ArrayList<Integer> addedList;

    private int index;

    private OrderList orders;

    private PersonClass user;

    public OrdersPage(PersonClass user) {
        this.user = user;
        this.orders = user.orderList;
        setVisible(true);
        initComponents();
        setLayout();
    }

    public static OrdersPage getInstance(PersonClass user) {
        if (instance == null) {
            instance = new OrdersPage(user);
        }
        return instance;
    }

    private void initComponents() {
        gbc = new GridBagConstraints();
        noOrdergbc = new GridBagConstraints();
        noOrderPanel = new JPanel();
        headerPanel = new JPanel();
        mainPanel = new DropShadowPanel(6);
        ordersPanel = new JPanel();

        addedList = new ArrayList<>();

        index = 1;

        noOrderLabel = new JLabel("No Orders Found");
        noOrderDescription = new JLabel("You haven't ordered anything.");
        noOrderDescription2 = new JLabel("Go ahead and explore");
    }

    private void setLayout() {
        setLayout(new GridBagLayout());
        noOrderPanel.setLayout(new GridBagLayout());
        ordersPanel.setLayout(new GridBagLayout());
        mainPanel.setLayout(new BorderLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;

        headerPanel.setLayout(new GridLayout(0, 5));
        headerPanel.setBackground(Color.WHITE);
        for (String text: headerTitles) {
            JLabel title = new JLabel(text);
            title.setFont(new Font("Open Sans MS", Font.BOLD, 18));
            title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            title.setHorizontalTextPosition(SwingConstants.CENTER);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            headerPanel.add(title);
        }
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        ordersPanel.setBackground(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public void loadOrders() {
        removeAll();
        if (orders.getOrderAmount() > 0) {
            remove(noOrderPanel);
            revalidate();
            repaint();
            add(mainPanel);
            for (int i = index; i <= orders.getOrderAmount(); i++) {
                gbc.gridy++;
                index++;
                ordersPanel.add(new OrderGui(i, user.orderList.getOrder(i)), gbc);
                addedList.add(i);
    
            }
        } else {
            noOrderPanel.removeAll();
            noOrderPanel.repaint();
            noOrderPanel.revalidate();
            noOrdergbc.gridy = 0;
            noOrderLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            noOrderLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
            noOrderLabel.setFont(new Font("Open Sans MS", Font.BOLD, 50));
            noOrderLabel.setIcon(noOrderIcon);
            noOrderPanel.add(noOrderLabel, noOrdergbc);
            
            noOrderDescription.setHorizontalAlignment(SwingConstants.CENTER);
            noOrderDescription.setFont(new Font("Open Sans MS", Font.PLAIN, 25));
            noOrdergbc.gridy = 1;
            noOrderPanel.add(noOrderDescription, noOrdergbc);
            
            noOrderDescription2.setHorizontalAlignment(SwingConstants.CENTER);
            noOrderDescription2.setVerticalTextPosition(SwingConstants.BOTTOM);
            noOrderDescription2.setFont(new Font("Open Sans MS", Font.PLAIN, 25));
            noOrdergbc.gridy = 2;
            noOrderPanel.add(noOrderDescription2, noOrdergbc);
            noOrderPanel.setPreferredSize(new Dimension(1450, 400));
            add(noOrderPanel);

        }
        repaint();
        revalidate();
    }

    public void setUser(PersonClass user) {
        this.user = user;
    }
}
