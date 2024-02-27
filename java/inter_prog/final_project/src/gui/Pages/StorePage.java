package gui.Pages;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.*;

import core.ItemClass;
import core.Items;
import core.PersonClass;

public class StorePage extends JPanel implements TopListener, HomeListener{
    /*
     * TO DO:
     * Refactor SotrePage - in Progress
     */

    private static String[] categoryList = {"All", "Fruit", "Vegetable", "Meat", "Fish"};
    private static String[] sortByList = {"Alphabetical: A to Z", "Alphabetical: Z to A", "Price: Low to High", "Price: High to Low", "Default"};

    private TopPanel topPanel;

    private JPanel leftPanel;
    private JPanel pricePanel;
    private JPanel itemsPanel;

    @SuppressWarnings("rawtypes")
    private JComboBox categories;
    @SuppressWarnings("rawtypes")
    private JComboBox sortBy;

    private JTextField lowerPrice;
    private JTextField upperPrice;

    private JButton applyButton;

    private ArrayList<ItemClass> alphaList,
                                priceList;

    private SortedMap<String, String> itemNames;
    private SortedMap<Double, String> itemPrices;

    private String selectedCategory;
                                    
    int SPACE_BETWEEN = 30;
    CardLayout cardLayout;
    PersonClass user;
    
    public StorePage(PersonClass user, TopPanel topPanel) {
        this.user = user;
        this.topPanel = topPanel;
        setLayout(new BorderLayout());
        initializeMaps();
        initializeComponents();
        setLayout();
        addListeners();
        loadItems(Items.itemData);
        setVisible(true);
    }

    private void initializeMaps() {
        itemNames = new TreeMap<>();
        itemPrices = new TreeMap<>();
    }

    private void initializeComponents() {
        leftPanel = new JPanel();
        itemsPanel = new JPanel();
        pricePanel = new JPanel();
        categories = new JComboBox<>(categoryList);
        sortBy = new JComboBox<>(sortByList);
        alphaList = new ArrayList<>();
        priceList = new ArrayList<>();
        applyButton = new JButton("Apply");
        lowerPrice = new JTextField(); 
        upperPrice = new JTextField();

    }

    public void setLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(30, 30, 0, 30);
        gbc.gridy = 0;
        leftPanel.setLayout(new GridBagLayout());
        categories.setFont(new Font("Arial", Font.PLAIN, 30));
        categories.setPreferredSize(new Dimension(300, 40));
        leftPanel.add(categories, gbc);

        gbc.gridy++;
        sortBy.setFont(new Font("Arial", Font.PLAIN, 30));
        sortBy.setPreferredSize(new Dimension(300, 40));
        leftPanel.add(sortBy, gbc);
        leftPanel.setBackground(Color.GRAY);

        itemsPanel.setLayout(new GridBagLayout());
        add(new JScrollPane(itemsPanel), BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        gbc.gridy++;
        pricePanel.setLayout(new GridLayout(0, 3));
        pricePanel.setBackground(Color.GRAY);
        pricePanel.setPreferredSize(new Dimension(300, 30));
        pricePanel.add(lowerPrice);
        JLabel dashLabel = new JLabel("-");
        dashLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        dashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pricePanel.add(dashLabel);
        pricePanel.add(upperPrice);
        leftPanel.add(pricePanel, gbc);

        gbc.gridy++;
        gbc.insets.top = 10;
        applyButton.setPreferredSize(new Dimension(300, 30));
        leftPanel.add(applyButton, gbc);
        
    }

    private void addListeners() {
        categories.addActionListener(e -> {
            selectedCategory = (String) categories.getSelectedItem();
            loadCategory(selectedCategory);
        });

        sortBy.addActionListener(e -> {
            String sortingBy = (String) sortBy.getSelectedItem();
            switch (sortingBy) {
                case "Alphabetical: A to Z": {
                    loadAlphaOrder(false);
                    loadItems(alphaList);
                    break;
                }
                case "Alphabetical: Z to A": {
                    loadAlphaOrder(true);
                    loadItems(alphaList);
                    break;
                }
                case "Price: Low to High": {
                    loadByPrice(false);
                    loadItems(priceList);
                    break;
                }
                case "Price: High to Low": {
                    loadByPrice(true);
                    loadItems(priceList);
                    break;
                }
                case "Default": {
                    loadCategory(selectedCategory);
                    break;
                }
            }
        });

        applyButton.addActionListener(e -> {
            filterPrice(Double.valueOf(lowerPrice.getText()), Double.valueOf(upperPrice.getText()));
            loadItems(priceList);
        });
    }

    private void loadCategory(String category) {
        switch (category) {
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
    }

    private void loadItems(ArrayList<ItemClass> list) {
        itemsPanel.removeAll();
        itemNames.clear();
        itemPrices.clear();
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
            ItemGui itemGui = new ItemGui(item, user);
            itemGui.setUser(user);
            itemGui.setStockInformation(user.cart.itemList.inStock(item.getName(), 1));
            itemGui.storeLayout();
            itemGui.setTopPanel(topPanel);
            setItemBackground(itemGui, item.getCategory());
            itemNames.put(item.getName(), item.getCategory());
            itemPrices.put(item.getPrice(), item.getName());
            itemsPanel.add(itemGui, gbc);

        }
        itemsPanel.repaint();
        itemsPanel.revalidate();
    }

    private void searchItem(String item) {
        itemsPanel.removeAll();
        ItemClass searchedItem = Items.loweredItems.get(item.toLowerCase());
        ItemGui itemGui = new ItemGui(searchedItem, user);
        itemGui.setUser(user);
        itemGui.setStockInformation(user.cart.itemList.inStock(searchedItem.getName(), 1));
        itemGui.storeLayout();
        itemGui.setTopPanel(topPanel);
        setItemBackground(itemGui, searchedItem.getCategory());
        itemsPanel.add(itemGui);
        itemsPanel.repaint();
        itemsPanel.revalidate();
    }

    private void setItemBackground(ItemGui item, String category) {
        Color meatColor = new Color(255, 253, 208);
        Color fishColor = new Color(151, 209, 246);
        Color fruitAndVeggyColor = new Color(195, 193, 241);
        switch (category) {
            case "Meat":
                item.changeBackground(meatColor);
                break;
            case "Fish":
                item.changeBackground(fishColor);
                break;
            case "Fruit":
                item.changeBackground(fruitAndVeggyColor);
                break;
            case "Vegetable":
                item.changeBackground(fruitAndVeggyColor);
                break;
        }
    }

    public void loadByPrice(boolean reversed) {
        priceList.clear();
        if (reversed) {
            itemPrices.forEach((key, value) -> {
                priceList.add(0, Items.items.get(value));
            });
        } else {
            itemPrices.forEach((key, value) -> {
                priceList.add(Items.items.get(value));
            });
        }
    }

    public void loadAlphaOrder(boolean reversed) {
        alphaList.clear();
        if (reversed) {
            itemNames.forEach((key, value) -> {
                alphaList.add(0, Items.items.get(key));
            });
        } else {
            itemNames.forEach((key, value) -> {
                alphaList.add(Items.items.get(key));
            });
        }
    }

    private void filterPrice(double lower, double upper) {
        priceList.clear();
        itemPrices.forEach((key, value) -> {
            if (key > lower && key < upper) {
                priceList.add(Items.items.get(value));
            } 
        });
    }

    public void setTopPanel(TopPanel panel) {
        this.topPanel = panel;
    }

    @Override
    public void searchButtonPressed(String text) {
        searchItem(text);
    }

    @Override
    public void fishButtonClicked() {
        loadItems(Items.fishList);
    }

    @Override
    public void meatButtonClicked() {
        System.out.println("hello from store");
        loadItems(Items.meatList);
    }

    @Override
    public void fruitButtonClick() {
        loadItems(Items.fruitList);
    }
}
