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
import java.util.HashMap;
import java.util.List;

import core.Coupons;
import core.Items;
import core.PersonClass;
import gui.Components.CartItem;
import gui.Components.CartItem.CartItemListener;
import core.Order;

interface CartListener {
    void purchaseEvent();
}
public class CartPage extends JPanel implements CartItemListener{
    /*
     * TO DO: 
     * Clean up GUI
     * Clean up very dirty logic and code
     * Fix bugs
     * 
     */
    private static CartPage instance;

    private CartListener listener;

    protected static Color backgroundColor = new Color(131,179,115);

    protected static ImageIcon noItemsIcon = new ImageIcon("src\\gui\\static\\images\\noitems.png");

    protected static Font textFont = new Font("Arial", Font.BOLD, 15);

    protected Double serviceFee,
                    discountPrice,
                    discountPer,
                    totalValue;

    protected JPanel cartPanel,
                    cartBackgroundPanel,
                    itemsPanel,
                    noItems;

    protected JButton applyCouponButton,
                    purchaseButton;

    protected JLabel noItemLabel,
                    noItemDescription,
                    noItemDescription2;

    protected JTextField couponField,
                    totalPrice,
                    discount,
                    fee,
                    total;

    protected GridBagConstraints cartgbc,
                                itemsgbc,
                                noItemgbc;

    protected HashMap<String, CartItem> addedItems;

    protected List<String> keysToRemove;

    protected PersonClass user;

    protected String currentCoupon;

    protected Items itemList;

    public CartPage(PersonClass user, Items itemList) {
        this.user = user;
        this.itemList = itemList;
        initComponents();
        setLayout();
        addListener();
        setVisible(true);
    }

    public static CartPage getInstance(PersonClass user, Items itemList) {
        if (instance == null) {
            instance = new CartPage(user, itemList);
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
        noItemgbc = new GridBagConstraints();

        addedItems = new HashMap<>();

        keysToRemove = new ArrayList<>();

        noItemLabel = new JLabel("The shopping cart is currently empty");
        noItemDescription = new JLabel("Looks like you have not added anything to the cart.");
        noItemDescription2 = new JLabel("Go ahead and explore");

        serviceFee = 0.00;
        discountPrice = 0.00;
        totalValue = 0.00;
        discountPer = 0.00;
        currentCoupon = "";
    }

    private void setLayout() {
        setLayout(new BorderLayout());
        noItems.setLayout(new GridBagLayout());

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
        discount.setText("₱ " + discountPrice);
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
        fee.setText("₱ " + serviceFee);
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
        total.setText("₱ " + totalValue);
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
            calculateFinalPrice();
            if (totalValue > user.getWallet().getBalance()) {
                JOptionPane.showMessageDialog(null, "Insufficient balance", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (user.cart.cart.size() > 0){

                int confirmationResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to purchase " + user.cart.getAmount() + " items " + "for ₱ " + String.format("%.2f", totalValue));
                if (confirmationResult == JOptionPane.YES_OPTION) {
                    if (listener != null) {
                        listener.purchaseEvent();
                    }
    
                    Order order = new Order(user.orderList.getOrderAmount(), currentCoupon, discountPrice, totalValue, serviceFee, user.cart);
                    currentCoupon = "";
                    discountPer = 0.00;
                    recalculateValues();
                    user.getWallet().subtractBalance(totalValue);
                    user.orderList.addOrder(order);
                    user.createNewCart();
                    addedItems.clear();
                    itemsPanel.removeAll();
                    itemsPanel.repaint();
                    itemsPanel.revalidate();
                    reloadPage();
                    JOptionPane.showMessageDialog(null , "Succesfully purchased!", "Thank you for buying!", JOptionPane.INFORMATION_MESSAGE);
                } else {

                }
            }
        });
        applyCouponButton.addActionListener(e -> {
            if (userCanUseVoucher(getCoupon())) {
                setVoucherValue(getCoupon());
                calculateFinalPrice();
                total.setText("₱ " + totalValue);
                user.getAvailabeCoupons().removeVoucher(couponField.getText());
                currentCoupon = couponField.getText();
                couponField.setText("");
            }
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
            itemsPanel.remove(noItems);
            itemsPanel.revalidate();
            itemsPanel.repaint();
            user.cart.cart.forEach((key, value) -> {
                if (!addedItems.containsKey(key)) {
                    itemsgbc.gridy++;
                    CartItem itemGui = new CartItem(Items.items.get(key), user, itemList);
                    itemGui.setUser(user);
                    itemGui.setListener(this);
                    itemsPanel.add(itemGui, itemsgbc);
                    addedItems.put(key, itemGui);
                } else {
                    CartItem currItem = addedItems.get(key);
                    currItem.reloadQuantity();
                }
            });
            
        } else if (itemsPanel.getComponentCount() == 0){
            noItems.removeAll();
            noItems.repaint();
            noItems.revalidate();
            noItemgbc.gridy = 0;
            noItemLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            noItemLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
            noItemLabel.setFont(new Font("Open Sans MS", Font.BOLD, 50));
            noItemLabel.setIcon(noItemsIcon);
            noItems.add(noItemLabel, noItemgbc);
            
            noItemDescription.setHorizontalAlignment(SwingConstants.CENTER);
            noItemDescription.setFont(new Font("Open Sans MS", Font.PLAIN, 25));
            noItemgbc.gridy = 1;
            noItems.add(noItemDescription, noItemgbc);
            
            noItemDescription2.setHorizontalAlignment(SwingConstants.CENTER);
            noItemDescription2.setVerticalTextPosition(SwingConstants.BOTTOM);
            noItemDescription2.setFont(new Font("Open Sans MS", Font.PLAIN, 25));
            noItemgbc.gridy = 2;
            noItems.add(noItemDescription2, noItemgbc);
            noItems.setPreferredSize(new Dimension(1450, 400));
            itemsPanel.add(noItems);
            
        }
        recalculateValues();
        itemsPanel.repaint();
        repaint();
    }

    private void calculateFinalPrice() {
        double finalPrice = Double.valueOf(totalPrice.getText().replace("₱ ", "")) - discountPrice + serviceFee;
        totalValue = finalPrice;
    }

    private void calculateServiceFee() {
        if (user.cart.cart.size() != 0) {     
            serviceFee = 25.00;
        } else {
            serviceFee = 0.00;
        }
    }

    private void recalculateValues() {
        calculateServiceFee();
        fee.setText("₱ " + serviceFee);
        totalPrice.setText("₱ " + String.format("%.2f", user.cart.getTotal()));
        applyDiscount(currentCoupon, discountPer);
        calculateFinalPrice();
        total.setText("₱ " + String.format("%.2f", totalValue));
    }

    public String getCoupon() {
        return couponField.getText();
    }

    public void setListener(CartListener listener) {
        this.listener = listener;
    }
    @Override
    public void onButtonPressed(double price) {
        recalculateValues();
    }

    private void setVoucherValue(String voucher) {
        if (userCanUseVoucher(voucher)) {
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
                    break;
            }
        } else {
            discountPrice = 0.00;
            discount.setText("₱ " + discountPrice);
        }
    }

    private boolean userCanUseVoucher(String voucher) {
        Coupons userCoupons = user.getAvailabeCoupons();
        if (userCoupons.contains(voucher) && user.getAvailabeCoupons().getUsedVouchers() < user.getAvailabeCoupons().getMaxVouchers()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void applyDiscount(String voucher, double discountPercentage) {
        double totalPriceValue = Double.valueOf(totalPrice.getText().replace("₱ ", ""));
        double discountValue = totalPriceValue * discountPercentage;
        System.out.println(discountValue);
        
        currentCoupon = voucher;
        discountPrice = discountValue;
        discount.setText("₱ " + discountValue);
        discountPer = discountPercentage;
        System.out.println("Applied");
    }


    @Override
    public void subtractButtonClicked(CartItem cartItem) {
        itemsPanel.remove(cartItem);
        addedItems.remove(cartItem.getName());
        listener.purchaseEvent();
        reloadPage();
    }

    public void setUser(PersonClass user) {
        this.user = user;
    }
}
