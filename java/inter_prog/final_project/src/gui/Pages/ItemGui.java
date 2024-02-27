package gui.Pages;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import core.ItemClass;
import core.PersonClass;

import java.awt.*;
import java.text.ParseException;

interface ItemGuiListener {
    void onButtonPressed(double price);
    void trashButtonClicked();
}
public class ItemGui extends gui.widgets.DropShadowPanel{
    private TopPanel topPanel;
    private ItemGuiListener listener;

    private Color backgroundColor = Color.WHITE;
    
    private static ImageIcon trashIcon = new ImageIcon("src\\gui\\static\\images\\trash_icon_hover.png");

    private JPanel backgroundPanel;
    private JPanel imagePanel;
    private JPanel quantityPanel;
    private JPanel informationPanel;
    private JPanel addToCartPanel;
    private JPanel checkBoxPanel;
    private JPanel informationTitlePanel;
    private JPanel quantityTitlePanel;
    private JPanel pricePanel;
    private JPanel priceTitlePanel;
    private JPanel totalPricePanel;
    private JPanel totalPriceGroupPanel;


    private JButton addToCartButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton trashButton;

    private JFormattedTextField quantityField;

    private JTextField totalPrice;
    private JTextField stockInformation;

    private JLabel priceTitleLabel;
    private JLabel totalPriceLabel;


    private JCheckBox includeInCart;

    private String itemName;
    private String category;
    private String description;
    private String imagePath;
    private String unit;

    private double price;

    private int imageSize = 175;
    private int imageBackgroundSize = 300;

    private boolean inStock;

    private PersonClass user;

    private ItemClass item;
    public ItemGui(ItemClass item, PersonClass user) {
        super(8);
        this.item = item;
        this.itemName = item.getName();
        this.category = item.getCategory();
        this.description = item.getDescription();
        this.imagePath = item.getImagePath();
        this.unit = item.getUnit();
        this.price = item.getPrice();
        this.inStock = false;
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        backgroundPanel = new JPanel();
        imagePanel = new JPanel();
        informationPanel = new JPanel();
        quantityPanel = new JPanel();
        checkBoxPanel = new JPanel();
        quantityField = new JFormattedTextField();
        addToCartPanel = new JPanel();
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        includeInCart = new JCheckBox();
        stockInformation = new JTextField("Stock: " + user.cart.itemList.getStockAmount(itemName));
        trashButton = new JButton(trashIcon);
        totalPrice = new JTextField();

        informationTitlePanel = new JPanel();
        quantityTitlePanel = new JPanel();
        pricePanel = new JPanel();
        priceTitlePanel = new JPanel();
        priceTitleLabel = new JLabel("Price");
        totalPricePanel = new JPanel();
        totalPriceGroupPanel = new JPanel();
        totalPriceLabel = new JLabel("Total price");
    }

    public void storeLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addToCartButton = new JButton("Add to cart");

        imagePanel.add(new JLabel(new ImageIcon(imagePath)));
        imagePanel.setPreferredSize(new Dimension(imageSize, imageSize));

        backgroundPanel.add(imagePanel);
        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(imageBackgroundSize, imageBackgroundSize));
        add(backgroundPanel);


        JLabel priceLabel = new JLabel("₱ " + String.format("%.2f", price));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 0);
        JLabel unitLabel = new JLabel(unit);
        unitLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        stockInformation.setEditable(false);
        stockInformation.setBorder(BorderFactory.createEmptyBorder());
        informationPanel.setLayout(new GridBagLayout());
        informationPanel.setPreferredSize(new Dimension(300, 125));
        informationPanel.add(nameLabel, gbc);
        gbc.gridy++;
        informationPanel.add(priceLabel, gbc);
        gbc.gridy++;
        informationPanel.add(unitLabel, gbc);
        gbc.gridy++;
        informationPanel.add(stockInformation, gbc);
        add(informationPanel);

        GridBagConstraints quantitygbc = new GridBagConstraints();
        quantitygbc.insets = new Insets(10, 40, 10, 40);
        initStoreFormatter();
        quantityField.setHorizontalAlignment(SwingConstants.CENTER);
        quantityPanel.setPreferredSize(new Dimension(300, 75));
        quantityPanel.setLayout(new GridBagLayout());
        quantityPanel.add(subtractButton);
        quantityPanel.add(quantityField, quantitygbc);
        quantityPanel.add(addButton);
        add(quantityPanel);

        addToCartButton.setPreferredSize(new Dimension(190, 30));
        addToCartButton.setBackground(new Color(0, 204, 102));
        addToCartButton.setForeground(Color.WHITE);
        addToCartPanel.setPreferredSize(new Dimension(200, 60));
        addToCartPanel.add(addToCartButton);
        add(addToCartPanel);

        addStoreListener();
    }

    private void setStock() {
        stockInformation.setText("Stock: " + user.cart.itemList.getStockAmount(itemName));
    }

    private void initStoreFormatter() {
        try {
            MaskFormatter formatter = new MaskFormatter("#");
            DefaultFormatterFactory formatterFactory = new DefaultFormatterFactory(formatter);
            quantityField.setFormatterFactory(formatterFactory);
            quantityField.setValue("0");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void initCartFormatter() {
        try {
            MaskFormatter formatter = new MaskFormatter("##");
            DefaultFormatterFactory formatterFactory = new DefaultFormatterFactory(formatter);
            quantityField.setFormatterFactory(formatterFactory);
            quantityField.setValue(user.cart.cart.get(itemName));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void cartLayout() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        checkBoxPanel.setLayout(new GridBagLayout());
        checkBoxPanel.setPreferredSize(new Dimension(75, 200));
        includeInCart.setSelected(true);
        trashButton.setBackground(backgroundColor);
        checkBoxPanel.add(trashButton);
        // add(checkBoxPanel);

        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(imageBackgroundSize, imageBackgroundSize));
        add(backgroundPanel);

        imagePanel.setPreferredSize(new Dimension(imageSize, imageSize));
        imagePanel.add(new JLabel(new ImageIcon(imagePath)));
        backgroundPanel.add(imagePanel);


        JPanel informationGroupPanel = new JPanel();
        informationGroupPanel.setLayout(new BorderLayout());
        
        
        informationPanel.setPreferredSize(new Dimension(300, 200));
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.Y_AXIS));
        JLabel productDescriptionLabel = new JLabel("Product Description");
        productDescriptionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        productDescriptionLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        informationTitlePanel.add(productDescriptionLabel);
        informationGroupPanel.add(informationTitlePanel, BorderLayout.NORTH);
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 20));
        informationPanel.add(nameLabel);
        JLabel unitLabel = new JLabel(unit);
        unitLabel.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 20));
        unitLabel.setFont(new Font("Arial", Font.PLAIN, 15));
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
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 25));
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
        priceTitleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        priceTitlePanel.add(priceTitleLabel);
        priceGroupPanel.add(priceTitlePanel, BorderLayout.NORTH);
        JLabel priceLabel = new JLabel("₱ " + String.format("%.2f", (price)));
        priceLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        priceGroupPanel.setBackground(backgroundColor);
        pricePanel.add(priceLabel);
        priceGroupPanel.add(pricePanel, BorderLayout.CENTER);
        add(priceGroupPanel);


        totalPriceGroupPanel.setPreferredSize(new Dimension(200, 200));
        totalPriceGroupPanel.setLayout(new BorderLayout());
        totalPriceLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 25));
        totalPriceGroupPanel.add(totalPriceLabel, BorderLayout.NORTH);
        totalPrice.setEditable(false);
        totalPrice.setText("₱ " + String.format("%.2f", (price * user.cart.cart.get(itemName))));
        totalPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        totalPrice.setBorder(BorderFactory.createEmptyBorder(25, 20, 20, 20));
        totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
        totalPricePanel.add(totalPrice, BorderLayout.CENTER);
        totalPriceGroupPanel.add(totalPricePanel);
        add(totalPriceGroupPanel);

        initCartFormatter();
        addCartListener();

    }

    private void addStoreListener() {
        addButton.addActionListener(e -> {
            quantityField.setValue(Integer.valueOf(String.valueOf(quantityField.getValue())) + 1);
        });
        subtractButton.addActionListener(e -> {
            quantityField.setValue(Integer.valueOf(String.valueOf(quantityField.getValue())) - 1);
        });
        addToCartButton.addActionListener(e -> {
            if (Integer.valueOf(quantityField.getText()) > 0) {
                user.cart.addToCart(item, Integer.valueOf(quantityField.getValue().toString()));
                quantityField.setValue(0);
                topPanel.getCartButton().setText(String.valueOf(user.cart.cart.size()));
                setStock();
                JOptionPane.showMessageDialog(null, "Added to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // TO DO: add popup message to inform user item is added to card
            }
            // TO DO: pop up menu to tell user no item is selected
        });
    }

    private void addCartListener() {
        addButton.addActionListener(e -> {
            quantityField.setValue(user.cart.cart.get(itemName) + 1);
            user.cart.addToCart(item);
            totalPrice.setText("₱ " + (item.getPrice() * user.cart.cart.get(itemName)));
            if (listener != null) {
                listener.onButtonPressed(this.price);
            }

        });
        subtractButton.addActionListener(e -> {
            quantityField.setValue(user.cart.cart.get(itemName) - 1);
            user.cart.subtractFromCart(item);
            totalPrice.setText("₱ " + (item.getPrice() * user.cart.cart.get(itemName)));
            if (listener != null) {
                listener.onButtonPressed(this.price);
            }
        });
        includeInCart.addActionListener(e -> {
                boolean isChecked = includeInCart.isSelected();
                System.out.println("Checkbox is " + (isChecked ? "checked" : "unchecked"));
                if (listener != null) {
                    listener.onButtonPressed(this.price);
                }
        });
        trashButton.addActionListener(e -> {
            user.cart.cart.remove(itemName);
            listener.trashButtonClicked();
        });
    }

    private void updateBackground() {
        backgroundPanel.setBackground(backgroundColor);
        imagePanel.setBackground(backgroundColor);
        informationPanel.setBackground(backgroundColor);
        quantityPanel.setBackground(backgroundColor);
        checkBoxPanel.setBackground(backgroundColor);
        addToCartPanel.setBackground(backgroundColor);
        stockInformation.setBackground(backgroundColor);
        informationTitlePanel.setBackground(backgroundColor);
        quantityTitlePanel.setBackground(backgroundColor);
        priceTitlePanel.setBackground(backgroundColor);
        pricePanel.setBackground(backgroundColor);
        priceTitleLabel.setBackground(backgroundColor);
        totalPricePanel.setBackground(backgroundColor);
        totalPrice.setBackground(backgroundColor);
        totalPriceGroupPanel.setBackground(backgroundColor);
        totalPriceLabel.setBackground(backgroundColor);
        totalPricePanel.setBackground(backgroundColor);
    }

    public void setUser(PersonClass user) {
        this.user = user;
    } 

    public void setStockInformation(boolean inStock) {
        this.inStock = inStock;
    }

    public void setTopPanel(TopPanel panel) {
        topPanel = panel;
    }

    public void setListener(ItemGuiListener listener) {
        this.listener = listener;
    }

    public void changeBackground(Color color) {
        this.backgroundColor = color;
        updateBackground();
        repaint();
        revalidate();
    }
}
