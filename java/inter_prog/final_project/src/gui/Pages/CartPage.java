package gui.Pages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import java.util.ArrayList;

import core.Coupons;
import core.Items;
import core.PersonClass;

interface CartListener {
    void purchaseEvent();
}
public class CartPage extends JPanel implements ItemGuiListener{
    /*
     * TO DO: 
     * Clean up GUI
     * Clean up very dirty logic and code
     * Fix bugs
     * 
     */
    private static CartPage instance;

    private CartListener listener;

    private Color backgroundColor = new Color(131,179,115);

    private Font textFont = new Font("Arial", Font.BOLD, 15);

    private Double serviceFee = 70.00;

    private JPanel cartPanel;
    private JPanel cartBackgroundPanel;
    private JPanel itemsPanel;
    private JPanel noItems;

    private JButton applyCouponButton;
    private JButton purchaseButton;

    private JTextField couponField;
    private JTextField totalPrice;
    private JTextField discount;
    private JTextField fee;
    private JTextField total;

    private GridBagConstraints cartgbc;
    private GridBagConstraints itemsgbc;

    private ArrayList<String> addedItems;

    private PersonClass user;

    private CartPage(PersonClass user) {
        this.user = user;
        initComponents();
        setLayout();
        addListener();
        setVisible(true);
    }

    public static CartPage getInstance(PersonClass user) {
        if (instance == null) {
            instance = new CartPage(user);
        }
        return instance;
    }

    private void initComponents() {
        cartPanel = new JPanel();
        cartBackgroundPanel = new JPanel();
        itemsPanel = new JPanel();
        noItems = new JPanel();

        applyCouponButton = new JButton("Apply");
        purchaseButton = new JButton("Make Purchase");

        couponField = new JTextField(10);
        totalPrice = new JTextField();
        discount = new JTextField();
        fee = new JTextField();
        total = new JTextField();

        cartgbc = new GridBagConstraints();
        itemsgbc = new GridBagConstraints();

        addedItems = new ArrayList<>();
    }

    private void setLayout() {
        setLayout(new BorderLayout());

        itemsgbc.gridy = 0;
        cartgbc.insets = new Insets(20, 20, 20, 20);
        
        cartBackgroundPanel.setLayout(new GridBagLayout());
        cartBackgroundPanel.setBackground(new Color(224, 227, 213));
        add(cartBackgroundPanel, BorderLayout.CENTER);

        cartPanel.setLayout(new GridBagLayout());
        cartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cartPanel.setBackground(backgroundColor);
        cartBackgroundPanel.add(cartPanel);

        itemsPanel.setLayout(new GridBagLayout());
        add(new JScrollPane(itemsPanel), BorderLayout.WEST);

        JLabel couponLabel = new JLabel("Have a Coupon?");
        couponLabel.setFont(new Font("Arial", Font.BOLD, 20));
        setCartGbc(0, 0, 2);
        cartPanel.add(couponLabel, cartgbc);

        setCartGbc(0, 1, 1);
        couponField.setFont(new Font("Arial", Font.PLAIN, 25));
        cartPanel.add(couponField, cartgbc);

        setCartGbc(1, 1, 1);
        cartPanel.add(applyCouponButton, cartgbc);

        JLabel totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setFont(textFont);
        setCartGbc(0, 2, 1);
        cartPanel.add(totalPriceLabel, cartgbc);
        setCartGbc(1, 2, 1);
        totalPrice.setBackground(backgroundColor);
        totalPrice.setFont(textFont);
        totalPrice.setBorder(BorderFactory.createEmptyBorder());
        totalPrice.setText("₱ " + "0.00");
        cartPanel.add(totalPrice, cartgbc);

        JLabel discountLabel = new JLabel("Discount");
        discountLabel.setFont(textFont);
        setCartGbc(0, 3, 1);
        cartPanel.add(discountLabel, cartgbc);
        discount.setBackground(backgroundColor);
        discount.setFont(textFont);
        discount.setText("₱ " + "0.00");
        discount.setBorder(BorderFactory.createEmptyBorder());
        setCartGbc(1, 3, 1);
        cartPanel.add(discount, cartgbc);

        JLabel feeLabel = new JLabel("Service Fee");
        feeLabel.setFont(textFont);
        setCartGbc(0, 4, 1);
        cartPanel.add(feeLabel, cartgbc);
        fee.setBackground(backgroundColor);
        fee.setFont(textFont);
        // TO DO: Add logic to increase fee depending on the amount of items
        calculateServiceFee();
        fee.setBorder(BorderFactory.createEmptyBorder());
        setCartGbc(1, 4, 1);
        cartPanel.add(fee, cartgbc);

        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setForeground(Color.BLACK);
        separator.setPreferredSize(new Dimension(350, 1));
        separator.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setCartGbc(0, 5, 2);
        cartPanel.add(separator, cartgbc);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(textFont);
        setCartGbc(0, 6, 1);
        cartPanel.add(totalLabel, cartgbc);

        setCartGbc(1, 6, 1);
        total.setBackground(backgroundColor);
        total.setFont(textFont);
        total.setText("₱ " + Double.valueOf(calculateFinalPrice()));
        total.setBorder(BorderFactory.createEmptyBorder());
        cartPanel.add(total, cartgbc);

        setCartGbc(0, 7, 2);
        cartgbc.weightx = 1;
        cartgbc.anchor = GridBagConstraints.CENTER;
        purchaseButton.setPreferredSize(new Dimension(350, 30));
        cartPanel.add(purchaseButton, cartgbc);
    }

    private void addListener() {
        purchaseButton.addActionListener(e -> {
            if (calculateFinalPrice() > user.getWallet().getBalance()) {

            } else if (user.cart.cart.size() > 0){
                if (listener != null) {
                    listener.purchaseEvent();
                }
                user.getWallet().subtractBalance(calculateFinalPrice());
                user.order.addOrder(user.cart);
                user.createNewCart();
                calculateServiceFee();
                itemsPanel.removeAll();
                itemsPanel.revalidate();
                itemsPanel.repaint();
                addedItems.clear();
                reloadPage();
                JOptionPane.showMessageDialog(null , "Succesfully purchased!", "Thank you for buying!", JOptionPane.INFORMATION_MESSAGE);
                // Popup message saying suscessfully bought
            }
        });
        applyCouponButton.addActionListener(e -> {
            setVoucherValue(getCoupon());
            total.setText("₱ " + Double.valueOf(calculateFinalPrice()));
            couponField.setText("");
        });
    }

    private void setCartGbc(int x, int y, int width) {
        cartgbc.gridx = x;
        cartgbc.gridy = y;
        cartgbc.gridwidth = width;
        cartgbc.anchor = GridBagConstraints.WEST;
    }

    public void reloadPage() {   
        itemsgbc.insets = new Insets(50, 100, 0, 100);
        if (user.cart.cart.size() > 0) {
            System.out.println(user.cart.cart.size());
            itemsPanel.remove(noItems);
            itemsPanel.revalidate();
            itemsPanel.repaint();
            user.cart.cart.forEach((key, value) -> {
                if (!addedItems.contains(key)) {
                    itemsgbc.gridy++;
                    ItemGui itemGui = new ItemGui(Items.items.get(key), user);
                    itemGui.setUser(user);
                    itemGui.setStockInformation(user.cart.itemList.inStock(key, 1));
                    itemGui.cartLayout();
                    itemGui.setListener(this);
                    itemsPanel.add(itemGui, itemsgbc);
                    addedItems.add(key);
                }
            });
            
        } else if (itemsPanel.getComponentCount() == 0){
            noItems.removeAll();
            noItems.repaint();
            noItems.revalidate();
            JLabel noItemLabel = new JLabel("No items in cart");
            noItems.add(noItemLabel);
            noItems.setPreferredSize(new Dimension(1450, 300));
            itemsPanel.add(noItems);
            
        }
        calculateServiceFee();
        itemsPanel.repaint();
        calculateFinalCart();
        total.setText("₱ " + Double.valueOf(calculateFinalPrice()));
        repaint();
    }

    private void calculateFinalCart() {
        double[] total = {0};
        user.cart.cart.forEach((key, value) -> {
            total[0] += Items.items.get(key).getPrice() * value;
        });
        totalPrice.setText("₱ " + String.format("%.2f", total[0]));

    }

    private Double calculateFinalPrice() {
        double finalPrice = Double.valueOf(totalPrice.getText().replace("₱ ", "")) - Double.valueOf(discount.getText().replace("₱ ", "")) + serviceFee;
        return finalPrice;
    }

    private void calculateServiceFee() {
        if (user.cart.cart.size() != 0) {
            fee.setText("₱ " + "70.00");
            serviceFee = 70.00;
        } else {
            fee.setText("₱ " + "0.00");
            serviceFee = 0.00;
        }
    }

    public String getCoupon() {
        return couponField.getText();
    }

    public void setListener(CartListener listener) {
        this.listener = listener;
    }
    @Override
    public void onButtonPressed(double price) {
        totalPrice.setText("₱ " + String.format("%.2f", (Double.valueOf(totalPrice.getText().replace("₱ ", "")) + price)));
        total.setText("₱ " + Double.valueOf(calculateFinalPrice()));
    }

    private void setVoucherValue(String voucher) {
        // Bug where in if you apply the voucher then added more items it would only discount the value of the items when the apply button was clicked
        Coupons userCoupons = user.getAvailabeCoupons();
        if (userCoupons.contains(voucher) && user.getAvailabeCoupons().getUsedVouchers() < user.getAvailabeCoupons().getMaxVouchers()) {
            switch (voucher) {
                case "10%OFF":
                applyDiscount(voucher, 0.10);
                break;
            case "25%OFF":
                applyDiscount(voucher, 0.25);
                break;
            case "50%OFF":
                applyDiscount(voucher, 0.50);
                break;
            case "75%OFF":
                applyDiscount(voucher, 0.75);
                break;
            case "100%OFF":
                applyDiscount(voucher, 1);
                break;
            case "FREESERVICE":
                discount.setText(fee.getText());
                user.getAvailabeCoupons().remove(voucher);
                
            }
        }
    }
    
    public void applyDiscount(String voucher, double discountPercentage) {
        double totalPriceValue = Double.valueOf(totalPrice.getText().replace("₱ ", ""));
        double discountValue = totalPriceValue * discountPercentage;
    
        discount.setText("₱ " + discountValue);
        user.getAvailabeCoupons().remove(voucher);
    }

    @Override
    public void trashButtonClicked() {
        System.out.println("hi");
        reloadPage();
    }


}
