package gui.Pages;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.*;

import core.ItemClass;
import core.Items;
import core.PersonClass;


public class StorePage extends JPanel{
    /*
     * TO DO:
     * Refactor SotrePage - in Progress
     * Fix bug where you can add items with 0 quantity - Done
     * Creating a sorting system - In progress
     * Add search functionality
     * Add pric range functionality ex. 100-500
     * Add logo?
     */

    private static String[] categoryList = {"All", "Fruit", "Vegetable", "Meat", "Fish"};

    private TopPanel topPanel;

    private JPanel leftPanel;
    private JPanel itemsPanel;

    private JComboBox categories;

    int SPACE_BETWEEN = 30;
    CardLayout cardLayout;
    PersonClass user;
    SortedMap<String, String> itemNames;
    HashMap<Integer, String> itemPrices;
    public StorePage(PersonClass user, TopPanel topPanel) {
        this.user = user;
        this.topPanel = topPanel;
        setLayout(new BorderLayout());
        initializeMaps();
        initializeComponents();
        setLayout();
        addListeners();
        loadItems(Items.itemData);
        loadByAlphaOrder(false);
        setVisible(true);
    }

    private void initializeMaps() {
        itemNames = new TreeMap<>();
    }

    private void initializeComponents() {
        leftPanel = new JPanel();
        itemsPanel = new JPanel();
        categories = new JComboBox<>(categoryList);

    }

    public void setLayout() {
        leftPanel.setLayout(new GridBagLayout());
        categories.setFont(new Font("Arial", Font.PLAIN, 30));
        categories.setPreferredSize(new Dimension(300, 40));
        leftPanel.add(categories);
        leftPanel.setBackground(Color.GRAY);
        add(new JScrollPane(itemsPanel), BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
    }

    private void addListeners() {
        categories.addActionListener(e -> {
            String selectedCategory = (String) categories.getSelectedItem();
            switch (selectedCategory) {
                case "All": {
                    loadItems(Items.itemData);
                    break;
                }
                case "Fruit": {
                    loadItems(Items.fruitList);
                    break;
                }
                case "Vegetable": {
                    loadItems(Items.vegetableList);
                    break;
                }
                case "Meat": {
                    loadItems(Items.meatList);
                    break;
                }
                case "Fish": {
                    loadItems(Items.fishList);
                    break;
                }
            }
        });
    }

    public void loadItems(ArrayList<ItemClass> list) {
        itemsPanel.removeAll();
        itemsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < list.size(); i++) {
            if (gbc.gridx == 3) {
                gbc.gridy++;
                gbc.gridx = 0;
            } else {
                gbc.gridx++;
            }
            ItemClass item = list.get(i);
            ItemGui itemGui = new ItemGui(item);
            itemGui.setUser(user);
            itemGui.setStockInformation(user.cart.itemList.inStock(item.getName(), 1));
            itemGui.storeLayout();
            itemGui.setTopPanel(topPanel);
            itemNames.put(item.getName(), item.getCategory());
            itemsPanel.add(itemGui, gbc);

        }
        itemsPanel.repaint();
        itemsPanel.revalidate();
    }

    public void loadByPrice(boolean reversed) {

    }

    public void loadByAlphaOrder(boolean reversed) {

    }

    public void setTopPanel(TopPanel panel) {
        this.topPanel = panel;
    }


    public static void main(String[] args) {
    }
}
