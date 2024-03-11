package gui.Components;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.ItemClass;
import core.Items;
import core.PersonClass;

public class ShopItem extends ItemGui{
    protected JPanel addToCartPanel;

    protected Items itemList;
    public ShopItem(ItemClass item, PersonClass user, Items itemList) {
        super(item, user, itemList);
        this.itemList = itemList;
        initComponents();
        setLayout();
        addListeners();
    }

    private void initComponents() {
        addToCartPanel = new JPanel();

    }

    private void setLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addToCartButton = new JButton("Add to cart");

        imagePanel.add(new JLabel(new ImageIcon(imagePath)));
        imagePanel.setPreferredSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));

        backgroundPanel.add(imagePanel);
        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.setPreferredSize(new Dimension(IMAGE_BACKGROUND_SIZE, IMAGE_BACKGROUND_SIZE));
        add(backgroundPanel);


        JLabel priceLabel = new JLabel("₱ " + String.format("%.2f", price));
        priceLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        JLabel nameLabel = new JLabel(itemName);
        nameLabel.setToolTipText(itemName);
        nameLabel.setFont(new Font("Open Sans MS", Font.BOLD, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 0);
        JLabel unitLabel = new JLabel(unit);
        unitLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 15));
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

    }

    private void addListeners() {
        addButton.addActionListener(e -> {
            if (itemList.inStock(itemName, 1)) {
                quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) + 1)); 
            }
        });
        subtractButton.addActionListener(e -> {
            if (Integer.valueOf(quantityField.getText()) > 0) {
                quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) - 1));
            }
        });
        addToCartButton.addActionListener(e -> {
            if (itemList.getStockAmount(itemName) >= Integer.valueOf(quantityField.getText()) && Integer.valueOf(quantityField.getText()) > 0) {
                user.cart.addToCart(item, Integer.valueOf(quantityField.getText()));
                itemList.subtractFromStock(item.getName(), Integer.valueOf(quantityField.getText()));
                quantityField.setText("0");
                topPanel.getCartButton().setText(String.valueOf(user.cart.cart.size()));
                setStock();
                JOptionPane.showMessageDialog(null, "Added to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            // TO DO: pop up menu to tell user no item is selected
        });
    
    }

    public void changeBackground(Color color) {
        super.changeBackground(color);
        addToCartPanel.setBackground(backgroundColor);

    }

}
