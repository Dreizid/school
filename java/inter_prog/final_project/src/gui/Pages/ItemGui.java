package gui.Pages; 
import javax.swing.*;
import java.awt.*;
import core.*;
import gui.widgets.*;

public class ItemGui extends RoundedCornerPanel{
    Color backgroundColor = new Color(214, 224, 234);
    private int size = 200;
    public ItemGui(MeatItem item) {
        super(30);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(size, size));
        setBackground(backgroundColor);
        initializeStore(item.itemName, item.description, item.imagePath, item.unit, item.price);
        setVisible(true);
    }

    public ItemGui(FishItem item) {
        super(30);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(size, size));
        setBackground(backgroundColor);
        initializeStore(item.itemName, item.description, item.imagePath, item.unit, item.price);
        setVisible(true);
    }

    public ItemGui(FruitItem item) {
        super(30);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(size, size));
        setBackground(backgroundColor);
        initializeStore(item.itemName, item.description, item.imagePath, item.unit, item.price);
        setVisible(true);
    }

    public ItemGui(VegetableItem item) {
        super(30);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(size, size));
        setBackground(backgroundColor);
        initializeStore(item.itemName, item.description, item.imagePath, item.unit, item.price);
        setVisible(true);
    }

    public void initializeStore(String itemName, String description, String imagePath, String unit, double price) {
        /*
         * TO DO:
         * Fix panels to be fixed size; so that image size wouldn't change the layout spacing - Done
         * Add functionality to ineract with person class cart
         * Limit itemQuantity field to integers
         * Fix +, - button colors
         * 
         */
        int PADDING = 15;
        String priceLayout = ("₱ " + String.valueOf(price));
        RoundedCornerPanel imagePanel = new RoundedCornerPanel(15);
        imagePanel.setPreferredSize(new Dimension(160, 100));
        imagePanel.setBackground(backgroundColor);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(PADDING - 5, PADDING - 5, 5, PADDING - 5));
        JLabel image = new JLabel(new ImageIcon(imagePath));
        imagePanel.add(image);
        add(imagePanel, BorderLayout.NORTH);
        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(3, 0));
        informationPanel.setBorder(BorderFactory.createEmptyBorder(0, PADDING, 0, PADDING));
        JLabel productName = new JLabel(itemName);
        JLabel productPrice = new JLabel(priceLayout);
        JLabel productUnit = new JLabel(unit);
        informationPanel.add(productName);
        informationPanel.add(productUnit);
        informationPanel.add(productPrice);
        informationPanel.setBackground(backgroundColor);
        add(informationPanel, BorderLayout.CENTER);

        RoundedCornerPanel bottomPanel = new RoundedCornerPanel(15);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(3, PADDING, PADDING, PADDING));
        bottomPanel.setBackground(backgroundColor);
        RoundedJFormattedField quantityField = new RoundedJFormattedField(3, 20);
        quantityField.setText("0");
        quantityField.setHorizontalAlignment(SwingConstants.CENTER);
        quantityField.setPreferredSize(new Dimension(40, 25));
        RoundJButton subtractButton = new RoundJButton("-", 15, Color.RED);
        subtractButton.addActionListener(e -> {
            if (Integer.valueOf(quantityField.getText()) > 0) {
                quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) - 1));
            }
        });
        RoundJButton additionButton = new RoundJButton("+", 15, Color.GREEN);
        additionButton.addActionListener(e -> {
            quantityField.setText(String.valueOf(Integer.valueOf(quantityField.getText()) + 1));
        });
        subtractButton.setBackground(Color.RED);
        additionButton.setBackground(Color.GREEN);
        bottomPanel.add(subtractButton);
        bottomPanel.add(Box.createHorizontalStrut(2));
        bottomPanel.add(quantityField);
        bottomPanel.add(Box.createHorizontalStrut(2));
        bottomPanel.add(additionButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
    }

    public void initializeLabel() {

    }

    public void initializeBottomPart() {

    }

    public static void main(String[] args) {
        ItemGui test = new ItemGui(new MeatItem("Beef", "Beefy", "src\\gui\\static\\images\\beef.png", "1kg", 155.50));
    }
}
