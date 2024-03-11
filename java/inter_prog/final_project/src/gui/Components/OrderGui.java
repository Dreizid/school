package gui.Components;

import javax.swing.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import core.Order;

import java.awt.*;

public class OrderGui extends JPanel{
    protected static String[] orderStatus = {"Order placed", "Proccessing", "Packaging your order", "Ready for Pickup", "Customer Pickup", "Completed"};

    protected int currentStatus = 1;

    protected static final Random random = new Random();

    protected JPanel titlePanel,
                    datePanel,
                    statusPanel,
                    totalPanel,
                    buttonPanel;

    protected Receipt receipt;

    private JLabel orderNumberLabel,
                    currentDate,
                    statusLabel,
                    totalLabel;

    private JButton viewOrderButton;

    private int orderNumber;

    private Order order;

    protected double totalPrice; 

    protected boolean inProccess;

    public OrderGui(int orderNumber, Order order) {
        this.orderNumber = orderNumber;
        this.order = order;
        setVisible(true);
        initComponents();
        setLayout();
        addListeners();
    }

    private void initComponents() {
        titlePanel = new JPanel();
        datePanel = new JPanel();
        statusPanel = new JPanel();
        totalPanel = new JPanel();
        buttonPanel = new JPanel();
        statusLabel = new JLabel();
        orderNumberLabel = new JLabel("#" + String.valueOf(orderNumber));
        viewOrderButton = new JButton("View order");
        receipt = new Receipt(order);
        statusLabel.setText(orderStatus[0]);
        statusPanel.repaint();
        statusPanel.revalidate();
        LocalDate date = LocalDate.now();
        currentDate = new JLabel(date.toString());
        inProccess = false;
    }

    private void setLayout() {
        setLayout(new GridLayout(0, 5));

        orderNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(orderNumberLabel);
        datePanel.add(currentDate);
        statusPanel.setPreferredSize(new Dimension(150, 20));
        
        statusPanel.add(statusLabel);
        if (order.getCart().getAmount() > 1) {
            totalPanel.add(new JLabel("₱ " + String.format("%.2f", order.getCart().getTotal()) + " for " + order.getCart().getAmount() + " items"));
        } else if (order.getCart().getAmount() == 1) {
            totalPanel.add(new JLabel("₱ " + String.format("%.2f", order.getCart().getTotal()) + " for " + order.getCart().getAmount() + " item"));
        }
        buttonPanel.add(viewOrderButton);
        add(titlePanel);
        add(datePanel);
        add(statusPanel);
        add(totalPanel);
        add(buttonPanel);
    }

    private void addListeners() {
        viewOrderButton.addActionListener(e -> {
            generateOrderFrame();
        });
    }

    private void generateOrderFrame() {
        JFrame orderFrame = new JFrame();
        orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        orderFrame.add(new JScrollPane(receipt));
        orderFrame.pack();
        orderFrame.setVisible(true);
        if (!inProccess) {
            new Timer().schedule(new NextStatus(this), getRandomDelay(2, 6) * 1000);
            inProccess = true;
        }
    }

    static class NextStatus extends TimerTask {
        private OrderGui orderGui;

        public NextStatus(OrderGui orderGui) {
            this.orderGui = orderGui;
        }
        @Override
        public void run() {
            if (orderGui.currentStatus < orderStatus.length - 1) {
                orderGui.statusLabel.setText(orderStatus[orderGui.currentStatus]);
                orderGui.currentStatus++;
    
                new Timer().schedule(new NextStatus(orderGui), getRandomDelay(2, 6) * 1000);
            } else {
                orderGui.statusLabel.setText(orderStatus[orderGui.currentStatus]);
                orderGui.statusLabel.setForeground(new Color(0, 128, 0));
            }
        }
    } 

    private static int getRandomDelay(int minSeconds, int maxSeconds) {
        return random.nextInt(maxSeconds - minSeconds + 1) + minSeconds;
    }
}
