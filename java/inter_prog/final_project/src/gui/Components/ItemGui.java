package gui.Components;

import javax.swing.*;

import core.ItemClass;
import core.Items;
import core.PersonClass;
import gui.Pages.TopPanel;

import java.awt.*;

public class ItemGui extends gui.widgets.DropShadowPanel{
    protected TopPanel topPanel;

    protected Color backgroundColor = Color.WHITE;

    protected static int IMAGE_SIZE = 175,
                        IMAGE_BACKGROUND_SIZE = 300;

    protected JPanel backgroundPanel,
                    imagePanel,
                    quantityPanel,
                    informationPanel,
                    pricePanel;

    protected JButton addToCartButton,
                    addButton,
                    subtractButton;
    
    protected JTextField totalPrice,
                        stockInformation,
                        quantityField;

    protected String itemName,
                    category,
                    description,
                    imagePath,
                    unit;

    protected double price;

    protected Items itemList;

    protected PersonClass user;

    protected ItemClass item;

    public ItemGui(ItemClass item, PersonClass user, Items itemList) {
        super(8);
        this.item = item;
        this.itemName = item.getName();
        this.category = item.getCategory();
        this.description = item.getDescription();
        this.imagePath = item.getImagePath();
        this.unit = item.getUnit();
        this.price = item.getPrice();
        this.user = user;
        this.itemList = itemList;
        initComponents();
        setLayout();
    }

    private void initComponents() {
        backgroundPanel = new JPanel();
        imagePanel = new JPanel();
        informationPanel = new JPanel();
        quantityPanel = new JPanel();
        quantityField = new JTextField();
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        stockInformation = new JTextField("Stock: " + itemList.getStockAmount(itemName));
        totalPrice = new JTextField();
        pricePanel = new JPanel();

    }

    private void setLayout() {
        quantityField.setBorder(BorderFactory.createEmptyBorder());
        quantityField.setText("0");
        quantityField.setEditable(false);
    }

    protected void addListener() {
    }

    public void setStock() {
        stockInformation.setText("Stock: " + itemList.getStockAmount(itemName));
    }

    protected void updateBackground() {
        backgroundPanel.setBackground(backgroundColor);
        imagePanel.setBackground(backgroundColor);
        informationPanel.setBackground(backgroundColor);
        quantityPanel.setBackground(backgroundColor);
        stockInformation.setBackground(backgroundColor);
        pricePanel.setBackground(backgroundColor);
        totalPrice.setBackground(backgroundColor);

    }

    public void setUser(PersonClass user) {
        this.user = user;
    } 

    public void setTopPanel(TopPanel panel) {
        topPanel = panel;
    }

    public void changeBackground(Color color) {
        this.backgroundColor = color;
        updateBackground();
        repaint();
        revalidate();
    }

    public String getName() {
        return this.itemName;
    }
}
