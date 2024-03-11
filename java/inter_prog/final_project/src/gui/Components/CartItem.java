package gui.Components;

import javax.swing.*;

import java.awt.*;

import core.ItemClass;
import core.Items;
import core.PersonClass;



public class CartItem extends ItemGui{
    public interface CartItemListener {
        void subtractButtonClicked(CartItem cartItem);
        void onButtonPressed(double price);
    }
    private static ImageIcon trashIcon = new ImageIcon("src\\gui\\static\\images\\trash_icon_hover.png");

    private CartItemListener listener;

    protected JPanel checkBoxPanel,
                    informationTitlePanel,
                    quantityTitlePanel,
                    priceTitlePanel,
                    totalPricePanel,
                    totalPriceGroupPanel;

    protected JLabel priceTitleLabel,
                    totalPriceLabel;

    protected JCheckBox includeInCart; // Possibly redundant

    protected JButton trashButton;

    public CartItem(ItemClass item, PersonClass user, Items itemList) {
        super(item, user, itemList);
        initComponents();
        setLayout();

    }

    private void initComponents() {
        checkBoxPanel = new JPanel();
        includeInCart = new JCheckBox();
        trashButton = new JButton(trashIcon);
        informationTitlePanel = new JPanel();
        quantityTitlePanel = new JPanel();
        priceTitlePanel = new JPanel();
        priceTitleLabel = new JLabel("Price");
        totalPricePanel = new JPanel();
        totalPriceGroupPanel = new JPanel();
        totalPriceLabel = new JLabel("Total price");
    }

    public void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        checkBoxPanel.setLayout(new GridBagLayout());
        checkBoxPanel.setPreferredSize(new Dimension(75, 200));
        includeInCart.setSelected(true);
        trashButton.setBackground(backgroundColor);
        checkBoxPanel.add(trashButton);
        // add(checkBoxPanel);

        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(IMAGE_BACKGROUND_SIZE, IMAGE_BACKGROUND_SIZE));
        add(backgroundPanel);

        imagePanel.setPreferredSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));
        imagePanel.add(new JLabel(new ImageIcon(imagePath)));
        backgroundPanel.add(imagePanel);


        JPanel informationGroupPanel = new JPanel();
        informationGroupPanel.setLayout(new BorderLayout());
        
        
        informationPanel.setPreferredSize(new Dimension(300, 200));
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        JLabel productDescriptionLabel = new JLabel("Product Description");
        productDescriptionLabel.setFont(new Font("Open Sans MS", Font.BOLD, 25));
        productDescriptionLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        informationTitlePanel.add(productDescriptionLabel);
        informationGroupPanel.add(informationTitlePanel, BorderLayout.NORTH);
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setFont(new Font("Open Sans MS", Font.BOLD, 20));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 20));
        informationPanel.add(nameLabel);
        JLabel unitLabel = new JLabel(unit);
        unitLabel.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 20));
        unitLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 15));
        informationPanel.add(unitLabel);
        informationGroupPanel.add(informationPanel, BorderLayout.CENTER);
        add(informationGroupPanel);

        GridBagConstraints quantitygbc = new GridBagConstraints();
        quantitygbc.insets = new Insets(35, 12, 35, 12);
        quantitygbc.anchor = GridBagConstraints.NORTH;
        quantitygbc.weighty = 1;
        JPanel quantityGroupPanel = new JPanel();
        quantityGroupPanel.setLayout(new BorderLayout());
        quantityGroupPanel.add(quantityTitlePanel, BorderLayout.NORTH);
        quantityGroupPanel.setPreferredSize(new Dimension(200, 200));
        quantityPanel.setPreferredSize(new Dimension(200, 80));
        quantityPanel.setLayout(new GridBagLayout());
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        quantityLabel.setFont(new Font("Open Sans MS", Font.BOLD, 25));
        System.out.println(String.valueOf(user.cart.cart.get(itemName)));
        quantityField.setText(String.valueOf(user.cart.cart.get(itemName)));
        quantityField.setHorizontalAlignment(SwingConstants.CENTER);
        quantityTitlePanel.add(quantityLabel);
        quantityPanel.add(subtractButton, quantitygbc);
        quantityPanel.add(quantityField, quantitygbc);
        quantityPanel.add(addButton, quantitygbc);
        quantityGroupPanel.add(quantityPanel, BorderLayout.CENTER);
        add(quantityGroupPanel);

        JPanel priceGroupPanel = new JPanel();
        priceGroupPanel.setLayout(new BorderLayout());
        pricePanel.setPreferredSize(new Dimension(200, 200));
        priceTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceTitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        priceTitleLabel.setFont(new Font("Open Sans MS", Font.BOLD, 25));
        priceTitlePanel.add(priceTitleLabel);
        priceGroupPanel.add(priceTitlePanel, BorderLayout.NORTH);
        JLabel priceLabel = new JLabel("₱ " + String.format("%.2f", (price)));
        priceLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        priceLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 20));

        priceGroupPanel.setBackground(backgroundColor);
        pricePanel.add(priceLabel);
        priceGroupPanel.add(pricePanel, BorderLayout.CENTER);
        add(priceGroupPanel);


        totalPriceGroupPanel.setPreferredSize(new Dimension(200, 200));
        totalPriceGroupPanel.setLayout(new BorderLayout());
        totalPriceLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        totalPriceLabel.setFont(new Font("Open Sans MS", Font.BOLD, 25));
        totalPriceGroupPanel.add(totalPriceLabel, BorderLayout.NORTH);
        totalPrice.setEditable(false);
        totalPrice.setText("₱ " + String.format("%.2f", (price * user.cart.cart.get(itemName))));
        totalPrice.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        totalPrice.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        totalPricePanel.add(totalPrice, BorderLayout.CENTER);
        totalPriceGroupPanel.add(totalPricePanel);
        add(totalPriceGroupPanel);

        addListeners();

    }

    private void addListeners() {
        super.addListener();
        addButton.addActionListener(e -> {
            if (itemList.inStock(itemName, 1)) {
                quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) + 1)); 
                itemList.subtractFromStock(itemName, 1);
                user.cart.addToCart(item);
                totalPrice.setText("₱ " + String.format("%.2f", (price * user.cart.cart.get(itemName))));
                if (listener != null) {
                    listener.onButtonPressed(this.price);
                }
            } 

        });
        subtractButton.addActionListener(e -> {
            if (Integer.valueOf(quantityField.getText()) > 0) {
                quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) - 1));
                itemList.addToStock(itemName, 1);
                user.cart.subtractFromCart(item);
            }
            if (Integer.valueOf(quantityField.getText()) > 0) {
                totalPrice.setText("₱ " + String.format("%.2f", (price * user.cart.cart.get(itemName))));
            }

            if (listener != null) {
                listener.onButtonPressed(this.price);
                if (Integer.valueOf(quantityField.getText()) == 0) {
                    listener.subtractButtonClicked(this);
                }
            }
        });
        includeInCart.addActionListener(e -> {
                boolean isChecked = includeInCart.isSelected();
                System.out.println("Checkbox is " + (isChecked ? "checked" : "unchecked"));
                if (listener != null) {
                    listener.onButtonPressed(this.price);
                }
        });
    }
    
    public void changeBackground(Color color) {
        checkBoxPanel.setBackground(backgroundColor);
        informationTitlePanel.setBackground(backgroundColor);
        quantityTitlePanel.setBackground(backgroundColor);
        priceTitlePanel.setBackground(backgroundColor);
        priceTitleLabel.setBackground(backgroundColor);
        totalPricePanel.setBackground(backgroundColor);
        totalPriceGroupPanel.setBackground(backgroundColor);
        totalPriceLabel.setBackground(backgroundColor);
        totalPricePanel.setBackground(backgroundColor);
    }

    public void reloadQuantity() {
        quantityField.setText(String.valueOf(user.cart.cart.get(itemName)));
        totalPrice.setText("₱ " + String.format("%.2f", (price * user.cart.cart.get(itemName))));
    }

    public int getQuantity() {
        return Integer.valueOf(quantityField.getText());
    }

    public void setListener(CartItemListener listener) {
        this.listener = listener;
    }
}
