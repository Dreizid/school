package gui.Pages;

import core.Order;
import core.Items;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Receipt extends JPanel{
    protected static ImageIcon QR_CODE = new ImageIcon("src\\gui\\static\\images\\qrcode.png");

    protected static Color backgroundColor = Color.WHITE;

    protected JPanel headerPanel,
                    bodyPanel,
                    footerPanel;

    protected JLabel titleLabel, 
                    footerLabel;

    protected Order order;

    public Receipt(Order order) {
        this.order = order;
        initComponents();
        setLayout();
    }

    private void initComponents() {
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        footerPanel = new JPanel();

        titleLabel = new JLabel();
        footerLabel = new JLabel();
    }

    private void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        headerPanel.setLayout(new GridBagLayout());
        headerPanel.setBackground(backgroundColor);
        bodyPanel.setLayout(new GridBagLayout());
        bodyPanel.setBackground(backgroundColor);
        footerPanel.setBackground(backgroundColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        titleLabel.setText("SHOP 2 GO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.insets.top = 5;
        JLabel addressLabel = new JLabel("123 Anywhere St. Imus City");
        headerPanel.add(addressLabel, gbc);

        gbc.gridy++;
        JLabel emailLabel = new JLabel("shop2go@gmail.com");
        headerPanel.add(emailLabel, gbc);

        gbc.gridy++;
        JLabel phoneNumberLabel = new JLabel("123-456-7890");
        headerPanel.add(phoneNumberLabel, gbc);

        gbc.insets.top = 10;
        gbc.gridy++;
        headerPanel.add(createSeperator(), gbc);

        gbc.gridy++;
        JLabel receiptLabel = new JLabel("ONLINE RECEIPT");
        receiptLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(receiptLabel, gbc);

        gbc.gridy++;
        headerPanel.add(createSeperator(), gbc);

        loadItems();

        footerLabel.setText("THANK YOU");
        footerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        footerLabel.setVerticalTextPosition(SwingConstants.TOP);
        footerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        footerPanel.add(footerLabel);
        footerLabel.setIcon(QR_CODE);

        add(headerPanel);
        add(bodyPanel);
        add(footerPanel);
    }

    private void loadItems() {
        GridBagConstraints bodyConstraints = new GridBagConstraints();
        bodyConstraints.gridy = 0;
        bodyConstraints.gridx = 0;
        bodyConstraints.weightx = 1;
        bodyConstraints.anchor = GridBagConstraints.WEST;
        bodyConstraints.insets = new Insets(5, 15, 0, 15);
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bodyPanel.add(descriptionLabel, bodyConstraints);

        bodyConstraints.gridx = 1;
        bodyConstraints.anchor = GridBagConstraints.EAST;
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bodyPanel.add(priceLabel, bodyConstraints);

        order.getCart().cart.forEach((key, value) -> {
            bodyConstraints.gridy++;
            bodyConstraints.gridx = 0;
            bodyConstraints.anchor = GridBagConstraints.WEST;
            bodyPanel.add(new JLabel(key + " x " + value), bodyConstraints);
            bodyConstraints.gridx = 1;
            bodyConstraints.anchor = GridBagConstraints.EAST;
            bodyPanel.add(new JLabel("₱ " + String.format("%.2f", Items.items.get(key).getPrice() * value)), bodyConstraints);
        });
        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 2;
        bodyPanel.add(createSeperator(), bodyConstraints);

        if (order.usedCoupon()) {
            bodyConstraints.gridy++;
            bodyConstraints.gridwidth = 1;
            bodyConstraints.gridx = 0;
            bodyConstraints.anchor = GridBagConstraints.WEST;
            JLabel couponLabel = new JLabel("Coupon used");
            bodyPanel.add(couponLabel, bodyConstraints);
    
            bodyConstraints.gridx = 1;
            bodyConstraints.anchor = GridBagConstraints.EAST;
            JLabel couponNameLabel = new JLabel(order.getUsedCoupon());
            bodyPanel.add(couponNameLabel, bodyConstraints);

            bodyConstraints.gridy++;
            bodyConstraints.gridx = 0;
            bodyConstraints.gridwidth = 1;
            bodyConstraints.anchor = GridBagConstraints.WEST;
            JLabel discountLabel = new JLabel("Discount");
            bodyPanel.add(discountLabel, bodyConstraints);
    
            bodyConstraints.gridx = 1;
            bodyConstraints.anchor = GridBagConstraints.EAST;
            JLabel discountPrice = new JLabel("-" + "₱ " + String.format("%.2f", order.getDiscount()));
            bodyPanel.add(discountPrice, bodyConstraints);
        }

        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 1;
        bodyConstraints.anchor = GridBagConstraints.WEST;
        JLabel serviceLabel = new JLabel("Service Fee");
        bodyPanel.add(serviceLabel, bodyConstraints);

        bodyConstraints.gridx = 1;
        bodyConstraints.anchor = GridBagConstraints.EAST;
        JLabel servicePrice = new JLabel("₱ " + String.format("%.2f", order.getServiceFee()));
        bodyPanel.add(servicePrice, bodyConstraints);

        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 1;
        bodyConstraints.anchor = GridBagConstraints.WEST;
        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bodyPanel.add(totalLabel, bodyConstraints);

        bodyConstraints.gridx = 1;
        bodyConstraints.anchor = GridBagConstraints.EAST;
        JLabel totalPrice = new JLabel("₱ " + String.format("%.2f", order.getTotal()));
        bodyPanel.add(totalPrice, bodyConstraints);

        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 2;
        bodyPanel.add(createSeperator(), bodyConstraints);
        
        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 2;
        bodyConstraints.anchor = GridBagConstraints.CENTER;
        Random random = new Random();
        JLabel orderId = new JLabel("Order ID: " + "#" + String.valueOf(random.nextInt(1001)));
        bodyPanel.add(orderId, bodyConstraints);

        bodyConstraints.gridy++;
        bodyConstraints.gridx = 0;
        bodyConstraints.gridwidth = 2;
        bodyPanel.add(createSeperator(), bodyConstraints);
    }

    private JSeparator createSeperator() {
        JSeparator seperator = new JSeparator(JSeparator.HORIZONTAL);
        seperator.setForeground(backgroundColor);
        seperator.setPreferredSize(new Dimension(300, 1));
        seperator.setBorder(BorderFactory.createDashedBorder(Color.BLACK, 5,1));
        return seperator;
    }
}
